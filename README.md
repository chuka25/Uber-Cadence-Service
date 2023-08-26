# Uber-Cadence-Service
I made an Uber Cadence service application as Test Task on Java using Spring Framework and MySQL as DBMS
#Task
Description
Create an Uber Cadence application.

It should contain 3 services:

Activity Worker Spring Boot application.
Workflow worker application.
Workflow launcher Spring boot application.
Use docker environment with Cadence to launch it locally.

Activity worker should contain 2 simple activities.

First activity: takes weather information from any open API, for example openweathermap.org .
Second activity: takes weather info and stores it in a database. Info for storing is a time of record creation, name of city that we are storing and air temperature. You can use any DB. It can even be embedded DB.
Workflow worker should contain workflow that will take info using the first activity and store it using the second one.
Workflow launcher application launches a workflow using cadence client. We`re just call HTTP route with the name of the city we want to retrieve weather for.
You can use any libraries, any services that can be used for task completion.
