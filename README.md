# desafio-tecnico-mantenedor

## Instructivo de aplicación

La aplicación corresponde a un desafío técnico de la empresa coopeuch, el cual se encuentra desarrollado en:

- Java con el framework Spring boot 2.7
- Bases de datos MySQL contenida en una imagen de Docker
- El ORM y persistencia se realizo con hibernate y JPA respectivamente
- La Api Rest fue documentada con Swagger, url swagger: http://localhost:8080/swagger-ui/index.html

Para realizar la instalación de la aplicación debe clonar o descargar el proyecto que se encuentra en github 
Una vez instalado el proyecto debe crear una imagen de Docker para la base de datos con el siguiente comando, lo puede ejecutar en cmd o powershell y debe tener instalado Docker 

docker run --detach --env MYSQL_ROOT_PASSWORD=tareas1234567 --env MYSQL_USER=tareas-user --env MYSQL_PASSWORD=tareas1234567 --env MYSQL_DATABASE=tareas-database --name mysqltareas --publish 3306:3306 mysql:8-oracle
62e5e59877c27bd7d2462371154c59ba4d764cc7eaf81afca90db75aae7aa165

Tambien se puede configurar otra base de datos en el properties 

## Los métodos realizados fueron los siguientes:

GET listarTareas Method
http://localhost:8080/v1/tareas/listarTareas

Delete removerTarea Method
http://localhost:8080/v1/tareas/removerTarea/3

Post agregarTarea Method
http://localhost:8080/v1/tareas/agregarTarea
Body
{
      "descripcion": "Prueba de Tareas",
      "fechaCreacion": "01-02-2023",
      "vigente": "true"
   }

PUT editarTarea Method
http://localhost:8080/v1/tareas/editarTarea/2
Body
{
        "descripcion": "Tarea 1",
        "fechaCreacion": "02-02-2023",
	"vigente": "true"
    }

