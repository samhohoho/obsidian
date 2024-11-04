---
id: merge-sorted
aliases: []
tags: []
---

```js
var mergeTwoLists = function(list1, list2) {
    const newList = new ListNode();
    let cur = newList;

    while (list1 && list2) {
        if (list1.val < list2.val) {
            cur.next = list1;
            list1 = list1.next;
        } else {
            cur.next = list2;
            list2 = list2.next;
        }
        cur = cur.next;
    }

    cur.next = list1 || list2;

    return newList.next;
}
```

Use 2 pointers, `l1` (on first linked-list) and `l2` (on 2nd).
Move the pointer forward once added to the new linked-list.
Once one of the linked-list is empty, move the rest of 2nd linked-list to the new linked-list.
