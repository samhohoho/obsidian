---
id: when-to-use
aliases: []
tags: []
---

Make a class that doesnt extend anything (other than Object) when your new class doesnt pass the IS-A test for any other type.

Make a subclass only when you need a more specific version of a class.
Or need to override or add new behaviors.

Abstract class when you want to define a template for a group of subclasses.
And you have at least some implementation code.
When you want to guarantee that nobody can make objects of that type.

Interface when you want to define a role that other classes can play, regardless of where the classes are in the inheritance tree.
