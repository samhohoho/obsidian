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
```java
List<String> strings = List.of("one", "two", "three", "four");
Function<String, Integer> toLength = String::length;
Stream<Integer> ints = strings.stream()
                              .map(toLength);
```
## Mapping a Stream to another Stream
- What?
    - The `map()` method, which takes `Function` as an argument.
## Filtering a stream
- What?
    - Discarding some elements with a predicate.
## Flatmapping a stream
```java
public class City {
    private String name;
    private int population;
}

public class State {
    private String name;
    private List<City> cities;
}

List<State> states = ...;
int totalPopulation = 
        states.stream()
              .flatMap(state -> state.getCities().stream())
              .mapToInt(City::getPopulation)
              .sum();
```
- Notes.
    - The first step consists of the mapping of all the elements of the stream.
    From `Stream<State>` to `Stream<Stream<City>>`, because every state is mapped to a stream of cities.
    - The second step consists of flattening the stream of streams.
    Instead of having stream of streams of cities, you end up with a single stream, with all the cities.
