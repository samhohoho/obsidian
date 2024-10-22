https://stackoverflow.com/a/40801034

```java
if (os.isPresent()) {
    System.out.println(os.get().toUpperCase());
}
```
```java
if (s != null) {
    System.out.println(s.toUpperCase());
}
```
The real advantage of using Optional:
```java
someFunc().map(String::toUpperCase)
          .ifPresent(System.out::println);
```