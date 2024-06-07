# 	:toolbox: Proyecto Foro Alura (BackEnd)

Foro Hub es un Web API :globe_with_meridians: creado en Java Spring, que se basa en REST, corresponde a un requisito para la formación de `BacKEnd` de #OracleOne y #Alura.

<h2>Base de datos</h2>

Este API se conecta a una base de datos MySQL, la cuàl contiene una serie de tablas, se detallan a continuación: 

1. Tabla course :blue_book:: Contiene los cursos que se imparten en el foro.
2. Tabla status :green_circle::red_circle:: Contiene el estado de los tópicos (Active, Inactive)
3. Tabla profile :briefcase:: Contiene los diferentes tipos de perfiles de los usuarios (Administrator, Expert, Junior)
4. Tabla user :pouting_man:: Contiene los usuarios que crean tópicos, respuestas a esos tópicos.
5. Tabla topic :notebook_with_decorative_cover:: Es la parte fundamental del challenge, crea el foro o la consulta que tiene un usuario en el sistema.
6. Tabla responses :receipt:: Contiene las respuestas a cada de los tópicos del sistema.

El modelo de base de datos se observa de la siguiente manera:

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/database.png" alt="Esquema de base de datos">

<h2>:hammer_and_wrench: Métodos del Web API</h2>

La función principal de este Web API es crear una tópico(consulta del foro) para uno de los cursos y que otros usuarios puedan ayudarle mediante respuestas.

El mismo permite consultar, crear, modificar y eliminar tópicos, respuestas. Y permite consultar, crear y modificar usuarios.

A continuación se adjuntan diversas imágenes del proyecto:

- Entorno de desarrollo en ejecución. 

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/0.png" alt="Entorno de desarrollo">

- Métodos del Web API, documentación mediante `Swagger UI`.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/1.png" alt="Metodos 1">

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/2.png" alt="Metodos 2">

<h2>:lock: Autenticación</h2>

- Para utilizar los métodos del Web API es necesario autenticarse, se utiliza JWT para realizarlo, lo debe de realizar en el método `POST` de la ruta `/login`

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/token.png" alt="Autenticarse">

- Una vez generado el token deberá de utilizarse en la sección Authorize (Swagger UI).

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/3.png" alt="Autenticarse">

- Una vez verificado el token podra consumir los mètodos de `GET`, `POST`, `PUT`, `DELETE`.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/4.png" alt="Autenticarse">

<h2>:hammer_and_pick: Métodos más utilizados del Web API</h2>

- Este es un ejemplo del método `GET` de la ruta /topics, que retorna todos los tópicos y las respuestas que le han brindado al mismo.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/5.png" alt="Metodo GET topics">

- En la siguiente imágen se observa el método `POST` para crear un nuevo tópico.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/6.png" alt="Crear un nuevo tópico">

- Se observa el método `POST` para crear una respuesta al tópico creado anteriormente.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/7.png" alt="Crear un nuevo tópico">

- Acá se observa como la consulta :mag: al tópico y la respuesta registrada.

<img src="https://github.com/cpiedraq/foro_hub/blob/changes/images/8.png" alt="Crear un nuevo tópico">

------------------------

<h2>Tecnologías Utilizadas</h2>

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