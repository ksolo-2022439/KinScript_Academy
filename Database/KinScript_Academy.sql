CREATE DATABASE IF NOT EXISTS KinScript_Academy;
USE KinScript_Academy;

-- -----------------------------------------------------
-- Tabla: Tutores
-- Almacena la información de los tutores o encargados de los alumnos.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Tutores (
  idTutor INT NOT NULL AUTO_INCREMENT,
  nombreCompleto VARCHAR(100) NOT NULL,
  apellidoCompleto VARCHAR(100) NOT NULL,
  numeroTelefono VARCHAR(15) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  CONSTRAINT pk_tutor PRIMARY KEY (idTutor)
);

-- -----------------------------------------------------
-- Tabla: Grados
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Grados (
  idGrado INT NOT NULL AUTO_INCREMENT,
  nombreGrado VARCHAR(45) NOT NULL UNIQUE,
  CONSTRAINT pk_grado PRIMARY KEY (idGrado)
);

-- -----------------------------------------------------
-- Tabla: Secciones
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Secciones (
  idSeccion INT NOT NULL AUTO_INCREMENT,
  nombreSeccion CHAR(1) NOT NULL UNIQUE,
  CONSTRAINT pk_seccion PRIMARY KEY (idSeccion)
);

-- -----------------------------------------------------
-- Tabla: Jornadas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Jornadas (
  idJornada INT NOT NULL AUTO_INCREMENT,
  nombreJornada VARCHAR(20) NOT NULL UNIQUE,
  CONSTRAINT pk_jornada PRIMARY KEY (idJornada)
);

-- -----------------------------------------------------
-- Tabla: Carreras
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Carreras (
  idCarrera INT NOT NULL AUTO_INCREMENT,
  nombreCarrera VARCHAR(100) NOT NULL UNIQUE,
  CONSTRAINT pk_carrera PRIMARY KEY (idCarrera)
);

-- -----------------------------------------------------
-- Tabla: Alumnos
-- Tabla principal que contiene toda la información de los alumnos.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Alumnos (
  idAlumno INT NOT NULL AUTO_INCREMENT,
  carnetAlumno VARCHAR(20) NOT NULL UNIQUE,
  nombreCompleto VARCHAR(100) NOT NULL,
  apellidoCompleto VARCHAR(100) NOT NULL,
  emailAcademico VARCHAR(255) NOT NULL,
  contrasena VARCHAR(255) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  idGrado INT NOT NULL,
  idSeccion INT NOT NULL,
  idJornada INT NULL, -- Puede ser NULO para 1ro a 3ro básico
  idCarrera INT NULL, -- Puede ser NULO para 1ro a 3ro básico
  idTutor INT NOT NULL,
  CONSTRAINT pk_alumno PRIMARY KEY (idAlumno),
  CONSTRAINT fk_alumno_grado FOREIGN KEY (idGrado) REFERENCES Grados (idGrado),
  CONSTRAINT fk_alumno_seccion FOREIGN KEY (idSeccion) REFERENCES Secciones (idSeccion),
  CONSTRAINT fk_alumno_jornada FOREIGN KEY (idJornada) REFERENCES Jornadas (idJornada),
  CONSTRAINT fk_alumno_carrera FOREIGN KEY (idCarrera) REFERENCES Carreras (idCarrera),
  CONSTRAINT fk_alumno_tutor FOREIGN KEY (idTutor) REFERENCES Tutores (idTutor)
);

CREATE INDEX idx_carnetAlumno ON Alumnos (carnetAlumno);
CREATE INDEX idx_fk_alumno_grado ON Alumnos (idGrado);
CREATE INDEX idx_fk_alumno_seccion ON Alumnos (idSeccion);
CREATE INDEX idx_fk_alumno_jornada ON Alumnos (idJornada);
CREATE INDEX idx_fk_alumno_carrera ON Alumnos (idCarrera);
CREATE INDEX idx_fk_alumno_tutor ON Alumnos (idTutor);

-- -----------------------------------------------------
-- Tabla: Profesores
-- Almacena la información de los profesores.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Profesores (
  idProfesor INT NOT NULL AUTO_INCREMENT,
  nombreCompleto VARCHAR(100) NOT NULL,
  apellidoCompleto VARCHAR(100) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  numeroTelefono VARCHAR(15) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  contrasena VARCHAR (255) NOT NULL,
  CONSTRAINT pk_profesor PRIMARY KEY (idProfesor)
);

-- -----------------------------------------------------
-- Tabla: Coordinadores
-- Almacena la información de los coordinadores académicos.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Coordinadores (
  idCoordinador INT NOT NULL AUTO_INCREMENT,
  nombreCompleto VARCHAR(100) NOT NULL,
  apellidoCompleto VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  contrasena VARCHAR(255) NOT NULL,
  idGrado INT NOT NULL,
  CONSTRAINT pk_coordinador PRIMARY KEY (idCoordinador),
  CONSTRAINT fk_coordinador_grado FOREIGN KEY (idGrado) REFERENCES Grados (idGrado)
);

CREATE INDEX idx_fk_coordinador_grado ON Coordinadores (idGrado);

-- -----------------------------------------------------
-- Tabla: Cursos
-- Catálogo de todos las Cursos que se imparten en el colegio.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cursos (
  idCurso INT NOT NULL AUTO_INCREMENT,
  nombreCurso VARCHAR(100) NOT NULL UNIQUE,
  CONSTRAINT pk_curso PRIMARY KEY (idCurso)
);

-- -----------------------------------------------------
-- Tabla: Notas
-- Almacena las notas de cada alumno por curso y por bimestre.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Notas (
  idNota INT NOT NULL AUTO_INCREMENT,
  idAlumno INT NOT NULL,
  idCurso INT NOT NULL,
  bimestre1 DECIMAL(5, 2) NULL,
  bimestre2 DECIMAL(5, 2) NULL,
  bimestre3 DECIMAL(5, 2) NULL,
  bimestre4 DECIMAL(5, 2) NULL,
  CONSTRAINT pk_nota PRIMARY KEY (idNota),
  CONSTRAINT fk_nota_alumno FOREIGN KEY (idAlumno) REFERENCES Alumnos (idAlumno),
  CONSTRAINT fk_nota_curso FOREIGN KEY (idCurso) REFERENCES Cursos (idCurso)
);

CREATE INDEX idx_fk_nota_alumno ON Notas (idAlumno);
CREATE INDEX idx_fk_nota_curso ON Notas (idCurso);

-- -----------------------------------------------------
-- Tabla de Asignación: GradoCurso
-- Tabla intermedia para definir qué Cursos corresponden a cada grado.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS GradoCurso (
    idGrado INT NOT NULL,
    idCurso INT NOT NULL,
    CONSTRAINT pk_grado_curso PRIMARY KEY (idGrado, idCurso),
    CONSTRAINT fk_gm_grado FOREIGN KEY (idGrado) REFERENCES Grados (idGrado),
    CONSTRAINT fk_gm_curso FOREIGN KEY (idCurso) REFERENCES Cursos (idCurso)
);

-- -----------------------------------------------------
-- Tabla de Asignación: ProfesorAsignacion
-- Tabla intermedia para asignar un profesor a un curso en un grado, sección y jornada específicos.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ProfesorAsignacion (
    idProfesor INT NOT NULL,
    idCurso INT NOT NULL,
    idGrado INT NOT NULL,
    idSeccion INT NOT NULL,
    idJornada INT NULL, -- Puede ser nulo para 1ro a 3ro
    CONSTRAINT pk_profesor_asignacion PRIMARY KEY (idProfesor, idCurso, idGrado, idSeccion),
    CONSTRAINT fk_pa_profesor FOREIGN KEY (idProfesor) REFERENCES Profesores (idProfesor),
    CONSTRAINT fk_pa_curso FOREIGN KEY (idCurso) REFERENCES Cursos (idCurso),
    CONSTRAINT fk_pa_grado FOREIGN KEY (idGrado) REFERENCES Grados (idGrado),
    CONSTRAINT fk_pa_seccion FOREIGN KEY (idSeccion) REFERENCES Secciones (idSeccion),
    CONSTRAINT fk_pa_jornada FOREIGN KEY (idJornada) REFERENCES Jornadas (idJornada)
);