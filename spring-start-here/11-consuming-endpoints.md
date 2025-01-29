---
id: 11-consuming-endpoints
aliases: []
tags: []
---
# Overview
- The client of a web app can call the backend, and so can another backend component.
- A REST endpoint is a way to implement communication between two apps.
- Often, a backend app needs to act as a client for another backend app, and calls exposed
REST endpoints to work with specific data.
- 3 ways to call REST endpoints from a Spring app:
    - OpenFeign
    - RestTemplate
    - WebClient
# Calling REST endpoints using Spring Cloud OpenFeign
- Define an interface (contract) methods that consume REST endpoints.
    - Implemented by Spring/OpenFeign and provides the implementation as a bean.
- Annotate these methods to define the path, HTTP method, parameters, headers, request body.
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```
- OpenFeign terminology, proxy interface = OpenFeign client.
## Declaring an OpenFeign client interface
```java
@FeignClient(name = "payments", // Configure the REST client
            url = "${name.service.url}")
public interface PaymentsProxy {

    @PostMapping("/payment")
    Payment createPayment(
        @RequestHeader String requestId,
        @RequestBody Payment payment);
}
```
- `@FeignClient` tells OpenFeign to provide implementation for this contract.
- `name` attribute to name the proxy.
    - Used by OpenFeign internally.
    - Uniquely identifies the client.
- `url` attribute to define the base URI.
    - Always store URIs in the properties files and never hardcode.
    - Use `${property_name}` to refer a property in "application.properties".
- Each method in the interface represents a REST endpoint call.
## Enabling the OpenFeign clients in the configuration class
- OpenFeign needs to know where to find the interfaces defining the client contracts.
- `@EnableFeignClients` tell OpenFeign where to search for the client contracts.
```java
@Configuration
@EnableFeignClients(
    basePackages = "com.example.proxy")
public class ProjectConfig {
}
```
## Injecting and using the OpenFeign client
```java
@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(
        @RequestBody Payment payment
        ) {
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);
    }
}
```
```bash
curl -X POST -H 'content-type:application/json' -d '{"amount":1000}'
➥ http://localhost:9090/payment

{"id":"1c518ead-2477-410f-82f3-54533b4058ff","amount":1000.0}
```
