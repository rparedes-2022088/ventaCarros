use db_ventaautos;
DELIMITER //
create procedure sp_agregarCliente(nombre varchar(30), apellido varchar(30), direccion varchar(60), telefono varchar(10), email varchar(30))
begin
insert into tbl_cliente (nombre,  apellido, direccion, telefono, email)
values(nombre, apellido, direccion, telefono, email);
end//
DELIMITER ;

DELIMITER //
create procedure sp_buscarCliente(id_clien int)
begin
select * from tbl_cliente
where id_cliente = id_clien;
end//
DELIMITER ;

DELIMITER //
create procedure sp_enlistarCliente()
begin
select * from tbl_cliente;
end//
DELIMITER ;

DELIMITER //
create procedure sp_actualizarCliente(id_clien int, nomb varchar(30), ape varchar(30), dir varchar(60), tel varchar(10), ema varchar(30))
begin
update tbl_cliente
set id_cliente = id_clien, nombre = nom, apellido = ape, direccion = dir, telefono = tel, email = ema
where id_clien;
end//
DELIMITER ;

/*
Clientes
*/

DELIMITER //
create procedure sp_agregarUsuario(usuario varchar(20), contraseña varchar(20), id_cliente int, 
estado_activo boolean, rol boolean)
begin
insert into tbl_usuario (usuario, contraseña, id_cliente, estado_activo, rol)
values(usuario, contraseña, id_cliente, estado_activo, rol);
end//
DELIMITER ;

DELIMITER //
create procedure sp_buscarUsuario(id_usu int)
begin
select * from tbl_usuario
where id_usuario = id_usu;
end//
DELIMITER ;

DELIMITER //
create procedure sp_enlistarUsuario()
begin
select * from tbl_usuario;
end//
DELIMITER ;

DELIMITER //
create procedure sp_actualizarUsuario(id_usu int, usu varchar(20), contra varchar(20), id_clien int, 
estado_act boolean, rol boolean)
begin
update tbl_usuario
set id_usuario = id_usu, usuario = usu, contraseña = contra, id_cliente = id_clien, estado_activo = estado_act,
rol = rol
where id_usu;
end//
DELIMITER ;

/*
Usuario
*/

DELIMITER //
create procedure sp_agregarCompra(fecha_de_compra date, id_cliente int)
begin
insert into tbl_compra (fecha_de_compra, id_cliente)
values(fecha_de_compra, id_cliente);
end//
DELIMITER ;

DELIMITER //
create procedure sp_buscarCompra(id_compra int)
begin
select * from tbl_compra
where id_compra = id_compra;
end//
DELIMITER ;

DELIMITER //
create procedure sp_enlistarCompra()
begin
select * from tbl_compra;
end//
DELIMITER ;

DELIMITER //
create procedure sp_actualizarCompra(id_comp int, fecha_de_comp date, id_clien int)
begin 
update tbl_compra
set id_compra = id_comp, fecha_de_compra = fecha_de_comp, id_cliente = id_clien
where id_comp;
end//
DELIMITER ;

/*
Compra
*/

DELIMITER //
create procedure sp_agregarCarro(carro varchar(30), modelo varchar(8), precio float)
begin
insert into tbl_carro (carro, modelo, precio)
values(carro, modelo, precio);
end//
DELIMITER ;

DELIMITER //
create procedure sp_buscarCarro(id_carr int)
begin
select * from tbl_carro
where id_carro = id_carr;
end//
DELIMITER ;

DELIMITER //
create procedure sp_enlistarCarro()
begin
select * from tbl_carro;
end//
DELIMITER ;

DELIMITER //
create procedure sp_actualizarCarro(id_carr int, carr varchar(30), model varchar(8), prec float)
begin
update tbl_carro
set id_carro = id_carr, carro = carr, modelo = model, precio = prec
where id_carr;
end//
DELIMITER ;

/*
Carro
*/

DELIMITER //
create procedure sp_agregarDetalleProveedorCarro(id_proveedor int, id_carro int)
begin
insert into tbl_detalle_proveedor_carro (id_proveedor, id_carro)
values(id_proveedor, id_carro);
end//
DELIMITER ;

DELIMITER //
create procedure sp_enlistarDetalleProveedorCarro()
begin
select * from tbl_detalle_proveedor_carro;
end//
DELIMITER ;
drop procedure sp_enlistarDetalleProveedorCarro;

/*
Detalle proveedor carro
*/

DELIMITER //
create procedure sp_agregarDetalleCompra(id_compra int, id_carro int, cantidad int)
begin
insert into tbl_detalle_compra (id_compra, id_carro, cantidad)
values(id_compra, id_carro, cantidad);
end//
DELIMITER ;

DELIMITER //
create procedure sp_enlistarDetalleCompra()
begin
select * from tbl_detalle_compra;
end//
DELIMITER ;

SET GLOBAL time_zone = '+0:00';