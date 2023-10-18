import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{12, 8, 16};
        int[] b = new int[]{4, 2, 4};

        Answer ans = new Answer();

        String itresume_res = Arrays.toString(ans.divArrays(a, b));
        System.out.println(itresume_res);
    }
}