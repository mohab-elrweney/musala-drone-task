# Drone-app

Drone app is a springboot application that uses h2 embedded database.

it consists of 5 APIs:

1. Register a drone: [POST] http://localhost:8080/register
  Body [JSON]:  
    ```shell 
   {
    "serialNumber": "drone-1",
    "model": "HEAVYWEIGHT",
    "weightLimit": 500,
    "batteryCapacity": 100,
    "state": "LOADED"
    }

2. Load medications for a specific drone: [POST] http://localhost:8080/load-medications/{serialNumber} it takes serial number as path variable and Body [JSON]:
      ```shell
       [
           {
           "name": "medication-50",
           "weight": 50,
           "code": "MED_2"
           },
           {
           "name": "medication-60",
           "weight": 50,
           "code": "MED_3"
           }
       ]
   
3. Get medications for a specific drone: [GET] http://localhost:8080/get-medications/{serialNumber} it takes serial number as path variable.

4. Get available drones: [GET] http://localhost:8080/drones/available

5. Check battery level for a specific drone http://localhost:8080/{serialNumber}/battery-level  it takes serial number as path variable.

6. There is a periodic task to check drones battery level every 10 seconds and log it to console.

There are multiple drones are pre inserted automatically by data.sql file.

To build the project you should navigate to root of the project via command line and write the following commands

 ```shell
    mvn clean
    mvn package
    mvn spring-boot:run
