/*
  My first wrong submission because I forgot to add offset.
  I think the reason for missing this is because I only consider
  the case for the first layer, in which the offset is 0. I should
  consider more general cases next time to avoid this problem.
*/

public void wrongRotate(int[][] image){
  for(int i = 0; i < image[0].length/2; i++){
    int bound = image[0].length - i - 1;
    for(int j = i; j < bound; j++){
      // save top
      int top = image[i][j];
      // left into top (I FORGOT TO PUT OFFSET HERE)
      image[i][j] = image[bound-j][i];
      // bottom into left (I FORGOT TO PUT OFFSET HERE)
      image[bound-j][i] = image[bound][bound-j];
      // right into bottom (I FORGOT TO PUT OFFSET HERE)
      image[bound][bound-j] = image[j][bound];
      // top into right
      image[j][bound] = top;
    }
  }
}

/*
  The correct version
*/
public void rotate(int[][] image){
  for(int i = 0; i < image[0].length/2; i++){
  int bound = image[0].length - i - 1;
  for(int j = i; j < bound; j++){
      // save top
      int top = image[i][j];
      // left into top (ADDING OFFSET MAKES IT CORRECT)
      image[i][j] = image[bound-j+i][i];
      // bottom into left (ADDING OFFSET MAKES IT CORRECT)
      image[bound-j+i][i] = image[bound][bound-j+i];
      // right into bottom (ADDING OFFSET MAKES IT CORRECT)
      image[bound][bound-j+i] = image[j][bound];
      // top into right
      image[j][bound] = top;
  }
}
