public class DedupArray {
    public void removeDuplicates(int[] nums) {

        if(nums.length == 0 || nums.length == 1)
            return;


        int j = 1;


        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }


        while(j<nums.length) {
            nums[j] = -1;
            j++;
        }
    }
//O(n)
    //O(n)
    //fixed size sliding window approach was used
}
