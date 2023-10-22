import java.beans.PropertyEditorSupport;

public class Expr {
    public static double expr(int a, int b) {
        double result = 0;

        try {
            if (b == 0) {
                throw new ArithmeticException();
            } else {
                result = (double) a / b;
            }
        } catch (ArithmeticException e) {
            result = 0;
        }

        printSum(a, b);

        return result;
    }

    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }
}
