---
id: container
aliases: []
tags: []
---

https://docs.docker.com/get-started/docker-concepts/the-basics/what-is-a-container/

- [ ] https://docs.docker.com/engine/containers/run/
- [ ] https://www.docker.com/resources/what-container/

**Container image** is a single package that contains everything needed to run a process. Like, Node environment.

**Containers** are isolated processes for each of the app's components (FE, BE, and DB). It runs in its own isolated environment, isolated from everything else on your machine.
To ensure the version of Python (or Node or the db) is not affected by local machine.
Basically an isolated filesystem. (created by `/bin/bash`)
- Each container has everything it needs.
- Minimal influence on the host, increasing security.
- Independent.
- Portable.

**Dockerfile** is a script that provides the instruction for building the image.

**Containers vs virtual machines (VMs)**
VM is an entire OS with its own kernel, hardware drivers, programs, and applications.
Containers share the same kernel.

Build the project.
```bash
docker build -t <DOCKER_USERNAME>/getting-started-todo-app .
```

To verify local image.
```bash
docker image ls
```

To push the image.
```bash
docker push <DOCKER_USERNAME>/getting-started-todo-app
```

Run a container.
```bash
docker run -d -p 8080:80 docker/welcome-to-docker
```

View running containers.
```bash
docker ps
```

View all stopped containers.
```bash
docker ps -a
```

Stop container.
No need full ID.
```bash
docker stop <the-container-id>
```
