/*
  Given a sorted array of n integers that has been rotated an unknown number of
  times, write code to find an element in the array. You may assume that the
  array was originally sorted in increasing order.
  Similar question is available on LeetCode
*/

// [1,3,5]
// [12,13,1,2,3,4]

/*
==================================================
  Approach one: most intuitive approach.
  Used binary search. Time complexity: O(log(N))
  Idea: divide the array into two halves,
  find which side is the sorted half located
==================================================
*/

public int search(int[] nums, int target){
  int start = 0;
  int end = nums.length-1;

  /* NOTE: if we change the while loop guard into start<end,
  then we can't simply return -1 at the end */
  while(start<=end){
    int mid = (start+end)/2;

    if(nums[mid]==target) return mid;
    /* find the sorted half of the array */
    // the sorted half is on the left side
    if(nums[start]<nums[mid]){
      if(target==nums[start]){
        return start;
      }
      // we need the second condition to determine whether to search left or right
      else if(target>nums[start]&&target<nums[mid]){
        end = mid-1;
      }
      else{
        start = mid+1;
      }
    }
    // the sorted half is on the right side
    else{
      if(target==nums[end]){
        return end;
      }
      else if(target<nums[end]&&target>nums[mid]){
        start = mid+1;
      }
      else{
        end = mid-1;
      }
    }
  }
  return -1;
}


// [4,5,6,7,1,2,3]

/*
=====================================================
  Approach two: Using infinity and negative infinity
  Idea: using the example of the array [4,5,6,7,1,2,3]
  if target is located in the second sorted half, we
  can treat the array as [-inf,-inf,-inf,-inf,1,2,3]
  and do a normal binary search on this array.
  Similarily, if target is in the first sorted half,
  we can treat the array as [4,5,6,7,inf,inf,inf].
  Next, we just need to figure out if nums[mid] and
  target are on the same half. If they are, we can
  keep nums[mid]. If they are not, we have to use
  either inf or -inf depending on target
  (low, mid, high, target)

  both mid and target are larger or lower than low
=====================================================
*/

public int search(int[] nums, int target){
  int low = 0;
  int high = nums.length-1;

  while(low<=high){
    int mid = (low+high)/2;
    int comparator = nums[mid];

    // determine if nums[mid] and target are on the same sorted half
    // this if statement check if both mid and target are larger or smaller than low
    // NOTE: using < sign here to handle edge cases like ([1,3],1)
    // Also using nums[0] or nums[low] will not change anything.
    if((nums[mid]<nums[0])==(target<nums[0])){
      // just use nums[mid] as comparator
      comparator = nums[mid];
    }
    else{
      /* nums[mid] and target are not on the same sorted half
      we need to determine whether to use inf or -inf */
      if(target<nums[0]){
        comparator = Integer.MIN_VALUE;
      }
      else{
        comparator = Integer.MAX_VALUE;
      }
    }

    if(target==comparator) return mid;
    else if(target<comparator) high = mid-1;
    else low = mid+1;
  }

  return -1;
}
