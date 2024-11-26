---
id: complexity
aliases: []
tags: []
---
- Analyze complexity.
    - Identify loops.
        - Each loop adds `O(n)`.
        - Nested loops multiply the complexities.
    - Recursive calls.
        - Analyze the depth and size reduction.
    - Ignore constants.
        - `O(2n) -> O(n)`
    - Ignore lower-order terms.
        - As `n` grows, smaller terms become insignificant.
        - `n^2 + n -> n^2`
