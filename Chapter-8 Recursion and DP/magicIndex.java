/*
  A magic index in an array A[0...n-1] is defined to be an index such that
  A[i] = i. Given a sorted array of distinct integers, write a method to
  find a magic index, if one exists, in array A.
*/

public int findMagicIndex(int[] arr){
  return helper(arr, 0, arr.length-1);
}
public int helper(int[] arr, int low, int up){
  if(low==up){
    if(arr[low]==low) return low;
    else return -1;
  }

  int mid = (low+up)/2;
  if(arr[mid]>mid){
    return helper(arr, low, mid-1);
  }
  else if(arr[mid]<mid){
    return helper(arr, mid+1, up);
  }
  else{
    return mid;
  }
}

/*
  Follow-up: what if the values in the array is not distinct
*/
   0 1 2 3 4 5
[  0,0,0,4,5,6]
public int findMagicIndex(int[] arr){
  return helper(arr, 0, arr.length-1);
}

public int helper(int[] arr, int low, int up){
  if(low==up){
    if(arr[low]==low) return low;
    else return -1;
  }

  int mid = (low+up)/2;
  if(arr[mid]==mid){
    return mid;
  }
  else{
    /* search left */
    int thres = Math.min(arr[mid], mid-1);
    int result = helper(arr, low, thres);
    if(result!=-1){
      return result;
    }

    /* search right */
    int search = Math.max(arr[mid], mid+1);
    return helper(arr, search, up);
  }
}
