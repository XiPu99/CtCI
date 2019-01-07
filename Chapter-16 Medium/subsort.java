/*
  Given an array of integers, write a method to find indices m and n such that
  if you sorted elements m through n, the entire array would be sorted. Minimize
  n-m (that is, find the smallest such sequence).
*/

public int findUnsortedSubarray(int[] nums) {
    int endLeft = 0;
    int startRight = nums.length-1;

    // find left boundary
    for(int i = 1; i < nums.length; i++){
        if(nums[i-1]>nums[i]){
            endLeft = i;
            break;
        }
    }

    // find right boundary
    for(int i = nums.length-2; i >= 0; i--){
        if(nums[i]>nums[i+1]){
            startRight = i;
            break;
        }
    }

    // array already sorted
    if(startRight==nums.length-1) return 0;

    int min = nums[startRight+1];// min(mid, right)
    int max = nums[endLeft-1];// max(left, mid)

    for(int i = endLeft; i <= startRight; i++){
        if(nums[i]<min) min = nums[i];
        if(nums[i]>max) max = nums[i];
    }

    int l = endLeft-1;
    int r = startRight+1;

    // max(left, mid) <= first element of right
    // min(mid, right) > last element of left
    for(int i = 0; i < nums.length; i++){
        if(nums[i]>min){
            l = i;
            break;
        }
    }

    for(int i = nums.length-1; i >= 0; i--){
        if(max>nums[i]){
            r = i;
            break;
        }
    }

    return r-l+1;
}
