CREATE TABLE producto(
	codigo INT PRIMARY KEY,
    descripcion VARCHAR(50),
    precio DOUBLE
);


INSERT INTO producto(codigo,descripcion,precio)VALUES(10001,'TECLADO',105.00);
SELECT * FROM producto;