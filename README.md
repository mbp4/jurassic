# jurassic
 
link al repositorio: https://github.com/mbp4/jurassic.git

Participantes: Miriam Blanco Ponce, Sira González-Madroño y Sonia Tejero Recio

Este proyecto es una aplicación desarrollada con Spring Boot y WebFlux, diseñada para monitorear la actividad de dinosaurios en un parque jurásico en tiempo real. Su propósito es integrar sensores y herramientas de gestión para garantizar la seguridad y el funcionamiento eficiente del parque.

---

## Funcionalidades principales

### 1. Gestión de Dinosaurios
- **Modelo de datos**: Se incluyen atributos como el nombre, tipo (familia), alimentación y hábitat (isla) de los dinosaurios.
- **CRUD completo**: Permite gestionar la información de los dinosaurios y su ubicación en el parque.
- **Plantillas Thymeleaf**: Diseñadas para mostrar las listas de dinosaurios y gestionar sus datos.

### 2. Sensores de Actividad
- **Movimiento**: Rastrea la ubicación y alimentación de los dinosaurios en tiempo real.
- **Alertas de Seguridad**: Detecta y notifica cuando herbívoros y carnívoros se encuentran en la misma ubicación, utilizando programación reactiva con **Project Reactor**.

### 3. Seguridad
- **Spring Security**: Implementación de autenticación y autorización.
- **Roles**:
  - `ADMIN`: Tiene acceso total al sistema.
  - `USER`: Acceso limitado.
- **Acceso restringido**: Páginas protegidas con validación de roles; los usuarios sin permiso son redirigidos a una página de error.

### 4. Auditoría
- **AOP (Programación Orientada a Aspectos)**: Registra acciones relevantes en la base de datos, como la creación o fallos al intentar guardar un dinosaurio.
- **Historial de eventos**: Muestra los registros en una vista lista mediante Thymeleaf.

### 5. Sensores Reactivos
- **MovimientoSensorService**: Procesa eventos de movimiento en paralelo, verificando ubicaciones conflictivas y almacenando información para su análisis.

---

## Estructura del Proyecto

### Paquetes principales
1. **`controller`**: Maneja las peticiones HTTP y redirige a las vistas correspondientes.
   - `MainController`: Redirige al listado principal.
   - `OperacionesController`: Gestiona dinosaurios y acciones como agregar, listar o finalizar el día.
   - `AuditoriaController`: Controlador para visualizar auditorías.

2. **`model.entidades`**: Define las entidades del modelo.
   - `Dinosaurio`: Representa a los dinosaurios con atributos como tipo, alimentación y ubicación.
   - `Isla`: Agrupa a los dinosaurios por ubicación y tipo.
   - `Auditoria`: Registra eventos relevantes en el sistema.

3. **`model.dao`**: Repositorios para interactuar con la base de datos.
   - `DinosaurioDao`, `IslaDao` y `AuditoriaDao`.

4. **`seguridad`**: Configuración y servicios de seguridad.
   - `SecurityConfig`: Configura usuarios y roles.
   - `SecurityServicio`: Recupera el rol y nombre del usuario actual.

5. **`servicios`**: Lógica del negocio.
   - `OperacionesServicio`: Gestión de dinosaurios y verificación de datos.
   - `MovimientoSensorService`: Manejo de sensores de actividad reactiva.

6. **`aop`**: Implementa aspectos para auditoría y control de permisos.

### Plantillas HTML
- **`listado.html`**: Muestra una lista de dinosaurios agrupados por islas.
- **`prohibido.html`**: Restringe el acceso a los usuarios que no tengan permiso.
- **`auditoria.html`**: Muestra una plantilla con los registros de auditoría.
- **`nacer.html`**: Interfaz para agregar nuevos dinosaurios.

### Dependencias clave
- Spring Boot Starter: Core, Web, Security, Data JPA, WebFlux y Thymeleaf.
- H2 Database: Base de datos en memoria para pruebas.
- AspectJ Weaver: Soporte para AOP.
- Reactor Core: Manejo de programación reactiva.

### Configuración
- **Puerto del servidor**: `8080`
- **Base de datos**: Configurada en memoria (H2) con credenciales predeterminadas.
