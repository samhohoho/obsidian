---
id: docker-compose
aliases: []
tags: []
---

https://docs.docker.com/get-started/docker-concepts/the-basics/what-is-docker-compose/

One best practice is that each container should do one thing and connect them all together.

With **Docker Compose**, define all containers and configurations in a single YAML file.
If any changes, run `docker compose up` again.

**Dorkerfile vs Compose file**
Dorkerfile provides container image build instructions.
Compose file defines running containers.
Compose file references a Dockerfile to build an image.

Start the application.
```bash
docker compose up -d --build
```

What happened during `compose up`?
- Download container images.
- Create network for application.
- Create volume to persist the database files between container restarts.
- Start containers with their config.

Remove everything.
```bash
docker compose down
```

By default, volumes aren't automatically removed.
Because you might want your data back.
```bash
docker compose down --volumes
```
