# 💡 API Rest - Integrador 3

Partiendo de la base del trabajo integrador N°2 desarrollamos un servicio REST para aplicar los conocimientos aprendidos sobre los diferentes patrones y tecnologias de Java.


## 🛠️ Tecnologías utilizadas
- **JAVA 17**
- **SPRING BOOT**
    - **Spring Web** (para construir la API REST)
    - **Spring Data JPA** (para la persistencia)
    - **MySQL Driver** (conexión con la base de datos MySQL)
- **JPA / Hibernate** (API para implementar mapeo objeto-relacional)
- **JPQL** (para hacer consultas de persistencia en Java (JPA)
- **MySQL** (base de datos relacional)
- **IntelliJ IDEA Ultimate** (IDE de desarrollo)
- **Maven** como gestor de dependencias
- **Postman** (para testeo de endpoints)

## 📏 Arquitectura del sistema
El sistema sigue una **arquitectura en capas**, compuesta por:

- **Controller** → gestiona las solicitudes HTTP y las respuestas.
- **Service** → contiene la lógica de negocio y las validaciones.
- **Repository** → maneja el acceso a los datos mediante *Spring Data JPA*.
- **DTOs (Data Transfer Objects)** → permiten transferir datos entre capas sin exponer directamente las entidades.
- **GlobalExceptionHandler** → manejo centralizado de errores y excepciones.


## 🏗️ Patrones de diseño aplicados
En el desarrollo del sistema se utilizaron los siguientes patrones de diseño arquitectónico:
- **Repository**: para aislar la persistencia de una entidad.
- **DTO (Data Transfer Object)**: transferencia de datos entre capas de la aplicación, desacoplando la entidad de la lógica de negocio (ocultando la información de mis entities). → seguridad, separación de intereses, performance.

## 🚀 Necesario para un correcto funcionamiento
- Tener instalado [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
- Agregar las dependencias de [Maven](https://mvnrepository.com/)

## ⚙️ Consejos para testear el proyecto
Recomendamos configurar el archivo application.properties para un correcto funcionamiento del servicio. (Es nuestro caso ejecutamos este servicio con una base de datos local mediante XAMPP)

### Propiedades principales a configurar:
- **URL de conexión**: `jdbc:mysql://localhost:3306/integrador3?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC`
- **Usuario**: `root`
- **Contraseña**: *(vacía por defecto, cambiar según tu entorno)*

## 📃 Endpoints
Las funcionalidades requeridas para este sistema son expuestas a traves de los siguientes endpoints:

### Estudiantes
- `GET /estudiantes` → Listar todos los estudiantes (Ordenados por edad ascendentemente)
- `GET /estudiantes/lu/{lu}` → Buscar estudiante por número de libreta
- `GET /estudiantes/gender/{gender}` → Listar estudiantes por género
- `GET /estudiantes/{career}/{city}` → Buscar estudiantes por carrera y ciudad
- `POST /estudiantes` → Dar de alta un estudiante
- `GET /estudiantes/{dni}` → Buscar estudiante por su documento
- `DELETE /estudiantes/{dni}` → Eliminar un estudiante
- `UPDATE /estudiantes/{dni}` → Actualizar la información de un estudiante

### Carreras
- `GET /carreras` → Listar todas las carreras
- `GET /carreras/{id}` → Buscar una carrera por identificador
- `POST /carreras` → Crear una nueva carrera
- `DELETE /carreras/{id}` → Eliminar una carrera
- `UPDATE /carreras/{id}` → Actualizar una carrera
- `GET /carreras/inscriptos` → Listar carreras con inscriptos ordenadas por cantidad de inscriptos
- `GET /carreras/reporte` → Listar un reporte con las diferentes carreras, graduados e inscriptos por año

### Matriculas
- `GET /matriculas` → Listar todas las matriculas activas
- `GET /matriculas/{dni}/{id_carrera}` → Buscar una matricula en base a estudiante y carrera
- `POST /matriculas` → Matricular un estudiante en una carrera
- `PUT /matriculas/{dni}/{id_carrera}` → Actualizar los datos de una matricula
- `DELETE /matriculas/{dni}/{id_carrera}` → Eliminar una matricula


> Creamos una colleción predefinida de consultas con Postman para agilizar el testing de los ejercicios. [Ver JSON](./src/main/resources/postman/Integrador3.postman_collection.json)


##  Contacto
- Juan Manuel Santa Cruz - juanmasantax@gmail.com
- Rafael Iván Garcia - rafa.g6320@gmail.com
- Joel Kiehr - kiehrjoel@gmail.com
- Santiago Rui - srui@alumnos.exa.unicen.edu.ar