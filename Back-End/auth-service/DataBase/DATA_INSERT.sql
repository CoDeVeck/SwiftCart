INSERT INTO TB_DISTRITO (NOMBRE) VALUES
('Ancón'),
('Ate'),
('Barranco'),
('Breña'),
('Carabayllo'),
('Chorrillos'),
('Comas'),
('La Molina'),
('Miraflores'),
('San Isidro');


INSERT INTO TB_ROL (DESCRIPCION) VALUES
('Administrador'),
('Cliente'),
('Vendedor'),
('Repartidor'),
('Empleado');

INSERT INTO TB_CARGO (DESCRIPCION) VALUES
('RRHH'),
('Gerente'),
('Jefe'),
('Encargado'), --manos derechas del jefe
('Trabajador'); -- trabajadores normales de la empresa

INSERT INTO TB_USUARIO 
(NOMBRES, APE_MATERNO, APE_PATERNO, CORREO, CLAVE, TIPO_DOC, NRO_DOC, DIRECCION, ID_DISTRITO, TELEFONO, ID_ROL, ID_CARGO, ID_EMPRESA)
VALUES
--administradores
('Juan','Perez','Gomez','admin1@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','12345678','Av Lima 123',1,'999888777',1,2,1),
('Pepe','De la Vega','Chavez','admin2@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','12345679','Av Lima 321',1,'991888777',1,2,1),
('Lucho','Montez','Zapata','admin3@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','12345179','Av Lima 321',1,'911888777',1,2,1),
--clientes
('Maria','Lopez','Torres','cliente1@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','87654321','Av Peru 456',2,'999111222',2,NULL,NULL),
('Luisania','Enrique','Alvarado','cliente2@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','87651321','Av Peru 156',2,'999111292',2,NULL,NULL),

--Vendedor
('Carlos','Ramirez','Diaz','vendedor@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','11223344','Av Sol 789',3,'988777666',3,5,1),

--Repartidor
('Luis','Fernandez','Castro','repartidor1@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','22334455','Av Norte 321',4,'977666555',4,5,1),
('Hector','Casas','Narazas','repartidor2@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','20334455','Av Norte 121',4,'977616555',4,5,1),

--Empleadas
('Ana','Vargas','Rios','empleado@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','33445566','Av Sur 654',5,'966555444',5,4,1);

