public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2,5,10};
        int sumA = 20;
        int sumB = 15;
        CoinChange c = new CoinChange();
        System.out.println(c.findCount(coins, sumA));
        System.out.println(c.findCount(coins, sumB));

    }
    public int findCount(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < sum+1; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[sum];
    }
}
