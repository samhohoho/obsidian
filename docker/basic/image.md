---
id: image
aliases: []
tags: []
---

https://docs.docker.com/get-started/docker-concepts/the-basics/what-is-an-image/
https://docs.docker.com/build/concepts/dockerfile/#docker-images

**Container image** is a package that include all the files, binaries, libraries and configurations to run a [[container]].

For a PostgreSQL image, it will package the database binaries, config files, and other dependencies.
Just like how PostgreSQL is being installed on local machine. It comes with all the dependencies.
- Images are immutable.
- Images are composed of layers. A filesystem changes that provide image functionality.

**Docker Hub** is the default global marketplace for storing and distributing images.

Search for images
```bash
docker search docker/welcome-to-docker
```

Pull images
In output, each line represents a different layer of the image.
```bash
docker pull docker/welcome-to-docker
```

List downloaded images
```bash
docker image ls
```
```bash
docker images
```

List image's layers
```bash
docker image history docker/welcome-to-docker
```
