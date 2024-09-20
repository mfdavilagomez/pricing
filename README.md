# Pricing Application

## Tecnologías utilizadas
- **Java 17**
- **Spring Boot** para la creación del API REST
- **JPA (Hibernate)** para la persistencia de datos
- **H2** como base de datos en memoria
- **Jacoco** para la cobertura de código
- **JUnit** y **MockMVC** para los tests de integración y unitarios

## Arquitectura
El proyecto sigue una **arquitectura hexagonal**, separando las capas de infraestructura, aplicación y dominio:
- **Dominio**: Contiene la lógica central de la aplicación (entidades, servicios de dominio).
- **Aplicación**: Contiene casos de uso y controladores.
- **Infraestructura**: Interactúa con frameworks y herramientas externas (repositorios, excepciones, adaptadores).

## Patrones de diseño implementados
- **Repository Pattern**: Para el acceso a los datos.
- **DTO Pattern**: Para transferir datos entre capas.
- **Exception Handling**: Control centralizado de errores.

## Instrucciones
### Ejecutar el proyecto
```bash
mvn spring-boot:run
