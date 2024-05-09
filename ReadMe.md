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

ere are several implementations of the Map interface in Java, each with its own characteristics, pros, and cons. Here's a comparison of some commonly used implementations:

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