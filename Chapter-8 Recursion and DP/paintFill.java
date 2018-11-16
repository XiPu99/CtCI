/*
  Implement the "paint fill" function that one might see.
  That is, given a screen(represented by a two-dimensional array of color),
  a point, and a new color, fill in the surrounding area until the color
  changes from the original color
*/

public void paintFill(int[][] image, int r, int c, int newColor){
  if(image[r][c]==newColor) return;
  else helper(image, r, c, image[r][c],newColor);
}

public void helper(int[][] image, int r, int c, int oldColor, int newColor){
  if(r<0||c<0||r>=image.length||c>=image[0].length){
    return;
  }

  if(image[r][c]==oldColor){
    image[r][c] = newColor;
    helper(image, r-1, c, oldColor, newColor);
    helper(image, r+1, c, oldColor, newColor);
    helper(image, r, c-1, oldColor, newColor);
    helper(image, r, c+1, oldColor, newColor);
  }
}
