---
id: stream-api
aliases: []
tags: []
---
# Overview
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
- Why?
    - Once the stream is consumed, cant reuse again.
    - When u work with large dataset, its better to close it after using.
        - To prevent data leakage.
        - '' unused resources.
- Best practices.
    - Storing streams in fields or local variables can be dangerous because you cant be sure that the stream has not been already operated upon.
    - A stream should be created and consumed on the spot.
    - The source should not be modified.
```java
public static void main(String[] args) {
    List<Integer> nums = Array.asList(4,5,6,7,1);
    Stream<Integer> data = nums.stream();

    data.forEach(n -> System.out.println(n));
    data.forEach(n -> System.out.println(n)); // Exception in thread. Stream has already been operated upon or closed.
}
```
```java
public static void main(String[] args) {
    List<Integer> nums = Array.asList(4,5,6,7,1);
    Stream<Integer> data = nums.stream();

    long count = data.count();
    data.forEach(n -> System.out.println(n)); // Exception in thread. Stream has already been operated upon or closed.
}
```
- Links
    - https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
    - https://stackoverflow.com/questions/47688418/what-is-the-difference-between-intermediate-and-terminal-operations
    - https://www.youtube.com/watch?v=tklkyVa7KZo
# Example
```java
Predicate<Integer> predicate = n -> n % 2 == 1;
nums.stream()
        .filter(predicate)
        .sorted()
        .map(n -> n*2)
        .reduce(0, (c, e) -> c + e);
```
# Map-Filter-Reduce Algorithm
## Mapping
## Filtering out objects
## Reducing
- What
    - Similar to SQL aggregation.
        - COUNT, SUM, MIN, MAX, AVERAGE.
    - To build complex structures.
        - Including lists, sets, maps.
# Why stream?
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
## Specialized streams of numbers
- 3 specilized interfaces to handle streams of numbers:
    - `IntStream`
    - `LongStream`
    - `DoubleStream`
- Special terminal operations.
    - `sum()`
    - `min()`, `max()`
    - `average()`
    - `summaryStatistics()`
# Adding intermediate operation on a stream
```java
List<String> strings = List.of("one", "two", "three", "four");
Function<String, Integer> toLength = String::length;
Stream<Integer> ints = strings.stream()
                              .map(toLength);
```
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
## Using Flatmap and MapMulti to validate elements transformation
```java
Function<String, Stream<Integer>> flatParser = s -> {
    try {
        return Stream.of(Integer.parseInt(s));
    } catch (NumberFormatException e) {
    }
    return Stream.empty();
};

List<String> strings = List.of("1", " ", "2", "3 ", "", "3");
List<Integer> ints = 
    strings.stream()
           .flatMap(flatParser)
           .collect(Collectors.toList());
System.out.println("ints = " + ints);
```
- Example
    - Remove buggy strings: empty, null, or blank characters.
- Problems.
    - It has an overhead.
        - `Stream.of()`
            - Stream creation for every element.
            - Can become costly for large input collections.
        - `Stream.empty()`
            - Adds extra overhead for each invalid string.
        - Exception handling.
            - Exceptions are expensive in terms of performance, if thrown frequently.
