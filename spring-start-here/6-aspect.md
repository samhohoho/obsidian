---
id: 6-aspect
aliases: []
tags: []
---
# How aspects work
- When designing an aspect:
    - The code to be executed when you call specific methods, AKA **aspect**.
    - Executing aspect logic before or after the method call, **advice**.
    - Intercepting method and executing aspect, **pointcut**.
- The event that triggers the aspect execution, **join point**.
- The bean method intercepted by aspect is named **target object**.
- To be an **aspect target**, the object needs to be a bean.
## How Spring intercept each method call and apply the aspect logic?
- Spring wont give you an instance reference.
- Instead, it gives you an object that calls the aspect logic.
- Spring gives you a proxy object instead of the real bean, **weaving**.
