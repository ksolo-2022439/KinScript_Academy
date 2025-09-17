-- USE KinScript_Academy;

INSERT IGNORE INTO Grados (nombre_grado) VALUES
('1ro Básico'), ('2do Básico'), ('3ro Básico'),
('4to Perito'), ('5to Perito'), ('6to Perito');

INSERT IGNORE INTO Secciones (nombre_seccion) VALUES ('A'), ('B'), ('C'), ('D');

INSERT IGNORE INTO Jornadas (nombre_jornada) VALUES ('Matutina'), ('Vespertina');

INSERT IGNORE INTO Cursos (nombre_curso) VALUES
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

INSERT IGNORE INTO Carreras (nombre_carrera) VALUES
('Informática'),
('Mecánica Automotriz'),
('Electricidad Industrial'),
('Dibujo Técnico de Ingeniería y Arquitectura'),
('Electrónica Industrial'),
('Electrónica en Computación');

-- -----------------------------------------------------
-- Asignación de Cursos para 1ro Básico
-- -----------------------------------------------------
INSERT IGNORE INTO grado_curso (id_grado, id_curso) VALUES
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Sociales')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Artes Plásticas')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Formación Músical')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Educación Física')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Idioma Inglés')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Emprendimiento para la productividad')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Idioma Español')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Cultura e Idiomas Mayas')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Matemáticas')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Programa de Actitudes')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Religión')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '1ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'TICS'));

-- -----------------------------------------------------
-- Asignación de Cursos para 2do Básico
-- -----------------------------------------------------
INSERT IGNORE INTO grado_curso (id_grado, id_curso) VALUES
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Sociales')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Artes Plásticas')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Formación Músical')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Educación Física')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Idioma Inglés')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Emprendimiento para la productividad')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Idioma Español')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Cultura e Idiomas Mayas')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Matemáticas')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Programa de Actitudes')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Religión')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '2do Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'TICS'));

-- -----------------------------------------------------
-- Asignación de Cursos para 3ro Básico
-- -----------------------------------------------------
INSERT IGNORE INTO grado_curso (id_grado, id_curso) VALUES
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Sociales')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Artes Plásticas')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Formación Músical')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Educación Física')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Idioma Inglés')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Emprendimiento para la productividad')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Idioma Español')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Cultura e Idiomas Mayas')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Matemáticas')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Programa de Actitudes')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Religión')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'TICS')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Física Fundamental')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '3ro Básico'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Química'));

-- -----------------------------------------------------
-- Asignación de Cursos para 4to Perito
-- -----------------------------------------------------
INSERT IGNORE INTO grado_curso (id_grado, id_curso) VALUES
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Tecnología I')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Sociales I')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Inglés I')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Ética I')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Física I')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Lengua y Literatura I')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Matemáticas I')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Estadística I')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Taller I')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'TICS I')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '4to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Educación Física'));

-- -----------------------------------------------------
-- Asignación de Cursos para 5to Perito
-- -----------------------------------------------------
INSERT IGNORE INTO grado_curso (id_grado, id_curso) VALUES
((SELECT id_grado FROM Grados WHERE nombre_grado = '5to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Tecnología II')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '5to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Sociales II')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '5to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Inglés II')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '5to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Ética II')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '5to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Física II')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '5to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Lengua y Literatura II')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '5to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Matemáticas II')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '5to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Química 5')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '5to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Taller II')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '5to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'TICS II'));

-- -----------------------------------------------------
-- Asignación de Cursos para 6to Perito
-- -----------------------------------------------------
INSERT IGNORE INTO grado_curso (id_grado, id_curso) VALUES
((SELECT id_grado FROM Grados WHERE nombre_grado = '6to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Tecnología III')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '6to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Sociales III')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '6to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Inglés III')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '6to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Ética III')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '6to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Física III')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '6to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Lengua y Literatura III')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '6to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Matemáticas III')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '6to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Biología 6')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '6to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'Taller III')),
((SELECT id_grado FROM Grados WHERE nombre_grado = '6to Perito'), (SELECT id_curso FROM Cursos WHERE nombre_curso = 'TICS III'));

-- select * from Cursos;