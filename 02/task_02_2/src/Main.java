public class Main {
    public static void main(String[] args) {
        int d = 1;
        int[] intArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Expr exp = new Expr();

        double result = exp.expr(intArray, d);
        System.out.println(result);
    }
}