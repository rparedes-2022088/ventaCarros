use db_ventaautos;
insert into tbl_proveedor
values(1,'Toyota','Toyota'),(2,'Ford','Ford'),(3,'Hyundai','Hyundai'),(4,'Kia','Kia'),(5,'Chevrolet','Chevrolet');

insert into tbl_proveedor
values(6,'Honda','Honda'),(7,'Mazda','Mazda'),(8,'Mitsubishi','Mitsubishi');

call sp_agregarCliente('Javier','Vega','su casa','8765-4321','javier@kinal.edu.gt');
call sp_agregarCliente();

select * from tbl_cliente;

insert into tbl_cliente
values(1,'Rubén','Paredes','Centro educativo tecnico laboral kinal','1234-5678','rparedes-2022088@kinal.edu.gt');

select * from tbl_cliente;
insert into tbl_cliente
values(3,'Fernando','Roquel','Pizza hut','1324-4321','fernando@kinal.edu.gt');

insert into tbl_cliente
values(4,'Miguel','Yac','El periferico','1234-56789','miguel@kinal.edu.gt'),
(5,'Brener','Rodriguez','Calzada rosvelt','0123-1234','brener@gmail.com');

/*
Clientes
*/

insert into tbl_usuario
values(1, 'darisflores', 'kinal123', 1, true, true);
select * from tbl_usuario;

insert into tbl_usuario
values(2,'cvega','kinal231',2,true,false),(3,'broquel','kinal456',3,true,false),
(4,'myac','kinal789',4,true,false),(5,'bvalladares','kinal987',5,true,false);

insert into tbl_carro
values(1, 'RAV4', '2022', 300000);

insert into tbl_carro
values(2, 'Mustang', '2020', 500000),(3,'Tucson','2021',254990),(4,'Sportage','2022',286900),
(5,'Mazda 3','2021',200000);

select * from tbl_carro;

insert into tbl_compra
values(1, '2022-09-27', 1);

insert into tbl_compra
values(2,'2022-09-26',2),(3,'2022-09-25',3),(4,'2022-09-24',4),(5,'2022-09-23',5);

select * from tbl_compra;

select * from tbl_detalle_proveedor_carro;
insert into tbl_detalle_proveedor_carro
values(1, 1, 1);
insert into tbl_detalle_proveedor_carro
values(2,2,2),(3,3,3),(4,4,4),(5,5,5);
select * from tbl_detalle_proveedor_carro;

insert into tbl_detalle_compra
values(1, 1, 1, 2);

insert into tbl_detalle_compra
values(2,2,2,1),(3,3,3,1),(4,4,4,1),(5,5,5,1);

select * from tbl_detalle_compra;