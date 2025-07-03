create database bd_sistema_ventas;
-- usamos la base de datos creada
use bd_sistema_ventas;

-- crear la tabla usuarios
create table tb_usuario(
idUsuario int(11) auto_increment primary key,
nombre varchar(30) not null,
apellido varchar (30) not null,
usuario varchar (12) not null,
password varchar (12) not null,
telefono varchar (12) not null,
estado int (1) not null
);
insert into tb_usuario(nombre, apellido, usuario, password, telefono, estado)
values ("Neyder", "Sanchez", "neyder", "280403", "989838016", 1);

select * from tb_usuario;

select usuario, password from tb_usuario where usuario = "neyder" and password = "280403";

-- crear la tabla cliente
create table tb_cliente(
idCliente int (11) auto_increment primary key,
nombre varchar (30) not null,
apellido varchar (30) not null,
dni varchar (12) not null,
telefono varchar (12) not null,
direccion varchar (50) not null,
estado int (1) not null
);
select * from tb_cliente;
-- ALTER TABLE tb_cliente RENAME COLUMN cedula to dni;
-- crear la tabla categoria
create table tb_categoria(
idCategoria int (11) auto_increment primary key,
descripcion varchar (100) not null,
estado int (1) not null
);

select * from tb_categoria;
select descripcion from tb_categoria where descripcion = '';
truncate table tb_categoria;

-- crear la tabla producto
create table tb_producto(
idProducto int (11) auto_increment primary key,
nombre varchar (100) not null,
cantidad int (11) not null,
precio double (10,2) not null,
descripcion varchar (100) not null,
porcentajeIgv int (2) not null,
idCategoria int (11) not null,
estado int (1) not null
);

select * from tb_producto;

select p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIgv, c.descripcion, p.estado 
from tb_producto As p, tb_categoria As c 
where p.idCategoria = c.idCategoria;

-- crear la tabla cabecera de venta
create table  tb_cabecera_venta(
idCabeceraVenta int (11) auto_increment primary key,
idCliente int (11) not null,
valorPagar double (10,2) not null,
fechaVenta date not null,
estado int (1) not null
);
select * from tb_cabecera_venta;
-- crear la tabla detalle de venta
create table tb_detalle_venta(
idDetalleVenta int (11) auto_increment primary key,
idCabeceraVenta int (11) not null,
idProducto int (11) not null,
cantidad int (11) not null,
precioUnitario double (10,2) not null,
subtotal double (10,2) not null,
descuento double (10,2) not null,
igv double (10,2) not null,
totalPagar double (10,2) not null,
estado int (1) not null
);
select * from tb_detalle_venta;
-- ver todas las tablas
show tables;
-- select p.idProducto, p.nombre, p.cantidad, p.descripcion, p.porcentajeIgv, c.descripcion, p.estado 
-- from tb_producto As p, tb_categoria AS c  
-- where p.idCategoria = c.idCategoria LIMIT 0, 1000
-- adicional

select cv.idCabeceraVenta as id, concat(c.nombre, ' ', c.apellido) as cliente, cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado from tb_cabecera_venta as cv, tb_cliente as c where cv.idCliente = c.idCliente;

select cv.idCabeceraVenta, cv.idCliente, concat(c.nombre, ' ', c.apellido) as cliente, cv.valorPagar, cv.fechaVenta, cv.estado from tb_cabecera_venta as cv, tb_cliente as c where cv.idCabeceraVenta = 3 and cv.idCliente = c.idCliente;

select p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIgv, c.descripcion as categoria, p.estado from tb_producto as p, tb_categoria as c where p.idCategoria = c.idCategoria;

select cv.idCabeceraVenta as id, concat(c.nombre, ' ', c.apellido) as cliente, cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado from tb_cabecera_venta as cv, tb_cliente as c where cv.idCliente = c.idCLiente;