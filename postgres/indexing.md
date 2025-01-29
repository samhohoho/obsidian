---
id: indexing
aliases: []
tags: []
---
# Why random access can be slow in index scan
## Disk I/O overhead
Random access means jumping to different locations in the storage (disk or memory) to fetch data, rather than reading data sequentially (in order).

However, the actual data for those rows is stored in the heap (the main data area of the table), and the rows might be scattered all over the heap.

On traditional spinning hard drives (HDDs), reading data from random locations is much slower than reading sequentially.
- **Sequential Access**: The disk head reads data in a straight line, like reading a book page by page.
- **Random Access**: The disk head has to jump around to different locations, like flipping to random pages in a book. This involves physically moving the disk head, which takes time.

Even on SSDs (solid-state drives), random access is slower than sequential access, though the difference is less pronounced because SSDs don’t have moving parts.
## Cache inefficiency
## Row scattering
The heap (where the actual row data is stored) doesn’t maintain any specific order. Rows are added wherever there’s space, so they can be scattered all over the heap.
## How does this happen in an index scan
```sql
SELECT * FROM users WHERE age > 30;
```
1. **Index lookup**
    - The index contains pointers to the locations of these rows in the heap.
2. **Heap access**
    - Fetches the actual row data from the heap using the pointers from the index.
    - If the rows are scattered across the heap, this involves a lot of random access.
3. **Performance impact**
    - Each random access requires a separate disk I/O operation, which is much slower than reading data sequentially.
## How to fix this?
Uses bitmap scans to reduce the cost of random access.
1. **Build a bitmap.**
    - Instead of fetching rows one by one, PostgreSQL first scans the index and builds a bitmap of all the rows that match the condition.
2. **Sort heap accesses.**
    - The bitmap is sorted by the physical location of the rows in the heap.
3. **Fetch data in sorted order.**
    - PostgreSQL fetches the rows from the heap in the order of their physical location, which is closer to sequential access and much faster than random access.
## Real-life analogy.
Library.
- **Index** is the library catalog:
- **Heap** is the actual library shelves.
If the books on your topic are scattered all over the library:
- **Random access**: You have to run around the library to fetch each book.
- **Sequential access**: If the books were all on the same shelf, you could grab them without running around.
