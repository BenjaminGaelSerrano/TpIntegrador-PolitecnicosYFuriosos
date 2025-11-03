<<<<<<< HEAD
package com.politecnicosYfuriosos.Politecnicos_y_furiosos.DTO;

=======
/*
package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo;

import com.fasterxml.jackson.core.JsonToken;
>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c
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
<<<<<<< HEAD

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
=======
    
    // ✅ Este método debe usar la entidad Auto del package correcto
    public static int fromEntity(Auto auto) {
        assert AutoDTO.builder() != null;
        return AutoDTO.builder()
                .id();
    }

    private static JsonToken builder() {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public BigDecimal getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(BigDecimal precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }

    public String getImagen4() {
        return imagen4;
    }

    public void setImagen4(String imagen4) {
        this.imagen4 = imagen4;
    }
}



 */

>>>>>>> 398a586581c20925353a9b5d89a94913b2a68e8c
