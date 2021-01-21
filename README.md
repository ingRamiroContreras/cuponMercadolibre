# cuponMercadolibre
calculate cupon from MercadoLibre

## Instalacion

Descargar archivo test-0.0.1-SNAPSHOT.jar  ubicado en la carpeta [jar].

Ejecutar JAR

```bash
java -jar cupon-0.0.1-SNAPSHOT.jar
```

## Consumo servicios 

Request

```json
Method = POST
Url = http://localhost:8080/coupon
Content-Type = application/json
Body = 
{
    "item_ids": [
        "MLA811601010",
        "MLA811601012"
    ],
    "amount": 500000
}
```

Response

```json
Method = POST
Content-Type = application/json
Body = 
{
    "item_ids": [
        "MLA811601010",
        "MLA811601012"
    ],
    "total": 497499.0
}

```

Limpiar cache

```json
Method = POST
Url = http://localhost:8080/cache/coupon
Content-Type = application/json

```

## Consumo servicios Heroku

Request

```json
Method = POST
Url = https://heroku-mercadolibre.herokuapp.com/coupon
Content-Type = application/json
Body = 
{
    "item_ids": [
        "MLA811601010",
        "MLA811601012"
    ],
    "amount": 500000
}
```

Response

```json
Method = POST
Content-Type = application/json
Body = 
{
    "item_ids": [
        "MLA811601010",
        "MLA811601012"
    ],
    "total": 497499.0
}

```

Limpiar cache

```json
Method = POST
Url = https://heroku-mercadolibre.herokuapp.com/cache/coupon
Content-Type = application/json

```


## Proyecto realizado en JAVA y Spring Boot

 - Descargar el proyecto o clonarlo.
 - Importarlo en eclipse o STS como proyecto MAVEN.
 - Ejecutar como Spring Boot App.
 - El proyecto se esta ejecutando por el puerto = 8080. 
