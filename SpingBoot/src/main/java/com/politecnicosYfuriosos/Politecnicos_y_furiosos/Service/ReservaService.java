package com.rda.concesionaria.service;

import com.rda.concesionaria.dto.ReservaRequestDTO;
import com.rda.concesionaria.dto.ReservaResponseDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.*;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Catalogo.AutoRepository;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Catalogo.ClienteRepository;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.garaje.ReservaGarajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AutoRepository autoRepository;

    private static final int MINIMO_CONDUCTORES = 1;

    public ReservaResponseDTO registrarReserva(ReservaRequestDTO request) {
        // 1. Validar datos básicos
        validarDatosBasicos(request);

        // 2. Obtener entidades
        Cliente clientePrincipal = clienteRepository.findById(request.getIdClientePrincipal())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Auto auto = autoRepository.findById(request.getIdAuto())
                .orElseThrow(() -> new RuntimeException("Auto no encontrado"));

        // 3. Validar disponibilidad del auto
        validarDisponibilidadAuto(auto, request.getFechaInicio(), request.getFechaFin(), clientePrincipal.isVip());

        // 4. Validar conductores
        List<Cliente> conductoresAdicionales = validarConductores(request.getIdsConductoresAdicionales(), auto);

        // 5. Calcular total
        double total = calcularTotal(auto, request.getFechaInicio(), request.getFechaFin());

        // 6. Crear y guardar reserva
        Reserva reserva = crearReserva(clientePrincipal, auto, request, conductoresAdicionales, total);
        Reserva reservaGuardada = reservaRepository.save(reserva);

        return crearResponseDTO(reservaGuardada, "Reserva registrada exitosamente");
    }

    private void validarDatosBasicos(ReservaRequestDTO request) {
        if (request.getFechaInicio() == null || request.getFechaFin() == null) {
            throw new RuntimeException("Las fechas de inicio y fin son obligatorias");
        }
        if (request.getFechaInicio().isBefore(LocalDate.now())) {
            throw new RuntimeException("La fecha de inicio no puede ser en el pasado");
        }
        if (request.getFechaFin().isBefore(request.getFechaInicio())) {
            throw new RuntimeException("La fecha de fin debe ser posterior a la fecha de inicio");
        }
    }

    private void validarDisponibilidadAuto(Auto auto, LocalDate fechaInicio, LocalDate fechaFin, boolean esVip) {
        // Verificar si el auto está disponible
        if (!auto.isDisponible()) {
            throw new RuntimeException("El auto no está disponible para reserva");
        }

        // Buscar reservas superpuestas
        List<Reserva> reservasSuperpuestas = reservaRepository.findReservasSuperpuestas(auto.getId(), fechaInicio, fechaFin);

        if (!reservasSuperpuestas.isEmpty()) {
            // Si hay reservas VIP superpuestas, no se puede reservar
            List<Reserva> reservasVip = reservaRepository.findReservasVipSuperpuestas(auto.getId(), fechaInicio, fechaFin);

            if (!reservasVip.isEmpty()) {
                throw new RuntimeException("No hay disponibilidad. Existen reservas VIP en las fechas seleccionadas");
            }

            // Si el cliente actual es VIP, tiene prioridad sobre reservas no VIP
            if (esVip) {
                // Cancelar reservas no VIP superpuestas
                for (Reserva reserva : reservasSuperpuestas) {
                    if (!reserva.getClientePrincipal().isVip()) {
                        reserva.setEstado(Reserva.EstadoReserva.CANCELADA);
                        reservaRepository.save(reserva);
                    }
                }
            } else {
                throw new RuntimeException("No hay disponibilidad en las fechas seleccionadas");
            }
        }
    }

    private List<Cliente> validarConductores(List<Integer> idsConductores, Auto auto) {
        List<Cliente> conductores = new ArrayList<>();

        if (idsConductores != null) {
            for (Integer idConductor : idsConductores) {
                Cliente conductor = clienteRepository.findById(idConductor)
                        .orElseThrow(() -> new RuntimeException("Conductor no encontrado: " + idConductor));

                // Validar que el conductor esté habilitado
                if (!conductor.isHabilitado()) {
                    throw new RuntimeException("El conductor " + conductor.getNombre() + " no está habilitado");
                }

                // Validar categoría de licencia para autos especiales
                if (auto.getTipo() == Auto.TipoAuto.DEPORTIVO &&
                        conductor.getCategoriaLicencia() == Cliente.CategoriaLicencia.B) {
                    throw new RuntimeException("El conductor " + conductor.getNombre() +
                            " no tiene la categoría necesaria para este auto deportivo");
                }

                conductores.add(conductor);
            }
        }

        // Validar cantidad mínima de conductores
        if (conductores.size() + 1 < MINIMO_CONDUCTORES) {
            throw new RuntimeException("Se requiere al menos " + MINIMO_CONDUCTORES + " conductor(es)");
        }

        return conductores;
    }

    private double calcularTotal(Auto auto, LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        if (dias < 1) dias = 1; // Mínimo 1 día

        return auto.getPrecioPorDia() * dias;
    }

    private Reserva crearReserva(Cliente clientePrincipal, Auto auto, ReservaRequestDTO request,
                                 List<Cliente> conductoresAdicionales, double total) {
        Reserva reserva = new Reserva();
        reserva.setClientePrincipal(clientePrincipal);
        reserva.setAuto(auto);
        reserva.setFechaInicio(request.getFechaInicio());
        reserva.setFechaFin(request.getFechaFin());
        reserva.setTotal(total);
        reserva.setEstado(Reserva.EstadoReserva.CONFIRMADA);
        reserva.setMetodoPago(Reserva.MetodoPago.valueOf(request.getMetodoPago()));
        reserva.setConductoresAdicionales(conductoresAdicionales);

        return reserva;
    }

    private ReservaResponseDTO crearResponseDTO(Reserva reserva, String mensaje) {
        ReservaResponseDTO response = new ReservaResponseDTO();
        response.setId(reserva.getId());
        response.setClientePrincipal(reserva.getClientePrincipal().getNombre() + " " +
                reserva.getClientePrincipal().getApellido());
        response.setAuto(reserva.getAuto().getMarca() + " " + reserva.getAuto().getModelo());
        response.setFechaInicio(reserva.getFechaInicio());
        response.setFechaFin(reserva.getFechaFin());
        response.setEstado(reserva.getEstado().name());
        response.setTotal(reserva.getTotal());
        response.setMensaje(mensaje);

        return response;
    }
}