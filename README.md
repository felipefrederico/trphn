# trphn
Technical challenge coding preparation

## A service to manage a specific resource: Device.

### **Installation**

_Requirements_:  
   1. **[Docker](https://docs.docker.com)**   
   2. **[Docker-compose](https://docs.docker.com/compose/)**

After cloning this repository into a local repository, use the docker-compose at root of this repository to install all the solution.

```bash
docker-compose -f stack.yml up
```

### **Overview**
Once you had done the clone and composition of your containers, you are able to use the Device Service,
At this time you have two containers running.

1. Service Discovery 
2. Device Service

### **Usage**

#### **Endpoints**

Swagger UI through Open API's definition can be checked visiting http://localhost:8082/swagger_ui.html


### **Extra Documentation**
#### Roadmap
_Each item would be running into a separated container_ 

1. Service Discovery (done)
2. Device Service (done)
3. API Gateway (to do)
4. Auth server with Keycloak (to do)
5. Tracing with Jaeger (to do)
6. Monitoring with Prometheus (to do)
7. Config externalization (to do)