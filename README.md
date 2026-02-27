Asunto: Entrega Microservicio Cliente – Prueba Técnica

Hola, muy buenos días equipo de Devsu,

Comparto el primer microservicio de los dos solicitados. Este corresponde al módulo de clientes/personas.

Base de Datos

Se implementó una base de datos independiente para cada microservicio, siguiendo buenas prácticas de arquitectura de microservicios.
Para este caso, la base de datos se llama:

clienteservicesdb (PostgreSQL)

Adjunto también el respaldo de la base de datos en formato .tar, para facilitar la restauración del entorno. Puede importarse mediante herramientas como DBeaver o cualquier IDE de su preferencia.

La aplicación fue dockerizada. A continuación, los comandos para su ejecución:

Construir la imagen:

docker build -t cliente-service .

Crear y ejecutar el contenedor de la aplicación:

docker run -d -p 8081:8081 cliente-service

Crear y ejecutar el contenedor de la aplicación:

docker-compose up --build

Adjunto también el archivo JSON con la colección de Postman para facilitar las pruebas de los endpoints expuestos.

Quedo atento a cualquier comentario o retroalimentación.

Muchas gracias por su tiempo.

Cordialmente,
Sergio Stiven Urbina Bayona
