# 🎓 KinScript Academy

## Descripción del Proyecto

KinScript Academy es un sistema integral de gestión académica desarrollado con Spring Boot, diseñado para facilitar la administración completa de instituciones educativas. El sistema permite gestionar alumnos, profesores, cursos, notas, tutores y toda la estructura organizacional de un centro académico.

## ✨ Características Principales

### 📚 Gestión Académica Completa
- **Gestión de Alumnos**: Registro, modificación y seguimiento completo de estudiantes
- **Gestión de Profesores**: Administración del personal docente y sus asignaciones
- **Gestión de Cursos**: Creación y administración de materias académicas
- **Sistema de Notas**: Registro y seguimiento del rendimiento académico
- **Gestión de Tutores**: Administración de tutores o encargados de los estudiantes

### 🏗️ Estructura Organizacional
- **Grados**: Gestión de niveles académicos
- **Secciones**: Organización por secciones (A, B, C, etc.)
- **Jornadas**: Administración de horarios (matutina, vespertina, nocturna)
- **Carreras**: Gestión de programas académicos
- **Coordinadores**: Administración del personal coordinador

### 🔧 Funcionalidades Técnicas
- **API REST** completa con operaciones CRUD
- **Documentación interactiva** con Swagger/OpenAPI
- **Integración con IA** mediante LangChain4j para funcionalidades avanzadas
- **Interfaz web** con PrimeFaces y JSF
- **Base de datos MySQL** con esquema robusto

## 🛠️ Tecnologías Utilizadas

### Backend
- **Java 21** - Lenguaje de programación principal
- **Spring Boot 3.5.5** - Framework principal
- **Spring Data JPA** - Acceso a datos y ORM
- **Spring Web** - Desarrollo de APIs REST
- **Hibernate** - Mapeo objeto-relacional
- **MapStruct 1.6.3** - Mapeo entre DTOs y entidades

### Frontend
- **PrimeFaces 5.2.1** - Componentes de interfaz de usuario
- **JSF (Jakarta Server Faces)** - Framework de interfaz web
- **OmniFaces 4.5** - Utilidades adicionales para JSF

### Base de Datos
- **MySQL 8** - Sistema de gestión de base de datos
- **Flyway/Liquibase** - Versionado de esquemas de base de datos

### Herramientas de Desarrollo
- **Lombok** - Reducción de código repetitivo
- **Maven** - Gestión de dependencias y construcción
- **LangChain4j** - Integración con inteligencia artificial
- **Swagger/OpenAPI** - Documentación automática de API

### Validación y Testing
- **Jakarta Bean Validation** - Validación de datos
- **Spring Boot Test** - Framework de testing integrado

## 📁 Estructura del Proyecto

```
src/main/java/org/kinscript/Academy/
├── AcademyApplication.java          # Clase principal de la aplicación
├── config/                          # Configuraciones de la aplicación
├── dominio/                         # Lógica de negocio
│   ├── dto/                         # Data Transfer Objects
│   ├── service/                     # Servicios de negocio
│   ├── repository/                  # Interfaces de repositorio
│   └── exception/                   # Excepciones customizadas
├── persistence/                     # Capa de persistencia
│   ├── entity/                      # Entidades JPA
│   └── crud/                        # Repositorios CRUD
└── web/                            # Capa de presentación
    └── controller/                  # Controladores REST
```

## 🗃️ Modelo de Datos

### Entidades Principales

#### 👨‍🎓 Alumnos
- **Identificación**: ID único, carnet estudiantil
- **Información personal**: Nombre, apellido, email académico, dirección
- **Relaciones**: Grado, sección, jornada, carrera, tutor
- **Seguridad**: Contraseña para acceso al sistema

#### 👨‍🏫 Profesores
- **Identificación**: ID único
- **Información personal**: Nombre, apellido, email, teléfono, dirección
- **Seguridad**: Contraseña para acceso al sistema
- **Asignaciones**: Relación con cursos mediante tabla intermedia

#### 📖 Cursos
- **Identificación**: ID único
- **Información**: Nombre del curso (único)

#### 📊 Notas
- **Identificación**: ID único
- **Calificación**: Nota numérica
- **Relaciones**: Alumno y curso asociados

#### 👥 Tutores
- **Identificación**: ID único
- **Información personal**: Nombre, apellido, teléfono, dirección
- **Relación**: Uno o más alumnos bajo su tutela

### Entidades de Configuración

- **Grados**: Niveles académicos (Primaria, Secundaria, etc.)
- **Secciones**: División por secciones (A, B, C, etc.)
- **Jornadas**: Horarios de estudio (Matutina, Vespertina, Nocturna)
- **Carreras**: Programas académicos disponibles
- **Coordinadores**: Personal administrativo coordinador

## 🚀 Instalación y Configuración

### Prerrequisitos

- **Java 21** o superior
- **Maven 3.6+**
- **MySQL 8.0+**
- **Git**

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/ksolo-2022439/KinScript_Academy.git
   cd KinScript_Academy
   ```

2. **Configurar la base de datos**
   - Crear una base de datos MySQL llamada `KinScript_Academy`
   - Ejecutar los scripts SQL en la carpeta `Database/`
   ```bash
   mysql -u root -p < Database/KinScript_Academy.sql
   mysql -u root -p < Database/Datos_KinScript_Academy.sql
   ```

3. **Configurar las propiedades de la aplicación**
   
   Editar `src/main/resources/application.properties`:
   ```properties
   # Configuración de base de datos
   spring.datasource.url=jdbc:mysql://localhost:3306/KinScript_Academy
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   
   # Puerto del servidor
   server.port=8090
   server.servlet.context-path=/academy/api
   ```

4. **Compilar y ejecutar la aplicación**
   ```bash
   # Hacer el wrapper ejecutable
   chmod +x mvnw
   
   # Compilar el proyecto
   ./mvnw clean compile
   
   # Ejecutar la aplicación
   ./mvnw spring-boot:run
   ```

5. **Acceder a la aplicación**
   - **API REST**: http://localhost:8090/academy/api
   - **Documentación Swagger**: http://localhost:8090/academy/api/swagger-ui.html
   - **Interfaz web**: http://localhost:8090/academy/

## 📡 API Endpoints

### 👨‍🎓 Gestión de Alumnos
- `GET /alumnos` - Obtener todos los alumnos
- `GET /alumnos/{id}` - Obtener alumno por ID
- `POST /alumnos` - Crear nuevo alumno
- `PUT /alumnos/{id}` - Actualizar alumno
- `DELETE /alumnos/{id}` - Eliminar alumno

### 👨‍🏫 Gestión de Profesores
- `GET /profesores` - Obtener todos los profesores
- `GET /profesores/{id}` - Obtener profesor por ID
- `POST /profesores` - Crear nuevo profesor
- `PUT /profesores/{id}` - Actualizar profesor
- `DELETE /profesores/{id}` - Eliminar profesor

### 📊 Gestión de Notas
- `GET /notas` - Obtener todas las notas
- `GET /notas/{id}` - Obtener nota por ID
- `GET /notas/alumno/{idAlumno}` - Obtener notas por alumno
- `POST /notas` - Crear nueva nota
- `PUT /notas/{id}` - Actualizar nota
- `DELETE /notas/{id}` - Eliminar nota

### 👥 Gestión de Tutores
- `GET /tutores` - Obtener todos los tutores
- `GET /tutores/{id}` - Obtener tutor por ID
- `POST /tutores` - Crear nuevo tutor
- `PUT /tutores/{id}` - Actualizar tutor
- `DELETE /tutores/{id}` - Eliminar tutor

### 🏫 Gestión de Secciones
- `GET /secciones` - Obtener todas las secciones
- `GET /secciones/{id}` - Obtener sección por ID
- `POST /secciones` - Crear nueva sección
- `PUT /secciones/{id}` - Actualizar sección
- `DELETE /secciones/{id}` - Eliminar sección

## 🏗️ Arquitectura del Sistema

### Patrón de Capas
1. **Capa de Presentación** (`web/controller/`)
   - Controladores REST
   - Manejo de peticiones HTTP
   - Validación de entrada
   - Formateo de respuestas

2. **Capa de Servicio** (`dominio/service/`)
   - Lógica de negocio
   - Procesamiento de datos
   - Validaciones de negocio
   - Orquestación de operaciones

3. **Capa de Acceso a Datos** (`persistence/`)
   - Entidades JPA
   - Repositorios CRUD
   - Mapeo objeto-relacional
   - Consultas personalizadas

### Patrones de Diseño Utilizados
- **Repository Pattern**: Abstracción del acceso a datos
- **DTO Pattern**: Transferencia de datos entre capas
- **Service Layer Pattern**: Encapsulación de lógica de negocio
- **Dependency Injection**: Gestión de dependencias con Spring

## ⚙️ Configuración Avanzada

### Variables de Entorno
```bash
# Base de datos
DB_HOST=localhost
DB_PORT=3306
DB_NAME=KinScript_Academy
DB_USERNAME=tu_usuario
DB_PASSWORD=tu_contraseña

# OpenAI (para funcionalidades de IA)
OPENAI_API_KEY=tu_api_key

# Puerto de la aplicación
SERVER_PORT=8090
```

### Perfiles de Spring
- **development**: Configuración para desarrollo local
- **production**: Configuración optimizada para producción
- **test**: Configuración para testing automatizado

## 🧪 Testing

### Ejecutar Tests
```bash
# Ejecutar todos los tests
./mvnw test

# Ejecutar tests con coverage
./mvnw test jacoco:report

# Ejecutar tests de integración
./mvnw integration-test
```

### Tipos de Tests Incluidos
- **Unit Tests**: Tests unitarios para servicios y utilidades
- **Integration Tests**: Tests de integración para controladores
- **Repository Tests**: Tests para la capa de datos

## 📊 Monitoreo y Métricas

### Actuator Endpoints
- `/actuator/health` - Estado de salud de la aplicación
- `/actuator/metrics` - Métricas de la aplicación
- `/actuator/info` - Información de la aplicación

## 🤝 Contribución

### Guías para Contribuir
1. Fork del repositorio
2. Crear rama feature (`git checkout -b feature/NuevaCaracteristica`)
3. Commit de cambios (`git commit -am 'Agregar nueva característica'`)
4. Push a la rama (`git push origin feature/NuevaCaracteristica`)
5. Crear Pull Request

### Convenciones de Código
- Seguir las convenciones de Java
- Usar Lombok para reducir boilerplate
- Documentar métodos públicos con JavaDoc
- Escribir tests para nuevas funcionalidades

## 📝 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 👨‍💻 Autor

**KinScript Academy Team**
- GitHub: [@ksolo-2022439](https://github.com/ksolo-2022439)

## 📞 Soporte

Para reportar bugs o solicitar nuevas características, por favor crea un [issue](https://github.com/ksolo-2022439/KinScript_Academy/issues) en GitHub.

---

⭐ **¡No olvides dar una estrella al proyecto si te fue útil!** ⭐