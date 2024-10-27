---
id: synchronization
aliases: []
tags:
  - java
---

- [ ]
https://medium.com/@AlexanderObregon/concurrent-programming-in-java-simplifying-complex-tasks-d7adab6d25c6

https://docs.oracle.com/javase/specs/jls/se21/html/jls-17.html

# Synchronization
Implemented using `monitors`.
Each object is associated with a `monitor`.
A thread can lock or unlock the monitor.
Only one thread at a time may hold a lock.
A thread may lock a monitor multiple times.
Unlocking reverses the effect of one lock operation.

- [ ] The synchronized statement

A synchronized method performs lock action when invoked.
An unlock action is performed when execution is abrupted.
