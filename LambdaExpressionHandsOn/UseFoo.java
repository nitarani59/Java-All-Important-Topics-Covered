package LambdaExpressionHandsOn;

// 7. Don’t Treat Lambda Expressions as Inner Classes
public class UseFoo {
    private String value = "Enclosing scope value";
    public static void main(String[] args) {
        UseFoo  useFoo = new UseFoo();
        useFoo.scopeExperiment();
    }

    public String scopeExperiment() {
        Foo fooIC = new Foo() {
            String value = "Inner class value";

            @Override
            public String foo(String string) {
                return this.value;
            }
        };
        String resultIC = fooIC.foo("");

        Foo fooLambda = parameter -> {
            String value = "Lambda value";
            return value;
        };
        String resultLambda = fooLambda.foo("");
        System.out.println("Results: resultIC = " + resultIC + ", resultLambda = " + resultLambda);
        return "Results: resultIC = " + resultIC + ", resultLambda = " + resultLambda;
    }
}
