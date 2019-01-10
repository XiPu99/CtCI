/*
  You are given an array of integers (both positive and negative). Find
  the contiguous sequence with the largest sum. Return the sum.

  Hint: #531, #551, #567, #594, #614
*/

/*
===============================================================
  NOTE: This solution will return 0 if there are no positive
  subsequences
===============================================================
*/
public int maxSubArray(int[] nums){

  int maxSum = 0;
  int runningSum = 0;

  for(int i = 0; i < nums.length; i++){
    runningSum += nums[i];
    if(runningSum>maxSum) maxSum = runningSum;
    else if(runningSum<0) runningSum = 0;
  }

  return maxSum;
}

/*
===============================================================
  NOTE: To return a non-zero value when there are no positive
  subsequences, we need to modify our algorithm
===============================================================
*/
public int maxSubArray(int[] nums){
  int maxSum = 0;
  int runningSum = 0;

  for(int i = 0; i < nums.length; i++){
    runningSum = Math.max(runningSum+nums[i], nums[i]);
    maxSum = Math.max(maxSum, runningSum);
  }

  return maxSum;
}
