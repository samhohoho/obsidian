---
id: interface
aliases: []
tags: []
---

A Java interface solves your multiple inheritance problem.
The solution is to make all the methods abstract.
That way, the subclass must implement the methods.
(Abstract methods must be implemented by the first concrete subclass)

**A Java interface is like a 100% pure abstract class.**

Methods are implicitly public and abstract.

Not putting implementation turns out to be good design.
Because most interface methods would need to be overriden,
and wouldnt make sense if implemented in a generic way.

**Q: What does it have to do with polymorphism?**
