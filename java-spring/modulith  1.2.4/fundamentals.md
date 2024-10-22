## Resources
[Spring Modulith](https://docs.spring.io/spring-modulith/reference/index.html)
https://github.com/spring-projects/spring-modulith/discussions/500

https://www.reddit.com/r/SpringBoot/comments/1dpgskc/migrating_to_spring_modulith_is_advisible/
## Sample repo:
[spring-modulith-with-ddd](https://github.com/xsreality/spring-modulith-with-ddd/tree/part-2-spring-modulith)
[spring-modular-monolith](https://github.com/sivaprasadreddy/spring-modular-monolith)

## [Fundamentals](https://docs.spring.io/spring-modulith/reference/fundamentals.html)
The application’s main package is the one that the main application class resides in. That is the class, that is annotated with `@SpringBootApplication`.

By default, each direct sub-package of the main package is considered an _application module package_.

## Advanced Application Modules
```
 Example
└─  src/main/java
   ├─  example
   |  └─  Application.java
   ├─  example.inventory
   |  ├─  InventoryManagement.java
   |  └─  SomethingInventoryInternal.java
   ├─  example.order
   |  └─  OrderManagement.java
   └─  example.order.internal
      └─  SomethingOrderInternal.java
```
The `order` package is considered an API package. Code from other application modules is allowed to refer to types within that.

`order.internal`, just as any other sub-package of the application module base package, is considered an _internal_ one. Code within those must not be referred to from other modules.
### Open Application Modules
To turn an application module into an open one, use the `@ApplicationModule` annotation on the `package-info.java` type.
```java
@org.springframework.modulith.ApplicationModule(
  type = Type.OPEN
)
package example.inventory;
```
## Explicit Application Module Dependencies
```java
@org.springframework.modulith.ApplicationModule(
  allowedDependencies = "order"
)
package example.inventory;
```
`Inventory` module was only allowed to refer to code in the order module.
## Named Interfaces
To expose additional packages to other modules.
```
 Example
└─  src/main/java
   ├─  example
   |  └─  Application.java
   ├─ …
   ├─  example.order
   |  └─  OrderManagement.java
   ├─  example.order.spi
   |  ├—  package-info.java
   |  └─  SomeSpiInterface.java
   └─  example.order.internal
      └─  SomethingOrderInternal.java
```
```java
@org.springframework.modulith.NamedInterface("spi")
package example.order.spi;
```
Code in other application modules is allowed to refer to `SomeSpiInterface`.

Application modules are able to refer to the named interface in explicit dependency declarations.
`Inventory` could refer to the above declared named interface like this:
```java
@org.springframework.modulith.ApplicationModule(
  allowedDependencies = "order :: spi"
)
package example.inventory;
```
Code in inventory would be allowed to depend on `SomeSpiInterface` and other code residing in the `order.spi` interface, but not on `OrderManagement`.

To allow an application module is allowed to refer to all explicitly declared named interfaces.
```java
@org.springframework.modulith.ApplicationModule(
  allowedDependencies = "order :: *"
)
package example.inventory;
```
## Customizing Module Detection
