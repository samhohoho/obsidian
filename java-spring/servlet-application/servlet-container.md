---
id: servlet-container
aliases: []
tags: []
---
https://www.baeldung.com/java-servlets-containers-intro
# Servlet container
- What?
    - Basically Java programs running inside the boundaries of a container.
- Examples.
    - Apache Tomcat
    - Jetty
    - WildFly
    - GlassFish
- Features.
    - Managing Servlets.
        - Instantiates, initializes, and destroy Servlets.
        - Invokes the `service()` method to process incoming HTTP requests.
    - Handling HTTP requests and Responses.
        - Converts HTTP requests into `HttpServletRequest` and reponses into `HttpServletResponse` objects.
        - It then passes these objects to the `Servlet`'s service method.
    - Multithreading.
    - Session management.
    - Security.
    - JSP processing.
## ServletContext
- What?
    - An object created by container at startup.
- Functions.
    - To function as the container's memory.
        - Remember all the `Servlets`, filters, and listeners
## Servlet
- What?
    - A Java class operates on the server-side.
    - A core part of Java EE (Jakarta EE) for building web applications.
- Features.
    - They handle HTTP requests and generate responses.
    - Enabling dynamic content generation (e.g., HTML pages, JSON data).
- How it works?
    - Received client HTTP request.
    - Processing.
        - Querying a db.
        - Executing business logic.
    - Generates response.
- Lifecycle.
    - Intantiated by the container.
    - After initialization, `Servlet` is ready to accept incoming requests.
    - The container directs these requests for processing in `Servlet`.
    - The container tears down the `Servlet`.
- Servlet application
    - A collection of Servlets, web resources (JSP pages, static files), and configuration files deployed as a unit.
    - The application typically interacts with clients via HTTP client.
