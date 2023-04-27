# Tekbees-viajes

Es una aplicacion desarrollada para tener un control y registro de los datos de los viajes.
Es una aplicacion desarrollada con Spring Boot version 3.0.6 con arquitectura modelo vista controlador, con base de datos relacional en MySQL, con uso de inserciones a la base de datos para un uso principal y validar la funcionalidad.

# Uso principal
para su despliegue se debe tener un Ide de java conpatible para ser ejecutando el proyecto.
se debe realizar `maven update` este mismo se realizar en el Ide de java dandole click derecho sobre el proyecto y en la parte de maven se encontrara el maven update. Este se puede tambien en la consola de comando con el comando `mvn clean install -U `.

# Ejecucion
para su ejecucion se debe en el Ide de java sobre el proyecto darle en `run as spring boot` este levantara el proyecto en el pueto `8080` del equito, para hacer uso del aplicativo se lenvatara en el enlace `http://localhost:4200/`, la aplicacion tiene un ruta de mapeo para el uso de los enlaces de acceso a las peticiones rest api este se usa con el subfijo de `/api`
***
ruta de uso:
`http://localhost:4200/api`

# Ejemplo de peticion
la estructura de la peticion post se base en el ingreso de datos de la siguiente forma:
***
```json

{
      "startDate": "2019-01-25T19:06:27.936-05:00",
      "strartPickupAddres": "Cl. 90 #19-41, Bogotá, Colombia",
      "endDate": "2020-02-21T10:06:27.936-05:00",
      "endPickupAddres": "Ac. 100 #13-21, Bogotá, Colombia",
      "country": {
         "id": 1,
        "name": "Colombia"
      },
      "city": {
          "id": 1,
          "name": "Bogotá",
          "country": {
          "id": 1,
          "name": "Colombia"
        }
      },
     "passenger": {
        "id": 1,
        "firstName": "Ricardo",
        "lastName": "Sarmiento"
      },
     "driver": {
         "id": 1,
        "firstName": "Julio Alberto",
        "lastName": "Mesa Rodriguez"
     },
    "car": {
      "id": 1,
      "plate": "ESM308"
    },
   "status": "started",
   "checkCode": "66",
   "price": 13800.0,
   "driverLocation": "Cl. 14 #78-14, Bogotá, Colombia"
},
```
***



