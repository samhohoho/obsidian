---
id: multithreading
aliases: []
tags: []
---

To make a new thread of execution, a new separate stack:
```jav
Thread t = new Thread();
t.start();
```

**Except for one problem**
That thread doesnt do anything.
It dies the instant its born.

So we are missing one key component--the thread's job.

Each new Java thread is not actually a separate process running on the OS,
unless you have multiple processors on computer. But it almost feel as though it is.

# Java has multiple threads but only one Thread class
A Thread is Java class that represents a thread.
Every Java application starts up a main thread--the thread that puts the `main()` method on the bottom of the stack.
JVM starts the main thread (and other threads, including the garbage collection thread).

# What does it mean to have more call stacks?
You get the *appearance* of having multiple things happen at the same time.
In reality, only a true multiprocessor system can do more than one thing at a time.
But with Java threads, excution can move back and forth between stacks so rapidly.

Java is just a process running on your underlying OS.
What does the JVM run?
Whatever is on top of the currently-running stack.

A thread must keep track of which statement (which method) is currently executing on the thread's stack.

# How to launch a new thread
**Make a Runnable object (the thread's job).**
```java
Runnable threadJob = new MyRunnable();
```
**Make a Thread object (the worker) and give it a Runnable (the job).**
```java
Thread myThread = new Thread(threadJob);
```
This tells the new Thread object which method to put on the bottom of the new stack--Runnable's run method.

**Start the thread**
```java
myThread.start();
```
Thats when you go from having just a Thread instance to having a new thread of execution. When the new thread starts up, it puts the Runnable object's run() method on the bottom of the new thread's stack. In other words, the first method that the new thread will run.

# Every Thread needs a job todo. A method to put on the new thread stack.
The job is the first method that goes on the new thread's stack.
It must look like this:
```java
public void run() {
 // code that will be run by the new thread
}
```
A thread's job can be defined in any class that implements the Runnable interface.
The thread cares only that you pass the Thread constructor an object of a class that implements Runnable.

# To make a job for thread, implement the Runnable interface
```java
public class MyRunnable implements Runnable {
    public void run() {
        go();
    }
    public void go() {
        doMore();
    }
    public void doMore() {
        // code...
    }
}
```
Runnable has only one method to implement: `public void run()`.
```java
class ThreadTester {
    public static void main (String[] args) {
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
    }
    myThread.start();
}
```
# The three states of a new thread
```
NEW (t.start()) -> RUNNABLE (selected to run) -> RUNNING
```
```java
Thread t = new Thread(r);
```
A Thread instance has been created but not started.

`t.start();`
When started, it moves into the runnable state.
Ready to run and waiting to be selected for execution.
At this point, there is new call stack for this thread.

RUNNING
In the running state, a thread (and ONLY this thread) has an active call stack, and the method on the top of the stack is executing.

# Typical runnable/running loop
Once the thread becomes runnable, it can move back and forth between runnable , running, and temporarily not-runnable.

JVM thread scheduler selects a thread to run and then kicks it back out so another thread gets a chance.

## A thread can be made temporarily not-runnable
The thread scheduler can move a running thread into a blocked state, for a variety of reasons.

For example, the thread might be executing code to read from a Socket input stream, but there isnt any data to read. The scheduler will move the thread out of the running state until something becomes available.
Or the executing code might have told the thread to sleep.
Or the thread might be waiting because it tried to call a method on an object, and that object was "locked".

All of those conditions cause a thread to become temporarily not-runnable.

# The Thread Scheduler
The thread schedulare makes all the decisions about who moves from runnable to running, and vice versa.
It also decides for how long the thread runs.

You cant control the scheduler.
There are no guarantees about scheduling.
The scheduler implementations are different for different JVM's.

The secret to 
