import java.util.*;
public class MaxMeanSubArray {
    public static void main(String[] args) {
        int[] input1 = {1, 1, 1, 1, -1, -1, 2, -1, -1, 6};
        int k1=3;
        MaxMeanSubArrayFunct(input1,k1);
    }
    public static void MaxMeanSubArrayFunct(int[] input, int k) {
        ArrayList<Integer> tempSumArr = new ArrayList<Integer>();
        int tempSum=0;
        //We need to go through the given array while it isn't over, respecting it's bounds for comparsions
        for(int i = 0; i < input.length-k+1; i++){
            for (int j = i; j<k+i; j++){
                tempSum+=input[j];
            }
            tempSumArr.add(tempSum);
            tempSum=0;
        }
        //Now, we just need to pick the highest value in our arraylist, could use some methods, also.
        float highest= tempSumArr.get(0);
        for (int i = 0; i < tempSumArr.size(); i++){
            if (tempSumArr.get(i)>highest){
                highest=tempSumArr.get(i);
            }
        }
        System.out.println(highest/k);
    }


//Time : O(n^2)
//Space : O(n)
//Technique: sliding window with a fixed size k.


}
