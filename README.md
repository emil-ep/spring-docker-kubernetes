# Jukebox

## Application setup

We have provided 3 ways to run this application
- Using Docker
- Using Kubernetes
- Local Deployment

### 1. Using Docker

This application has been tested on `Docker version 20.10.5, build 55c4c88` <br />
Please install the appropriate version of Docker from [Docker Documentation](https://docs.docker.com/engine/install/) <br />
Make sure the `Dockerfile` is available in the root path of the project. The contents of the `Dockerfile` is as follows
```
FROM arm64v8/openjdk:8
RUN mkdir /app
RUN cd /app
COPY target/jukebox-0.0.1-SNAPSHOT.jar /app/jukebox.jar
COPY config/production.properties /app/application.properties
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "jukebox.jar", "--spring.config.location=application.properties"]
```

Here we are using a Base image of `arm64v8/openjdk:8` which is suitable for a M1 Macbook Pro. It is recommended to use the base image which correctly suits your machine platform. You can check if the openJdk base image is supported for your machine architecture by following this [link](https://hub.docker.com/_/openjdk) .<br />
If you are using a non compatible version of the image, then its likely to show an error message<br />
> The requested platform doesn't support the host platform

Once this is done, you can follow the steps mentioned in the file `docker-readme.txt` which is attached with this project. The documentation provides a clear cut of how to deploy and start the container using docker.

### 2. Using Kubernetes

For deploying this application using Kubernetes, we are using a localised setup called `Minikube`. This is not recommended for a production deployment and is only used for local testing and development.<br />
1. Install `kubectl` which is a kubernetes resource client from their downloads [page](https://kubernetes.io/docs/tasks/tools/)
2. Install `Minikube` from their official [page](https://minikube.sigs.k8s.io/docs/start/)
3. Make sure you have already followed the instruction in `docker-readme.txt` and created docker image of the application locally
4. Follow the instructions in the file `kubernetes-readme.txt` included in this project.
5. The instructions provided in the txt file will guide you in deploying the application into a minikube kubernetes cluster
6. In a production environment, you can try using kubectl directly in deploying applications

#### References
I've followed the below tutorials and documentations in deploying this application using kubernetes
- [learnk8- springboot kubernetes deployment](https://learnk8s.io/spring-boot-kubernetes-guide)
- [kubectl - kubernetes cli resource documentation](https://kubernetes.io/docs/reference/kubectl/overview/)
- [minikube documentation](https://minikube.sigs.k8s.io/docs/start/)

### 3. Local Deployment
* Install mysql in local machine
* Login to mysql server
* create a database named "jukebox" - CREATE DATABASE jukebox
* Create a jar build of the application using the maven command - mvn clean install
* Run the application using the command : java -jar path/to/jar/build
* By default the application runs on the port 8089


### API documentation 

You can access the API documentation by using Swagger doc
- Docker deployment - [swagger-doc](http://localhost:8080/swagger-ui.html)
- kubernetes deployment - generate minikube url by using "minikube service jukebox --url", then use <url>/swagger-ui.html
- Local deployment - [swagger-doc](http://localhost:8080/swagger-ui.html)
