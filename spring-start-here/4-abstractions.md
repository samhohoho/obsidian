---
id: 4-abstractions
aliases: []
tags: []
---
- Analogy
    - Using a ride-sharing app.
        - I don’t care whether a car or a spaceship comes to pick me up if I reach the destination in time.
        - The ride-sharing app is an interface.
        - The customer and the driver are decoupled through the app (interface).
        - The customer doesn’t know who the driver is nor which car will pick them up.
- Notes
    - An object only needs to specify what it needs and stay completely unaware of how the what is implemented.
```java
public class DeliveryDetailsPrinter {
    private S orter sorter;
        public DeliveryDetailsPrinter(S orter sorter) {
        this.sorter = sorter;
    }
    public void printDetails() {
        sorter.sortDetails();
        // printing the delivery details
    }
}
```
