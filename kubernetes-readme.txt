For creating kubernetes cluster, this project uses minikube (this is not recommended for production use)
Minikube can be used only for debugging purposes and for local development

Reference url - https://learnk8s.io/spring-boot-kubernetes-guide

1. Install 'kubectl' (kubernetes client) from the official documentation page
2. Install Minikube from their official page according to your local machine platform
3. For creating kubernetes cluster - we should dockerise the application first. See 'docker-readme.txt' associated with this project
4. Once the application is dockerised, we need to upload/push the application docker image to docker hub
  4.1 For that, execute the terminal command 'docker login'
  4.2 For 'docker push' to work, we should tag the application by <docker-id>/<docker-image-name>
      Here, we are creating the docker image with name jukebox:<version-number>
      So we can push the image to docker hub by the command
      'docker push <your-docker-id>/jukebox:v1'
5. Once the image is uploaded to docker hub, create the deployment yaml files in k8 folder
   See jukebox-deployment.yaml and mysql.yaml in k8 folder
6. we can deploy the application to cluster using the command
   'kubectl apply -f k8' - This will deploy everything in the k8 folder
7. We can see the kubernetes dashboard using the command
   'minikube dashboard'
8. We can see log of an individual Pod by the commands
   'kubectl get pods' - will fetch id's of all pods
   'kubectl log <pod-id>' -  will show the log of an individual pod
9. To get the url of an application deployed in kubernetes, we can use the command
    'minikube service <service-name> --url'
    Here : 'minikube service jukebox --url'
10. we can easily scale up the application by the command
    'kubectl scale --replicas=2 deployment/<application-name>'
    Here : kubectl scale --replicas=2 deployment/jukebox
