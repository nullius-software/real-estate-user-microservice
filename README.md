# Real Estate User Microservice - Setup Guide

Welcome to the Real Estate User Microservice project. This guide provides step-by-step instructions to set up the development environment locally.

## About This Repository

The `real-estate-user-microservice` repository serves as the User Service for the Real Estate project. The User Microservice handles all user-related operations such as user registration, authentication, profile management, and more. It is built using Kotlin and SpringBoot.

## Prerequisites

- Docker: Ensure Docker is installed and running on your machine. Download from [docker.com](https://www.docker.com) if needed.
- Access to a terminal (bash, cmd, PowerShell, etc.).
- Internet connection to pull necessary images.
- Keycloak: Ensure Keycloak is running locally. The guide for configuring Keycloak locally can be found [here](https://github.com/nullius-software/real-estate-keycloak-render).
- Discovery Service: Ensure the discovery service is running locally. The guide for setting up the discovery service can be found [here](https://github.com/nullius-software/real-estate-discovery-service).

## Step 1: Clone the Repository

First, clone the `real-estate-user-microservice` repository to your local machine:

```bash
git clone https://github.com/nullius-software/real-estate-user-microservice.git
cd real-estate-user-microservice
```

## Step 2: Build the Docker Image

Build the Docker image for the User Microservice:

```bash
docker build -t real-estate-user-microservice .
```

## Step 3: Run the Docker Container

Run the Docker container for the User Microservice:

```bash
docker run -p 8081:8081 real-estate-user-microservice
```

### Explanation:

- `-p 8081:8081`: Maps port 8081 from the container to your local machine.

Wait for the container to start. You’ll see logs indicating the User Microservice is ready when something like this appears:

```
Started UserMicroserviceApplication in X.XXX seconds
```

## Step 4: Access the User Microservice

Open your browser and go to: [http://localhost:8081](http://localhost:8081).

You should see the User Microservice indicating that it is running.

## Step 5: Verify the Configuration

Ensure that the other microservices in the Real Estate project are configured to communicate with the User Microservice by checking their configuration files. They should have the User Microservice URL set to `http://localhost:8081`.
