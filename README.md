# Proyecto Foro Alura
Literalura es un Web API creado en Java Spring

Consiste en una API que se conecta a una base de datos MySQL que contiene una serie de tablas.

1. Tabla course: Contiene los cursos que se imparten en el foro.
2. Tabla status: Contiene el estado de los tópicos (Active, Inactive)
3. Tabla profile: Contiene los diferentes tipos de perfiles de los usuarios (Administrator, Expert, Junior)
4. Tabla user: Contiene los usuarios que crean tópicos, respuestas a esos tópicos.
5. Tabla topic: Es la parte fundamental del challenge, crea el foro o la consulta que tiene un usuario en el sistema.
6. Tabla responses: Contiene las respuestas a cada de los tópicos del sistema

La función principal es crear una tópico o una consulta para uno de los cursos y que otros usuarios puedan ayudarle dando respuestas a esa consulta.

Este Web API permite consultar, crear, modificar y eliminar tópicos, respuestas. Y permite consultar, crear y modificar usuarios.

A continuaciòn se adjuntan diversas imagenes del proyecto:

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/0.png" alt="Entorno de desarrollo">

------------------------

# Tecnologías Utilizadas.

- Lombok
- JDK 17.
- Maven.
- Spring Web
- Spring Boot.
- MySQL.
- Spring Data JPA.
- Flyway Migration
- Validation
- Spring Security - Auth0 para la creación de JWT.
- Swagger UI. 