package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Trayecto; // O .Repository.Trayecto

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Trayecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TrayectosRepository extends JpaRepository<Trayecto, Integer> {

    @Query("SELECT t FROM Trayecto t JOIN t.reserva r WHERE r.cliente.id = :clienteId ORDER BY t.fechaInicio DESC")
    ArrayList<Trayecto> findTrayectosByClienteId(@Param("clienteId") int clienteId);
}
