# 🎓 KinScript Academy

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen?style=flat-square&logo=springboot)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1.2-005F0F?style=flat-square&logo=thymeleaf)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql)
![Maven](https://img.shields.io/badge/Maven-3.6+-red?style=flat-square&logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)
![Status](https://img.shields.io/badge/Status-In%20Development-blue?style=flat-square)

## 📖 Descripción del Proyecto

**KinScript Academy** es un sistema integral de gestión académica moderno desarrollado con **Spring Boot** y **Thymeleaf**, diseñado para facilitar la administración completa de instituciones educativas. El sistema combina una potente API REST con una interfaz web intuitiva y elegante, permitiendo gestionar alumnos, profesores, cursos, notas, tutores y toda la estructura organizacional de un centro académico.

### 🌟 Lo Nuevo en Esta Versión

✨ **Migración completa de PrimeFaces a Thymeleaf** - Interfaz web moderna y responsive
🎨 **Nuevo diseño UI/UX** - Interfaz limpia y profesional con CSS personalizado
🤖 **Integración con IA** - Asistente inteligente para generación de actividades educativas mediante LangChain4j
📱 **Diseño responsive** - Adaptado para todos los dispositivos
⚡ **Rendimiento mejorado** - Carga rápida y navegación fluida
🔒 **Sistema de autenticación** - Login seguro con recuperación de contraseña

## 📋 Tabla de Contenidos

- [✨ Características Principales](#-características-principales)
- [🛠️ Tecnologías Utilizadas](#️-tecnologías-utilizadas)
- [🖼️ Capturas de Pantalla](#️-capturas-de-pantalla)
- [📁 Estructura del Proyecto](#-estructura-del-proyecto)
- [🗃️ Modelo de Datos](#️-modelo-de-datos)
- [🚀 Instalación y Configuración](#-instalación-y-configuración)
- [📡 API Endpoints](#-api-endpoints)
- [🏗️ Arquitectura del Sistema](#️-arquitectura-del-sistema)
- [⚙️ Configuración Avanzada](#️-configuración-avanzada)
- [🧪 Testing](#-testing)
- [🚀 Despliegue en Producción](#-despliegue-en-producción)
- [🔧 Solución de Problemas](#-solución-de-problemas)
- [🤝 Contribución](#-contribución)
- [📞 Soporte](#-soporte)

## ✨ Características Principales

### 📚 Gestión Académica Completa
- **👨‍🎓 Gestión de Alumnos**: Registro completo con información personal, académica y de contacto
- **👨‍🏫 Gestión de Profesores**: Administración del personal docente con asignaciones de cursos
- **📖 Gestión de Cursos**: Creación y administración de materias académicas
- **📊 Sistema de Notas**: Registro y seguimiento detallado del rendimiento académico
- **👥 Gestión de Tutores**: Administración de tutores o encargados de los estudiantes

### 🏗️ Estructura Organizacional
- **🏆 Grados**: Gestión de niveles académicos (Primaria, Secundaria, Bachillerato, etc.)
- **📊 Secciones**: Organización por secciones (A, B, C, etc.)
- **☀️ Jornadas**: Administración de horarios (Matutina, Vespertina, Nocturna)
- **💼 Carreras**: Gestión de programas académicos especializados
- **👩‍💼 Coordinadores**: Administración del personal coordinador por nivel

### 🤖 Funcionalidades Avanzadas con IA
- **✨ Generador de Actividades**: Asistente inteligente que sugiere actividades educativas personalizadas
- **🎯 Personalización por Nivel**: Adaptación de contenido según el grado educativo
- **📝 Sugerencias Contextuales**: Recomendaciones basadas en materia y nivel
- **🔄 Integración OpenAI**: Powered by LangChain4j para respuestas inteligentes

### 🔧 Funcionalidades Técnicas
- **🌐 API REST** completa con documentación OpenAPI/Swagger
- **📱 Interfaz Web Moderna** con Thymeleaf y diseño responsive
- **🎨 UI/UX Intuitiva** con navegación fluida y diseño profesional
- **🗄️ Base de datos MySQL** con esquema normalizado y optimizado
- **🔐 Sistema de Autenticación** con login y recuperación de contraseña
- **📊 Dashboard Interactivo** con métricas y accesos rápidos
- **🔄 Operaciones CRUD** completas para todas las entidades

## 🛠️ Tecnologías Utilizadas

### Backend
- **☕ Java 21** - Lenguaje de programación principal con las últimas características
- **🍃 Spring Boot 3.5.5** - Framework principal para desarrollo rápido
- **💾 Spring Data JPA** - Acceso a datos y mapeo objeto-relacional
- **🌐 Spring Web** - Desarrollo de APIs REST y controladores MVC
- **🔄 Hibernate** - Implementación JPA para persistencia
- **🗺️ MapStruct 1.6.3** - Mapeo automático entre DTOs y entidades
- **🤖 LangChain4j 1.0.0-beta1** - Integración con servicios de IA (OpenAI)

### Frontend
- **🎨 Thymeleaf 3.1.2** - Motor de plantillas moderno para Java
- **📱 HTML5 + CSS3** - Estructura y estilos personalizados
- **✨ CSS Personalizado** - Diseño moderno y responsive sin frameworks pesados
- **🎯 JavaScript Vanilla** - Interactividad del lado del cliente
- **📊 Marked.js** - Renderizado de Markdown para contenido generado por IA

### Base de Datos
- **🗄️ MySQL 8** - Sistema de gestión de base de datos relacional
- **📋 Scripts SQL** - Esquema y datos de prueba incluidos

### Herramientas de Desarrollo
- **🔧 Lombok** - Reducción de código boilerplate
- **📦 Maven** - Gestión de dependencias y construcción del proyecto
- **📚 SpringDoc OpenAPI 2.8.12** - Documentación automática de API con Swagger UI
- **✅ Jakarta Bean Validation** - Validación declarativa de datos

### Validación y Testing
- **🧪 Spring Boot Test** - Framework de testing integrado
- **✔️ JUnit 5** - Framework de pruebas unitarias
- **🎯 Mockito** - Framework para mocking en tests

## 🖼️ Capturas de Pantalla

### 🎨 Interfaz de Usuario

#### 🏠 Dashboard Principal
_El dashboard ofrece una vista general del sistema con acceso rápido a todas las funcionalidades principales._

![Dashboard Principal](ruta/a/screenshot-dashboard.png)

**Características destacadas:**
- 📊 Métricas en tiempo real de alumnos, profesores y notas
- 🚀 Accesos rápidos a las secciones más utilizadas
- 🤖 Panel integrado de Asistente IA para generar actividades
- 🎨 Diseño limpio y profesional

#### 👨‍🎓 Gestión de Alumnos
_Interfaz completa para administrar el registro estudiantil._

![Gestión de Alumnos](ruta/a/screenshot-alumnos.png)

**Funcionalidades:**
- ➕ Crear y editar información de estudiantes
- 🔍 Búsqueda y filtrado avanzado
- 📋 Tabla con datos completos (carnet, nombre, grado, sección, etc.)
- 🗑️ Eliminación con confirmación

#### 👨‍🏫 Gestión de Profesores
_Panel de administración del personal docente._

![Gestión de Profesores](ruta/a/screenshot-profesores.png)

#### 📝 Sistema de Notas
_Registro y seguimiento de calificaciones estudiantiles._

![Sistema de Notas](ruta/a/screenshot-notas.png)

#### 🤖 Asistente IA de Actividades
_Generador inteligente de actividades educativas personalizado._

![Asistente IA](ruta/a/screenshot-ai-assistant.png)

**Capacidades del Asistente:**
- 🎯 Generación de actividades según grado educativo
- 📚 Personalización por materia y tema específico
- ✨ Respuestas en formato Markdown formateado
- 💡 Sugerencias pedagógicamente relevantes

#### 🔐 Login y Autenticación
_Sistema seguro de inicio de sesión._

![Login](ruta/a/screenshot-login.png)

### 📡 API REST y Documentación

#### 📚 Swagger UI - Documentación Interactiva
_Documentación completa y probador interactivo de la API._

![Swagger UI Overview](ruta/a/screenshot-swagger-overview.png)

**Características de la API:**
- 📖 Documentación completa de todos los endpoints
- 🧪 Interfaz de prueba integrada
- 📝 Esquemas de datos detallados
- ✅ Respuestas de ejemplo

#### 🔍 Endpoints de Alumnos
_Operaciones CRUD para gestión de estudiantes._

![Swagger Alumnos Endpoints](ruta/a/screenshot-swagger-alumnos.png)

#### 📊 Endpoints de Notas
_API para gestión de calificaciones._

![Swagger Notas Endpoints](ruta/a/screenshot-swagger-notas.png)

#### 🤖 Endpoints de IA
_Integración con servicios de inteligencia artificial._

![Swagger IA Endpoints](ruta/a/screenshot-swagger-ai.png)

#### 📋 Modelos de Datos (Schemas)
_Definición de estructuras de datos utilizadas en la API._

![Swagger Data Models](ruta/a/screenshot-swagger-schemas.png)

---


## 📁 Estructura del Proyecto

```
KinScript_Academy/
├── 📁 src/main/
│   ├── 📁 java/org/kinscript/Academy/
│   │   ├── 🚀 AcademyApplication.java          # Clase principal Spring Boot
│   │   ├── 📁 config/                          # Configuraciones
│   │   │   └── OpenApiConfig.java              # Config Swagger/OpenAPI
│   │   ├── 📁 dominio/                         # Capa de lógica de negocio
│   │   │   ├── 📁 dto/                         # Data Transfer Objects
│   │   │   │   ├── AlumnosDto.java
│   │   │   │   ├── ProfesoresDto.java
│   │   │   │   ├── NotasDto.java
│   │   │   │   └── ...
│   │   │   ├── 📁 service/                     # Servicios de negocio
│   │   │   │   ├── AlumnosService.java
│   │   │   │   ├── ProfesoresService.java
│   │   │   │   ├── AIServiceColegio.java       # Servicio IA
│   │   │   │   └── ...
│   │   │   └── 📁 repository/                  # Interfaces de repositorio
│   │   │       ├── AlumnosRepository.java
│   │   │       └── ...
│   │   ├── 📁 persistence/                     # Capa de persistencia
│   │   │   ├── 📁 entity/                      # Entidades JPA
│   │   │   │   ├── Alumnos.java
│   │   │   │   ├── Profesores.java
│   │   │   │   ├── Notas.java
│   │   │   │   └── ...
│   │   │   ├── 📁 crud/                        # Repositorios CRUD
│   │   │   │   ├── AlumnosCrudRepository.java
│   │   │   │   └── ...
│   │   │   └── 📁 mapper/                      # Mappers MapStruct
│   │   │       ├── AlumnosMapper.java
│   │   │       └── ...
│   │   └── 📁 web/                            # Capa de presentación
│   │       └── 📁 controller/                  # Controladores
│   │           ├── AlumnosController.java      # API REST
│   │           ├── ProfesoresController.java
│   │           ├── LoginController.java        # Controlador MVC
│   │           ├── 📁 ai/                      # Controladores IA
│   │           │   └── AiActividadController.java
│   │           └── 📁 views/                   # Controladores MVC (legacy)
│   │
│   └── 📁 resources/
│       ├── 📁 templates/                       # Plantillas Thymeleaf
│       │   ├── login.html                      # Página de login
│       │   ├── dashboard.html                  # Dashboard principal
│       │   ├── gestion-alumnos.html           # CRUD Alumnos
│       │   ├── gestion-profesores.html        # CRUD Profesores
│       │   ├── gestion-notas.html             # CRUD Notas
│       │   ├── gestion-tutores.html
│       │   ├── gestion-cursos.html
│       │   ├── gestion-grados.html
│       │   ├── gestion-secciones.html
│       │   ├── gestion-jornadas.html
│       │   ├── gestion-carreras.html
│       │   ├── gestion-coordinadores.html
│       │   ├── gestion-gradocurso.html
│       │   ├── gestion-profesorasignacion.html
│       │   └── 📁 fragments/                   # Componentes reutilizables
│       │       └── sidebar.html                # Barra lateral de navegación
│       │
│       ├── 📁 static/                          # Recursos estáticos
│       │   └── 📁 styles/                      # Hojas de estilo CSS
│       │       ├── cruds.css                   # Estilos generales CRUD
│       │       ├── dashboard.css               # Estilos del dashboard
│       │       └── login.css                   # Estilos de login
│       │
│       └── application.properties              # Configuración de la app
│
├── 📁 Database/                                # Scripts SQL
│   ├── KinScript_Academy.sql                  # Esquema de base de datos
│   └── Datos_KinScript_Academy.sql            # Datos de prueba
│
├── 📄 pom.xml                                  # Configuración Maven
└── 📄 README.md                                # Este archivo
```

### 🎯 Principales Directorios

- **`dominio/`**: Contiene la lógica de negocio, DTOs y servicios
- **`persistence/`**: Entidades JPA, repositorios y mappers
- **`web/controller/`**: Controladores REST API y MVC
- **`templates/`**: Vistas Thymeleaf para la interfaz web
- **`static/`**: Archivos CSS, JavaScript e imágenes
- **`Database/`**: Scripts SQL para inicializar la base de datos

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

### 📋 Prerrequisitos

- **☕ Java 21** o superior ([Descargar aquí](https://adoptium.net/))
- **📦 Maven 3.6+** (incluido con el wrapper `mvnw`)
- **🗄️ MySQL 8.0+** ([Descargar aquí](https://dev.mysql.com/downloads/))
- **🔧 Git** para clonar el repositorio
- **🤖 API Key de OpenAI** (opcional, solo para funcionalidades de IA)

### 🔧 Pasos de Instalación

#### 1️⃣ Clonar el repositorio
```bash
git clone https://github.com/ksolo-2022439/KinScript_Academy.git
cd KinScript_Academy
```

#### 2️⃣ Configurar las propiedades de la aplicación

Editar `src/main/resources/application.properties`:

```properties
# 🗄️ Configuración de Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/KinScript_Academy
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# 🔄 JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true

# 🌐 Configuración del Servidor
server.port=8090

# 🎨 Thymeleaf
spring.thymeleaf.cache=false
spring.thymeleaf.enabled=true
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html

# 🤖 OpenAI (opcional - solo para funciones de IA)
langchain4j.open-ai.chat-model.api-key=tu_api_key_aqui
langchain4j.open-ai.chat-model.model-name=gpt-3.5-turbo
langchain4j.open-ai.chat-model.temperature=0.7

# 📚 Swagger/OpenAPI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

#### 3️⃣ Compilar y ejecutar la aplicación

**Hacer el wrapper ejecutable (Linux/Mac):**
```bash
chmod +x mvnw
```

**Compilar el proyecto:**
```bash
./mvnw clean compile
```

**Ejecutar la aplicación:**
```bash
./mvnw spring-boot:run
```

**O compilar y ejecutar el JAR:**
```bash
./mvnw clean package
java -jar target/Academy-0.0.1-SNAPSHOT.jar
```

#### 4️⃣ Acceder a la aplicación

Una vez iniciada la aplicación, puedes acceder a:

| 🌐 Servicio | 🔗 URL | 📝 Descripción |
|------------|--------|---------------|
| **Interfaz Web** | http://localhost:8090/ | Dashboard y gestión |
| **Login** | http://localhost:8090/login | Página de inicio de sesión |
| **API REST** | http://localhost:8090/api/ | Endpoints REST |
| **Swagger UI** | http://localhost:8090/swagger-ui.html | Documentación interactiva |
| **API Docs** | http://localhost:8090/api-docs | Especificación OpenAPI JSON |

### 🎉 ¡Listo!

El sistema está ahora funcionando. Puedes comenzar a:
- 🔐 Iniciar sesión en el sistema
- 📊 Explorar el dashboard
- 👥 Gestionar alumnos y profesores
- 📝 Registrar notas
- 🤖 Usar el asistente de IA para generar actividades
- 📡 Probar la API con Swagger UI

## 📡 API Endpoints

### 📊 Resumen de la API

La API REST de KinScript Academy proporciona endpoints completos para todas las operaciones CRUD. Todos los endpoints están documentados con OpenAPI/Swagger y pueden ser probados interactivamente.

**Base URL:** `http://localhost:8090/api`

### 🔑 Endpoints Principales

#### 👨‍🎓 Gestión de Alumnos (`/api/alumnos`)

| Método | Endpoint | Descripción | 
|--------|----------|-------------|
| 🟢 GET | `/api/alumnos` | Obtener todos los alumnos |
| 🟢 GET | `/api/alumnos/{id}` | Obtener alumno por ID |
| 🟡 POST | `/api/alumnos` | Crear nuevo alumno |
| 🟠 PUT | `/api/alumnos/{id}` | Actualizar alumno |
| 🔴 DELETE | `/api/alumnos/{id}` | Eliminar alumno |

**Ejemplo de respuesta:**
```json
{
  "idAlumno": 1,
  "carnetEstudiantil": "2024001",
  "nombreAlumno": "Juan",
  "apellidoAlumno": "Pérez",
  "emailAcademico": "juan.perez@academy.edu",
  "direccion": "Zona 10, Ciudad",
  "idGrado": 3,
  "idSeccion": 1,
  "idJornada": 2,
  "idCarrera": 1,
  "idTutor": 5
}
```

#### 👨‍🏫 Gestión de Profesores (`/api/profesores`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| 🟢 GET | `/api/profesores` | Obtener todos los profesores |
| 🟢 GET | `/api/profesores/{id}` | Obtener profesor por ID |
| 🟡 POST | `/api/profesores` | Crear nuevo profesor |
| 🟠 PUT | `/api/profesores/{id}` | Actualizar profesor |
| 🔴 DELETE | `/api/profesores/{id}` | Eliminar profesor |

#### 📊 Gestión de Notas (`/api/notas`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| 🟢 GET | `/api/notas` | Obtener todas las notas |
| 🟢 GET | `/api/notas/{id}` | Obtener nota por ID |
| 🟢 GET | `/api/notas/alumno/{idAlumno}` | Obtener notas por alumno |
| 🟡 POST | `/api/notas` | Crear nueva nota |
| 🟠 PUT | `/api/notas/{id}` | Actualizar nota |
| 🔴 DELETE | `/api/notas/{id}` | Eliminar nota |

#### 📖 Gestión de Cursos (`/api/cursos`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| 🟢 GET | `/api/cursos` | Obtener todos los cursos |
| 🟢 GET | `/api/cursos/{id}` | Obtener curso por ID |
| 🟡 POST | `/api/cursos` | Crear nuevo curso |
| 🟠 PUT | `/api/cursos/{id}` | Actualizar curso |
| 🔴 DELETE | `/api/cursos/{id}` | Eliminar curso |

#### 👥 Gestión de Tutores (`/api/tutores`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| 🟢 GET | `/api/tutores` | Obtener todos los tutores |
| 🟢 GET | `/api/tutores/{id}` | Obtener tutor por ID |
| 🟡 POST | `/api/tutores` | Crear nuevo tutor |
| 🟠 PUT | `/api/tutores/{id}` | Actualizar tutor |
| 🔴 DELETE | `/api/tutores/{id}` | Eliminar tutor |

#### 🏫 Entidades de Configuración

| Entidad | Endpoint Base | Descripción |
|---------|---------------|-------------|
| 🏆 Grados | `/api/grados` | Niveles académicos |
| 📊 Secciones | `/api/secciones` | Divisiones por grupo |
| ☀️ Jornadas | `/api/jornadas` | Horarios de estudio |
| 💼 Carreras | `/api/carreras` | Programas académicos |
| 👩‍💼 Coordinadores | `/api/coordinadores` | Personal coordinador |

#### 🔗 Relaciones

| Entidad | Endpoint Base | Descripción |
|---------|---------------|-------------|
| 📚 Grado-Curso | `/api/gradocurso` | Asociación de cursos a grados |
| 🤵 Profesor-Asignación | `/api/profesorasignacion` | Asignación de profesores a cursos |

#### 🤖 Inteligencia Artificial

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| 🟡 POST | `/ai/sugerir` | Generar actividad educativa con IA |

**Ejemplo de solicitud:**
```json
{
  "preferencias": "Generar una actividad de matemáticas para nivel de primaria sobre fracciones"
}
```

### 📚 Documentación Interactiva

Para explorar y probar todos los endpoints, visita:
- **Swagger UI:** http://localhost:8090/swagger-ui.html
- **OpenAPI JSON:** http://localhost:8090/api-docs

### 🔒 Códigos de Respuesta HTTP

| Código | Significado | Descripción |
|--------|-------------|-------------|
| ✅ 200 | OK | Solicitud exitosa |
| ✅ 201 | Created | Recurso creado exitosamente |
| ⚠️ 400 | Bad Request | Datos de entrada inválidos |
| ⚠️ 404 | Not Found | Recurso no encontrado |
| ❌ 500 | Internal Server Error | Error del servidor |

## 🏗️ Arquitectura del Sistema

### 🎯 Patrón de Capas (Layered Architecture)

El sistema sigue una arquitectura en capas bien definida que separa las responsabilidades:

```
┌─────────────────────────────────────────────────────────┐
│                🌐 CAPA DE PRESENTACIÓN                   │
│  - Controladores REST (API)                             │
│  - Controladores MVC (Thymeleaf)                        │
│  - Vistas Thymeleaf                                     │
│  - Validación de entrada                                │
└─────────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────────┐
│                  💼 CAPA DE SERVICIO                     │
│  - Lógica de negocio                                    │
│  - Servicios de aplicación                              │
│  - Validaciones de negocio                              │
│  - Orquestación de operaciones                          │
│  - Integración con servicios externos (IA)              │
└─────────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────────┐
│             🗺️ CAPA DE MAPEO (DTOs ↔ Entities)         │
│  - MapStruct Mappers                                    │
│  - Conversión bidireccional                             │
└─────────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────────┐
│              💾 CAPA DE ACCESO A DATOS                   │
│  - Repositorios Spring Data JPA                         │
│  - Entidades JPA                                        │
│  - Consultas personalizadas                             │
└─────────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────────┐
│                  🗄️ BASE DE DATOS                       │
│  - MySQL 8                                              │
│  - Esquema relacional normalizado                       │
└─────────────────────────────────────────────────────────┘
```

### 📋 Patrones de Diseño Utilizados

#### 1️⃣ **Repository Pattern** 🗄️
Abstracción del acceso a datos mediante interfaces de Spring Data JPA.
```java
public interface AlumnosRepository extends JpaRepository<Alumnos, Long> {
    // Métodos de consulta personalizados
}
```

#### 2️⃣ **DTO Pattern** 📦
Transferencia segura de datos entre capas sin exponer entidades.
```java
@Data
public class AlumnosDto {
    private Long idAlumno;
    private String nombreAlumno;
    // ... más campos
}
```

#### 3️⃣ **Service Layer Pattern** 💼
Encapsulación de la lógica de negocio en servicios reutilizables.
```java
@Service
public class AlumnosService {
    public AlumnosDto guardar(AlumnosDto dto) {
        // Lógica de negocio
    }
}
```

#### 4️⃣ **Dependency Injection** 💉
Gestión automática de dependencias con Spring Framework.
```java
@RestController
public class AlumnosController {
    private final AlumnosService service;
    
    public AlumnosController(AlumnosService service) {
        this.service = service;
    }
}
```

#### 5️⃣ **MVC Pattern** 🎨
Separación de modelo, vista y controlador en la interfaz web.
- **Modelo**: Entidades y DTOs
- **Vista**: Plantillas Thymeleaf
- **Controlador**: Spring MVC Controllers

### 🔄 Flujo de una Petición

#### API REST
```
1. Cliente → HTTP Request → RestController
2. RestController → DTO → Service
3. Service → Lógica de negocio → Repository
4. Repository → JPA → Base de Datos
5. Base de Datos → Entidad → Repository
6. Repository → Service → Mapper → DTO
7. DTO → RestController → JSON Response → Cliente
```

#### Interfaz Web MVC
```
1. Navegador → HTTP Request → MVC Controller
2. Controller → Service → Repository → BD
3. BD → Entidad → Service → Controller
4. Controller → Model → Thymeleaf Template
5. Template → HTML Response → Navegador
```

### 🎯 Componentes Clave

#### 🌐 Controladores REST
- Exponen la API RESTful
- Anotados con `@RestController`
- Documentados con OpenAPI annotations
- Retornan ResponseEntity con códigos HTTP apropiados

#### 🎨 Controladores MVC
- Manejan la navegación web
- Anotados con `@Controller`
- Retornan nombres de vistas Thymeleaf
- Populan el modelo con datos

#### 💼 Servicios
- Contienen la lógica de negocio
- Anotados con `@Service`
- Transaccionales con `@Transactional`
- Independientes de la capa de presentación

#### 🗄️ Repositorios
- Extienden `JpaRepository`
- Generan implementaciones automáticamente
- Soportan consultas derivadas de métodos
- Permiten consultas personalizadas con `@Query`

#### 🗺️ Mappers
- Interfaz anotada con `@Mapper`
- Generación de código en tiempo de compilación
- Conversión automática DTO ↔ Entity
- Manejo de relaciones complejas

### 🔧 Tecnologías de Integración

#### 🤖 LangChain4j para IA
```java
@Service
public class AIServiceColegio {
    @Autowired
    private ChatLanguageModel chatModel;
    
    public String generarActividad(String preferencias) {
        return chatModel.generate(preferencias);
    }
}
```

#### 📚 OpenAPI/Swagger
- Generación automática de documentación
- UI interactiva para pruebas
- Especificación OpenAPI 3.0
- Anotaciones descriptivas en controladores

#### 🎨 Thymeleaf
- Motor de plantillas del lado del servidor
- Sintaxis natural HTML5
- Fragmentos reutilizables
- Integración perfecta con Spring MVC

## ⚙️ Configuración Avanzada

### 🔐 Variables de Entorno

Para una configuración más segura en producción, puedes usar variables de entorno:

```bash
# 🗄️ Base de datos
export DB_HOST=localhost
export DB_PORT=3306
export DB_NAME=KinScript_Academy
export DB_USERNAME=tu_usuario
export DB_PASSWORD=tu_contraseña

# 🤖 OpenAI (para funcionalidades de IA)
export OPENAI_API_KEY=sk-tu_api_key_aqui

# 🌐 Puerto de la aplicación
export SERVER_PORT=8090

# 🔧 Perfil de Spring
export SPRING_PROFILES_ACTIVE=production
```

Luego en `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://${DB_HOST:localhost}:${DB_PORT:3306}/${DB_NAME:KinScript_Academy}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:}
```

### 🎭 Perfiles de Spring

El proyecto soporta diferentes perfiles para distintos entornos:

#### 📝 Development (application-dev.properties)
```properties
# Desarrollo local
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
logging.level.org.kinscript.Academy=DEBUG
```

#### 🚀 Production (application-prod.properties)
```properties
# Producción optimizada
spring.jpa.show-sql=false
spring.thymeleaf.cache=true
logging.level.org.kinscript.Academy=INFO
server.compression.enabled=true
```

#### 🧪 Test (application-test.properties)
```properties
# Testing automatizado
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=create-drop
```

**Activar un perfil:**
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

### 🎨 Personalización del Frontend

#### Modificar estilos CSS
Los archivos CSS están en `src/main/resources/static/styles/`:
- `cruds.css` - Estilos para las vistas CRUD
- `dashboard.css` - Estilos del dashboard
- `login.css` - Estilos de la página de login

#### Personalizar plantillas Thymeleaf
Las vistas están en `src/main/resources/templates/`

Ejemplo de uso de fragmentos:
```html
<!-- Incluir el sidebar en cualquier página -->
<div th:replace="~{fragments/sidebar :: sidebar}"></div>
```

### 🔧 Configuración de Base de Datos

#### Modo de actualización de esquema
```properties
# create: Crea el esquema desde cero (¡elimina datos existentes!)
# update: Actualiza el esquema sin perder datos
# validate: Solo valida el esquema
# none: No hace nada
spring.jpa.hibernate.ddl-auto=update
```

#### Pool de conexiones
```properties
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=30000
```

### 📊 Configuración de Swagger/OpenAPI

Personalizar la documentación de la API:

```properties
# Rutas de Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operationsSorter=method

# Información de la API
springdoc.api-docs.enabled=true
```

Configuración en código (`OpenApiConfig.java`):
```java
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("KinScript Academy API")
                .version("1.0")
                .description("Sistema de Gestión Académica"));
    }
}
```

### 🤖 Configuración de IA (LangChain4j)

```properties
# Modelo de chat
langchain4j.open-ai.chat-model.api-key=${OPENAI_API_KEY}
langchain4j.open-ai.chat-model.model-name=gpt-3.5-turbo
langchain4j.open-ai.chat-model.temperature=0.7
langchain4j.open-ai.chat-model.max-tokens=500

# Timeout
langchain4j.open-ai.chat-model.timeout=60s
```

### 📝 Logging

Configurar niveles de log por paquete:

```properties
# Log general
logging.level.root=INFO

# Log de la aplicación
logging.level.org.kinscript.Academy=DEBUG

# Log de Spring
logging.level.org.springframework=INFO

# Log de Hibernate SQL
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# Archivo de log
logging.file.name=logs/academy.log
logging.file.max-size=10MB
logging.file.max-history=30
```

### 🔒 Seguridad (Para implementación futura)

Configuración básica de Spring Security:

```properties
# Configuración de seguridad
spring.security.user.name=admin
spring.security.user.password=admin123

# JWT (si se implementa)
jwt.secret=tu_secreto_muy_largo_y_seguro
jwt.expiration=86400000
```

## 🧪 Testing

### 🎯 Estrategia de Testing

El proyecto incluye una estructura de testing completa para garantizar la calidad del código:

```
src/test/java/org/kinscript/Academy/
├── 🧪 unit/              # Tests unitarios
│   ├── service/          # Tests de servicios
│   └── mapper/           # Tests de mappers
├── 🔗 integration/       # Tests de integración
│   ├── controller/       # Tests de controladores
│   └── repository/       # Tests de repositorios
└── 🌐 e2e/              # Tests end-to-end (futuro)
```

### 🚀 Ejecutar Tests

#### Todos los tests
```bash
./mvnw test
```

#### Tests con reporte de cobertura
```bash
./mvnw test jacoco:report

# Ver reporte en:
# target/site/jacoco/index.html
```

#### Tests de integración
```bash
./mvnw integration-test
```

#### Tests específicos
```bash
# Por clase
./mvnw test -Dtest=AlumnosServiceTest

# Por método
./mvnw test -Dtest=AlumnosServiceTest#testGuardarAlumno
```

#### Modo verbose
```bash
./mvnw test -X
```

### 📋 Tipos de Tests Incluidos

#### 🔬 Unit Tests
Prueban componentes individuales de forma aislada.

```java
@SpringBootTest
class AlumnosServiceTest {
    
    @Mock
    private AlumnosRepository repository;
    
    @InjectMocks
    private AlumnosService service;
    
    @Test
    void testGuardarAlumno() {
        // Arrange
        AlumnosDto dto = new AlumnosDto();
        dto.setNombreAlumno("Juan");
        
        // Act
        AlumnosDto result = service.guardar(dto);
        
        // Assert
        assertNotNull(result);
        assertEquals("Juan", result.getNombreAlumno());
    }
}
```

#### 🔗 Integration Tests
Prueban la interacción entre componentes.

```java
@SpringBootTest
@AutoConfigureMockMvc
class AlumnosControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void testObtenerTodosLosAlumnos() throws Exception {
        mockMvc.perform(get("/api/alumnos"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
```

#### 💾 Repository Tests
Prueban el acceso a datos.

```java
@DataJpaTest
class AlumnosRepositoryTest {
    
    @Autowired
    private AlumnosRepository repository;
    
    @Test
    void testGuardarYBuscarAlumno() {
        Alumnos alumno = new Alumnos();
        alumno.setNombreAlumno("Juan");
        
        Alumnos saved = repository.save(alumno);
        Optional<Alumnos> found = repository.findById(saved.getIdAlumno());
        
        assertTrue(found.isPresent());
        assertEquals("Juan", found.get().getNombreAlumno());
    }
}
```

### 📊 Cobertura de Tests

Objetivo de cobertura:
- **Servicios**: ≥ 80%
- **Controladores**: ≥ 70%
- **Repositorios**: ≥ 60%
- **General**: ≥ 70%

### 🛠️ Herramientas de Testing

- **JUnit 5**: Framework de testing principal
- **Mockito**: Mocking de dependencias
- **Spring Boot Test**: Testing de aplicaciones Spring
- **AssertJ**: Assertions fluidas y expresivas
- **JaCoCo**: Análisis de cobertura de código
- **H2 Database**: Base de datos en memoria para tests

### ✅ Buenas Prácticas

1. **📝 Nombres descriptivos**: `testGuardarAlumno_cuandoDatosValidos_debeRetornarAlumnoGuardado()`
2. **🎯 Tests aislados**: Cada test debe ser independiente
3. **🔄 AAA Pattern**: Arrange, Act, Assert
4. **🚫 No tests redundantes**: Evitar duplicación
5. **⚡ Tests rápidos**: Mantener tiempo de ejecución bajo
6. **🧹 Cleanup**: Limpiar datos de prueba después de cada test

## 📊 Monitoreo y Métricas

### 📈 Spring Boot Actuator

El proyecto incluye Spring Boot Actuator para monitoreo y métricas.

#### Endpoints Disponibles

| Endpoint | Descripción |
|----------|-------------|
| `/actuator/health` | 💚 Estado de salud de la aplicación |
| `/actuator/info` | ℹ️ Información de la aplicación |
| `/actuator/metrics` | 📊 Métricas de rendimiento |
| `/actuator/env` | 🔧 Variables de entorno |
| `/actuator/loggers` | 📝 Configuración de logs |

#### Habilitar Actuator

En `application.properties`:
```properties
# Habilitar endpoints de Actuator
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=always

# Información de la aplicación
info.app.name=KinScript Academy
info.app.description=Sistema de Gestión Académica
info.app.version=1.0.0
```

#### Acceso a métricas
```bash
# Salud de la aplicación
curl http://localhost:8090/actuator/health

# Métricas disponibles
curl http://localhost:8090/actuator/metrics

# Métrica específica (ejemplo: uso de memoria)
curl http://localhost:8090/actuator/metrics/jvm.memory.used
```

### 📊 Métricas Clave

- **💻 JVM Metrics**: Uso de memoria, threads, garbage collection
- **🌐 HTTP Metrics**: Peticiones, respuestas, tiempos de respuesta
- **💾 Database Metrics**: Conexiones activas, queries ejecutadas
- **⏱️ Performance Metrics**: Tiempo de respuesta por endpoint
- **❌ Error Metrics**: Tasa de errores por tipo

### 🔍 Herramientas Recomendadas de Monitoreo

#### Prometheus + Grafana
```properties
# application.properties
management.metrics.export.prometheus.enabled=true
management.endpoint.prometheus.enabled=true
management.endpoints.web.exposure.include=prometheus
```

#### Configuración Docker Compose (ejemplo)
```yaml
version: '3.8'
services:
  academy:
    image: kinscript/academy:latest
    ports:
      - "8090:8090"
  
  prometheus:
    image: prom/prometheus
    ports:
      - "9090:9090"
    volumes:
      - ./prometheus.yml:/etc/prometheus/prometheus.yml
  
  grafana:
    image: grafana/grafana
    ports:
      - "3000:3000"
```

### 📊 Dashboards Sugeridos

- **Sistema**: CPU, Memoria, Disco
- **Aplicación**: Request rate, Error rate, Response time
- **Base de Datos**: Conexiones, Query performance
- **Usuarios**: Sesiones activas, Operaciones por usuario

## 🤝 Contribución

¡Las contribuciones son bienvenidas! 🎉

### 📝 Guías para Contribuir

#### 1️⃣ Fork y Clone
```bash
# Fork el repositorio en GitHub
# Luego clona tu fork
git clone https://github.com/TU_USUARIO/KinScript_Academy.git
cd KinScript_Academy
```

#### 2️⃣ Crear Rama Feature
```bash
# Crear y cambiar a nueva rama
git checkout -b feature/NuevaCaracteristica

# O para corrección de bugs
git checkout -b fix/CorreccionBug

# O para documentación
git checkout -b docs/ActualizarDocumentacion
```

#### 3️⃣ Hacer Cambios
- ✍️ Escribe código limpio y documentado
- ✅ Sigue las convenciones del proyecto
- 🧪 Agrega tests para nuevas funcionalidades
- 📝 Actualiza documentación si es necesario

#### 4️⃣ Commit de Cambios
```bash
# Añadir archivos
git add .

# Commit con mensaje descriptivo
git commit -m "feat: Agregar funcionalidad de exportación de notas"

# Convenciones de commit:
# feat: Nueva característica
# fix: Corrección de bug
# docs: Cambios en documentación
# style: Formato, punto y coma, etc.
# refactor: Refactorización de código
# test: Agregar tests
# chore: Mantenimiento
```

#### 5️⃣ Push y Pull Request
```bash
# Push a tu fork
git push origin feature/NuevaCaracteristica

# Crear Pull Request en GitHub
# Incluye descripción detallada de los cambios
```

### 📋 Convenciones de Código

#### Java
```java
// ✅ BIEN
public class AlumnosService {
    
    private final AlumnosRepository repository;
    
    // Constructor injection
    public AlumnosService(AlumnosRepository repository) {
        this.repository = repository;
    }
    
    /**
     * Guarda un nuevo alumno en el sistema.
     * 
     * @param dto Datos del alumno a guardar
     * @return Alumno guardado con ID asignado
     * @throws IllegalArgumentException si el DTO es nulo o inválido
     */
    public AlumnosDto guardar(AlumnosDto dto) {
        // Validaciones
        if (dto == null) {
            throw new IllegalArgumentException("DTO no puede ser nulo");
        }
        
        // Lógica de negocio
        Alumnos entity = mapper.toEntity(dto);
        Alumnos saved = repository.save(entity);
        return mapper.toDto(saved);
    }
}
```

**Reglas:**
- 📏 Nombres descriptivos en español para entidades/DTOs
- 🔤 camelCase para variables y métodos
- 🔡 PascalCase para clases
- 📝 JavaDoc para métodos públicos
- 🎯 Single Responsibility Principle
- 🔧 Usar Lombok para reducir boilerplate
- 💉 Constructor injection en lugar de @Autowired

#### Thymeleaf
```html
<!-- ✅ BIEN -->
<!DOCTYPE html>
<html lang="es" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title th:text="${titulo}">Título por defecto</title>
</head>
<body>
    <!-- Usar fragmentos para código reutilizable -->
    <div th:replace="~{fragments/sidebar :: sidebar}"></div>
    
    <!-- Iteración -->
    <div th:each="alumno : ${alumnos}">
        <span th:text="${alumno.nombreAlumno}">Nombre</span>
    </div>
</body>
</html>
```

#### CSS
```css
/* ✅ BIEN */
/* Nombres de clases descriptivos */
.student-card {
    padding: 1rem;
    margin-bottom: 1rem;
    border-radius: 8px;
}

/* Usar variables CSS para colores consistentes */
:root {
    --primary-color: #007bff;
    --secondary-color: #6c757d;
}
```

### 🧪 Testing

Todas las nuevas funcionalidades deben incluir tests:

```java
@SpringBootTest
class AlumnosServiceTest {
    
    @Autowired
    private AlumnosService service;
    
    @Test
    @DisplayName("Debe guardar alumno correctamente con datos válidos")
    void testGuardarAlumno_conDatosValidos_debeRetornarAlumnoGuardado() {
        // Arrange
        AlumnosDto dto = crearAlumnoDtoValido();
        
        // Act
        AlumnosDto result = service.guardar(dto);
        
        // Assert
        assertNotNull(result);
        assertNotNull(result.getIdAlumno());
        assertEquals(dto.getNombreAlumno(), result.getNombreAlumno());
    }
    
    @Test
    @DisplayName("Debe lanzar excepción con DTO nulo")
    void testGuardarAlumno_conDtoNulo_debeLanzarExcepcion() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, 
            () -> service.guardar(null));
    }
}
```

### 📚 Documentación

Al agregar nuevos endpoints, documenta con OpenAPI:

```java
@RestController
@RequestMapping("/api/alumnos")
@Tag(name = "Alumnos", description = "Gestión de alumnos")
public class AlumnosController {
    
    @GetMapping("/{id}")
    @Operation(
        summary = "Obtener alumno por ID",
        description = "Busca y retorna un alumno específico por su ID"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Alumno encontrado"),
        @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    })
    public ResponseEntity<AlumnosDto> obtenerPorId(
        @Parameter(description = "ID del alumno") @PathVariable Long id
    ) {
        // ...
    }
}
```

### 🔍 Code Review

Criterios de revisión:
- ✅ Código sigue las convenciones
- ✅ Tests incluidos y pasando
- ✅ Documentación actualizada
- ✅ Sin warnings de compilación
- ✅ Sin code smells graves
- ✅ Performance aceptable
- ✅ Seguridad verificada

### 🎯 Áreas de Contribución

Buscamos ayuda en:

- 🆕 **Nuevas funcionalidades**
  - Reportes y estadísticas
  - Export/Import de datos
  - Notificaciones por email
  - Dashboard mejorado
  
- 🐛 **Corrección de bugs**
  - Revisar issues abiertos
  - Reportar nuevos bugs
  
- 📝 **Documentación**
  - Mejorar README
  - Tutoriales y guías
  - Comentarios de código
  
- 🧪 **Testing**
  - Aumentar cobertura
  - Tests E2E
  - Tests de performance
  
- 🎨 **UI/UX**
  - Mejorar diseño
  - Responsive design
  - Accesibilidad

### 💡 Ideas para Contribuir

- Implementar sistema de roles y permisos
- Agregar API de reportes en PDF/Excel
- Crear módulo de asistencia
- Implementar calendario académico
- Agregar notificaciones push
- Mejorar el asistente de IA
- Crear app móvil (React Native / Flutter)
- Implementar sistema de backup automático
- Agregar soporte multiidioma (i18n)
- Crear módulo de horarios

## 👨‍💻 Autores

### 👥 KinScript Academy Team

| Developer | GitHub | Rol |
|-----------|--------|-----|
| **Ksolo** | [@ksolo-2022439](https://github.com/ksolo-2022439) | Lead Developer & Project Manager |
| **GC** | [@gc130041](https://github.com/gc130041) | Backend Developer |
| **Eduardo LG** | [@EduardoLG](https://github.com/EduardoLG) | Backend Developer |
| **Marcos Banajera** | [@marcss-bnajera](https://github.com/marcss-bnajera) | Frontend Developer |
| **Daniel Morales** | [@dnmrll](https://github.com/dnmrll) | Database & DevOps |

### 🙏 Agradecimientos

- 🍃 **Spring Team** - Por el increíble framework
- 🎨 **Thymeleaf Team** - Por el motor de plantillas
- 🤖 **LangChain4j Team** - Por la integración con IA
- 💾 **MySQL Team** - Por el sistema de base de datos
- 👥 **Comunidad Open Source** - Por todas las bibliotecas utilizadas

## 📞 Soporte

### 🐛 Reportar Bugs

¿Encontraste un bug? ¡Ayúdanos a mejorarlo!

1. 🔍 **Verifica** que no exista un issue similar
2. 📝 **Crea un issue** con:
   - Título descriptivo
   - Descripción detallada del problema
   - Pasos para reproducir
   - Comportamiento esperado vs actual
   - Screenshots si aplica
   - Versión de Java, MySQL, etc.
   - Logs de error relevantes

**Template de Issue:**
```markdown
### Descripción
[Descripción breve del bug]

### Pasos para Reproducir
1. ...
2. ...
3. ...

### Comportamiento Esperado
[Qué debería pasar]

### Comportamiento Actual
[Qué está pasando]

### Información del Sistema
- Java: [versión]
- MySQL: [versión]
- SO: [sistema operativo]

### Logs
```

### 💡 Solicitar Funcionalidades

¿Tienes una idea genial? ¡Compártela!

1. 📋 **Crea un Feature Request** en GitHub Issues
2. 📝 **Describe** la funcionalidad deseada
3. 🎯 **Explica** el caso de uso
4. 💭 **Sugiere** una posible implementación

### 🆘 Obtener Ayuda

#### 📚 Documentación
- **README.md** - Esta guía completa
- **Wiki** - Documentación extendida y tutoriales
- **Swagger UI** - Documentación de API
- **Código** - Ejemplos en el repositorio

#### 💬 Canales de Comunicación

| Canal | Uso | Link |
|-------|-----|------|
| **GitHub Issues** | Bugs y features | [Issues](https://github.com/ksolo-2022439/KinScript_Academy/issues) |
| **GitHub Discussions** | Preguntas generales | [Discussions](https://github.com/ksolo-2022439/KinScript_Academy/discussions) |
| **Pull Requests** | Contribuciones | [PRs](https://github.com/ksolo-2022439/KinScript_Academy/pulls) |
| **Email** | Contacto directo | Ver perfil de GitHub |

#### ❓ Preguntas Frecuentes (FAQ)

**P: ¿Qué versión de Java necesito?**
R: Java 21 o superior es requerido.

**P: ¿Puedo usar otra base de datos?**
R: El proyecto está optimizado para MySQL, pero puede adaptarse a PostgreSQL con mínimos cambios.

**P: ¿Es gratuito el uso de la API de OpenAI?**
R: OpenAI tiene planes de pago. La clave API es opcional solo para funciones de IA.

**P: ¿Cómo puedo contribuir sin saber programar?**
R: ¡Puedes ayudar con documentación, reportar bugs, sugerir mejoras o traducir la interfaz!

**P: ¿Hay una versión demo disponible?**
R: Actualmente no hay demo pública, pero puedes clonar y ejecutar localmente fácilmente.

### 🔗 Enlaces Útiles

- 📦 **Repositorio**: https://github.com/ksolo-2022439/KinScript_Academy
- 📚 **Documentación**: Ver Wiki del proyecto
- 🐛 **Issues**: Reportar problemas o sugerencias
- 💬 **Discussions**: Hacer preguntas a la comunidad
- 🌟 **Releases**: Ver cambios por versión

### 📧 Contacto

Para consultas específicas o colaboraciones:
- Ver perfiles de GitHub de los autores
- Crear un Discussion en GitHub
- Comentar en Issues relevantes

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

---

## 🌟 Reconocimientos

### ⭐ **¡Dale una estrella!**

Si este proyecto te fue útil, ¡considera darle una ⭐ en GitHub!

```bash
# Comparte el proyecto
https://github.com/ksolo-2022439/KinScript_Academy
```

### 🎓 Proyecto Educativo

Este proyecto fue desarrollado como parte de un proyecto académico, demostrando:
- ✅ Arquitectura de software moderna
- ✅ Buenas prácticas de desarrollo
- ✅ Integración de tecnologías actuales
- ✅ Desarrollo de APIs RESTful
- ✅ Diseño de interfaces de usuario
- ✅ Gestión de bases de datos
- ✅ Implementación de IA en aplicaciones

### 🚀 Tecnologías del Futuro

KinScript Academy demuestra el uso de:
- **Spring Boot 3** - Framework moderno de Java
- **Thymeleaf** - Plantillas del lado del servidor
- **LangChain4j** - Integración con IA
- **OpenAPI** - Documentación de APIs
- **MapStruct** - Mapeo eficiente de objetos
- **MySQL 8** - Base de datos robusta

---

<div align="center">

### 💖 Hecho con pasión por el equipo de KinScript Academy

**⭐ No olvides dar una estrella al proyecto si te fue útil ⭐**

**KinScript Academy** - *Revolucionando la gestión académica con tecnología moderna*

[🏠 Inicio](#-kinscript-academy) • [📚 Documentación](#-tabla-de-contenidos) • [🐛 Reportar Bug](https://github.com/ksolo-2022439/KinScript_Academy/issues) • [💡 Solicitar Feature](https://github.com/ksolo-2022439/KinScript_Academy/issues)

---

© 2024 KinScript Academy Team. Todos los derechos reservados.

</div>

## 🚀 Despliegue en Producción

### 🐳 Opción 1: Docker

#### Dockerfile
```dockerfile
# Etapa de compilación
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/Academy-0.0.1-SNAPSHOT.jar app.jar

# Variables de entorno
ENV JAVA_OPTS="-Xmx512m -Xms256m"
ENV SERVER_PORT=8090

# Exponer puerto
EXPOSE 8090

# Ejecutar aplicación
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
```

#### Construcción y ejecución
```bash
# Construir imagen
docker build -t kinscript/academy:latest .

# Ejecutar contenedor
docker run -d \
  --name kinscript-academy \
  -p 8090:8090 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/KinScript_Academy \
  -e SPRING_DATASOURCE_USERNAME=root \
  -e SPRING_DATASOURCE_PASSWORD=password \
  -e OPENAI_API_KEY=sk-your-api-key \
  kinscript/academy:latest

# Ver logs
docker logs -f kinscript-academy

# Detener contenedor
docker stop kinscript-academy
```

### 🐳 Opción 2: Docker Compose

#### docker-compose.yml
```yaml
version: '3.8'

services:
  mysql:
    image: mysql:8.0
    container_name: academy-mysql
    environment:
      MYSQL_ROOT_PASSWORD: rootpassword
      MYSQL_DATABASE: KinScript_Academy
      MYSQL_USER: academy_user
      MYSQL_PASSWORD: academy_pass
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql
      - ./Database:/docker-entrypoint-initdb.d
    networks:
      - academy-network

  app:
    build: .
    container_name: kinscript-academy
    depends_on:
      - mysql
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/KinScript_Academy
      SPRING_DATASOURCE_USERNAME: academy_user
      SPRING_DATASOURCE_PASSWORD: academy_pass
      OPENAI_API_KEY: ${OPENAI_API_KEY}
      SPRING_PROFILES_ACTIVE: production
    ports:
      - "8090:8090"
    networks:
      - academy-network
    restart: unless-stopped

networks:
  academy-network:
    driver: bridge

volumes:
  mysql_data:
```

#### Comandos Docker Compose
```bash
# Iniciar servicios
docker-compose up -d

# Ver logs
docker-compose logs -f app

# Detener servicios
docker-compose down

# Reconstruir y reiniciar
docker-compose up -d --build
```

### ☁️ Opción 3: Despliegue en la Nube

#### AWS Elastic Beanstalk
```bash
# Crear archivo JAR
./mvnw clean package

# Desplegar con EB CLI
eb init -p java-21 kinscript-academy
eb create kinscript-academy-env
eb deploy
```

#### Heroku
```bash
# Crear aplicación
heroku create kinscript-academy

# Configurar Java
echo "java.runtime.version=21" > system.properties

# Agregar base de datos
heroku addons:create jawsdb:kitefin

# Desplegar
git push heroku main

# Ver logs
heroku logs --tail
```

#### Google Cloud Run
```bash
# Construir imagen
gcloud builds submit --tag gcr.io/PROJECT_ID/academy

# Desplegar
gcloud run deploy academy \
  --image gcr.io/PROJECT_ID/academy \
  --platform managed \
  --region us-central1 \
  --allow-unauthenticated
```

### 🔧 Variables de Entorno para Producción

Crear archivo `.env` o configurar en el servicio de hosting:

```bash
# Base de datos
SPRING_DATASOURCE_URL=jdbc:mysql://db-host:3306/KinScript_Academy
SPRING_DATASOURCE_USERNAME=prod_user
SPRING_DATASOURCE_PASSWORD=secure_password

# Perfil de Spring
SPRING_PROFILES_ACTIVE=production

# OpenAI
OPENAI_API_KEY=sk-your-production-key

# Servidor
SERVER_PORT=8090

# JVM
JAVA_OPTS=-Xmx1024m -Xms512m -XX:+UseG1GC

# Logging
LOGGING_LEVEL_ROOT=INFO
LOGGING_FILE_NAME=/var/log/academy/application.log
```

### ✅ Checklist de Producción

Antes de desplegar a producción, asegúrate de:

- [ ] ✅ Variables de entorno configuradas correctamente
- [ ] 🔒 Credenciales de base de datos seguras
- [ ] 🗄️ Base de datos con respaldos automáticos
- [ ] 📝 Logging configurado apropiadamente
- [ ] 🔐 HTTPS habilitado (SSL/TLS)
- [ ] 🚫 Endpoints de desarrollo deshabilitados
- [ ] 📊 Monitoreo y alertas configurados
- [ ] 🔄 Estrategia de respaldo y recuperación
- [ ] ⚡ Performance testing realizado
- [ ] 🛡️ Firewall y seguridad de red configurados
- [ ] 📈 Escalado automático configurado (si aplica)
- [ ] 📋 Documentación de despliegue actualizada

### 🔄 Actualización sin Downtime

Para actualizaciones sin interrupciones:

```bash
# Blue-Green Deployment
1. Desplegar nueva versión en servidor "green"
2. Verificar que funciona correctamente
3. Cambiar balanceador de carga a "green"
4. Mantener "blue" como backup
5. Después de verificar, actualizar "blue"

# Rolling Update (Kubernetes)
kubectl set image deployment/academy \
  academy=kinscript/academy:v2.0 \
  --record

# Rollback si hay problemas
kubectl rollout undo deployment/academy
```

### 📊 Monitoreo Post-Despliegue

Después del despliegue, monitorear:

- 📈 **Métricas de rendimiento**: CPU, memoria, latencia
- 🔍 **Logs de errores**: Detectar problemas temprano
- 👥 **Tráfico de usuarios**: Patrones de uso
- 💾 **Estado de base de datos**: Conexiones, queries lentas
- 🔐 **Seguridad**: Intentos de acceso no autorizados

## 🔧 Solución de Problemas

### 🐛 Problemas Comunes y Soluciones

#### ❌ Error de Conexión a Base de Datos

**Síntoma:**
```
java.sql.SQLNonTransientConnectionException: Could not create connection to database server
```

**Soluciones:**

1. **Verificar que MySQL esté ejecutándose:**
```bash
# Linux/Mac
sudo systemctl status mysql
# o
ps aux | grep mysql

# Windows
services.msc  # Buscar MySQL en la lista
```

2. **Verificar conectividad:**
```bash
mysql -u tu_usuario -p -h localhost
```

3. **Verificar configuración:**
```properties
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/KinScript_Academy?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_password
```

4. **Verificar firewall:**
```bash
# Permitir puerto 3306
sudo ufw allow 3306
```

#### 🔴 Puerto en Uso

**Síntoma:**
```
Web server failed to start. Port 8090 was already in use.
```

**Soluciones:**

1. **Encontrar proceso usando el puerto:**
```bash
# Linux/Mac
lsof -i :8090
sudo kill -9 [PID]

# Windows
netstat -ano | findstr :8090
taskkill /PID [PID] /F
```

2. **Cambiar puerto en application.properties:**
```properties
server.port=8091
```

3. **Usar puerto aleatorio disponible:**
```properties
server.port=0
```

#### ☕ Problemas de Compilación con Java 21

**Síntoma:**
```
Invalid target release: 21
```

**Soluciones:**

1. **Verificar versión de Java:**
```bash
java -version
javac -version
```

2. **Configurar JAVA_HOME:**
```bash
# Linux/Mac
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk
export PATH=$JAVA_HOME/bin:$PATH

# Windows
set JAVA_HOME=C:\Program Files\Java\jdk-21
set PATH=%JAVA_HOME%\bin;%PATH%
```

3. **Limpiar y recompilar:**
```bash
./mvnw clean install -U
```

#### 🎨 Thymeleaf: Plantilla no Encontrada

**Síntoma:**
```
Error resolving template "dashboard", template might not exist
```

**Soluciones:**

1. **Verificar ubicación de plantillas:**
```bash
ls -la src/main/resources/templates/
```

2. **Verificar configuración de Thymeleaf:**
```properties
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.cache=false
spring.thymeleaf.enabled=true
```

3. **Limpiar y recompilar:**
```bash
./mvnw clean compile
```

#### 🤖 Error con API de OpenAI

**Síntoma:**
```
ApiKeyNotSetException: OpenAI API key is not set
```

**Soluciones:**

1. **Configurar API key:**
```properties
langchain4j.open-ai.chat-model.api-key=sk-tu_api_key
```

2. **Verificar validez del API key:**
```bash
curl https://api.openai.com/v1/models \
  -H "Authorization: Bearer sk-tu_api_key"
```

3. **Deshabilitar funcionalidad de IA temporalmente:**
Comentar o remover las dependencias de LangChain4j del `pom.xml`

#### 💾 Error de Mapeo de Entidades

**Síntoma:**
```
org.hibernate.MappingException: Unknown entity
```

**Soluciones:**

1. **Verificar anotación @Entity:**
```java
@Entity
@Table(name = "alumnos")
public class Alumnos {
    // ...
}
```

2. **Verificar escaneo de paquetes:**
```java
@SpringBootApplication
@EntityScan("org.kinscript.Academy.persistence.entity")
public class AcademyApplication {
    // ...
}
```

#### 🗺️ Error con MapStruct

**Síntoma:**
```
No property named "X" exists in source parameter(s)
```

**Soluciones:**

1. **Regenerar mappers:**
```bash
./mvnw clean compile
```

2. **Verificar nombres de campos:**
```java
@Mapper(componentModel = "spring")
public interface AlumnosMapper {
    AlumnosDto toDto(Alumnos entity);
    Alumnos toEntity(AlumnosDto dto);
}
```

3. **Limpiar target y recompilar:**
```bash
./mvnw clean install
```

### 📝 Logs de la Aplicación

#### Ver logs en tiempo real
```bash
# Con Maven
./mvnw spring-boot:run | grep "org.kinscript.Academy"

# Con archivo JAR
java -jar target/Academy-0.0.1-SNAPSHOT.jar | tee academy.log

# Con Docker
docker logs -f kinscript-academy

# Filtrar errores
docker logs kinscript-academy 2>&1 | grep ERROR
```

#### Configurar nivel de logs
```properties
# application.properties

# Log general
logging.level.root=INFO

# Log de la aplicación (más detallado)
logging.level.org.kinscript.Academy=DEBUG

# Log de Spring (menos verbose)
logging.level.org.springframework=WARN

# Log de Hibernate SQL
logging.level.org.hibernate.SQL=DEBUG

# Archivo de log
logging.file.name=logs/academy.log
logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
```

### 🔍 Debugging

#### Ejecutar en modo debug
```bash
# Maven
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"

# JAR
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 -jar target/Academy-0.0.1-SNAPSHOT.jar
```

Luego conectar el debugger de tu IDE al puerto 5005.

### 📊 Análisis de Performance

#### Identificar queries lentas
```properties
# application.properties
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
spring.jpa.properties.hibernate.generate_statistics=true
```

#### Profiling de memoria
```bash
# Generar heap dump
jmap -dump:live,format=b,file=heap.bin [PID]

# Analizar con herramientas como:
# - Eclipse Memory Analyzer (MAT)
# - VisualVM
# - JProfiler
```

### 🆘 Obtener Ayuda

Si sigues experimentando problemas:

1. 📋 **Revisa los logs** completos en `logs/academy.log`
2. 🔍 **Busca el error** en Stack Overflow o GitHub Issues
3. 📝 **Crea un issue** en el repositorio con:
   - Descripción del problema
   - Logs de error completos
   - Pasos para reproducir
   - Versiones de Java, Maven, MySQL
4. 💬 **Contacta al equipo** a través de los canales de soporte

## 🔐 Seguridad

### 🛡️ Mejores Prácticas Implementadas

#### ✅ Validación de Entrada
Todos los endpoints utilizan Jakarta Bean Validation:

```java
@PostMapping
public ResponseEntity<AlumnosDto> crear(@Valid @RequestBody AlumnosDto dto) {
    // Spring valida automáticamente el DTO
}
```

```java
public class AlumnosDto {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombreAlumno;
    
    @Email(message = "Email inválido")
    private String emailAcademico;
}
```

#### 🔒 Uso de DTOs

El sistema usa DTOs para:
- ✅ Evitar exposición directa de entidades JPA
- ✅ Controlar qué datos se envían/reciben
- ✅ Prevenir mass assignment vulnerabilities
- ✅ Separar lógica de presentación de persistencia

```java
// ❌ MAL - Exponer entidad directamente
@GetMapping
public List<Alumnos> getTodos() { }

// ✅ BIEN - Usar DTO
@GetMapping
public List<AlumnosDto> getTodos() { }
```
