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

## 📂 Folder Structure

```
      hello-app/
      │
      ├── producer-service/
      │   ├── src/...
      │   ├── Dockerfile
      │
      ├── consumer-service/
      │   ├── src/...
      │   ├── Dockerfile
      │
      ├── hello-service/
      │   ├── src/...
      │   ├── Dockerfile
      │
      ├── api-gateway/
      │   ├── src/...
      │   ├── Dockerfile
      │
      ├── docker/
      │   ├── docker-compose.yml (Kafka + MySQL)
      │
      └── k8s/
            ├── producer-deployment.yml
            ├── consumer-deployment.yml
            ├── mysql-deployment.yml
            ├── kafka-deployment.yml
            ├── gateway-ingress.yml

```

## 🧱 Architecture

### Components:

- **Microservices**: Spring Boot services (producer, consumer, hello-service)
- **Event Broker**: Kafka (Confluent Platform)
- **Database**: MySQL
- **Gateway**: Spring Cloud Gateway

```
                          +------------------------+
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
        |                                                          |
        |                                                          v
        |                                                  +---------------+
        |                                                  |  Consumer     |
        +----------------------------------------------->  |  Service      |
                                                           | (writes to DB)|
                                                           +-------+-------+
                                                                   |
                                                                   v
                                                           +---------------+
                                                           |    MySQL      |
                                                           |   hello_db    |
                                                           +---------------+

```

---

## 🐳 Docker Setup

### 📁 Prerequisites

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

### ⚙️ Steps to Run

1. Open your terminal and navigate to the Docker setup folder:

   ```bash
   cd docker
   ```

2. Build and start all containers:

   ```bash
   docker compose up --build -d
   ```
####  Steps to Run Locally (Outside of the Docker)


### 🌐 Services will be available on:

- **API Gateway**: `http://localhost:8080`
- **Producer Service**: `http://localhost:8081`
- **Consumer Service**: `http://localhost:8082`
- **Hello Service**: `http://localhost:8083`
- **Kafka Broker**: `localhost:9092`
- **MySQL Database**: `localhost:3307` (mapped to container's port `3306`)

## ☸️ Kubernetes Setup

All Kubernetes manifests are in the `k8s/` directory.

### 📂 Kubernetes Files

```
      k8s/
      ├── producer-deployment.yml
      ├── consumer-deployment.yml
      ├── hello-deployment.yml
      ├── kafka-deployment.yml
      ├── mysql-deployment.yml
      └── gateway-ingress.yml
```

### ⚙️ Steps to Deploy

1. **Ensure your Kubernetes cluster is running**  
   You can use tools like Docker Desktop (with Kubernetes enabled) or Minikube.

2. **Apply all the Kubernetes manifests**  
   Run the following command from the project root:

   ```bash
   kubectl apply -f k8s/

   ```

3. **Verify the resources are up and running**

   ```bash
   kubectl get pods
   kubectl get svc
   ```

4. **If using an Ingress Controller (like NGINX), make sure it's installed and running**
   The gateway will be exposed via the gateway-ingress.yml.

## 📦 Technologies Used

- **Java 21, Spring Boot**
- **Apache Kafka**
- **MySQL**
- **Docker & Docker Compose**
- **Kubernetes**
- **Spring Cloud Gateway**

## 👨‍💻 Author

- **Pranav Singh Solanki**

##### Feel free to open issues or contribute to the project!
