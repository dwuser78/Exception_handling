public class Expr {
    public static String expr(char a) throws Exception {
        String result = "";

        if (a == ' ') {
            throw new Exception("Empty string has been input.");
        } else {
            result = "Your input was - " + a;
        }

        return result;
    }
}
