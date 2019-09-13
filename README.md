# Metallica : Trade Service

Trade Service is the main business driving service of Metallica application. This service manages the generation of new trades in to metallica ecosystem and exposes
endpoints to fetch and modify trades.
TradeSerivce microsevices uses Eureka Client to connect to Centralized Discovery Server to register it self for consumption and access other dependent services
like MarketData services.
This service also queues messages to the Message Broker informing system about the Trading Events happing.
For comunicating with other microservices , Ribbon enabled RestTemplate is used.
Message Broker used in the system is RabbitMQ.
Work in Progess Items:

Integration with Message Broker.
Integration with Database
