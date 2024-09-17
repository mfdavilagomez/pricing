# Pricing API

Esta API ofrece un servicio REST para consultar precios de productos basados en fecha, identificador de producto y cadena. Utiliza una arquitectura hexagonal y sigue los principios de diseño SOLID para garantizar la mantenibilidad y escalabilidad.

## Tecnologías
- Java 17
- Spring Boot
- H2 Database
- Maven
- JUnit & Jacoco

## Cómo ejecutar el proyecto
1. Clona el repositorio: `git clone https://github.com/usuario/pricing.git`
2. Ve al directorio del proyecto: `cd pricing`
3. Ejecuta el proyecto: `mvn spring-boot:run`
4. Para pruebas: `mvn test`

## Patrones de Diseño
- **Repository Pattern:** Para separar la lógica de acceso a datos.
- **DTO:** Para desacoplar las entidades de negocio de las respuestas del API.
