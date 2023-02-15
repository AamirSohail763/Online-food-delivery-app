# REST API for an Online Food Delivery Application

* A SpringBoot project which provides REST API for an Online Food Delivery application. This API performs all the fundamental CRUD operations of any Online Food Delivery platform with user validation at every step.

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

## Modules

* Signup, Login/Logout Module
* Restaurant Module
* Customer Module
* Order and Items Module
* Bill Module

## Features

* Customer and Admin authentication & validation with session uuid.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete restaurants or customer from main database
    * Admin can access the details of different customers, restaurants and orders
* Customer Features:
    * Registering themselves with application, and logging in to get the valid session token
    * Viewing list of available items and ordering it
    * Only logged in users view cart details, place an order, update and access other features
    
## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/AamirSohail763/Online-food-delivery-app/blob/main/Food_Delivery_App/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8008

    spring.datasource.url=jdbc:mysql://localhost:3306/cabdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

## API Root Endpoint

`https://localhost:8008/`

`http://localhost:8008/swagger-ui.html`

### Sample API Response for Customer Login

`POST   localhost:8008/login`

* Request Body

```
    {
        
        "password": "Aamir@123",
        "userId": 1,
        "userName": "AamirSohail"
    }
```

* Response

```
    {
         UserSession(id=2, userId=1, UUID=000267, timeStamp=2022-11-14T14:12:43.129790400)

    }
```
