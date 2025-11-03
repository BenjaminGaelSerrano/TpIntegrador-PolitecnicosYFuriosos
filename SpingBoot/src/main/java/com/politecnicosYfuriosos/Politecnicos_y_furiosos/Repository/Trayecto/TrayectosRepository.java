package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Trayecto; // O .Repository.Trayecto

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Trayecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TrayectosRepository extends JpaRepository<Trayecto, Integer> {


    ArrayList<Trayecto> findByReservaClienteIdOrderByFechaInicioDesc(int clienteId);

}