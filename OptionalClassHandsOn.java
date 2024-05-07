import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class OptionalClassHandsOn {

    public static void main(String[] args) {
    }

    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertTrue(empty.isEmpty());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        Optional<String> opt = Optional.of("name"); // of method always takes non-null values
//        Optional<String> opt1 = Optional.of(null); - NPE
        assertTrue(opt.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        Optional<String> opt = Optional.ofNullable(null); // if a value can be null at some point of time use ofNullable
        // if value is null it return Optional.empty
        System.out.println("opt = " + opt);
        assertFalse(opt.isPresent());
    }

    @Test
    public void givenOptional_whenIsPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("Baeldung");
//      To check if there is a value in it or not with the isPresent() method:
        assertTrue(opt.isPresent());

        opt = Optional.ofNullable(null);
        assertFalse(opt.isPresent());
    }

    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        String name = "scanner.next();";
        Optional<String> opt = Optional.ofNullable(name);
        if (opt.isPresent()) {
            System.out.println("opt = null");
        }
//        opt.ifPresent(name -> System.out.println(name.length()));
    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
        assertEquals("john", name);
    }

    @Test
    public void whenOrElseGetWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        assertEquals("john", name);
    }

    // Diff between orElse or orElseGet
    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;

        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Default Value", defaultText);

        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Default Value", defaultText);

        // The getMyDefault() method is called in each case. It so happens that when the wrapped value is not present,
        // then both orElse() and orElseGet() work exactly the same way.
    }

    @Test
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String text = "Text present";

        System.out.println("Using orElseGet:");
        String defaultText
                = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Text present", defaultText);

        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Text present", defaultText);

        // Notice that when using orElseGet() to retrieve the wrapped value,
        // the getMyDefault() method is not even invoked since the contained value is present.
        //
        //However, when using orElse(), whether the wrapped value is present or not,
        // the default object is created. So in this case, we have just created one redundant object that is never used.
        //
        //In this simple example, there is no significant cost to creating a default object,
        // as the JVM knows how to deal with such. However, when a method such as getMyDefault() has to make a web service call
        // or even query a database, the cost becomes very obvious.
    }

    private String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenOrElseThrowWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow(
                IllegalArgumentException::new);
    }

    // In Java 10
    @Test(expected = NoSuchElementException.class)
    public void whenNoArgOrElseThrowWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow();
    }

    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        Optional<String> opt = Optional.of("baeldung");
        String name = opt.get();
        assertEquals("baeldung", name);
    }

    @Test(expected = NoSuchElementException.class)
    public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
        Optional<String> opt = Optional.ofNullable(null);
        String name = opt.get();
//        However, unlike the previous three approaches, get() can only return a value if the wrapped object is not null;
//        otherwise, it throws a no such element exception:
    }

    @Test
    public void whenOptionalFilterWorks_thenCorrect() {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        assertTrue(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        assertFalse(is2017);
    }

    @Test
    public void givenOptional_whenMapWorks_thenCorrect() {
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional
                .map(List::size)
                .orElse(0);
        assertEquals(6, size);
    }
}
