<<<<<<< HEAD
<<<<<<< HEAD
package com.rda.concesionaria.controller;

import com.rda.concesionaria.dto.AutoDTO;
import com.rda.concesionaria.service.AutoService;
=======
/*
package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.AutoDTO;
// import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Auto; // <-- Este import ya no es necesario
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.AutoService;

>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c
=======
package com.rda.concesionaria.controller;

import com.rda.concesionaria.dto.AutoDTO;
import com.rda.concesionaria.service.AutoService;
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
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
<<<<<<< HEAD
=======

<<<<<<< HEAD
    // Esto está perfecto, Lombok usará este campo
    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    // VvV ¡ELIMINA ESTE BLOQUE DE CÓDIGO! VvV
    /*
    public AutoController(Auto autoService) { // <-- Este constructor estaba mal
        this.autoService = autoService;
    }

    // ^^^ ¡ELIMINA ESE BLOQUE DE CÓDIGO! ^^^

>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c

    private final AutoService autoService; // ✅ Corregido

=======
    private final AutoService autoService; // ✅ Corregido

>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
    // 🔹 GET: /api/autos/catalogo?tipo=SUV&disponible=true&search=Ford
    @GetMapping("/catalogo")
    public ResponseEntity<List<AutoDTO>> obtenerCatalogo(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) Boolean disponible,
            @RequestParam(required = false) String search) {

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
        List<Integer> autos;
=======
        List<AutoDTO> autos;
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d

        if (search != null && !search.trim().isEmpty()) {
            autos = autoService.buscarPorMarcaOModelo(search);
        } else if (tipo != null && disponible != null) {
            autos = autoService.filtrarPorTipoYDisponibilidad(tipo, disponible);
        } else if (tipo != null) {
            autos = autoService.filtrarPorTipo(tipo);
        } else if (disponible != null) {
            autos = autoService.filtrarPorDisponibilidad(disponible);
<<<<<<< HEAD
        }
        else {
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c
=======
        } else {
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
            autos = autoService.obtenerTodosParaCatalogo();
        }

        return ResponseEntity.ok(autos);
    }
<<<<<<< HEAD
=======

<<<<<<< HEAD
    // ... (El resto de tus métodos @GetMapping, @PostMapping, etc.)
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c

=======
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
    // 🔹 GET: /api/autos/tipo/{tipo}
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<AutoDTO>> filtrarPorTipo(@PathVariable String tipo) {
        List<AutoDTO> autos = autoService.filtrarPorTipo(tipo);
        return ResponseEntity.ok(autos);
    }
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c

=======
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
    // 🔹 GET: /api/autos/disponibles
    @GetMapping("/disponibles")
    public ResponseEntity<List<AutoDTO>> obtenerDisponibles() {
        List<AutoDTO> autos = autoService.filtrarPorDisponibilidad(true);
        return ResponseEntity.ok(autos);
    }
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c

=======
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
    // 🔹 GET: /api/autos/destacados?limit=4
    @GetMapping("/destacados")
    public ResponseEntity<List<AutoDTO>> obtenerDestacados(
            @RequestParam(defaultValue = "4") int limit) {
        List<AutoDTO> autos = autoService.obtenerDestacados(limit);
        return ResponseEntity.ok(autos);
    }
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c

=======
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
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
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c

=======
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
    // 🔹 GET: /api/autos/buscar?q=Mustang
    @GetMapping("/buscar")
    public ResponseEntity<List<AutoDTO>> buscar(@RequestParam String q) {
        List<AutoDTO> autos = autoService.buscarPorMarcaOModelo(q);
        return ResponseEntity.ok(autos);
    }
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c

=======
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
    // 🔹 POST: /api/autos
    @PostMapping
    public ResponseEntity<AutoDTO> crearAuto(@RequestBody AutoDTO autoDTO) {
        AutoDTO nuevoAuto = autoService.crearAuto(autoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAuto);
    }
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c

=======
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
    // 🔹 PUT: /api/autos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<AutoDTO> actualizarAuto(
            @PathVariable Integer id,
            @RequestBody AutoDTO autoDTO) {
        AutoDTO autoActualizado = autoService.actualizarAuto(id, autoDTO);
        return ResponseEntity.ok(autoActualizado);
    }
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c

=======
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
    // 🔹 DELETE: /api/autos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAuto(@PathVariable Integer id) {
        autoService.eliminarAuto(id);
        return ResponseEntity.noContent().build();
    }
}
<<<<<<< HEAD
<<<<<<< HEAD
=======

 */
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c
=======
>>>>>>> 0d0222234f56ae6dab30c3487e06e700703edc8d
