package LambdaExpressionHandsOn;

public class LambdaExpressionHandsOn {

    public static void main(String[] args) {
        Foo foo = param -> param;
        System.out.println(foo.foo("hi"));
    }

}

//class FooImpl implements Foo {
//    @Override
//    public String foo(String string) {
//        System.out.println(string);
//        return string;
//    }
//}

