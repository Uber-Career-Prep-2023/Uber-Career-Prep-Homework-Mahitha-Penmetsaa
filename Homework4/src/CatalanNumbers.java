import java.util.Arrays;

public class CatalanNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(catalans(5)));
        System.out.println(Arrays.toString(catalans(155)));
        System.out.println(Arrays.toString(catalans(0)));
        System.out.println(Arrays.toString(catalans(1)));
    }
    public static int[] catalans(int n) {
        int[] answer = new int[n + 1];
        if (n == 0) {
            return new int[]{1};
        } else if (n == 1) {
            return new int[]{1, 1};
        }
        answer[1] = 1;
        answer[0] = 1;

        for (int i = 2; i <= n; i++) {
            answer[i] = 0;
            for (int j = 0; j < i; j++) {
                answer[i] += answer[j] * answer[i - j - 1];
            }
        }
        return answer;
    }
}