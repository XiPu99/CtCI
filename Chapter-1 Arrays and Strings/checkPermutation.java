/*
  Given two strings, write a method to decide if one is a permutation
  of the other
*/

/*
  ============================================================
  One way to do it is sort the two strings by alphabetic order,
  then compare the two sorted strings to see if they are equal.
  Time complexity: O(Nlog(N)) because of sorting.
  Space complexity: O(1)
  ============================================================
*/
public boolean checkPermutationBySorting(String s, String t){
  if(s.length()!=t.length()) return false;
  return sort(s).equals(sort(t));
}

public String sort(String s){
  char[] chars = s.toCharArray();
  Arrays.sort(chars);
  return new String(chars);
}

/*
  ============================================================
  Another way to do it is to check if two strings have identical
  character counts.
  Time complexity: O(N)
  Space complexity: an array of 128 integers
  ============================================================
*/
public boolean checkPermutation(String s, String t){
  if(s.length()!=t.length()) return false;

  // assume we are using ASCII char sets
  int[] counts = new int[128];

  for(char c: s.toCharArray()){
    counts[c] += 1;
  }

  for(char c: t.toCharArray()){
    counts[c] -= 1;
    if(counts[c] < 0) return false;
  }

  // since we already know at this point, string s, t have the same length;
  // no negative values in the character counts; we can conclude that there
  // are no positive values as well. 
  return true;
}
