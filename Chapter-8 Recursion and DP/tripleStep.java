/*
  A child is running up a staircase with n steps and can hop either 1
  step, 2 steps, or 3 steps at a time. Implement a method to count how
  many possible ways the child can run up the stairs.
*/

/*
  =====================================================
    Naive recursive solution: O(3^n) runtime
  =====================================================
*/
public int tripleStep(int n){
  if(n < 0){
    return 0;
  }
  else if(n == 0){
    return 1;
  }
  return tripleStep(n-1) + tripleStep(n-2) + tripleStep(n-3);
}

/*
  =====================================================
    Recursive solution with memo
    Note: be careful about the integer overflow issues
    (as n gets larger, the result will soon exceed the
    size of an integer)
  =====================================================
*/
public int climbStairs(int n){
  int[] memo = new int[n+1];
  return climbStairs(n, memo);
}

public int climbStairs(int n, int[] memo){
  if(n < 0){
    return 0;
  }
  else if(n == 0){
    return 1;
  }
  else if(memo[n]!=0){
    return memo[n];
  }
  int numOfWaysAtStepN = climbStairs(n-1, memo) + climbStairs(n-2, memo) + climbStairs(n-3, memo);
  memo[n] = numOfWaysAtStepN;
  return memo[n];
}

/*
  ===================================================================
    Dynamic Programming:
    To get to ith step, we can hop one step from (i-1)th step, hop two
    steps from (i-2)th step or hop three steps from (i-3)th step. The
    idea is similar to adding fibonacci numbers.
  ===================================================================
*/
public int climbStairs(int n){
  if(n==1) return 1;
  else if(n==2) return 2;

  int[] cache = new int[n+1];
  cache[1] = 1;
  cache[2] = 2;
  cache[3] = 4;

  for(int i = 4; i <= n; i++){
    cache[i] = cache[i-1] + cache[i-2] + cache[i-3];
  }
  return cache[n];
}
