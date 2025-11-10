package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String direccion;
    private String codigoPostal;
    private String pais;
    private String usuario;
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private CategoriaLicencia categoriaLicencia;

    @Enumerated(EnumType.STRING)
    private MembershipPlan membresia;

    private boolean vip;
    private boolean habilitado;

    @OneToMany(mappedBy = "clientePrincipal")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "cliente")
    private List<Resenia> resenias;

    public enum CategoriaLicencia {
        A, B, C, D, E
    }

    public enum MembershipPlan {
        BASICO, PREMIUM, VIP
    }

    // Constructor vacío
    public Cliente() {}

    // Constructor con parámetros principales
    public Cliente(String nombre, String apellido, String dni, String email, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.habilitado = true;
        this.vip = false;
        this.categoriaLicencia = CategoriaLicencia.B;
        this.membresia = MembershipPlan.BASICO;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public CategoriaLicencia getCategoriaLicencia() { return categoriaLicencia; }
    public void setCategoriaLicencia(CategoriaLicencia categoriaLicencia) { this.categoriaLicencia = categoriaLicencia; }

    public MembershipPlan getMembresia() { return membresia; }
    public void setMembresia(MembershipPlan membresia) { this.membresia = membresia; }

    public boolean isVip() { return vip; }
    public void setVip(boolean vip) { this.vip = vip; }

    public boolean isHabilitado() { return habilitado; }
    public void setHabilitado(boolean habilitado) { this.habilitado = habilitado; }

    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }

    public List<Resenia> getResenias() { return resenias; }
    public void setResenias(List<Resenia> resenias) { this.resenias = resenias; }

    // Métodos utilitarios
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public boolean puedeManejarAutoDeportivo() {
        return categoriaLicencia != CategoriaLicencia.B;
    }

    public boolean esMiembroPremium() {
        return membresia == MembershipPlan.PREMIUM || membresia == MembershipPlan.VIP;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", vip=" + vip +
                ", habilitado=" + habilitado +
                '}';
    }
}