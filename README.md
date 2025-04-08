Sistema Educativo - Microservicios

Este repositorio contiene el desarrollo de un sistema educativo distribuido utilizando arquitectura de microservicios con Spring Boot y Spring Cloud. El objetivo es modularizar diferentes funcionalidades como gestión de usuarios, asignaturas y calificaciones, entre otros.

👨‍💻 Datos personales
Nombre: Alvaro Contreras Bastidas

Correo: ac91.bastidas@gmail.com

GitHub: @acbastidas

📂 Estructura del Repositorio
pgsql
Copiar
Editar
sistema-educativo-microservicios-nombre/
│
├── config-server/
├── eureka-server/
├── gateway/
├── usuarios-servicio/
├── asignaturas-servicio/
├── matriculas-servicio/
├── docker-compose.yml
└── README.md
🌐 Visión General del Sistema
El sistema está diseñado para facilitar la gestión educativa en un entorno modular y escalable. Cada servicio funciona de forma independiente y se comunica a través de REST APIs. Los servicios se descubren dinámicamente mediante Eureka y se gestionan a través de un API Gateway. Las configuraciones están centralizadas con un Config Server, facilitando el mantenimiento y la escalabilidad del sistema.

🚀 Tecnologías Usadas
Spring Boot

Spring Cloud (Eureka, Gateway, Config Server)

MongoDB

Docker y Docker Compose

Spring Security + JWT (Seguridad)

Spring Boot Actuator (Monitorización)

GitHub Actions (CI/CD)

📌 Estado del Desarrollo por Puntos
✅ 1. Estructura de Microservicios
Proyecto dividido en múltiples módulos Maven.

Servicios creados: usuarios-servicio, asignaturas-servicio, matriculas-servicio, config-server, eureka-server, gateway.

✅ 2. Funcionalidad CRUD Básica
Cada servicio implementa operaciones básicas con MongoDB.

Endpoints REST funcionando.

✅ 3. Comunicación entre Microservicios
Uso de OpenFeign en matriculas-servicio para consumir usuarios-servicio y asignaturas-servicio.

✅ 4. Configuración y Descubrimiento de Servicios
Se implementó un config-server apuntando al repositorio remoto config-repo.

Todos los microservicios están registrados en eureka-server.

Configuración centralizada funcionando correctamente.

✅ 5. Seguridad con Spring Security y JWT
Autenticación implementada en usuarios-servicio.

Tokens JWT generados y validados correctamente.

Endpoints protegidos con roles.

✅ 6. Monitorización y Registro
Se integró Spring Boot Actuator en cada microservicio.

Se exponen los endpoints /actuator/health, /actuator/info para métricas y estado.

✅ 7. Pruebas de Microservicios
Pruebas unitarias y de integración creadas con Spring Boot Test.

Se usó Postman para pruebas manuales.

Al menos 1 prueba por microservicio implementada.

✅ 8. Despliegue y Orquestación
Se creó un archivo Dockerfile por microservicio.

Se configuró docker-compose.yml para levantar todo el sistema localmente.

Los servicios se ejecutan correctamente en red compartida sistema-red.
