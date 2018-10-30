/*
  Given an infinite number of quarters, dimes, nickels, and pennies, write
  code calculate the number of ways of representing n cents
  Similar to https://leetcode.com/problems/coin-change-2/description/
*/

/*
==================================================================
  Naive recursive solution(time-limit-exceed error in LeetCode)
==================================================================
*/

public int change(int amount, int[] coins) {
    if(amount==0) return 1;
    return change(amount, coins.length-1, coins);
}

public int change(int amount, int k, int[] coins){
    if(amount < 0 || k < 0){
        return 0;
    }
    else if(amount==0){
        return 1;
    }
    else{
        return change(amount-coins[k], k, coins) + change(amount, k-1, coins);
    }
}

/*
=====================================================================
  Recursive solution with memoization: still have a time-limit-exceed
  error, but this time it passes more test cases before it reaches
  the time limit
=====================================================================
*/

public int change(int amount, int[] coins) {
  int[][] cache = new int[amount+1][coins.length];
  return change(amount, coins.length-1, cache, coins);
}

public int change(int amount, int k, int[][] cache, int[] coins){
  if(amount < 0 || k < 0){
      return 0;
  }
  else if(cache[amount][k]!=0){
    return cache[amount][k];
  }
  else if(amount==0){
      return 1;
  }
  else{
      cache[amount][k] = change(amount-coins[k], k, coins) + change(amount, k-1, coins);
      return cache[amount][k];
  }
}

/*
=====================================================================
  Bottom-up dynamic programming solution with 2D array
=====================================================================
*/

public int change(int amount, int[] coins){
  int[][] dp = new int[coins.length+1][amount+1];
  dp[0][0] = 1;

  for(int i = 1; i <= coins.length; i++){
    dp[i][0] = 1;
    for(int j = 1; j <= amount; j++){
        if(j >= coins[i-1]){
            dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
        }
        else{
            dp[i][j] = 0 + dp[i-1][j];
        }
    }
  }

  return dp[coins.length][amount];
}

/*
=====================================================================
  Bottom-up dynamic programming solution with 1D array based on the
  2D array approach
=====================================================================
*/

public int change(int amount, int[] coins){
  int[] dp = new int[amount+1];
  dp[0] = 1;

  for(int coin: coins){
    for(int i = coin; i <= amount; i++){
      dp[i] += dp[i-coin];
    }
  }
  return dp[amount];
}
