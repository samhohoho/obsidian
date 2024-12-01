---
id: spring-security
aliases: []
tags: []
---
[servlet-container](java-spring/servlet-application/servlet-container.md)
# Overview
- What?
    - Springboot security is a broader framework provided by Spring security.
    - Can be used to secure various type of app, including REST APIs.
- Features:
    - Authentication and authorization.
        - Implementing security policies, user roles, and permissions.
    - Security context management.
        - Managing security contexts, sessions, and remembering users.
    - Protection against attacks.
        - Built-in protection against common security threats like:
            - CSRF (Cross-Site Request Forgery).
            - XSS (Cross-Site Scripting).
            - session fixation.
# Querying
```bash
./mvnw spring-boot:run
```
```bash
curl -i -u user:password http://localhost:8080/
```
# FilterChain
- What?
    - Created and managed by the Servlet container.
- Notes.
    - `Filter` only impacts downstream `Filter`.
    - The order in which each `Filter` is invoked is important.
- How it works?
    - The container creates a `FilterChain`.
        - Contains the `Filter` instances and `Servlet`.
- Features.
    - Orchestrates the execution of multiple filters.
    - Move the request through the filter pipeline.
    - Modify the `HttpServletRequest` & `HttpServletResponse` used by downstream `Filter` and `Servlet`.
    - Validating user credentials, checking roles, and more.
# DelegatingFilterProxy
- What?
    - A `Filter` implementation provided by Spring.
- Why?
    - 
- Functions.
    - Allows bridging between **Servlet container** and **Spring's `ApplicationContext`**.
