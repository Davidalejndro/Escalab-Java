
Proyecto API-Rest de Curso Escalab

Se realiza un proyecto API-Rest (CRUD) que permite realizar las siguientes acciones: mostrar, ingresar, editar y eliminar un usuario.

Se utiliza Spring Initializer para la maqueta de Spring Boot y el IDE IntelliJ IDEA para la codificación.

El proyecto consiste en una API Rest para gestionar usuarios y teléfonos de usuarios. Está conectado a una base de datos MySQL y consta de dos tablas: "Teléfonos" y "Usuarios". Al agregar un usuario y su teléfono correspondiente, se creará automáticamente la relación en la base de datos, generando tres tablas adicionales: "telefonos_seq", "usuario_seq" y "usuarios_telefonos".

Codificación:

El proyecto se organiza en módulos que incluyen servicios, modelos, controladores y componentes comunes. En el módulo de componentes comunes se encuentran las secuencias y detalles de errores.

Se proporciona un archivo con los scripts de creación de la base de datos y las tablas correspondientes.

Pruebas sobre el proyecto:

Las pruebas se pueden realizar mediante rutas utilizando el programa Postman.

Se adjunta un archivo JSON con las pruebas realizadas.

Rutas para realizar las pruebas:

Mostrar todos los usuarios de la tabla (GET): localhost:8080/usuarios/
Mostrar un usuario por ID (GET): localhost:8080/usuarios/id
Agregar un usuario (POST): localhost:8080/usuarios/
Modificar un usuario (PUT): localhost:8080/usuarios/
Eliminar un usuario por ID (DELETE): localhost:8080/usuarios/id
