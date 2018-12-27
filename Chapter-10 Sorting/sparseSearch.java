/*
  Given a sorted array of strings that is interspersed with empty strings,
  write a method to find the location of a given string.
*/

/**
  Maybe use binary search
*/
public int search(String[] arr, String str){
  return binary(arr, str, 0, arr.length-1);
}

public int binary(String[] arr, String str, int low, int high){

  int mid = (low+high)/2;

  // empty string case
  if(arr[mid].length()==0){
    int left = mid-1;
    int right = mid+1;

    while(true){
      if(left<low&&right>high) {
        return -1;
      }
      if(left>=low&&arr[left].length()!=0) {
        mid = left;
        break;
      }
      if(right<=high&&arr[right].length()!=0) {
        mid = right;
        break;
      }
      left--;
      right++;
    }
  }

  String compare = arr[mid];
  if(compare.equals(str)){
    return mid;
  }
  else if(str.compareTo(compare)<0){
    return binary(arr, str, low, mid-1);
  else{
    return binary(arr, str, mid+1, high);
  }
}

// public int findNonEmpty(String[] arr, int mid){
//   for(int i = mid-1; i >= 0; i--){
//     if(arr[i].length()!=0){
//       return i;
//     }
//   }
//   return 0;
// }
