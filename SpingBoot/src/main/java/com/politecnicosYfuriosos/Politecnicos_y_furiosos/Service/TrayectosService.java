package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Trayecto.Trayecto_DTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Auto;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Reserva;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Trayecto;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Trayecto.TrayectosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrayectosService {

    @Autowired
    private TrayectosRepository trayectosRepository;


    public ArrayList<Trayecto_DTO> obtenerHistorialPorConductor(Integer clienteId) {

        // 1. Llamar al repositorio para buscar los trayectos
        ArrayList<Trayecto> trayectos = trayectosRepository.findTrayectosByClienteId(clienteId);

        // 2. Convertir la lista de Entidades a una lista de DTOs
        ArrayList<Trayecto_DTO> historialDTOs = new ArrayList<>();
        for (Trayecto trayecto : trayectos) {
            historialDTOs.add(convertirEntidadADTO(trayecto));
        }

        return historialDTOs;
    }

    /**
     * Método privado (helper) para hacer la conversión de Entidad a DTO
     */
    private Trayecto_DTO convertirEntidadADTO(Trayecto trayecto) {

        // Obtenemos los objetos relacionados
        Reserva reserva = trayecto.getReserva();
        Auto auto = reserva.getAuto();

        // Creamos el DTO de respuesta
        Trayecto_DTO dto = new Trayecto_DTO();

        dto.setOrigen(trayecto.getDireccionOrigen());
        dto.setDestino(trayecto.getDireccionDestino());
        dto.setFecha(trayecto.getFechaInicio());

        // Combinamos marca y modelo para el DTO
        dto.setAutoUtilizado(auto.getMarca() + " " + auto.getModelo());

        return dto;
    }
}