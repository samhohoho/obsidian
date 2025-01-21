---
id: complexity
aliases: []
tags: []
---
# Drop all constants.
- Big-O describes growth rate, not exact performance.
    - It tells us how the runtime or space requirements grow relative to the input size.
    - Big-O notation is focusing on how algorithm's performance grows as the size of the input becomes very large.
- Constants depend on implementation, not algorithm.
    - Constants depend on implementation details like:
        - Processor speed.
        - Number of iterations in a loop.
    - Big-O focuses on the algorithm itself.
- In algorithm, we dont care about the small things.
We care about the really big things, as `n` increases towards infinity.
