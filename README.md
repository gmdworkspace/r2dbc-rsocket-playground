# r2dbc-rsocket-playground

Hola! this project holds a setup for creating a full stack application using R2DBC driver(for MSSQL) with RSocket protocol communication. On the frontend it's a node project with react for user interfaces.

## Why R2DBC? 
The traditional JDBC drivers are blocking in nature(synchronous) which has down sides on a highly scaled applications. R2DBC on other hand does reactive way for data communication with the databases. 

We are going to use r2dbc-mssql driver to connect to MSSQL database.
Check out more at https://r2dbc.io

## What's Rsocket?
To build a full stack application you may need backend interfaces to provide data to your frontends.
Rsocket is protocol which uses transports like TCP/HTTP-2.0/UDP/websocket for reactive communication.
Check out more at http://rsocket.io

## Local Setup

1. Run MSSQL server on your machine. Easy way is run the mssql on docker(https://hub.docker.com/r/microsoft/mssql-server-linux/)

2. Download the movies_metadata.csv and import the data into your database

3. Configure database username, password and database name on Constants.java

4. To start server do `gradle run` which will start rsocket server on port 9091.

5. Go to src/main/resources/web and do `npm i && npm run dev` to start client on port 9092

6. Now go to the browser and hit `http://localhost:9092` to see it in action.



 
