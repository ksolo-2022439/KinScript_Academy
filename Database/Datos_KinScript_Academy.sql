USE KinScript_Academy;

INSERT INTO Grados (nombreGrado) VALUES
('1ro Básico'), ('2do Básico'), ('3ro Básico'),
('4to Perito'), ('5to Perito'), ('6to Perito');

INSERT INTO Secciones (nombreSeccion) VALUES ('A'), ('B'), ('C'), ('D');

INSERT INTO Jornadas (nombreJornada) VALUES ('Matutina'), ('Vespertina');

INSERT INTO Cursos (nombreCurso) VALUES
('Física Fundamental'), ('Sociales'), ('Artes Plásticas'), ('Formación Músical'),
('Educación Física'), ('Idioma Inglés'), ('Emprendimiento para la productividad'),
('Idioma Español'), ('Cultura e Idiomas Mayas'), ('Matemáticas'), ('Programa de Actitudes'),
('Religión'), ('TICS'), ('Química'),
('Tecnología I'), ('Sociales I'), ('Inglés I'), ('Ética I'), ('Física I'),
('Lengua y Literatura I'), ('Matemáticas I'), ('Estadística I'), ('Taller I'), ('TICS I'),
('Tecnología II'), ('Sociales II'), ('Inglés II'), ('Ética II'), ('Física II'),
('Lengua y Literatura II'), ('Matemáticas II'), ('Química 5'), ('Taller II'), ('TICS II'),
('Tecnología III'), ('Sociales III'), ('Inglés III'), ('Ética III'), ('Física III'),
('Lengua y Literatura III'), ('Matemáticas III'), ('Biología 6'), ('Taller III'), ('TICS III');

INSERT INTO Carreras (nombreCarrera) VALUES
('Informática'),
('Mecánica Automotriz'),
('Electricidad Industrial'),
('Dibujo Técnico de Ingeniería y Arquitectura'),
('Electrónica Industrial'),
('Electrónica en Computación');

-- -----------------------------------------------------
-- Asignación de Cursos para 1ro Básico
-- -----------------------------------------------------
INSERT INTO GradoCurso (idGrado, idCurso) VALUES
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Sociales')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Artes Plásticas')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Formación Músical')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Educación Física')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Idioma Inglés')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Emprendimiento para la productividad')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Idioma Español')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Cultura e Idiomas Mayas')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Matemáticas')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Programa de Actitudes')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Religión')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '1ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'TICS'));

-- -----------------------------------------------------
-- Asignación de Cursos para 2do Básico
-- -----------------------------------------------------
INSERT INTO GradoCurso (idGrado, idCurso) VALUES
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Sociales')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Artes Plásticas')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Formación Músical')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Educación Física')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Idioma Inglés')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Emprendimiento para la productividad')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Idioma Español')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Cultura e Idiomas Mayas')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Matemáticas')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Programa de Actitudes')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Religión')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '2do Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'TICS'));

-- -----------------------------------------------------
-- Asignación de Cursos para 3ro Básico
-- -----------------------------------------------------
INSERT INTO GradoCurso (idGrado, idCurso) VALUES
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Sociales')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Artes Plásticas')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Formación Músical')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Educación Física')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Idioma Inglés')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Emprendimiento para la productividad')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Idioma Español')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Cultura e Idiomas Mayas')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Matemáticas')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Programa de Actitudes')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Religión')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'TICS')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Física Fundamental')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '3ro Básico'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Química'));

-- -----------------------------------------------------
-- Asignación de Cursos para 4to Perito
-- -----------------------------------------------------
INSERT INTO GradoCurso (idGrado, idCurso) VALUES
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Tecnología I')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Sociales I')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Inglés I')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Ética I')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Física I')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Lengua y Literatura I')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Matemáticas I')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Estadística I')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Taller I')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'TICS I')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '4to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Educación Física'));

-- -----------------------------------------------------
-- Asignación de Cursos para 5to Perito
-- -----------------------------------------------------
INSERT INTO GradoCurso (idGrado, idCurso) VALUES
((SELECT idGrado FROM Grados WHERE nombreGrado = '5to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Tecnología II')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '5to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Sociales II')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '5to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Inglés II')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '5to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Ética II')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '5to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Física II')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '5to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Lengua y Literatura II')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '5to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Matemáticas II')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '5to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Química 5')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '5to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Taller II')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '5to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'TICS II'));

-- -----------------------------------------------------
-- Asignación de Cursos para 6to Perito
-- -----------------------------------------------------
INSERT INTO GradoCurso (idGrado, idCurso) VALUES
((SELECT idGrado FROM Grados WHERE nombreGrado = '6to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Tecnología III')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '6to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Sociales III')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '6to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Inglés III')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '6to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Ética III')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '6to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Física III')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '6to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Lengua y Literatura III')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '6to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Matemáticas III')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '6to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Biología 6')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '6to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'Taller III')),
((SELECT idGrado FROM Grados WHERE nombreGrado = '6to Perito'), (SELECT idCurso FROM Cursos WHERE nombreCurso = 'TICS III'));

select * from Cursos;