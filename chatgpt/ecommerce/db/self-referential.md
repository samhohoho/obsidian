---
id: self-referential
aliases: []
tags: []
---
In an **ecommerce project**, self-referential foreign keys can be highly useful to model hierarchical relationships, which are common in areas such as:

---

### 1. **Category and Subcategory Relationships**
For an ecommerce system, product categories often have a hierarchical structure where a category can have subcategories, and those subcategories can have further subcategories.

#### Example: Categories Table
```sql
CREATE TABLE Category (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    parent_id INT,
    FOREIGN KEY (parent_id) REFERENCES Category (id)
);
```

#### Sample Data
```plaintext
id    name             parent_id
--------------------------------
1     Electronics      NULL
2     Phones           1
3     Laptops          1
4     Smartphones      2
5     Feature Phones   2
6     Gaming Laptops   3
```

Here:
- "Electronics" is the root category.
- "Phones" and "Laptops" are subcategories of "Electronics."
- "Smartphones" is a subcategory of "Phones."

#### Queries:
- **Fetch all top-level categories:**
  ```sql
  SELECT * FROM Category WHERE parent_id IS NULL;
  ```
- **Fetch all subcategories of a given category (e.g., Electronics):**
  ```sql
  SELECT * FROM Category WHERE parent_id = 1;
  ```
- **Recursive Query to Fetch Full Hierarchy (PostgreSQL Example):**
  ```sql
  WITH RECURSIVE CategoryHierarchy AS (
      SELECT id, name, parent_id
      FROM Category
      WHERE parent_id IS NULL
      UNION ALL
      SELECT c.id, c.name, c.parent_id
      FROM Category c
      INNER JOIN CategoryHierarchy ch ON c.parent_id = ch.id
  )
  SELECT * FROM CategoryHierarchy;
  ```

---

### 2. **Product Bundles**
Some products may act as bundles or kits that contain other products. For example, a "Gaming Setup" might include a keyboard, mouse, and monitor.

#### Example: Product Table
```sql
CREATE TABLE Product (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    parent_id INT,
    FOREIGN KEY (parent_id) REFERENCES Product (id)
);
```

#### Sample Data
```plaintext
id    name                 parent_id
------------------------------------
1     Gaming Setup         NULL
2     Keyboard             1
3     Mouse                1
4     Monitor              1
5     Wireless Mouse       3
```

#### Queries:
- **Fetch all components of a product bundle (e.g., Gaming Setup):**
  ```sql
  SELECT * FROM Product WHERE parent_id = 1;
  ```

---

### 3. **Customer Referrals**
If your ecommerce platform has a referral program, you might need to track customers who referred other customers.

#### Example: Customer Table
```sql
CREATE TABLE Customer (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    referrer_id INT,
    FOREIGN KEY (referrer_id) REFERENCES Customer (id)
);
```

#### Sample Data
```plaintext
id    name          referrer_id
-------------------------------
1     Alice         NULL
2     Bob           1
3     Charlie       1
4     David         2
```

#### Queries:
- **Find all customers referred by a specific customer (e.g., Alice):**
  ```sql
  SELECT * FROM Customer WHERE referrer_id = 1;
  ```
- **Recursive Query to Find Referral Tree:**
  ```sql
  WITH RECURSIVE ReferralTree AS (
      SELECT id, name, referrer_id
      FROM Customer
      WHERE id = 1
      UNION ALL
      SELECT c.id, c.name, c.referrer_id
      FROM Customer c
      INNER JOIN ReferralTree rt ON c.referrer_id = rt.id
  )
  SELECT * FROM ReferralTree;
  ```

---

### Benefits of Using Self-Referential Foreign Keys in Ecommerce
1. **Scalable Data Models**:
   - Handle hierarchical relationships efficiently without requiring multiple tables.
   - Useful for unlimited levels of nesting (e.g., deeply nested categories or product kits).

2. **Simpler Queries**:
   - Retrieve related data (e.g., subcategories or bundled products) with straightforward queries.

3. **Better Data Integrity**:
   - Ensures relationships between parent and child rows are always valid.

4. **Custom Features**:
   - Enables advanced features like recursive discounts, category-wide promotions, or product bundles.

---

Let me know which of these examples you'd like to implement, and I can help you further!
