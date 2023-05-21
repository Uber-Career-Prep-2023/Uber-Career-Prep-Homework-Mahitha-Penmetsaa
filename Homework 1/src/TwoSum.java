import java.util.*;
public class TwoSum {
    public static int twoSum(int[] nums, int k) {
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>(); // to track the number of occurrences of number
        for (int i = 0; i < nums.length; i++) {
            int req = k - nums[i];
            if (map.containsKey(req)) {
                // required number to reach k is found, add # occurrences to number of pairs
                pairs += map.get(req);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return pairs;
    }
  //  Time: O(n)
   //     Space: O(n)
   //     Hash the Elements

}
