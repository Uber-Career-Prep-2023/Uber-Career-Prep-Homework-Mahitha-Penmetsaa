public class ZeroSumSubArrays {
    public static int zeroSumSubArrays(int[] arr) {
        int output = 0;
        int k = 0;

        while (k < arr.length) {
            int l = k;
            int intSum = arr[l];
            while (l < arr.length) {
                if (l != k)
                    intSum += arr[l];
                if (intSum==0)
                    output++;
                l++;
            }
            k++;
        }
        return output;
    }

    //Time : O(n^2)
    //Space: O(n)
    //Variable Size Growing Sliding Window
}
