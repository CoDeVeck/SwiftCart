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

INSERT INTO TB_CATEGORIA (DESCRIPCION) VALUES
('Frutas y Verduras'),
('Carnes, Aves y Pescados'),
('Desayunos'),
('Lácteos y Huevos'),
('Quesos y Fiambres'),
('Abarrotes'),
('Panadería y Pastelería'),
('Pollo Rostizado y Comidas Preparadas'),
('Congelados'),
('Bebidas'),
('Vinos, licores y cervezas'),
('Limpieza'),
('Cuidado Personal y Salud'),
('Cuidado del Bebé'),
('Mascotas');

INSERT INTO TB_EMPRESA (RUC,RAZON_SOCIAL,ID_DISTRITO,TELEFONO,DIRECCION) values
(12546789342,'Plaza Vea',1,665-2331,'Av. Lima 132'),
(12546789341,'Tay Loy',2,667-2334,'Av. Lima 321'),
(12546789344,'Promart',3,668-2334,'Av. Lima 566'),
(12546789346,'Tottus',4,669-2334,'Av. Lima 898');

INSERT INTO TB_SUBCATEGORIA (NOMBRE,ID_CATEGORIA) VALUES
('Frutas',1),
('Verduras',1),
('Pollo',2),
('Res',2),
('Cerdo',2),
('Pescados y Mariscos',2),
('Pavo, Pavita y Otras Carnes',2),
('Enrollados',2),
('Hamburguesas, Nuggets y Apanados',2),
('Cafe e Infusiones',3),
('Modificadores de Leche',3),
('Mermeladas',3),
('Mantequilla y Margarina',3),
('Azucar y Endulzantes',3),
('Leche',4),
('Yogurt',4),
('Huevos',4),
('Arroz',5),
('Aceite',5),
('Menestras',5),
('Fideos, Pastas y Salsas',5),
('Postres',6),
('Panetones',6),
('Pan',6),
('Pollo Rostizado',7),
('Comidas Preparadas',7),
('Cremasas y salsal',7),
('Pizza y pastas Frescas',7),
('Helados',8),
('Hielo',8),
('Frutas y verduras congeladas',8),
('Gaseosas',9),
('Agua',9),
('Jugos',9),
('Licores',10),
('Vinos',10),
('Espumantes',10),
('Cervezas',10),
('Cuidado de la ropa',11),
('Cuidado del hogar',11),
('Papel para el hogar',11),
('Limpieza de Baño',11),
('Limpieza de Cocina',11),
('Cuidado de la Piel',12),
('Higiene Personal',12),
('Cuidado Bucal',12),
('Cuidado facial',12),
('Proteccion Solar',12),
('Cuidado Femenino',12),
('Pañales y toallitas',13),
('Alimentacion del Bebe',13),
('Aseo del Bebe',13),
('Comida para perros',14),
('Comidas para gatos',14),
('Salud e Higine para Perro',14),
('Salud e Higiene para Gato',14),
('Accesorio para Perros',14),
('Accesorio para gatos',14);

INSERT INTO TB_USUARIO 
(NOMBRES, APE_MATERNO, APE_PATERNO, CORREO, CLAVE, TIPO_DOC, NRO_DOC, DIRECCION, ID_DISTRITO, TELEFONO, ID_ROL, ID_CARGO)
VALUES
--administradores
('Juan','Perez','Gomez','admin1@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','12345678','Av Lima 123',1,'999888777',1,2),
('Pepe','De la Vega','Chavez','admin2@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','12345679','Av Lima 321',1,'991888777',1,2),
('Lucho','Montez','Zapata','admin3@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','12345179','Av Lima 321',1,'911888777',1,2),
--clientes
('Maria','Lopez','Torres','cliente1@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','87654321','Av Peru 456',2,'999111222',2,NULL),
('Luisania','Enrique','Alvarado','cliente2@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','87651321','Av Peru 156',2,'999111292',2,NULL),

--Vendedor
('Carlos','Ramirez','Diaz','vendedor@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','11223344','Av Sol 789',3,'988777666',3,5),

--Repartidor
('Luis','Fernandez','Castro','repartidor1@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','22334455','Av Norte 321',4,'977666555',4,5),
('Hector','Casas','Narazas','repartidor2@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','20334455','Av Norte 121',4,'977616555',4,5),

--Empleadas
('Ana','Vargas','Rios','empleado@mail.com','$2a$12$mvNPsLkYeND0pRaTKwiFVuqAON6L5ZIEDshtFN3/UEhKE7TRV9bUu','DNI','33445566','Av Sur 654',5,'966555444',5,4);


INSERT INTO TB_SUCURSAL (NOMBRE_UBICACION, ID_EMPRESA, ID_DISTRITO, DIRECCION, FECHA_APERTURA) VALUES
('Chacarrilla',1,1,'Av Central 100','2023-01-10'),
('Primavera',2,2,'Av Norte 200','2023-02-15'),
('Los Proceres',3,3,'Av Sur 300','2023-03-20');

-- SUBCATEGORIA 1 (Frutas)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Manzana','Fruta fresca',1,1),
('Plátano','Fruta fresca',1,1),
('Naranja','Fruta fresca',1,1);

-- SUBCATEGORIA 2 (Verduras)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Tomate','Verdura fresca',1,2),
('Lechuga','Verdura fresca',1,2),
('Zanahoria','Verdura fresca',1,2);

-- SUBCATEGORIA 3 (Pollo)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Pollo entero','Carne fresca',1,3),
('Pechuga de pollo','Carne fresca',1,3),
('Alitas de pollo','Carne fresca',1,3);

-- SUBCATEGORIA 4 (Res)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Carne molida','Carne de res',1,4),
('Bistec','Carne de res',1,4),
('Lomo fino','Carne de res',1,4);

-- SUBCATEGORIA 5 (Cerdo)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Chuleta de cerdo','Carne de cerdo',1,5),
('Costilla de cerdo','Carne de cerdo',1,5),
('Pierna de cerdo','Carne de cerdo',1,5);

-- SUBCATEGORIA 6 (Pescados y Mariscos)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Filete de merluza','Pescado fresco',1,6),
('Camarones','Mariscos frescos',1,6),
('Atún en lata','Conserva de atún',1,6);

-- SUBCATEGORIA 7 (Pavo, Pavita y Otras Carnes)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Pechuga de pavo','Carne de pavo fresca',1,7),
('Pavita entera','Carne de pavita fresca',1,7),
('Codorniz entera','Otra carne fresca',1,7);

-- SUBCATEGORIA 8 (Enrollados)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Enrollado de pollo','Carne enrollada lista para cocinar',1,8),
('Enrollado de res','Carne enrollada lista para cocinar',1,8),
('Enrollado mixto','Carne enrollada lista para cocinar',1,8);

-- SUBCATEGORIA 9 (Hamburguesas, Nuggets y Apanados)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Hamburguesa de res','Carne lista para cocinar',1,9),
('Nuggets de pollo','Apanado listo para freír',1,9),
('Milanesa de pollo','Apanado listo para cocinar',1,9);

-- SUBCATEGORIA 10 (Café e Infusiones)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Café molido 250g','Café de grano molido',1,10),
('Té verde x20 bolsitas','Infusión natural',1,10),
('Manzanilla x20 bolsitas','Infusión natural',1,10);

-- SUBCATEGORIA 11 (Modificadores de Leche)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Milo 400g','Modificador de leche en polvo',1,11),
('Nesquik chocolate 400g','Modificador de leche en polvo',1,11),
('Ovomaltina 400g','Modificador de leche en polvo',1,11);

-- SUBCATEGORIA 12 (Mermeladas)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Mermelada de fresa 300g','Mermelada dulce',1,12),
('Mermelada de durazno 300g','Mermelada dulce',1,12),
('Mermelada de piña 300g','Mermelada dulce',1,12);

-- SUBCATEGORIA 13 (Mantequilla y Margarina)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Mantequilla Gloria 200g','Mantequilla de mesa',1,13),
('Margarina Dorina 200g','Margarina de mesa',1,13),
('Mantequilla sin sal 200g','Mantequilla de mesa',1,13);

-- SUBCATEGORIA 14 (Azúcar y Endulzantes)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Azúcar rubia 1kg','Azúcar de caña',1,14),
('Azúcar blanca 1kg','Azúcar refinada',1,14),
('Stevia en sobres x50','Endulzante natural',1,14);

-- SUBCATEGORIA 15 (Leche)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Leche Gloria entera 1L','Leche UHT entera',1,15),
('Leche Laive semidescremada 1L','Leche UHT semidescremada',1,15),
('Leche en polvo Anchor 400g','Leche en polvo',1,15);

-- SUBCATEGORIA 16 (Yogurt)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Yogurt Gloria fresa 1kg','Yogurt batido',1,16),
('Yogurt Laive natural 500g','Yogurt natural',1,16),
('Yogurt griego 200g','Yogurt griego sin azúcar',1,16);

-- SUBCATEGORIA 17 (Huevos)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Huevo blanco x30','Huevos frescos',1,17),
('Huevo rosado x12','Huevos frescos',1,17),
('Huevo de codorniz x24','Huevos frescos',1,17);

-- SUBCATEGORIA 18 (Arroz)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Arroz Costeño 5kg','Arroz extra',1,18),
('Arroz Paisana 5kg','Arroz superior',1,18),
('Arroz integral 1kg','Arroz integral',1,18);

-- SUBCATEGORIA 19 (Aceite)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Aceite Primor 1L','Aceite vegetal',1,19),
('Aceite de oliva 500ml','Aceite de oliva extra virgen',1,19),
('Aceite Cil 1L','Aceite vegetal',1,19);

-- SUBCATEGORIA 20 (Menestras)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Lentejas 500g','Menestra seca',1,20),
('Frijoles canario 500g','Menestra seca',1,20),
('Garbanzos 500g','Menestra seca',1,20);

-- SUBCATEGORIA 21 (Fideos, Pastas y Salsas)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Fideos Don Vittorio espagueti 500g','Pasta seca',1,21),
('Fideos Lavaggi tallarín 500g','Pasta seca',1,21),
('Salsa de tomate Heinz 500g','Salsa para pasta',1,21);

-- SUBCATEGORIA 22 (Postres)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Flan en polvo 100g','Mezcla para postre',1,22),
('Gelatina de fresa 100g','Mezcla para postre',1,22),
('Mousse de chocolate 150g','Postre listo para preparar',1,22);

-- SUBCATEGORIA 23 (Panetones)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Panetón D Onofrio 900g','Panetón clásico',1,23),
('Panetón Bimbo 900g','Panetón clásico',1,23),
('Panetón Todinno 600g','Panetón familiar',1,23);

-- SUBCATEGORIA 24 (Pan)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Pan de molde blanco','Pan de caja',1,24),
('Pan de molde integral','Pan de caja integral',1,24),
('Pan ciabatta','Pan artesanal',1,24);

-- SUBCATEGORIA 25 (Pollo Rostizado)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Pollo rostizado entero','Pollo a la brasa listo',1,25),
('Pollo rostizado medio','Medio pollo a la brasa',1,25),
('Pollo rostizado cuarto','Cuarto de pollo a la brasa',1,25);

-- SUBCATEGORIA 26 (Comidas Preparadas)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Lomo saltado porción','Comida preparada lista',1,26),
('Arroz con leche porción','Postre preparado listo',1,26),
('Causa rellena porción','Comida preparada lista',1,26);

-- SUBCATEGORIA 27 (Cremas y Salsas)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Mayonesa Alacena 500g','Salsa lista para usar',1,27),
('Ají amarillo en crema 300g','Crema peruana',1,27),
('Huancaína en crema 300g','Crema peruana',1,27);

-- SUBCATEGORIA 28 (Pizza y Pastas Frescas)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Pizza margarita fresca','Pizza fresca lista para hornear',1,28),
('Ravioles de espinaca 250g','Pasta fresca rellena',1,28),
('Fetuccini fresco 250g','Pasta fresca',1,28);

-- SUBCATEGORIA 29 (Helados)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Helado D Onofrio vainilla 1L','Helado de crema',1,29),
('Helado Lamborghini chocolate 1L','Helado de crema',1,29),
('Paleta de fresa x6','Paletas heladas',1,29);

-- SUBCATEGORIA 30 (Hielo)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Hielo en cubos 2kg','Hielo envasado',1,30),
('Hielo en barra 5kg','Hielo en barra',1,30),
('Hielo triturado 1kg','Hielo triturado envasado',1,30);

-- SUBCATEGORIA 31 (Frutas y Verduras Congeladas)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Mezcla de verduras congelada 500g','Verduras congeladas listas',1,31),
('Fresas congeladas 400g','Fruta congelada',1,31),
('Choclo desgranado congelado 400g','Verdura congelada',1,31);

-- SUBCATEGORIA 32 (Gaseosas)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Coca-Cola 2.5L','Gaseosa',1,32),
('Inca Kola 2.5L','Gaseosa',1,32),
('Sprite 1.5L','Gaseosa',1,32);

-- SUBCATEGORIA 33 (Agua)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Agua San Luis 2.5L','Agua de mesa sin gas',1,33),
('Agua Cielo 625ml','Agua de mesa sin gas',1,33),
('Agua San Mateo con gas 1L','Agua mineral con gas',1,33);

-- SUBCATEGORIA 34 (Jugos)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Jugo Pulp naranja 1L','Jugo de fruta',1,34),
('Jugo Frugos durazno 1L','Jugo de fruta',1,34),
('Jugo de maracuyá 1L','Jugo natural',1,34);

-- SUBCATEGORIA 35 (Licores)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Pisco Queirolo 750ml','Pisco puro',1,35),
('Ron Cartavio 750ml','Ron añejo',1,35),
('Whisky Johnnie Walker Red 750ml','Whisky escocés',1,35);

-- SUBCATEGORIA 36 (Vinos)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Vino tinto Casillero del Diablo 750ml','Vino tinto seco',1,36),
('Vino blanco Santa Helena 750ml','Vino blanco seco',1,36),
('Vino rosado Concha y Toro 750ml','Vino rosado',1,36);

-- SUBCATEGORIA 37 (Espumantes)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Espumante Riccadonna 750ml','Espumante dulce',1,37),
('Espumante Freixenet 750ml','Espumante brut',1,37),
('Espumante Mumm 750ml','Espumante premium',1,37);

-- SUBCATEGORIA 38 (Cervezas)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Cerveza Cristal 6x355ml','Cerveza rubia',1,38),
('Cerveza Pilsen 6x355ml','Cerveza rubia',1,38),
('Cerveza Corona 6x355ml','Cerveza rubia importada',1,38);

-- SUBCATEGORIA 39 (Cuidado de la Ropa)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Detergente Ariel 2kg','Detergente en polvo',1,39),
('Suavizante Downy 1L','Suavizante de telas',1,39),
('Lejía Clorox 1L','Blanqueador para ropa',1,39);

-- SUBCATEGORIA 40 (Cuidado del Hogar)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Desinfectante Lysol 900ml','Desinfectante multiusos',1,40),
('Limpiatodo Sapolio 500ml','Limpiador multiusos',1,40),
('Insecticida Raid 360ml','Aerosol insecticida',1,40);

-- SUBCATEGORIA 41 (Papel para el Hogar)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Papel higiénico Elite x12','Papel higiénico suave',1,41),
('Papel toalla Suave x2','Papel de cocina absorbente',1,41),
('Servilletas Scott x100','Servilletas de mesa',1,41);

-- SUBCATEGORIA 42 (Limpieza de Baño)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Limpiador de baño Sapolio 500ml','Limpiador para inodoro',1,42),
('Pato WC gel 500ml','Gel limpiador de inodoro',1,42),
('Quitasarro Clorox 500ml','Removedor de sarro',1,42);

-- SUBCATEGORIA 43 (Limpieza de Cocina)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Lavaloza Ayudín limón 500ml','Lavavajillas líquido',1,43),
('Esponja de acero x3','Esponja metálica',1,43),
('Desengrasante Sapolio 500ml','Desengrasante de cocina',1,43);

-- SUBCATEGORIA 44 (Cuidado de la Piel)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Crema Nivea cuerpo 400ml','Crema hidratante',1,44),
('Loción Lubriderm 400ml','Loción corporal',1,44),
('Vaselina Original 100g','Crema protectora',1,44);

-- SUBCATEGORIA 45 (Higiene Personal)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Shampoo Head & Shoulders 400ml','Shampoo anticaspa',1,45),
('Jabón Dove 90g x3','Jabón de baño',1,45),
('Desodorante Rexona roll-on 50ml','Desodorante antitranspirante',1,45);

-- SUBCATEGORIA 46 (Cuidado Bucal)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Pasta dental Colgate 150g','Pasta dental flúor',1,46),
('Cepillo dental Oral-B','Cepillo dental suave',1,46),
('Enjuague bucal Listerine 500ml','Enjuague antibacterial',1,46);

-- SUBCATEGORIA 47 (Cuidado Facial)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Desmaquillante Pond s 200ml','Desmaquillante facial',1,47),
('Crema facial Olay 50g','Crema hidratante facial',1,47),
('Tónico facial Neutrogena 150ml','Tónico limpiador',1,47);

-- SUBCATEGORIA 48 (Protección Solar)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Protector solar Coppertone FPS50 150ml','Bloqueador solar',1,48),
('Bloqueador Banana Boat FPS30 150ml','Protector solar',1,48),
('Protector solar facial Neutrogena FPS50','Bloqueador facial',1,48);

-- SUBCATEGORIA 49 (Cuidado Femenino)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Toallas Always Normal x10','Toalla femenina',1,49),
('Tampones Tampax x8','Tampón de algodón',1,49),
('Protectores Kotex x30','Protector diario',1,49);

-- SUBCATEGORIA 50 (Pañales y Toallitas)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Pañales Huggies talla M x40','Pañales desechables',1,50),
('Pañales Pampers talla G x36','Pañales desechables',1,50),
('Toallitas húmedas WaterWipes x80','Toallitas para bebé',1,50);

-- SUBCATEGORIA 51 (Alimentación del Bebé)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Leche NAN 1 800g','Fórmula láctea etapa 1',1,51),
('Papilla Nestlé arroz 200g','Papilla para bebé',1,51),
('Cereal Gerber avena 227g','Cereal para bebé',1,51);

-- SUBCATEGORIA 52 (Aseo del Bebé)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Shampoo Johnson s Baby 400ml','Shampoo para bebé',1,52),
('Crema Johnsons Baby 200g','Crema protectora para bebé',1,52),
('Jabón Dove Baby 75g','Jabón suave para bebé',1,52);

-- SUBCATEGORIA 53 (Comida para Perros)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Croquetas Purina Dog Chow 2kg','Alimento seco para perro',1,53),
('Pedigree adulto 2kg','Alimento seco para perro',1,53),
('Royal Canin adulto 1.5kg','Alimento premium para perro',1,53);

-- SUBCATEGORIA 54 (Comida para Gatos)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Whiskas adulto 1kg','Alimento para gato adulto',1,54),
('Felix pouch salmón x12','Alimento húmedo para gato',1,54),
('Royal Canin gato adulto 1.5kg','Alimento premium para gato',1,54);

-- SUBCATEGORIA 55 (Salud e Higiene para Perro)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Shampoo para perro Bañó Bello 500ml','Shampoo canino',1,55),
('Antiparasitario Frontline perro','Pipeta antiparasitaria',1,55),
('Pasta dental canina 100g','Higiene bucal canina',1,55);

-- SUBCATEGORIA 56 (Salud e Higiene para Gato)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Antiparasitario Frontline gato','Pipeta antiparasitaria',1,56),
('Arena sanitaria Catsan 5kg','Arena para gato',1,56),
('Shampoo para gato 250ml','Shampoo felino',1,56);

-- SUBCATEGORIA 57 (Accesorios para Perros)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Correa ajustable para perro','Correa de paseo',1,57),
('Collar de nylon talla M','Collar para perro',1,57),
('Juguete mordedor de goma','Juguete para perro',1,57);

-- SUBCATEGORIA 58 (Accesorios para Gatos)
INSERT INTO TB_PRODUCTO (NOMBRE, DESCRIPCION, ID_EMPRESA, ID_SUBCATEGORIA) VALUES
('Rascador de cartón para gato','Rascador básico',1,58),
('Pelota con cascabel para gato','Juguete para gato',1,58),
('Comedero doble de acero gato','Comedero para gato',1,58);
