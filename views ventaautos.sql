use db_ventaautos;
create view vista_cliente AS select * from tbl_cliente;
select * from vista_cliente;

create view vista_usuario AS select * from tbl_usuario;
select * from vista_usuario;

create view vista_compra AS select * from tbl_compra;
select * from vista_compra;

create view vista_carro AS select * from tbl_carro;
select * from vista_carro;

create view vista_proveedor AS select * from tbl_proveedor;
select * from vista_proveedor;

create view vista_detalle_proveedor_carro AS select * from tbl_detalle_proveedor_carro;
select * from vista_detalle_proveedor_carro;

create view vista_detalle_compra AS select * from tbl_detalle_compra;
select * from vista_detalle_compra;