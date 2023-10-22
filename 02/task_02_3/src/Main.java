public class Main {
    public static void main(String[] args) {
        int a = 90;
        int b = 0;
        Expr exp = new Expr();

        double result = Expr.expr(a, b);
        System.out.println(result);
    }
}