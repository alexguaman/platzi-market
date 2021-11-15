# Practica de Spring

## Estructura del proyecto
```
└───src
    └───main
        ├───java
        │   └───com
        │       └───platzi
        │           └───market
        │               ├───domain
        │               │   ├───dto
        │               │   ├───repository
        │               │   └───service
        │               ├───persistence
        │               │   ├───crud
        │               │   ├───entity
        │               │   └───mapper
        │               └───web
        │                   ├───config
        │                   ├───controller
        │                   └───security
        │                       └───filter
        └───resources
            ├───static
            └───templates

```

## Despliegue en heroku
Se utiliza el client de heroku para crear la aplicacion
```
heroku login
heroku create ag-platzi-market
```
Se instala el complemento para usar postgres
```
heroku addons:create heroku-postgresql
```
Obtenemos las configuraciones de database realizadas en heroku
```
heroku config
```
En la carpeta resources se encuentran los scripts para esta práctica.
* schema.sql
* data.sql

Desplegamos la aplicacion
```
git push heroku master
```

De esta manera Heroku se encarga de desplegar y ejecutar la aplicacion utilizando el archivo "Procfile" que contiene:
```
web: java -jar -Dspring.profiles.active=pro build/libs/platzi-market-1.0.jar
```

## Documentación

La documentacion del proyecto en encuentra desplegada con swagger en la url:

[ https://[host]:[port]/platzi-market/api/swagger-ui.html ]

