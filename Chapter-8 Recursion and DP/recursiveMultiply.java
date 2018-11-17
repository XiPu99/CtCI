/*
  Write a recursive function to multiply two positive integers without using
  the * operator. You can use addition, subtraction, and bit shifting, but
  you should minimize the number of those operations.
*/

/*
=========================================================================
  Approach one: Recursive solution
=========================================================================
*/

public int recurseMult(int i, int j){
  if(i==1){
    return j;
  }

  int result = recurseMult(i/2, j);

  if(i%2==1){
    return result + result + j;
  }
  else{
    return result + result;
  }

}

/*
=========================================================================
  Approach two: Iterative solution
=========================================================================
*/

public int iterativeMult(int i, int j){
    int small = i < j ? i : j;
    int big = i >= j ? i : j;
    int numOfTwos = -1;
    int m = small;
    while(m != 0){
      m >>= 1;
      numOfTwos += 1;
    }

    int quo = small - (1<<numOfTwos);
    int leftover = 0;
    for(int k = 0; k < quo; k++){
      leftover += big;
    }

    int result = (big<<numOfTwos) + leftover;
    return result;
}
