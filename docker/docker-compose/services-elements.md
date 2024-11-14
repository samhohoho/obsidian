---
id: services-elements
aliases: []
tags: []
---

```yml
services:
  frontend:
    image: example/webapp
    build: ./webapp

  backend:
    image: example/database
    build:
      context: backend
      dockerfile: ../backend.Dockerfile

  custom:
    build: ~/custom
```
# Build
[Specification](https://docs.docker.com/reference/compose-file/build/)
