---
id: simple-server
aliases: []
tags: []
---

# Writing a simple server
What does it take to write a server application?
A ServerSocket: which waits for client requests (when client makes new Socket()).
A plain old Socket to use for communication with the client.
## How it works
1. Server application makes a ServerSocket on a specific port.
This starts the server application listening for client requests coming in for port 4242.
```java
ServerSocket serverSock = new ServerSocket(4242);
```
2. Client makes a Socket connection.
```java
Socket sock = new Socket("190.165.1.103", 4242);
```
3. Server makes new Socket to communicate with this client.
```java
Socket sock = serverSock.accept();
```
TODO
