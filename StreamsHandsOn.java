import lombok.Data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StreamsHandsOn {

    public static void main(String[] args) throws IOException {
//        String[] arr = new String[]{"a", "b", "c"};
//        Stream<String> stream = Arrays.stream(arr);
//        stream.findFirst().ifPresent(System.out::println);
//        stream = Stream.of("a", "b", "c");
//
//
//        /**
//         * To convert elements of a Stream by applying a special function to them and
//         * to collect these new elements into a Stream, we can use the map() method:
//         *
//         * So, the code below converts Stream<String> to the Stream<Path> by applying a specific lambda expression
//         * to every element of the initial Stream.
//        */
//        List<String> uris = new ArrayList<>();
//        uris.add("C:\\My.txt");
//        Stream<Path> stream1 = uris.stream().map(uri -> Paths.get(uri));
//
//
//        /** If you have a stream where every element contains its own sequence of elements and
//         you want to create a stream of these inner elements, you should use the flatMap() method:
//         In this example, we have a list of elements of type Detail. The Detail class contains a field PARTS,
//         which is a List<String>. With the help of the flatMap() method, every element from field PARTS will
//         be extracted and added to the new resulting stream. After that, the initial Stream<Detail> will be lost
//        */
//        List<Detail> details = new ArrayList<>();
//        details.add(new Detail());
//        Stream<String> stream2 = details.stream().flatMap(detail -> detail.getParts().stream());
//
//        stream2.forEach(System.out::println);
//        List<String> list = new ArrayList<>();
////        list.add("hello");
//        boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
//        boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
//        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false
//
//        boolean isValidThree = list.stream().anyMatch(Objects::nonNull);
//
//        Stream.generate(() -> "-").limit(10).forEach(System.out::print);
//
//        Path path = Paths.get("E:\\file.txt");
//        Stream<String> streamOfStrings = Files.lines(path);
//        Stream<String> streamWithCharset =
//                Files.lines(path, Charset.forName("UTF-8"));
//        System.out.println(streamWithCharset.findFirst().get());

        List<String> list1 = new ArrayList<>();
        list1.add("abc1");list1.add("abc2");list1.add("abc3");
        long size = list1.stream().skip(2).map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).skip(2).count();

    }

    private static void wasCalled() {
        System.out.println("Called me");
    }
}
class Detail {
    List<String> parts = new ArrayList<>();
    public List<String> getParts() {
        return parts;
    }
}