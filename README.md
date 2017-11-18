# MessagingWithRabbitMQ

1. Install Erlang.
2. Install and run RabbitMQ.
3. Clone this repository.
4. Import Maven project and run mvn package command.
5. Application is started by selecting MainClass -> Run As -> Java Application.
6. Test the application locally by using links http://localhost:8080/mrpiglet-rabbitmq/produceNumber 
or http://localhost:8080/mrpiglet-rabbitmq/produceColor. All the sent and received messages will be printed in the console of your IDE.
7. Unit tests are in the package org.mrpiglet.test.
8. It is possible to change queue and RabbitMQ related properties in application.proeprties.
   Similarly, new queues with appropriate routing keys can be added.
