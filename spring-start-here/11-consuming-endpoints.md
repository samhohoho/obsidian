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
