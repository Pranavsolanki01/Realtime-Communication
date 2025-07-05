# 👋 Hello Application

A cloud-native microservices application built using Spring Boot, Apache Kafka, MySQL, Docker, and Kubernetes. This project demonstrates the fundamentals of distributed systems using event-driven architecture, REST APIs, and modern container orchestration.

---

## 📌 Project Overview

The **Hello Application** is a microservices-based system that includes:

- **Producer Service** – Publishes messages to Kafka.
- **Consumer Service** – Consumes messages from Kafka and writes to MySQL.
- **Hello Service** – Serves simple REST-based greetings.
- **API Gateway** – Exposes a unified entry point for routing client requests to internal services.

All services are containerized and managed with Docker Compose and Kubernetes for scalable deployment.

---

## 🧱 Architecture

### Components:

- **Microservices**: Spring Boot services (producer, consumer, hello-service)
- **Event Broker**: Kafka (Confluent Platform)
- **Database**: MySQL
- **Gateway**: Spring Cloud Gateway

```+------------------------+
                          |      API Gateway       |
                          |    (Spring Cloud)      |
                          +-----------+------------+
                                      |
        +-----------------------------+-----------------------------+
        |                             |                             |
        v                             v                             v
  +-------------+             +---------------+               +-------------+
  | Hello       |             | Producer      |               |   Kafka     |
  | Service     |             | Service       |-------------->| (Broker)    |
  +-------------+             +---------------+               +-------------+
                                                                   |
                                                                   v
                                                           +---------------+
                                                           |  Consumer     |
                                                           |  Service      |
                                                           | (writes to DB)|
                                                           +-------+-------+
                                                                   |
                                                                   v
                                                           +---------------+
                                                           |    MySQL      |
                                                           |   hello_db    |
                                                           +---------------+

```
