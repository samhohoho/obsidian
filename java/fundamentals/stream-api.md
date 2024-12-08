---
id: stream-api
aliases: []
tags: []
---
# Map-Filter-Reduce Algorithm
## Mapping
## Filtering out objects
## Reducing
- What
    - Similar to SQL aggregation.
        - COUNT, SUM, MIN, MAX, AVERAGE.
    - To build complex structures.
        - Including lists, sets, maps.
# Optimizing the Map-Filter-Reduce Algorithm
```java
Collection<Integer> populations = cities.map(city -> city.getPopulation());
Collection<Integer> filteredPopulations = populations.filter(population -> population > 100_000);
int sum = filteredPopulations.sum();
```
- Problems
    - This code returns a collection.
    - Storing this intermediate collection of integers may result in a lot of overhead.
- Notes.
    - The for loop does not have this overhead.
    It directly sums up the integers in the result without storing them.
## Stream interface
- What
    - A stream is an object connected to a source.
    - A stream is an object that does not store any data.
    - It avoids creating imtermediate structures to store mapped or filtered objects.
    - Using stream is about creating pipelines of operations.
        - **Intermediate operation**: An operation that returns another stream.
        - A pipeline is a sequence of intermediate operations applied to the stream.
        - Each intermediate operation transforms/filters the stream in some way,
        producing another stream as output.
        - After an intermediate operation, the another stream is ready for the next pipeline stage.
        - **Terminal operation**: An operation to produce a result.
- Best practices.
    - Storing streams in fields or local variables can be dangerous because you cant be sure that the stream has not been already operated upon.
    - A stream should be created and consumed on the spot.
    - The source should not be modified.
- Links
    - https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
    - https://stackoverflow.com/questions/47688418/what-is-the-difference-between-intermediate-and-terminal-operations
# Adding intermediate operation on a stream
