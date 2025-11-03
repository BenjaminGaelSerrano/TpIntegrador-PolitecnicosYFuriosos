package com.politecnicosYfuriosos.Politecnicos_y_furiosos.DTO;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Auto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutoDTO {

    private Integer id;
    private String marca;
    private String modelo;
    private Integer anio;
    private BigDecimal precioPorDia;
    private String tipo;
    private Boolean disponible;
    private String descripcion;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private String imagen4;

    // ✅ Conversión de entidad a DTO
    public static AutoDTO fromEntity(Auto auto) {
        if (auto == null) return null;

        return AutoDTO.builder()
                .id(auto.getId())
                .marca(auto.getMarca())
                .modelo(auto.getModelo())
                .anio(auto.getAnio())
                .precioPorDia(BigDecimal.valueOf(auto.getPrecioPorDia()))
                .tipo(auto.getTipo() != null ? auto.getTipo().name() : null)
                .disponible(auto.isDisponible())
                .descripcion(auto.getDescripcion())
                .imagen1(auto.getImagen1())
                .imagen2(auto.getImagen2())
                .imagen3(auto.getImagen3())
                .imagen4(auto.getImagen4())
                .build();
    }

    // ✅ Conversión inversa de DTO a entidad
    public Auto toEntity() {
        Auto auto = new Auto();
        auto.setId(this.id);
        auto.setMarca(this.marca);
        auto.setModelo(this.modelo);
        auto.setAnio(this.anio != null ? this.anio : 0);
        auto.setPrecioPorDia(this.precioPorDia != null ? this.precioPorDia.doubleValue() : 0.0);
        auto.setTipo(this.tipo != null ? Auto.TipoAuto.valueOf(this.tipo) : null);
        auto.setDisponible(this.disponible != null ? this.disponible : false);
        auto.setDescripcion(this.descripcion);
        auto.setImagen1(this.imagen1);
        auto.setImagen2(this.imagen2);
        auto.setImagen3(this.imagen3);
        auto.setImagen4(this.imagen4);
        return auto;
    }
}
