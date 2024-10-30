---
id: image-layer
aliases: []
tags: []
---

https://docs.docker.com/get-started/docker-concepts/building-images/understanding-image-layers/

Basically, it is a set of instructions that detail how to setup the environment,
just like a recipe for installing Python and its dependencies on local machine.

For example, to specify instruction in the `Dockerfile`,
- Install the package manager, like `apt`.
- Next layer could be the installation of Python.
- Then installing libraries or tools that Python needs.

TODO
create the filesystem a container can use.
