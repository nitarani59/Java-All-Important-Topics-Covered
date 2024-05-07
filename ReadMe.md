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