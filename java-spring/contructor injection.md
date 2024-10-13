https://www.baeldung.com/spring-injection-lombok

## Contructor-based DI
Explicitly pass component's dependencies to a contructor.
However, due to the need of writing a contructor, it could lead to larger code base.
## Contructor injection with Lombok
The annotation: 
`@AllArgsContructor` (all class's fields),
`@RequiredArgsConstructor` (all final class's fields),
`@NoArgsConstructor` (empty constructor)
will cause `Lombok` to generate a constructor.

## Multiple constructors