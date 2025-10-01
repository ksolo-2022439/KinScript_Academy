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

> **Nota:** Las capturas de pantalla están disponibles en la carpeta `docs/screenshots/` del repositorio. Puedes reemplazar las rutas de las imágenes con las URLs finales una vez subidas.



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

#### 2️⃣ Configurar la base de datos

**Crear la base de datos MySQL:**
```bash
mysql -u root -p
```

```sql
CREATE DATABASE KinScript_Academy CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
EXIT;
```

**Ejecutar los scripts SQL:**
```bash
# Importar esquema de base de datos
mysql -u root -p KinScript_Academy < Database/KinScript_Academy.sql

# Importar datos de prueba (opcional)
mysql -u root -p KinScript_Academy < Database/Datos_KinScript_Academy.sql
```

#### 3️⃣ Configurar las propiedades de la aplicación

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

#### 4️⃣ Compilar y ejecutar la aplicación

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

#### 5️⃣ Acceder a la aplicación

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

## 👨‍💻 Autor

**KinScript Academy Team**
- GitHub: [@ksolo-2022439](https://github.com/ksolo-2022439)
- GitHub: [@gc130041](https://github.com/gc130041)
- GitHub: [@EduardoLG](https://github.com/EduardoLG)
- GitHub: [@marcss-bnajera](https://github.com/marcss-bnajera)
- GitHub: [@dnmrll](https://github.com/dnmrll)

## 🚀 Despliegue en Producción

### Docker
```dockerfile
# Dockerfile ejemplo
FROM openjdk:21-jre-slim
COPY target/Academy-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### Variables de Entorno para Producción
```bash
SPRING_PROFILES_ACTIVE=production
SPRING_DATASOURCE_URL=jdbc:mysql://db-host:3306/KinScript_Academy
SPRING_DATASOURCE_USERNAME=${DB_USER}
SPRING_DATASOURCE_PASSWORD=${DB_PASSWORD}
SERVER_PORT=8090
```

## 🔧 Solución de Problemas

### Problemas Comunes

#### Error de Conexión a Base de Datos
```bash
# Verificar que MySQL esté ejecutándose
sudo systemctl status mysql

# Verificar conectividad
mysql -u tu_usuario -p -h localhost
```

#### Puerto en Uso
```bash
# Encontrar proceso usando el puerto 8090
lsof -i :8090

# Cambiar puerto en application.properties
server.port=8091
```

#### Problemas de Compilación con Java 21
```bash
# Verificar versión de Java
java -version

# Configurar JAVA_HOME
export JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64
```

### Logs de la Aplicación
```bash
# Ver logs en tiempo real
tail -f logs/academy.log

# Configurar nivel de logs en application.properties
logging.level.org.kinscript.Academy=DEBUG
```

## 🔐 Seguridad

### Mejores Prácticas Implementadas
- Validación de entrada en todos los endpoints
- Uso de DTOs para evitar exposición de entidades
- Encriptación de contraseñas (cuando se implemente autenticación)
- Configuración de CORS apropiada
- Sanitización de datos SQL con JPA

### Recomendaciones Adicionales
- Implementar HTTPS en producción
- Configurar firewall para la base de datos
- Usar secretos seguros para API keys
- Implementar rate limiting
- Auditoría de accesos

## 📊 Métricas y Monitoreo

### Métricas Disponibles
- Número de requests por endpoint
- Tiempo de respuesta promedio
- Uso de memoria y CPU
- Número de conexiones a base de datos
- Errores por tipo y frecuencia

### Herramientas Recomendadas
- **Micrometer**: Métricas de aplicación
- **Prometheus**: Recolección de métricas
- **Grafana**: Visualización de métricas
- **ELK Stack**: Análisis de logs

## 📞 Soporte

Para reportar bugs o solicitar nuevas características, por favor crea un [issue](https://github.com/ksolo-2022439/KinScript_Academy/issues) en GitHub.

### Canales de Comunicación
- **Issues**: Para bugs y solicitudes de características
- **Discussions**: Para preguntas generales y discusiones
- **Wiki**: Documentación adicional y guías avanzadas

---

⭐ **¡No olvides dar una estrella al proyecto si te fue útil!** ⭐

**KinScript Academy** - Revolucionando la gestión académica con tecnología moderna
