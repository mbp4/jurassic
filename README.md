# jurassic
 
link al repositorio: https://github.com/mbp4/jurassic.git

Participantes: Miriam Blanco Ponce, Sira González-Madroño y Sonia Tejero Recio

Este proyecto es una aplicación desarrollada con Spring Boot y WebFlux, diseñada para monitorear la actividad de dinosaurios en un parque jurásico en tiempo real. Su propósito es integrar sensores y herramientas de gestión para garantizar la seguridad y el funcionamiento eficiente del parque.

## Funcionalidades principales
### 1. Gestión de Dinosaurios
- *Modelo de datos:* Incluye atributos como el tipo, la alimentación y el hábitat de los dinosaurios.
- *Interfaz:* Una lista muestra todos los dinosaurios en el parque y permite gestionar su información.

### 2. Sensores de Actividad
- *Movimiento:* Se rastrea la ubicación y los cambios en los comportamientos de los dinosaurios.
- *Alerta de Seguridad:* Se genera una alerta si se detecta una convivencia peligrosa entre herbívoros y carnívoros en el mismo espacio.

### 3. Seguridad
- Autenticación y autorización implementadas con */Spring Security/*.
- Roles definidos para administradores y usuarios invitados.
- Acceso restringido a ciertas áreas del sistema.

### 4. Auditoría
- Registro de acciones en el sistema, como cambios en la base de datos o accesos de usuarios.

### 5. Interfaces Gráficas
- Páginas web dinámicas desarrolladas con Thymeleaf para facilitar la interacción del usuario.
- Diseño adaptado para la visualización de listas de dinosaurios, alertas y registros de auditoría.

### 6. Tecnologías
- Base de datos en memoria utilizando */H2/*.
- Implementación reactiva con */Project Reactor/* para manejar datos de sensores en tiempo real.
- Diseño modular con controladores, servicios y repositorios bien definidos.
