public class Answer {
    public int[] subArrays(int[] a, int[] b) {
        int[] res = new int[a.length];;

        try {
            for (int i = 0; i < a.length; i++) {
                res[i] = a[i] - b[i];
            }

            return res;
        } catch (ArrayIndexOutOfBoundsException e) {
            return new int[]{0};
        }
    }
}
