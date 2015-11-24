create database igpa;

create table Materia
(
IdMateria int auto_increment not null,
NombreMateria varchar(50) not null,
primary key (IdMateria)
);

create table Tema
(
IdTema int auto_increment not null ,
NombreTema varchar(50) not null,
IdMateria int not null,
primary key (IdTema),
foreign key (IdMateria) references Materia (IdMateria) on delete cascade
);

create table TipoPregunta
(
IdTipoPregunta int auto_increment not null ,
NombreTipoPregunta varchar(50) not null,
CantRespuestasPosibles int not null,
CantREspuestasCorrectas int not null,
primary key (IdTipoPregunta)
);

create table Pregunta(
IdPregunta int auto_increment not null,
Enunciado varchar(250) not null,
Complejdad int not null,
IdTipoPregunta int not null,
IdTema int not null,
primary key (IdPregunta),
foreign key (IdTema) references Tema (IdTema) on delete cascade,
foreign key (IdTipoPregunta) references TipoPregunta (IdTipoPregunta) on delete cascade
);

create table Respuesta(
IdRespuesta int auto_increment not null,
Respuesta varchar(250) not null,
ValorResultado bool not null,
IdPregunta int not null,
primary key (IdRespuesta),
foreign key (IdPregunta) references Pregunta (IdPregunta) on delete cascade
);

insert into TipoPregunta(IdTipoPregunta, NombreTipoPregunta, CantRespuestasPosibles, CantREspuestasCorrectas)
values (1,'Falso-Verdadero', 2,1);
insert into TipoPregunta(IdTipoPregunta, NombreTipoPregunta, CantRespuestasPosibles, CantREspuestasCorrectas)
values (2,'Selección Múltiple única Respuesta', 4,1);
insert into TipoPregunta(IdTipoPregunta, NombreTipoPregunta, CantRespuestasPosibles, CantREspuestasCorrectas)
values (3,'Selección Múltiple Múltiple Respuesta', 4,2);

insert into materia(IdMateria, NombreMateria)
values (1,'Biologia');
insert into materia(IdMateria, NombreMateria)
values (2,'Microbioligia ');
insert into materia(IdMateria, NombreMateria)
values (3,'Sistemas  ');
insert into materia(IdMateria, NombreMateria)
values (4,'Matematicas ');
insert into materia(IdMateria, NombreMateria)
values (5,'Fisica ');
insert into materia(IdMateria, NombreMateria)
values (6,'Biologia ');
insert into materia(IdMateria, NombreMateria)
values (7,'Lenguas ');
insert into materia(IdMateria, NombreMateria)
values (8,'Cultura ');
insert into materia(IdMateria, NombreMateria)
values (9,'Aritmetica ');
insert into materia(IdMateria, NombreMateria)
values (10,'Logica ');

insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values( 1, 'El aumento de la abundancia de bacterias que degradan la materia orgánica se puede dar gracias', 1,2,2);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values( 2, 'Una medición de alta turbiedad en un río corresponderá a :', 2,2,3);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values( 3, 'Con respecto a los patrones de cauces de las corrientes el orden lógico sería :', 1,2,3);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values( 4, 'Usted está realizando mediciones de oxígeno disuelto en la parte baja de un río, una vez tomados los datos usted encontrará :', 3,2,3);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values( 5, 'Le entregan resultados de medición de sólidos suspendidos  para una quebrada, dicha característica corresponde a :', 2,2,3);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values( 6, 'La fauna predominante de un lecho con sustrato arcilloso será :', 3,2,2);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values( 7, 'Lagos con aguas cargadas de ácido carbónico corresponden a :', 1,2,3);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values( 8, 'Una de las técnicas más de materia orgánica es :', 3,2,3);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values (9,'Se consideran características de las bacterias Gram positivas : ',3,2,2);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values (10,'Usted ha sido contratado con el fin de realizar pruebas de efectividad para la acción de una cepa de (Nitrobacter sp.) para mostrar los efectos positivos de esta usted realizaría las pruebas en : ',3,2,2);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values (11,'Con el fin de controlar  la eutrofización en cuerpo de agua lentico usted recomendaría, teniendo en cuenta que se necesita un resultado rápido y económico : ',2,2,2);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values (12,'A un paciente con amigdalitis  se le realizó un frotis faríngeo para identificar la bacteria responsable de esta inflamación. Al colocar el frotis al microscopio después de una tinción de Gram se observa una formación de cocos simples sin formación de cadenas, de color violeta. Estos resultados nos indican que el microorganismo causante de la inflamación corresponde a :   ',3,2,2);
insert into pregunta(IdPregunta, Enunciado, Complejidad, IdTipoPregunta, IdTema)
values (13,'El proceso de desnitrificación , realizado por bacterias anaerobias, evalúa la pérdida de nitrógeno para un ecosistema que requiere alta productividad; en altas temperaturas predomina la producción de nitrógeno atmosférico y en bajas temperaturas la de óxido nitroso. Usted es contratado para determinar si en un ecosistema  tipo humedal en la Sabana de Bogotá si este proceso de desnitrificación es alto y por ende se está perdiendo productividad, por lo que usted recomienda un análisis de : ',3,2,2);

insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (1,'a.     Adición de azúcares simples ',1,1);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (2,'b.     Adición de lignina ',0,1);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (3,'c.     Adición de celulosa ',0,1);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (4,'d.     Cambios bruscos de la relación C:N ',0,1);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (5,'a.     Impedimento de paso de rayos solares por alta concentración de sólidos suspendidos y poco intercambio gaseoso. ',1,2);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (6,'b.     Alta concentración de sólidos disueltos y alta conductividad eléctrica y pérdida de fauna por presión osmótica. ',0,2);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (7,'c.     Impedimento de paso de rayos solares por alta concentración de sólidos disueltos y poco intercambio gaseoso. ',0,2);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (8,'d.     Alta concentración de sólidos disueltos y baja conductividad eléctrica y pérdida de fauna por presión osmótica. ',0,2);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (9,'a.     Quebrada, riachuelo y cauce ',0,3);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (10,'b.     Cauce, quebrada y río ',0,3);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (11,'c.     Riachuelo, quebrada y meandros ',1,3);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (12,'d.     Riachuelo, delta y quebrada ',0,3);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (13,'a.     Alta concentración de materia orgánica ',0,4);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (14,'b.     Bajas concentraciones de oxígeno disuelto ',1,4);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (15,'c.     Baja conductividad eléctrica ',0,4);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (16,'d.     Baja temperatura ',0,4);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (17,'a.     Materia orgánica en forma de detritos que se ve a simple vista. ',1,5);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (18,'b.     Materia inorgánica en forma iónica. ',0,5);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (19,'c.     Conductividad eléctrica ',0,5);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (20,'d.     Oxígeno disuelto ',0,5);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (21,'a.     Fauna adaptada con ventosas y cuerpos aplanados, muy diversa. ',0,6);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (22,'b.     Fauna adaptada con ventosas y cuerpos aplanados, poco diversa. ',0,6);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (23,'c.     Fauna adaptada a bajas de oxígeno con predominancia en los moluscos. ',1,6);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (24,'d.     Fauna no adaptada a bajas de oxígeno. ',0,6);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (25,'a.     Lagos formados por acumulación de materia orgánica ',0,7);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (26,'b.     Lagos formados por disolución del sustrato ',1,7);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (27,'c.     Lagos formados por actividad animal ',0,7);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (28,'d.     Lagos por deslizamiento de terreno ',0,7);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (29,'a.     Medición de rata fotosintética ',0,8);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (30,'b.     Medición de la liberación de CO2 ',1,8);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (31,'c.     Recuento de degradadores de carbono ',0,8);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (32,'d.     Medición de nitratos ',0,8);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (33,'A.          Son rosadas, carecen de pared y tienen alta concentración de peptidoglucano. ',0,9);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (34,'B.           Son rosadas, tiene poca cantidad de peptidoglucano, poca o nula presencia de ácidos teicoícos. ',0,9);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (35,'C.          Alta concentración de peptidoglucano, de ácidos teicoicos y de color morado. ',1,9);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (36,'D.           Baja concentración de peptidoglucano, de ácidos teicoicos y de color morado. ',0,9);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (37,'A.   Un suelo rico en nitritos ',0,10);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (38,'B.    Un suelo rico en nitratos ',0,10);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (39,'C.  Un selo en donde no se evidencie fijación de nitrógeno ',0,10);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (40,'D.   Un suelo rico en fosfatos ',1,10);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (41,'A.     Realizaría un control desde la entrada con énfasis en tratamiento de residuos antes de ser volcados al cuerpo de agua  y uso de prepantanos y control dentro del cuerpo de agua con énfasis en dragado y precipitación de fósforo ',1,11);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (42,'B.     Realizaría un control desde la entrada con énfasis en tratamiento de residuos antes de ser volcados al cuerpo de agua  y uso de prepantanos y control dentro del cuerpo de agua con énfasis en dragado y precipitación de nitrógeno.  ',0,11);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (43,'C.    Recolección de malezas acuáticas, dragado, uso de control biológico, técnicas para precipitación de fósforo ',0,11);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (44,'D.     Dragado y precipitación de fósforo. ',0,11);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (45,'A.           Estreptococo Gram negativo    ',1,12);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (46,'B.            Estafilococo Gram negativo  ',0,12);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (47,'C.          Estreptococo Gram positivo ',0,12);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (48,'D.           Cocos Gram positivos ',0,12);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (49,'A.           N2 ,  recuento total de  anaerobios y aerobios ',0,13);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (50,'B.            NH3 y recuento total de anaerobios ',0,13);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (51,'C.          N2O y recuento total de anaerobios y aerobios ',1,13);
insert into	respuesta(IdRespuesta, Respuesta,	ValorResultado, IdPregunta)
values (52,'D.           N2  y  recuento total de  anaerobios ',1,13);
