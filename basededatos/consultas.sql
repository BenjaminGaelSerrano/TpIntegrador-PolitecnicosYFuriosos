#c. Procedimiento que, dado un auto y una fecha, determine si el auto estará disponible o no.
delimiter //

create procedure verificar_disponibilidad_auto(
    in p_id_auto int,
    in p_fecha date
)
begin
    declare v_estado varchar(20);
    
    -- Verificar si el auto está disponible
    if exists(
        select 1 from auto 
        where id = p_id_auto 
        and disponible = 1
        and not exists (
            select 1 from reserva 
            where id_auto = p_id_auto 
            and estado in ('PENDIENTE', 'CONFIRMADA')
            and p_fecha between fecha_inicio and fecha_fin
        )
    ) then
        set v_estado = 'DISPONIBLE';
    else
        set v_estado = 'NO DISPONIBLE';
    end if;
    
    select v_estado as estado;
end//

delimiter ;

#D, Procedimiento que devuelve la cantidad de reservas que tuvo cada modelo en un rango d fechas
delimiter //
create procedure cantidad_reservas_entre_fechas (in f_menor date, in f_mayor date)
begin

select auto.modelo, count(*)  from reserva join auto on id_auto=auto.id where fecha_inicio<=f_mayor and fecha_fin >= f_menor group by auto.modelo;

end//
delimiter ; 	



#e. Evento que, cada mes, elimine a los conductores que hace más de 6 meses que no 
#registran entradas y salidas.

delimiter //

create event eliminar_conductores_inactivos 
on schedule every 1 month
starts current_timestamp
do
begin
    delete from cliente 
    where id in (select id_cliente from (
	select cliente.id as id_cliente, max(reserva.fecha_inicio) as ultima_reserva from cliente left join
    reserva on cliente.id = reserva.id_cliente group by cliente.id having  ultima_reserva < date_sub(current_date(), interval 6 month)) as sub);
end//

delimiter ;


