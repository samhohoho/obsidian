---
id: balanced-binary-tree
aliases: []
tags: []
---

https://leetcode.com/problems/balanced-binary-tree/solutions/5632240/solution-by-dare2solve-detailed-explanation-clean-code/

```js
var isBalanced = function(root) {
    let result = true;

    var dfs = function(root) {
        if (!root) return 0;

        let left = dfs(root.left);
        let right = dfs(root.right);

        if (Math.abs(right - left) > 1) {
            result = false;
        }

        return Math.max(left, right) + 1;
    };
}
```

Make sure the height difference of the left and right is no more than 1.
When i receive 2 values from left and right, i compare and check if the difference is more than 1.
