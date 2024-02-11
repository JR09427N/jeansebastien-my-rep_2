public class Main {
	public static void main(String[] args) {
		int[] coins = {5, 9, 6, 1};
		
		int m = coins.length;
		
		int V = 11;
		
		long startTime = System.nanoTime();
		minCoins(coins, m, V);
		System.out.print("With DP: ");
		System.out.println(System.nanoTime() - startTime);
		
		startTime = System.nanoTime();
		minCoinsRec(coins, m, V);
		System.out.print("W/Out DP: ");
		System.out.println(System.nanoTime() - startTime);
		
	}
	
	private static int minCoinsRec(int[] coins, int m, int V) {
		if(V == 0) {
			return 0;
		}
		
		int res = Integer.MAX_VALUE;
		
		for(int i = 0; i < m; i++) {
			if(coins[i] <= V) {
				int sub_result = minCoinsRec(coins, m, V - coins[i]);
				
				if(sub_result != Integer.MAX_VALUE && sub_result +1 < res) {
					res = sub_result + 1;
				}
			}
		}
		
		return res;
	}

	public static int minCoinsUtil(int[] coins, int m, int V, int[] dp) {
		if(V == 0) {
			return 0;
		}
		
		if(dp[V] != -1) {
			return dp[V];
		}
		
		int res = Integer.MAX_VALUE;
		
		for(int i = 0; i < m; i++) {
			if(coins[i] <= V) {
				int sub_result = minCoinsUtil(coins, m, V - coins[i], dp);
				
				if(sub_result != Integer.MAX_VALUE && sub_result + 1 < res) {
					res = sub_result + 1;
				}
			}
		}
		
		dp[V] = res;
		
		return res;
	}
	
	public static int minCoins(int[] coins, int m, int V) {
		int[] dp = new int[V + 1];
		
		for(int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		
		return minCoinsUtil(coins, m, V, dp);
	}
}