[redhat - What does an API gateway do?](https://www.redhat.com/en/topics/api/what-does-an-api-gateway-do)

[[api monetization|Monetized APIs]], 

A software application that **intercepts** API calls and routes them to backend services.
Most enterprise APIs are deployed via API gateways.
A way to **decouple** the client interface from your backend implementation.
When a client makes a request, the API gateway **breaks it into multiple requests**, routes them to the right places, produces a response, and keeps track of everything.
## Why
1. Rate limiting.
2. Analytics and monitoring.
3. Monetized APIs.
4. Adopted a [microservices](https://www.redhat.com/en/topics/microservices/what-are-microservices) architecture.
   A single request could require calls to dozens of distinct applications.
5. 