import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class MergeIntervals {
    public static void returnMerge(ArrayList<int[]> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = arr.get(i)[0]; j <= arr.get(i)[1]; j++) {
                if (map.containsKey(j)) {
                    map.put(j, map.get(j) + 1);
                } else {
                    map.put(j, 1);
                }
            }

        }
        //
//Time : O(n^2)
//Space : O(n)
        //attempted to merge the two intervals was unable to however complete this
    }
}
