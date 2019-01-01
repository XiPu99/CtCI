/*
  You are given two sorted arrays, A and B, where A has a large enough buffer at
  the end to hold B. Write a method to merge B into A in sorted order.
*/

/*
========================================================
  Approach one: Naive way to do this is just append B to
  the end of A and then sort A. Time complexity will be
  O((A+B)log(A+B))
========================================================
*/


/*
========================================================
  Approach two:
  Idea: Move from the end of the array to the start.
========================================================
*/

public void sortMerge(int[] a, int[] b){
  int aIndex = a.length-1;
  int bIndex = b.length-1;
  int index = aIndex+bIndex-1;
  while(bIndex>=0){
    if(aIndex>=0&&a[aIndex]>b[bIndex]){
      a[index] = a[aIndex];
      aIndex--;
    }
    else{
      a[index] = b[bIndex];
      bIndex--;
    }
    index--;
  }
}
