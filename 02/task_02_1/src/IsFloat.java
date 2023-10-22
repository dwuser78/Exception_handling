public class IsFloat {
    public static float isFloat(String input) {
        float result;

        try {
            result = Float.parseFloat(input);
        } catch (NumberFormatException e) {
            System.out.println("Your input is not a float number. " +
                               "Please, try again.");
            result = Float.NaN;
        }

        return result;
    }
}
