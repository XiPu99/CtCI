/*
  Explain what the following code does: ((n&(n-1)) == 0)
*/

/*
  Check to see if n is a power of 2
*/
public boolean isPowerOf2(int n){
  return (n&(n-1))==0;
}
