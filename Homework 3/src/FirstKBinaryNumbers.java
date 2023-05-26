import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class FirstKBinaryNumbers {
    private int k;

    public static ArrayList<String> returnNums(int k){
        ArrayList<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        if (k == 0) {
            return result;
        }
        result.add("0");
        q.add("1");
        for (int i = 0; i < k - 1; i++) {
            String s = q.poll();
            result.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return result;
    }
    public static String binary(int k){
        return returnNums(k).get(k-1);
    }

    public static void main(String[] args) {
        System.out.println(binary(4));
        System.out.println(binary(10));
        System.out.println(binary(5));
        System.out.println(binary(6));
        System.out.println(binary(7));
    }

}
