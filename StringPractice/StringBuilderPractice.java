public class StringBuilderPractice {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Hello");
        StringBuilder stringBuilder1 = new StringBuilder("Hello");

        System.out.println(stringBuilder==stringBuilder1);
        System.out.println(stringBuilder.equals(stringBuilder1));
        System.out.println(stringBuilder1);
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        System.out.println("compareTo " + stringBuilder1.compareTo(stringBuilder));
        stringBuilder1.delete(1, 3);

        System.out.println(stringBuilder1);

    }
}
