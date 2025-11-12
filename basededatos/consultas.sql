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


