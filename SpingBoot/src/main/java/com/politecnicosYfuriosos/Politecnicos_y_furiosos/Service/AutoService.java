/*
package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service;


import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.AutoDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Auto;
// VvV ¡CORRECCIÓN IMPORTANTE DE PAQUETE! VvV
// ^^^ (Asegúrate de que esta sea la ruta correcta a tu AutoRepository) ^^^

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // <-- Lombok se encarga de la inyección
@Transactional(readOnly = true)
public class AutoService {

    private final com.rda.concesionaria.repository.AutoRepository autoRepository; // <-- Esto está perfecto

    public AutoService(com.rda.concesionaria.repository.AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    // VvV ¡ELIMINA ESTE BLOQUE DE CÓDIGO! VvV
    /*
    public AutoService(AutoRepository autoRepository) { // <-- Redundante
        this.autoRepository = autoRepository;
    }

    // ^^^ ¡ELIMINA ESE BLOQUE DE CÓDIGO! ^^^


    public List<Integer> obtenerTodosParaCatalogo() {
        return autoRepository.findAll()
                .stream()
                .map(AutoDTO::fromEntity)
                .collect(Collectors.toList()).reversed();
    }

    public List<Integer> filtrarPorTipo(String tipo) {
        try {
            Auto.TipoAuto tipoAuto = Auto.TipoAuto.valueOf(tipo.toUpperCase());
            return autoRepository.findByTipo(tipoAuto)
                    .stream()
                    .map(AutoDTO::fromEntity)
                    .collect(Collectors.toList()).reversed();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Tipo de auto inválido: " + tipo);
        }
    }

    // ... (el resto de tus métodos está perfecto) ...

    public List<Integer> filtrarPorDisponibilidad(Boolean disponible) {
        return autoRepository.findByDisponible(disponible)
                .stream()
                .map(AutoDTO::fromEntity)
                .collect(Collectors.toList()).reversed();
    }

    public List<Integer> filtrarPorTipoYDisponibilidad(String tipo, Boolean disponible) {
        try {
            Auto.TipoAuto tipoAuto = Auto.TipoAuto.valueOf(tipo.toUpperCase());
            return autoRepository.findByTipoAndDisponible(tipoAuto, disponible)
                    .stream()
                    .map(AutoDTO::fromEntity)
                    .collect(Collectors.toList()).reversed();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Tipo de auto inválido: " + tipo);
        }
    }

    public List<Integer> buscarPorMarcaOModelo(String search) {
        if (search == null || search.trim().isEmpty()) {
            return obtenerTodosParaCatalogo();
        }

        return autoRepository.searchByMarcaOrModelo(search)
                .stream()
                .map(AutoDTO::fromEntity)
                .collect(Collectors.toList());
    }


    public int obtenerDetallePorId(Integer id) {
        Auto auto = autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto no encontrado con ID: " + id));
        return AutoDTO.fromEntity(auto);
    }


    public List<Integer> obtenerDestacados(int limit) {
        return autoRepository.findDestacados()
                .stream()
                .limit(limit)
                .map(AutoDTO::fromEntity)
                .collect(Collectors.toList()).reversed();
    }


    public int obtenerUltimoLanzamiento() {
        Auto auto = autoRepository.findUltimoLanzamiento();
        if (auto == null) {
            throw new RuntimeException("No hay autos disponibles");
        }
        return AutoDTO.fromEntity(auto);
    }


    @Transactional // <-- Correcto
    public int crearAuto(AutoDTO autoDTO) {
        Auto auto = new Auto();
        actualizarEntidadDesdeDTO(auto, autoDTO);
        Auto autoGuardado = autoRepository.save(auto);
        return AutoDTO.fromEntity(autoGuardado);
    }


    @Transactional // <-- Correcto
    public int actualizarAuto(Integer id, AutoDTO autoDTO) {
        Auto auto = autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto no encontrado con ID: " + id));
        actualizarEntidadDesdeDTO(auto, autoDTO);
        Auto autoActualizado = autoRepository.save(auto);
        return AutoDTO.fromEntity(autoActualizado);
    }


    @Transactional // <-- Correcto
    public void eliminarAuto(Integer id) {
        if (!autoRepository.existsById(id)) {
            throw new RuntimeException("Auto no encontrado con ID: " + id);
        }
        autoRepository.deleteById(id);
    }


    private void actualizarEntidadDesdeDTO(Auto auto, AutoDTO dto) {
        auto.setMarca(dto.getMarca());
        auto.setModelo(dto.getModelo());
        auto.setAnio(dto.getAnio());
        auto.setPrecioPorDia(dto.getPrecioPorDia());
        auto.setTipo(Auto.TipoAuto.valueOf(dto.getTipo().toUpperCase()));
        auto.setDisponible(dto.getDisponible());
        auto.setDescripcion(dto.getDescripcion());
        auto.setImagen1(dto.getImagen1());
        auto.setImagen2(dto.getImagen2());
        auto.setImagen3(dto.getImagen3());
        auto.setImagen4(dto.getImagen4());
    }

}

*/