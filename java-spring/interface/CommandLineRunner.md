---
id: CommandLineRunner
aliases: []
tags: []
---

- `CommandLineRunner` is an interface provided by SpringBoot.
    - When implemented, SpringBoot detects it as a bean and executes its `run()`.
    - Allows to specific logic after the **application context** is fully initialized.
    - Commonly used to execute code at the application startup.
- Purpose
    - Useful for initialization tasks.
    - Like loading initial data, setup scripts
- Execution timing.
    - `run()` is executed after all beans are created and dependencies are injected.
- Parameters.
    - `run()` takes a `String[] args` parameter, which represents the command-line arguments passed when starting the application.
