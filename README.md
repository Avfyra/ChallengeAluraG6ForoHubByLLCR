# ForoHub
#### Challenge Alura G6, ONE.

Un foro es un espacio donde todos los participantes de una plataforma pueden plantear sus preguntas sobre determinados tópicos.

Como parte del último challenge de Alura, se ha creado una API REST usando Spring.

Esta API se centra específicamente en los tópicos y permite a los usuarios:
+ Login.
+ Crear un nuevo tópico.
+ Mostrar todos los tópicos creados. 
+ Mostar un tópico especifico.
+ Actualizar un tópico.
+ Eliminar un tópico.

Es lo que normalmente conocemos como CRUD (CREATE, READ, UPDATE, DELETE).

Esta aplicación es parte de los Challenges de AluraLatam, G6, que forman parte del programan Oracle Next Education.

## Funcionalidades
### Login
Para poder acceder a las funcionalidades de la API se ha implementado un Login el cual arroja un Bearer Token, el cual es necesario para poder autorizar las demás request. 
Para ello es necesario agregar un usuario a la base de datos que contenga el nombre de usuario y la clave convertida a un HASH, el cual puedes generar en la siguiente liga: https://www.browserling.com/tools/bcrypt
![image](https://github.com/user-attachments/assets/a2390b2a-d755-4fea-9b77-9b1c9e54ef85)
Hecho esto, se ingresa a Insomniam en la request Login, en este ejemplo de uso, de la siguiente manera:
![Captura de pantalla 2024-07-12 150920](https://github.com/user-attachments/assets/0e466b82-564a-474d-963b-a6647e86cd3b)
Una vez generado el token, pasamos a la http request deseada e ingresamos el token como se muestra en la siguiente imagen:
![Captura de pantalla 2024-07-12 151351](https://github.com/user-attachments/assets/da26ecc6-4c44-4396-87d8-9af6c817d438)
Este paso es importante ya que de lo contrario las demás peticiones serán denegadas.
![Captura de pantalla 2024-07-12 151010](https://github.com/user-attachments/assets/616e69b5-177e-4e75-b548-b6abfe47d625)
### Crear un nuevo tópico
Para crear un nuevo tópico, una vez hecho lo el Login e ingresado el token en la parte correspondiente, mandamos la información mediante un JSON, y el tópico será registrado en la base de datos y también mostrado en el Preview de Insomnia, como se muestra a continuación:
![Captura de pantalla 2024-07-12 151316](https://github.com/user-attachments/assets/3e89e4e0-75d3-4686-a243-765c3016c1ee)
### Mostrar todos los tópicos creados
Para mostrar todos los tópicos, una vez hecho lo el Login e ingresado el token en la parte correspondiente, simplemente enviamos la información haciendo clic en Send y en el preview se mostrará la lista de los tópicos.
![Captura de pantalla 2024-07-12 151427](https://github.com/user-attachments/assets/ca57cba0-0947-4bc5-b950-22fe80462e77)
### Mostar un tópico especifico
Para mostrar un tópico en especifico se utiliza el id del tópico que se desea buscar. Una vez hecho lo el Login e ingresado el token en la parte correspondiente, es necesario modificar la URL http://localhost:8080/topicos/8, donde el 8 representa el id del tópico que se desea ver. Después simplemente enviamos la información haciendo clic en Send y en el preview se mostrará el tópico.
![image](https://github.com/user-attachments/assets/01ac7399-d134-419a-b3ff-c1296dadf6c3)
### Actualizar un tópico
Para actualizar los datos de un tópico, una vez hecho el Login e ingresado el token en la parte correspondiente, enviaremos la información mediante un JSON, y en el preview mostrará como ha sido modificado dicho tópico. 
![Captura de pantalla 2024-07-12 151547](https://github.com/user-attachments/assets/0430ab7c-7612-462e-be9c-cdc3b1ad8cb1)
Si deseas comprobar la actualización, puedes volver a listar los tópicos y mostrará todos los tópicos y podrás confirmar que se ha modificado. También puedes buscarlo por id para que solo te muestre el tópico modificado.
![Captura de pantalla 2024-07-12 151728](https://github.com/user-attachments/assets/0cefc0c0-1692-410d-ad41-9dbafd3f4a0a)
### Eliminar un tópico

Para eliminar un tópico, una vez hecho lo el Login e ingresado el token en la parte correspondiente, es necesario modificar la URL http://localhost:8080/topicos/8, donde el 8 representa el id del tópico que se desea eliminar. Después simplemente enviamos la información haciendo clic en Send.
![Captura de pantalla 2024-07-12 151741](https://github.com/user-attachments/assets/5a0789cf-d02d-4e29-af91-22f3f49ee097)
Si deseas comprobar la eliminación del tópico, puedes volver a listar los tópicos y podrás confirmar que ya no aparece.
![image](https://github.com/user-attachments/assets/143d7ed6-0c14-4f2c-a25a-6aebfff4d494)
## Demostración 
Ejecutando las http request
![Grabación de pantalla 2024 07 12 181847](https://github.com/user-attachments/assets/de5b058a-111c-47d0-86ed-ee3990a51695)
## Dependencias

Se utilizaron las siguientes dependencias para el desarrollo de la API:
+ Lombok
+ Flyway
+ JWT
+ Spring Boot Dev Tools
+ Spring Data JPA
+ Flyway Migration
+ MySQL Driver
+ Validation
+ Spring Security

## Requisitos
Para el correcto funcionamiento de la aplicación se recomienda el uso de:
+ Java Development Kit (JDK) 17 o superior.
+ Conexión a Internet para obtener la información mediante la API.
+ IDE de su preferencia.
+ MySQL
+ Configurar los datos o las variables de entorno para conectar la aplicación a la base de datos.
+ Insomnia o Postman

Nota: en el presente código no se utilizaron variables de entorno ya que es un demo y solo están a manera de ejemplo. Recuerda que es necesario configurar esta información para que la API tenga acceso a tu base de datos y el programa funcione.

## Instalación y uso
+ Para acceder a la aplicación puedes descargar directamente el repositorio desde GitHub, o bien clonar el proyecto por medio del comando **git clone**.
+ Recuerda verificar que cumples con los requisitos para correr la aplicación.
+ Configura los datos o las variables de entorno para conectar la aplicación a la base de datos.
+ Abre Insomnia o Postman para configurar las http resquest

## Contribución
Las contribuciones siempre son bienvenidas. Puede seguir estos pasos para colaborar:
+ Realice un fork del repositorio
+ Clone el repositorio
+ Actualice la rama master
+ Crea una rama
+ Haga los cambios
+ Haga un Pull Request

## Consideraciones
Esta es la primera versión de la app, por lo que puede estar sujeta a futuros cambios. 

