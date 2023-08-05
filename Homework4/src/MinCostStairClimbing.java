
public class MinCostStairClimbing {


    public static void main(String[] args) {
        System.out.println(minCost(new int[]{4, 1, 6, 3, 5, 8}));
        System.out.println(minCost(new int[]{1,1,1,1,1}));
        System.out.println(minCost(new int[]{3,2,1}));
        System.out.println(minCost(new int[]{1,2,3}));
    }
    public static int minCost(int[] stairs){
        int[] costs = new int[stairs.length+1];
        costs[stairs.length] = 0;
        for (int i = stairs.length - 1; i >= 0; i--){
            if (i == stairs.length-1){
                costs[i] = stairs[i];
            } else {
                costs[i] = stairs[i] + Math.min(costs[i+1], costs[i+2]);
            }
        }
        return Math.min(costs[0], costs[1]);
    }


}
