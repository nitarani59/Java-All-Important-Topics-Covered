## Optional Class

* Optional.of(arg) - Argument must never be null, otherwise it will throw NullPointerException
* Optional.ofNullable(arg) - If the arg is expected to be null, then use ofNullable
* Optional.empty() - Create an empty instance of optional.
* Optional.ofNullable(arg).orElse(arg)
* Optional.ofNullable(arg).orElseGet(arg)
* Difference between orElse and orElseGet
  - the primary difference between orElse() and orElseGet() lies in when the default value is evaluated.
  - orElse() always evaluates the default value, while orElseGet() evaluates it lazily, only if needed.
  - This makes orElseGet() more efficient in certain scenarios, 
  - especially when the default value is costly to construct or compute.
* get() vs isPresent(): 
  - It's important to note that while isPresent() checks whether a value exists, get() retrieves the value directly. 
  - However, using get() without first checking with isPresent() can lead to NoSuchElementException if the Optional is empty.
* #### _Pending_ - 
  * Map, FlatMap, Chaining Optional

## HashMap
* Why do we need a HashMap? 
  * The simple reason is performance. If we want to find a specific element in a list, 
  * the time complexity is O(n) and if the list is sorted, it will be O(log n) using, for example, a binary search.
* containsKey vs containsValue
  * Though they look very similar, there is an important difference in performance between these two method calls.
  * The complexity to check if a key exists is O(1), while the complexity to check for an element is O(n), 
  * as it’s necessary to loop over all the elements in the map.
* We can use any class as the key in our HashMap. 
* However, for the map to work properly, we need to provide an implementation for equals() and hashCode().
* With HashMap, we can achieve an average time complexity of O(1) for the put and get operations and space complexity of O(n).

## HashTable
  - Certainly! Here's a summary of the explanation about `HashTable`:

`HashTable` is a class in Java that implements the `Map` interface, providing a data structure to store key-value pairs. It internally uses hashing to efficiently store and retrieve entries based on their keys.

**Key Characteristics**:
1. **Synchronization**: `HashTable` is synchronized, making it thread-safe for concurrent access from multiple threads. However, this synchronization can lead to performance overhead.
2. **Performance**: While providing thread safety, `HashTable` may have lower performance compared to `HashMap`, especially in single-threaded scenarios.
3. **Null Handling**: `HashTable` does not allow `null` keys or values, as attempting to insert them will result in a `NullPointerException`.
4. **Iteration Order**: The order of iteration over the elements of a `HashTable` is not guaranteed to be predictable.

**Usage**:
- `HashTable` was one of the earliest hash table implementations in Java but is less commonly used in modern Java development due to its performance limitations and restrictions on null keys and values.

**Thread Safety**:
- `HashTable` ensures thread safety by allowing only one thread to modify the table at a time. While this provides safety for concurrent access, it can lead to performance degradation due to synchronization overhead.

**Recommendation**:
- In modern Java development, `HashTable` is typically not the preferred choice for new projects. Developers often opt for alternatives like `HashMap` for better performance and flexibility. However, `HashTable` can still be used if thread safety is a primary concern and performance is not critical. Otherwise, alternatives such as `ConcurrentHashMap` or external synchronization with `HashMap` are preferred for achieving thread safety without sacrificing performance.
## TreeMap

## LinkedHashMap

## Differences between all the Maps

There are several implementations of the Map interface in Java, each with its own characteristics, pros, and cons. Here's a comparison of some commonly used implementations:

1. HashMap

   Pros:
   * Provides constant-time performance for basic operations (put(), get(), remove()) on average, assuming a good hash function and proper tuning.
   * Allows null values and one null key. 
   * Not synchronized, making it efficient for single-threaded operations.
   
   Cons:
   * Not thread-safe. If multiple threads access a HashMap concurrently and one or more threads modify it structurally (e.g., via put() or remove()), it must be synchronized externally. 
   * Iteration over a HashMap is not guaranteed to be ordered. 
   * May have collisions, which can degrade performance, especially if the hash function is poor.
2. TreeMap

   Pros:
   * Guarantees log(n) time cost for the basic operations (put(), get(), remove()), where n is the number of elements in the map.
   * Sorted according to the natural ordering of its keys or by a Comparator provided at map creation time.
   
   Cons:
   * Slower than HashMap for most operations due to the tree structure.
   * Not thread-safe. Like HashMap, external synchronization is required for concurrent access.
   * Does not allow null keys.
3. LinkedHashMap
   
   Pros:
   * Maintains insertion order, making iteration over the map predictable.
   * Performance characteristics similar to HashMap.
   
   Cons:
   * Slightly slower than HashMap due to maintaining the linked list for maintaining insertion order.
   * Not thread-safe.
4. ConcurrentHashMap
   
   Pros:
   * Thread-safe without external synchronization.
   * Provides high concurrency for read operations by allowing multiple threads to read concurrently.
   * Supports some atomic operations (putIfAbsent(), remove(), etc.).
   
   Cons:
   * May have higher memory overhead and slightly slower performance compared to HashMap due to concurrency features.
   * Iterator of ConcurrentHashMap is weakly consistent and doesn't provide strong guarantees on the consistency of iteration.

### Lambda Expression
  * What is lambda expression in java
    - Lambda expression in Java is a feature introduced in Java 8 that allows you to implement one-function interfaces (functional interfaces) more simply and concisely.
    - It is an anonymous function that adds functional programming techniques to Java, making it easier to write code in specific situations compared to using anonymous inner classes.
  
  * Instantiate Functional Interface with Lambda Expression
    * Foo foo = parameter -> parameter + " from Foo";
      * Instead of, 
        * Foo fooByIC = new Foo() {
         * @Override
           * public String method(String string) { 
           * return string + " from Foo";
         * }
        * };

### Stream API
* Stream API helps to substitute for, for-each, and while loops. 
* It allows concentrating on operation’s logic, but not on the iteration over the sequence of elements.

##### What is a Stream?
  A Stream in Java represents a sequence of elements from a source, such as a collection, array, or I/O resource. 
  It supports functional-style operations to process the elements efficiently in a pipeline manner.

##### Methods
  - Stream.empty() - We should use the empty() method in case of the creation of an empty stream
  - Stream.builder() - When builder is used, the desired type should be additionally specified in the right part of the statement
                       Example - Stream.<String>builder.add(...)
  - Stream.generate()
    The generate() method accepts a Supplier<T> for element generation. As the resulting stream is infinite, 
    the developer should specify the desired size, or the generate() method will work until it reaches the memory limit:
  - Stream<String> stream =
    Stream.of("a", "b", "c").filter(element -> element.contains("b"));
    Optional<String> anyElement = stream.findAny();
    An attempt to reuse the same reference after calling the terminal operation will trigger the IllegalStateException:
  - We can only use one terminal operation per stream. 
  - The correct and most convenient way to use streams is by a stream pipeline, 
    which is a chain of the stream source, intermediate operations, and a terminal operation:
  - intermediate operations which reduce the size of the stream should be placed before operations which are applying to each element. 
    So we need to keep methods such as skip(), filter(), and distinct() at the top of our stream pipeline.
##### Uses of Streams:
  ###### Data Transformation:
             Streams allow you to transform data by applying various operations such as mapping, filtering, and sorting.
  ###### Aggregation: 
             You can perform aggregation operations like summing, averaging, or counting elements in a stream.
  ###### Parallel Processing: 
             Streams support parallel execution, enabling efficient utilization of multi-core processors for data processing tasks.
  ###### Lazy Evaluation: 
             Operations on streams are lazily evaluated, meaning intermediate operations are only performed when a terminal operation is invoked.
             This allows for optimized resource usage.

#### Common Stream Methods:
  ###### Intermediate Operations:
             - filter(Predicate): Filters elements based on the given predicate.
             - map(Function): Transforms each element into another value using the provided function.
             - flatMap(Function): Maps each element to a stream and then flattens the resulting streams into a single stream.
             - distinct(): Removes duplicate elements from the stream.
             - sorted(): Sorts elements in natural order.
             - limit(long): Limits the size of the stream to the specified number of elements.
             - skip(long): Skips the specified number of elements from the stream.
             - peek(Consumer): Performs an action for each element of the stream without affecting its elements.
  ###### Terminal Operations:
              - forEach(Consumer): Performs an action for each element of the stream.
              - collect(Collector): Collects the elements of the stream into a collection or other data structure.
              - count(): Returns the count of elements in the stream.
              - anyMatch(Predicate), allMatch(Predicate), noneMatch(Predicate): Check if any, all, or no elements match the given predicate.
              - findFirst(), findAny(): Returns the first or any element of the stream, respectively.
              - reduce(): Performs a reduction operation on the elements of the stream.
              - min(Comparator), max(Comparator): Returns the minimum or maximum element of the stream, respectively.

#### Pending 
    Collect, Parallel Stream


### Serialization
    - The JVM associates a version (long) number with each serializable class. We use it to verify that the saved and loaded objects have the same attributes, and thus are compatible on serialization.
    - Most IDEs can generate this number automatically, and it’s based on the class name, attributes, and associated access modifiers. Any changes result in a different number, and can cause an InvalidClassException.

    - Note that static fields belong to a class (as opposed to an object) and are not serialized.
    - The JVM associates a version (long) number with each serializable class. We use it to verify that the saved and loaded objects have the same attributes, and thus are compatible on serialization.
    - Most IDEs can generate this number automatically, and it’s based on the class name, attributes, and associated access modifiers. Any changes result in a different number, and can cause an InvalidClassException.

### Try-With-Resources
    - introduced in Java 7 — allows us to declare resources to be used in a try block with the assurance that the resources will be closed after the execution of that block.
    - The resources declared need to implement the AutoCloseable interface.
    - We can declare multiple resources just fine in a try-with-resources block by separating them with a semicolon:
    - To construct a custom resource that will be correctly handled by a try-with-resources block, the class should implement the Closeable or AutoCloseable interfaces and override the close method:
    - Resources that were defined/acquired first will be closed last. 
    - A try-with-resources block can still have the catch and finally blocks, which will work in the same way as with a traditional try block.
    - As of Java 9 and as part of JEP 213, we can now use final or even effectively final variables inside a try-with-resources block:

### Reflection
    -  forName() is used to obtain the Class object for a class given its fully qualified name (including package).
    -  getSimpleName() is used to retrieve the simple (unqualified) name of a class.