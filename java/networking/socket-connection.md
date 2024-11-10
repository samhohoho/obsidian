---
id: socket-connection
aliases: []
tags: []
---

To connect to another machine, we need a Socket connection.

To make a Socket connection, you need to know two things about the server:
who it is, and which port its running on.
In other words, IP address and TCP port number.
```java
Socket chatSocket = new Socket(“196.164.1.103”, 5000);
```
A Socket connection means the two machines have information about each other, including location (IP address) and TCP port.
# To read data from a Socket, use a `BufferedReader`
To communicate over a Socket connection, you use streams.
I/O wont care what high-level chain stream is connected to.
In other words, you can use `BufferedReader` just like when writing to a file.
Reader doesnt know or care where the characters came from.
The difference is the underlying connection stream is connected to a Socket rathar than a File.
```java
InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream());
BufferedReader reader = new BufferedReader(stream);
String message = reader.readLine();
```
`InputStreamReader` is a "bridge" between a low-level byte stream (from Socket) and a high-level character stream (like `BufferedReader` we are after as top of the chain stream).

`chatSocket.getInputStream()`:
We ask the socket for an input stream.
Its a low-level connection stream,
we chain it to something more text-friendly.

`new BufferedReader(stream)`:
Chain the `BufferedReader` to the `InputStreamReader`, which was chained to low-level connection stream from the Socket.
```
Client <- BufferedReader <- InputStreamReader <- Socket's input stream <- Server
```
Socket's input stream: bytes from server.
`InputStreamReader`: convert to characters.
`BufferedReader`: buffered characters.
# To write data to a Socket, use a PrintWriter
When writing one String at a time, PrintWriter is the standard choice.
```java
PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
```
`PrintWriter` acts as bridge between character data and the bytes from the Socket's low-level output stream. By chaining PrintWriter to the Socket's output stream, we can swite to the Socket connection.
```
Client -> PrintWriter -> Socket's output stream -> Server
```
PrintWriter: characters (message).
Socket's output stream: bytes to server.
