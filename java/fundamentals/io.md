---
id: io
aliases: []
tags: []
---
# Overview
- Notes
    - Java Database Connectivity API use the Java I/O API to access databases through TCP/IP.
    - Defines 2 types of content for a resource:
        - Character content, text file.
        - Byte content, image/video.

|                      | Reading       | Writing        |
| -------------------- | ------------- | -------------- |
| Streams of character | `Reader`      | `Writer`       |
| Streams of bytes     | `InputStream` | `OutputStream` |
## Accessing a file
- How?
    - Open a stream to a resource.
    - Use `File` class (legacy) or `Path` interface.
- Notes.
    - `File` cons: https://dev.java/learn/java-io/intro/#file
# I/O streams
- What?
    - Represents an input source or an output destination.
    - A stream is a sequence of data.
    - Input stream: Read data from a source, one item at a time.
    - Output stream: Write data to a destination, one item at a time.
# Path interface
- What?
    - One of the primary entrypoint of the `java.nio.file` package.
- Notes.
    - A `Path` instance reflects the underlying platform.
        - In Solaris OS (/home/hosam/foo).
        - Windows (C:\home\joe\foo).
- Links.
    - [Retrieving Information about a Path](https://dev.java/learn/java-io/file-system/path/#getting-info)
    - [Converting a Path](https://dev.java/learn/java-io/file-system/path/#getting-info)
    - [Comparing Two Paths](https://dev.java/learn/java-io/file-system/path/#joining)
# Reading/Writing
## `BufferedReader`
- What?
    - Wraps another `Reader` and uses a buffer (a temporary memory space) to read chunks of characters at once instead of one character at a time.
- Without `BufferedReader`
    - **Direct reads are costly**
        - `Reader`'s `read()` results in a direct result to the underlying data source (like file or input stream).
        - `FileReader` or `InputStreamReader` processes data one character at a time by default.
        - Each invocation of `read()` or `readLine()` could cause bytes to be read from the file, converted into characters, and then returned, which can be very inefficient.
- Links
    - https://download.java.net/java/early_access/valhalla/docs/api/java.base/java/io/BufferedReader.html
## Catching exception
- How?
    - Use *try-with-resources* statement.
    - *try-with-resources* has the advantage.
        - Compiler automatically generates the code to close the resources when no longer required.
