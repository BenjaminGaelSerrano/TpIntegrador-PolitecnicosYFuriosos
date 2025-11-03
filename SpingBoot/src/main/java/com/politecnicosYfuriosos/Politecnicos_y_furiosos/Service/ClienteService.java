package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Perfil.ClientePerfilDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Cliente;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Catalogo.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Obtiene los datos de perfil de un usuario por su ID.
     */
    public ClientePerfilDTO obtenerPerfil(Integer clienteId) {
        // 1. Busca al cliente por ID
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + clienteId));

        // 2. Mapea la Entidad (con contraseña) a un DTO (sin contraseña)
        return mapClienteToPerfilDTO(cliente);
    }

    // --- Método privado para mapear ---

    private ClientePerfilDTO mapClienteToPerfilDTO(Cliente cliente) {
        ClientePerfilDTO dto = new ClientePerfilDTO();
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setTelefono(cliente.getTelefono());
        dto.setDni(cliente.getDni());
        dto.setDireccion(cliente.getDireccion());
        dto.setUsuario(cliente.getUsuario());
        dto.setCodigo_postal(cliente.getCodigo_postal());
        dto.setPais(cliente.getPais());
        dto.setMembresia(cliente.getMembresia());
        return dto;
    }
}