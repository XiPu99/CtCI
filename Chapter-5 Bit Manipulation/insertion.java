/*
  Insert M into N such that M starts at bit j and ends at bit i.
  eg i = 2, j = 6, M = 10011, N = 10000000000
*/

public int insert(int n, int m, int j, int i){

  // clear bits in N from i to j using a bitmask
  int allOnes = ~0; // all one bits
  int right = (1<<i)-1;
  int left = allOnes<<(j+1);
  int mask = right|left;
  // clear bits
  int cleared = n & mask;
  int shifted = m<<i;

  return cleared|shifted;
}
