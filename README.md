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
**a. Movimiento**: 
 - Rastrea la ubicación y alimentación de los dinosaurios en tiempo real.
 - **Alertas de Seguridad**: Detecta y notifica cuando herbívoros y carnívoros se encuentran en la misma ubicación, utilizando programación reactiva con **Project Reactor**.
**b. Frecuencia Cardiaca**:
 - Monitorea el ritmo cardíaco de los dinosaurios.
 - Genera alarmas si el ritmo está fuera del rango seguro.
**c. Temperatura**:
 - Verifica que los dinosaurios estén dentro de su rango ideal de temperatura.
 - Genera alertas si las condiciones ambientales son extremas.

### 3. Seguridad
- **Spring Security**: Implementación de autenticación y autorización.
- **Roles**:
  - `ADMIN`: Tiene acceso total al sistema.
  - `USER`: Acceso limitado.
- **Acceso restringido**: Páginas protegidas con validación de roles; los usuarios sin permiso son redirigidos a una página de error.

### 4. Auditoría
- **AOP (Programación Orientada a Aspectos)**: Registra acciones relevantes en la base de datos, como la creación o fallos al intentar guardar un dinosaurio.
- **Historial de eventos**: Muestra los registros en una vista lista mediante Thymeleaf.
- **Limpieza de auditorías**: Posibilidad de borrar registros al finalizar su revisión.

### 5. Sensores Reactivos
- **MovimientoSensorService**:
 - Procesa datos en paralelo con `Flux`.
 - Maneja técnicas de backpressure para evitar sobrecarga de datos.
- **Otros Sensores**:
 - **SensorCardiaco**: Evalúa la salud cardíaca de los dinosaurios.
 - **SensorTemperatura**: Verifica la temperatura ambiental ideal por especie.

---

## Estructura del Proyecto

### Paquetes principales
1. **`controller`**: Maneja las peticiones HTTP y redirige a las vistas correspondientes.
   - `MainController`: Redirige al listado principal.
   - `OperacionesController`: Gestiona dinosaurios y acciones como agregar, listar o finalizar el día.
   - `AuditoriaController`: Controlador para visualizar auditorías.
   - `CrianzaController`: Gestiona la asignación de islas a dinosaurios en crianza.

2. **`model.entidades`**: Define las entidades del modelo.
   - `Dinosaurio`: Representa a los dinosaurios con atributos como tipo, alimentación y ubicación.
   - `Isla`: Agrupa a los dinosaurios por ubicación y tipo.
   - `Auditoria`: Registra eventos relevantes en el sistema.

3. **`model.dao`**: Repositorios para interactuar con la base de datos.
   - `DinosaurioDao`, `IslaDao` y `AuditoriaDao`: Repositorios JPA para interactuar con la base de datos.

4. **`seguridad`**: Configuración y servicios de seguridad.
   - `SecurityConfig`: Configura usuarios y roles.
   - `SecurityServicio`: Recupera el rol y nombre del usuario actual.
  
5. **`sensores`**: Sensores para los dinosaurios.
   - `MovimientoSensor`: Procesa ubicaciones de dinosaurios.
   - `SensorCardiaco`: Monitorea ritmos cardíacos.
   - `SensorTemperatura`: Controla rangos de temperatura para cada especie.

7. **`servicios`**: Lógica del negocio.
   - `OperacionesServicio`: Gestión de dinosaurios y verificación de datos.
   - `MovimientoSensorService`: Manejo de sensores de actividad reactiva.
   - `AuditoriaServicio`: Gestiona las auditorías.

8. **`aop`**: Implementa aspectos para auditoría y control de permisos.

### Plantillas HTML
- **`listado.html`**: Muestra una lista de dinosaurios agrupados por islas.
- **`prohibido.html`**: Restringe el acceso a los usuarios que no tengan permiso.
- **`auditoria.html`**: Muestra una plantilla con los registros de auditoría.
- **`nacer.html`**: Interfaz para agregar nuevos dinosaurios.
- **`crianza.html`**: Permite asginar islas a los dinosaurios en crianza.

### Tecnologías clave
- **Spring Boot**: Framework principal.
- **Spring WebFlux**: Procesamiento reactivo.
- **Thymeleaf**: Motor de plantillas para HTML.
- **Spring Security**: Control de acceso basado en roles.
- **H2 Database**: Base de datos en memoria.
- **Bootstrap**: Diseño responsivo y estilos interactivos.
- **Reactor Core**: Gestión de flujos de datos reactivos.

### Configuración del Proyecto
1. **Base de datos**: H2 en memoria configurada con credenciales predeterminadas.
2. **Puerto del servidor**: `8080`.
3. **Usuarios preconfigurados**:
   - `ADMIN`:
    - `Miriam`/ `1234`
    - `Sira` / `1234`
    - `Sonia` / `1234`
   - `USER`:
    - `Invitado` / `1111`
