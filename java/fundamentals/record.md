---
id: record
aliases: []
tags: []
---
https://dev.java/learn/records/
## Overview
```java
public record Point(int x, int y) {}
```
- Features.
    - Simplify the creation of immutable aggregates of data.
    - The compiler generates one *accessor* for each component.
    - The compiler creates a canonical constructor, to initialize the fields.
        - Situation to override this default behavior:
            1. You need to validate the state of your record.
            2. To make a defensive copy if a mutable component.
    - `toString()`, `equals()`, `hashCode()` methods are created by the compiler with a default behavior.
    - Implements the [[serializable|Serializable]] interface.
    - Everytime you modify the components of a record, the compiler automatically updates the `equals()` and `hashCode()` methods.
- Notes.
    - A record can implement any number of interfaces.
    - You may define your own accessor methods.
    - You may defined your own overrides of `toString()`, `equals()`, `hashCode()` methods.
    - You can create static fields with initializers and static initializers.
- Restrictions.
    - Cannot add any instance field.
    - Cannot add any instance initializer.
    - Cannot define any field initializer.
## Compact constructor
- Features.
    - To redefine the canonical constructor.
- Restrictions.
    - You cannot directly assign the record's fields. For example, `this.start = start`. That is done by the compiler.
```java
public record Range(int start, int end) {
    public Range {
        if (end <= start) {
            throw new IllegalArgumentException("End cannot be lesser than start");
        }
    }
}
```
## Using the canonical constructor
- Why?
    - You prefer not to reassign parameters.
- Notes.
    - In this case, you need to assign values to the fields.
    - If the components are not immutable, consider making defensive copies in both canonical constructor and the accessors.
```java
public record Range(int start, int end) {

    public Range(int start, int end) {
        if (end <= start) {
            throw new IllegalArgumentException("End cannot be lesser than start");
        }
        if (start < 0) {
            this.start = 0;
        } else {
            this.start = start;
        }
        if (end > 100) {
            this.end = 10;
        } else {
            this.end = end;
        }
    }
}
```
## Defining any constructor
- Restrictions.
    - The constructor must call the canonical constructor.
    `this` must be the first statement of your constructor.
