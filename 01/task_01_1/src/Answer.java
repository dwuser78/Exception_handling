public class Answer {
    public static void arrayOutOfBoundsException() {
        int[] arr;
        arr = new int[3];

        arr[5] = 1;
    }

    public static void divisionByZero() {
        int x = 0;
        int y = 1;
        int z = 0;

        z = y / x;
    }

    public static void numberFormatException() {
        String x = "a";
        Integer y = 0;

        y = Integer.parseInt(x);
    }
}
