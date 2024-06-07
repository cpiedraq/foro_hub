# Proyecto Foro Alura

Foro Hub es un Web API creado en Java Spring, que se basa en REST, corresponde a un requisito para la formación de BacKEnd de #OracleOne y #Alura

<h3>Base de datos</h3>

Consiste en una API que se conecta a una base de datos MySQL que contiene una serie de tablas, las cuales se detallan a continuación: 

1. Tabla course: Contiene los cursos que se imparten en el foro.
2. Tabla status: Contiene el estado de los tópicos (Active, Inactive)
3. Tabla profile: Contiene los diferentes tipos de perfiles de los usuarios (Administrator, Expert, Junior)
4. Tabla user: Contiene los usuarios que crean tópicos, respuestas a esos tópicos.
5. Tabla topic: Es la parte fundamental del challenge, crea el foro o la consulta que tiene un usuario en el sistema.
6. Tabla responses: Contiene las respuestas a cada de los tópicos del sistema

<h3>Métodos del Web API</h3>

La función principal es crear una tópico o una consulta para uno de los cursos y que otros usuarios puedan ayudarle dando respuestas a esa consulta.

Este Web API permite consultar, crear, modificar y eliminar tópicos, respuestas. Y permite consultar, crear y modificar usuarios.

A continuaciòn se adjuntan diversas imagenes del proyecto:

- Entorno de desarrollo

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/0.png" alt="Entorno de desarrollo">

- Métodos del Web API, documentación mediante Swagger UI

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/1.png" alt="Metodos 1">

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/2.png" alt="Metodos 2">

<h3>Autenticación</h3>

- Para utilizar los metodos del Web API es necesario autenticarse, esta API utiliza JWT para realizarlo, lo debe de realizar en el método POST de la ruta /login

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/token.png" alt="Autenticarse">

- Una vez generado el token deberà de utilizarse en la sección Authorize.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/3.png" alt="Autenticarse">

- Una vez autenticado podra consumir los mètodos

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/4.png" alt="Autenticarse">

<h3>Mètodos màs utilizados del Web API</h3>

- Este es un ejemplo del metodo GET de la ruta /topics, que retorna todos los tópicos y las respuestas que le han brindado al mismo.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/5.png" alt="Metodo GET topics">

- En la siguiente imagen se observa el método POST para crear un nuevo tópico.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/6.png" alt="Crear un nuevo tópico">

- Se observa el método POST para crear una respuesta al tópico creado anteriormente.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/7.png" alt="Crear un nuevo tópico">

- Acà se observa como la consulta al tópico y la respuesta registrada.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/8.png" alt="Crear un nuevo tópico">

------------------------

<h3>Tecnologías Utilizadas</h3>

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