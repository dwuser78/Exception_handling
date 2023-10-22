public class Expr {
    public static double expr(int[] intArray, int d) {
        double result = 0;
        String err_msg = "It's not possible to evaluate the expression - " +
                         "intArray[8] / d as ";

        try {
            if (d == 0) {
                throw new ArithmeticException();
            } else {
                result = (double) intArray[8] / (double) d;
                System.out.println(String.format("intArray[8] / d = %d / %d " +
                                                 "= %.1f", intArray[8], d,
                                                 result));
            }
        } catch (ArithmeticException e) {
            System.out.println(err_msg + "d = 0.");
            result = Double.NaN;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(err_msg +
                               "there is no 8th element in the given array.");
            result = Double.NaN;
        }

        return result;
    }
}
