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

The secret to almost everything is *sleep*.
Putting a thread to sleep, forces the currently-running thread to leave the running state,
giving another thread a chance to run.

# Putting a thread to sleep
```java
Thread.sleep(2000);
```
Calling sleep will force the new thread to leave the currently-running state.
The thread cant become the running thread again until after at least 2 seconds have passed.
The sleep method throws an InterruptedException.
```java
try {
    Thread.sleep(2000);
} catch (InterruptedException ex) {
    ex.printStackTrace();
}
```
When the thread wakes up, it always goes back to the runnable state.

# Using sleep to make our program more predictable
Sometims main had to wait until the new thread finished.

# Making and starting two threads
Threads have names. You can give your threads a name or accept there default names.
By setting the name, you can tell which thread is running.
```java
public class RunThreads implements Runnable {
    public static void main(String[] args) {
        RunThreads runner = new RunThreads(); // Make one Runnable instance
        Thread alpha = new Thread(runner);
        Thread beta = new Thread(runner);
        alpha.setName("Alpha thread");
        beta.setName("Beta thread");
        alpha.start();
        beta.start();
    }
    public void run() {
        for (int i = 0; i < 25; i++) {
            String threadName = Thread.currectThread().getName();
            System.out.println(threadName + " is running");
        }
    }
}
```

# Threads can lead to concurrency issues
It all comes down to one potentially deadly scenario:
two or more threads have access to a single object's data.
In other words, methods excuting on two different stacks are both calling, getters or setters on a single object on the heap.

# We need the makeWithdrawal() method to run as one atomic thing.
We need to make sure that once a thread enters the makeWithdrawal() method, it must be allowed to finish the method before any other thread can enter.

**Use the `synchronized` to modify a method so that only one thread at a time can access it.**

You dont put a lock on the bank account itself; you lock the method that does the banking transaction, start to finish, even if that thread falls asleep in the middle of the method.
```java
private synchronized void makeWithdrawal(int amount) {
    if (account.getBalance() >= amount) {
        try {
            Thread.sleep(500);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        account.withdraw(amount);
    } else {}
}
```

# Using an object's lock
**Every object has a lock.** Object locks come into play only when there are synchronized methods.
When an object has one or more synchronized methods, a thread can enter a synchronized method **only if the thread can get the key to the object's lock**.

The locks are per object, not method.
If an object has two synchronized methods, it means you cant have two threads entering any of the synchronized methods.

Think about it. If you have multiple methods that can act on an object's instance variables, all those methods need to be protected with synchronized.

Remember, you dont lock the data itself, you synchronize the methods that access that data.

## When a thread hits a synchronized method
What happens when a thread is cranking through its call stack (starting with the run() method) and suddenly hits a synchronized method? The thread recognizes that it needs a key for that object before it can enter the method.

While that thread is holding the key, no other threads can enter any of that object's synchronized methods.
Because the one key for that object wont be available.

# The dreaded "Lost Update" problem
Each thread runs 50 times, incrementing the balance on each iteration.
Thread A updated it to 5, but now B came back and stepped on top of the update A made.

# Make the increment() method atomic. Synchronize it.
Synchronizing the method solves the "Lost Update" problem, because it keeps the two steps as on unbreakable unit.
```java
public synchronized void increment() {
    int i = balance;
    balance = i + 1;
}
```

# The deadly side of synchronization
Thread deadlock happens two threads are holding a key the other thread wants.
There is no way out of this scenario, so the two threads will sit and wait and wait ...

Databases often have a locking mechanism somewhat like synchronization.
But a real transaction management system can sometimes deal with deadlock.
For example, that deadlock might have occurred when two transactions are taking too long to complete.
But unlike Java, the application server can do a "transaction rollback" that returns the state to where it was before.

# FAQ
**Can you reuse a Thread object? Can you give it a new job to do and restart it?**
No. Once a thread's run() has completed, it moves into a **dead** state.
But, there are design patterns for making a pool of threads that you can keep using to perform different task.

**Sounds like a good idea to synchronize everything, just to be thread-safe**
Nope. A synchronized method has a certain amount of overhead.
When code hits a synchronized method, there will be a performance hit while the matter of "is the key available?" is resolved.

Second, synchronization restricts concurrency.
A synchronized method forces other threads to get in line and wait their turn,

Third, deadlock.

A good rule of thumb is to synchronize only the bare minimum.
