---
id: stash
aliases: []
tags: []
---
# Save a stash with a message
```
git stash push -m "my_stash_name"
```
# Apply
```
git stash apply stash@{n}
```
# Apply by name
```
git stash apply stash^{/my_stash_name}
```
# Apply and drop
```
git stash pop stash@{n}
```
