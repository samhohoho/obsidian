---
id: wildcards
aliases: []
tags: []
---
# Overview
# Upper Bounded Wildcards
- What?
    - To relax the restriction on a variable.
    - Use `? extends ...` to declare an upper-bounded wildcard.
- Notes.
    - In this context, `extends` means either `extends` or `implements`.
- Example.
    - Writing a method that works on `List<Integer>`, `List<Double`, and `List<number>`.
        - `List<? extends Number>`
        - It matches a list of type `Number` or any of its subclasses.
```java
public static void process(List<? extends Foo> list) {
    for (Foo elem : list) {
        // ...
    }
}
```
- Notes.
    - Any method defined in the `Foo` class can now be used on `elem`.
# Unbounded Wildcards
- What?
    - Unknown type.
    - Use `?`, `List<?>`.
- When?
    - Writing a method that can be implemented using functionality provided in the `Object` class.
    - When using methods in the generic class that dont depend on the type parameter.
    For example, `List.size()` or `List.clear()`.
```java
public static void printList(List<Object> list) {
    for (Object elem : list)
        System.out.println(elem + " ");
    System.out.println();
}
```
- Problem.
    - It cannot print `List<Integer>`.
    - Because it is not a subtype of `List<Object>`.
```java
public static void printList(List<?> list) {
    for (Object elem: list)
        System.out.print(elem + " ");
    System.out.println();
}

List<Integer> li = Arrays.asList(1, 2, 3);
List<String>  ls = Arrays.asList("one", "two", "three");
printList(li);
printList(ls);
```
- Solution.
    - To write a generic `printList()`, use `List<?>`.
    - Any concrete type is a subtype of `List<?>`.
# Lower Bounded Wildcards
- What?
    - Restricts the unknown type to be a specific type or a super type of that type.
    - `<? super A>`
- Example.
    - A method that works on lists of `Integer` and the supertypes of `Integer`, such as `Number`, and `Object`.
```java
public static void addNumbers(List<? super Integer> list) {
    for (int i = 1; i <= 10; i++) {
        list.add(i);
    }
}
```
