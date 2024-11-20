---
id: contain-duplicate
aliases: []
tags:
  - hashing
---

```js
function containsDuplicate(nums) {
    const seen = {};
    for (let i = 0; i < nums.length; i++) {
        const current = nums[i];
        if (seen[current]) {
            return true;
        } else {
            seen[current] = true;
        }
    }
}
```
