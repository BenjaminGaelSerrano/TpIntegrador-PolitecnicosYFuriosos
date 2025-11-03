package com.rda.concesionaria.controller;

import com.rda.concesionaria.dto.AutoDTO;
import com.rda.concesionaria.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Configurar según tus necesidades
public class AutoController {

    private final AutoService autoService; // ✅ Corregido

    // 🔹 GET: /api/autos/catalogo?tipo=SUV&disponible=true&search=Ford
    @GetMapping("/catalogo")
    public ResponseEntity<List<AutoDTO>> obtenerCatalogo(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) Boolean disponible,
            @RequestParam(required = false) String search) {

        List<AutoDTO> autos;

        if (search != null && !search.trim().isEmpty()) {
            autos = autoService.buscarPorMarcaOModelo(search);
        } else if (tipo != null && disponible != null) {
            autos = autoService.filtrarPorTipoYDisponibilidad(tipo, disponible);
        } else if (tipo != null) {
            autos = autoService.filtrarPorTipo(tipo);
        } else if (disponible != null) {
            autos = autoService.filtrarPorDisponibilidad(disponible);
        } else {
            autos = autoService.obtenerTodosParaCatalogo();
        }

        return ResponseEntity.ok(autos);
    }

    // 🔹 GET: /api/autos/tipo/{tipo}
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<AutoDTO>> filtrarPorTipo(@PathVariable String tipo) {
        List<AutoDTO> autos = autoService.filtrarPorTipo(tipo);
        return ResponseEntity.ok(autos);
    }

    // 🔹 GET: /api/autos/disponibles
    @GetMapping("/disponibles")
    public ResponseEntity<List<AutoDTO>> obtenerDisponibles() {
        List<AutoDTO> autos = autoService.filtrarPorDisponibilidad(true);
        return ResponseEntity.ok(autos);
    }

    // 🔹 GET: /api/autos/destacados?limit=4
    @GetMapping("/destacados")
    public ResponseEntity<List<AutoDTO>> obtenerDestacados(
            @RequestParam(defaultValue = "4") int limit) {
        List<AutoDTO> autos = autoService.obtenerDestacados(limit);
        return ResponseEntity.ok(autos);
    }

    // 🔹 GET: /api/autos/ultimo-lanzamiento
    @GetMapping("/ultimo-lanzamiento")
    public ResponseEntity<AutoDTO> obtenerUltimoLanzamiento() {
        AutoDTO auto = autoService.obtenerUltimoLanzamiento();
        return ResponseEntity.ok(auto);
    }

    // 🔹 GET: /api/autos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<AutoDTO> obtenerDetalle(@PathVariable Integer id) {
        AutoDTO auto = autoService.obtenerDetallePorId(id);
        return ResponseEntity.ok(auto);
    }

    // 🔹 GET: /api/autos/buscar?q=Mustang
    @GetMapping("/buscar")
    public ResponseEntity<List<AutoDTO>> buscar(@RequestParam String q) {
        List<AutoDTO> autos = autoService.buscarPorMarcaOModelo(q);
        return ResponseEntity.ok(autos);
    }

    // 🔹 POST: /api/autos
    @PostMapping
    public ResponseEntity<AutoDTO> crearAuto(@RequestBody AutoDTO autoDTO) {
        AutoDTO nuevoAuto = autoService.crearAuto(autoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAuto);
    }

    // 🔹 PUT: /api/autos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<AutoDTO> actualizarAuto(
            @PathVariable Integer id,
            @RequestBody AutoDTO autoDTO) {
        AutoDTO autoActualizado = autoService.actualizarAuto(id, autoDTO);
        return ResponseEntity.ok(autoActualizado);
    }

    // 🔹 DELETE: /api/autos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAuto(@PathVariable Integer id) {
        autoService.eliminarAuto(id);
        return ResponseEntity.noContent().build();
    }
}
