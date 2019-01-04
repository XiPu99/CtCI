/*
  5! = 1*2*3*4*5 = one zero due to 2*5;
  10! = two zeros
  15! = three zeros
  20! = four zeros
*/

/*
  Count factors of 5
*/

public int trailingZeroes(int n) {
  int result = 0;
  while(n>0){
    n /= 5;
    result += n;
  }
  return result;
}
