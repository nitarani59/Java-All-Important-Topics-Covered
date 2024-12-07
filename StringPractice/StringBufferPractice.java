public class StringBufferPractice {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Hello");
        StringBuffer stringBuffer1 = new StringBuffer("Hello");

        System.out.println(stringBuffer==stringBuffer1);
        System.out.println(stringBuffer.equals(stringBuffer1));
        System.out.println(stringBuffer1);
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        System.out.println("compareTo " + stringBuffer1.compareTo(StringBuffer));
        stringBuffer1.delete(1, 3);

        System.out.println(stringBuffer1);
        

    }
}
