public class Main {
    public static void main(String[] args) throws Exception {
        char a = 'a';
        Expr exp = new Expr();

        String result = exp.expr(a);
        System.out.println(result);
    }
}