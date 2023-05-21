public class MissingInteger {

    public static int missingInt(int arr[],int n){
        int i;
        int temp[] = new int[n + 1];
        for (i = 0; i <= n; i++) {
            temp[i] = 0;
        }

        for (i = 0; i < n; i++) {
            temp[arr[i] - 1] = 1;
        }

        int ans = 0;
        for (i = 0; i <= n; i++) {
            if (temp[i] == 0)
                ans = i + 1;
        }
        return ans;
    }



    //Time: O(logn)
    //Space: O(1)
    //Binary Search Variation
}
