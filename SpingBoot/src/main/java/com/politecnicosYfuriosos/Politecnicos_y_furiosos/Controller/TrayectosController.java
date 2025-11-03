package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Trayecto.Trayecto_DTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.TrayectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/salidas")
@CrossOrigin(origins = "*")
public class TrayectosController {

    @Autowired
    private TrayectosService trayectosService;


    @GetMapping("/por-conductor/{id}")
    public ResponseEntity<ArrayList<Trayecto_DTO>> obtenerSalidasPorConductor(
            @PathVariable Integer id) {

        ArrayList<Trayecto_DTO> historial = trayectosService.obtenerHistorialPorConductor(id);

        // Devuelve 200 OK con la lista (la lista puede estar vacía si no hay historial)
        return ResponseEntity.ok(historial);
    }
}