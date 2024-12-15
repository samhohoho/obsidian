---
id: exception
aliases: []
tags: []
---
# The three kinds of exceptions
- Checked exception.
    - Should anticipate and recover from.
    - Subject to the Catch or Specify Requirement.
    - All are checked exceptions, except `Error`, `RuntimeException`, and their subclasses.
    - Examples.
        - FileNotFoundException.
- Error. (unchecked)
    - Cannot anticipate or recover from.
    - Examples.
        - Failure in the Java Virtual Machine.
        - Hardware or system malfunction.
- Runtime exceptions. (unchecked)
    - `RuntimeException`, an `Exception` subclass.
    - Reserved for incorrect use of an API.
    - Examples.
        - Logic errors.
        - Improper use of an API.
        - `NullPointerException`.
# Multi-catching
- What?
    - Catch more than one exception types with one exception handler.
- Notes.
    - The catch parameter `ex` is implicitly `final`.
```java
catch (IOException|SQLException ex) {
    logger.log(ex);
    throw ex;
}
```
# Try-with-resources statement
- What?
    - A resource is an object that must be cloased.
        - Object that implements `AutoCloseable` or `Closeable`.
- Notes.
    - `BufferedReader` will be closed regardless of whether the `try` statement completes normally or abruptly (`IOException`).
    - `catch` or `finally` block is run after the resources declared have been closed.
```java
static String readFirstLineFromFile(String path) throws IOException {
    try (BufferedReader br =
                   new BufferedReader(new FileReader(path))) {
        return br.readLine();
    }
}
```
```java
public static void viewTable(Connection con) throws SQLException {

    String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

    try (Statement stmt = con.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String coffeeName = rs.getString("COF_NAME");
            int supplierID = rs.getInt("SUP_ID");
            float price = rs.getFloat("PRICE");
            int sales = rs.getInt("SALES");
            int total = rs.getInt("TOTAL");

            System.out.println(coffeeName + ", " + supplierID + ", " +
                               price + ", " + sales + ", " + total);
        }
    } catch (SQLException e) {
        JDBCTutorialUtilities.printSQLException(e);
    }
}
```
## Declare one or more resources
- Example.
    - Retrieves from file `zipFileName`.
    - And creates a file.
- Notes.
    - The close methods of resources are called in the opposite order of their creation.
```java
public static void writeToFileZipFileContents(String zipFileName,
                                           String outputFileName)
                                           throws java.io.IOException {

    java.nio.charset.Charset charset =
         java.nio.charset.StandardCharsets.US_ASCII;
    java.nio.file.Path outputFilePath =
         java.nio.file.Paths.get(outputFileName);

    // Open zip file and create output file with
    // try-with-resources statement

    try (
        java.util.zip.ZipFile zf =
             new java.util.zip.ZipFile(zipFileName);
        java.io.BufferedWriter writer =
            java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
    ) {
        // Enumerate each entry
        for (java.util.Enumeration entries =
                                zf.entries(); entries.hasMoreElements();) {
            // Get the entry name and write it to the output file
            String newLine = System.getProperty("line.separator");
            String zipEntryName =
                 ((java.util.zip.ZipEntry)entries.nextElement()).getName() +
                 newLine;
            writer.write(zipEntryName, 0, zipEntryName.length());
        }
    }
}
```
# Suppressed exception
- What?
    - `Throwable.getSuppressed()` to retrieve suppressed exceptions.
- Example.
    - In the example `readFirstLineFromFile()`, if exceptions are thrown from both the `try` block and the try-with-resources statement, `readFirstLineFromFile()` throws the exception from `try` block.
    - The exception from the `try-with-resources` block is suppressed.

# Chained exceptions
- What?
    - One exception causes another exception.
    - Catch one and throw another, but keeping the original
- Why?
    - 
- `Throwable` class.
    - `Throwable(Throwable cause)`: `cause`, the exception that causes the current exception.
        - `Throwable(String msg, Throwable cause)`.
    - `getCause()`: Returns actual cause of an exception.
    - `initCause(Throwable cause)`: Sets the cause for the calling exception.
- Links
    - https://medium.com/thefreshwrites/what-is-exception-chaining-in-java-exception-handling-d5f5a694579b
