/*
  Write an algorithm such that if an element in an M*N matrix is 0, its entire
  row and column are set to 0.

  [ 1  0  1 ]    [ 0 0 0 ]
  [ 0  1  0 ] -> [ 0 0 0 ]
  [ 1  1  1 ]    [ 0 0 1 ]

  [ 1  0  1 ]    [ 1 0 0 ]
  [ 0  1  0 ] -> [ 0 1 0 ]
  [ 1  1  1 ]    [ 1 1 1 ]
  
*/

/*
  Time complexity: O(MN)
  Space complexity: O(M+N)
*/

public void zeroMatrix(int[][] matrix){
  HashSet<Integer> row = new HashSet<>();
  HashSet<Integer> col = new HashSet<>();

  for(int r = 0; r < matrix.length; r++){
    for(int c = 0; c < matrix[0].length; c++){
      if(matrix[r][c]==0){
        row.add(r);
        col.add(c);
      }
    }
  }

  for(int r: row){
    for(int c = 0; c < matrix[0].length; c++){
      matrix[r][c] = 0;
    }
  }

  for(int c: col){
    for(int r = 0; r < matrix.length; r++){
      matrix[r][c] = 0;
    }
  }

}

/*
  A more space-efficient solution
*/
public void zeroMatrixSpaceEfficient(int[][] matrix){
  boolean fr = false;
  boolean fc = false;

  // check if first row contains 0
  for(int c = 0; c < matrix[0].length; c++){
    if(matrix[0][c]==0){
      fr = true;
      break;
    }
  }

  // check if first column contains 0
  for(int r = 0; r < matrix.length; r++){
    if(matrix[r][0]==0){
      fc = true;
      break;
    }
  }

  // check for the rest of the matrix except first row and first column
  for(int r = 1; r < matrix.length; r++){
    for(int c = 1; c < matrix[0].length; c++){
      if(matrix[r][c]==0){
        matrix[0][c] = 0;
        matrix[r][0] = 0;
      }
    }
  }

  // iterate through first row
  for(int c = 1; c < matrix[0].length; c++){
    if(matrix[0][c]==0){
      setColZero(matrix, c);
    }
  }

  // iterate through first col
  // Note: Be careful that here index starts from
  // one because we don't want to override the boolean
  // vector we store in the first row (same thing applies for first col)
  for(int r = 1; r < matrix.length; r++){
    if(matrix[r][0]==0){
      setRowZero(matrix, r);
    }
  }

  if(fr) setRowZero(matrix, 0);
  if(fc) setColZero(matrix, 0);
}

public void setColZero(int[][] matrix, int col){

  for(int r = 0 ; r < matrix.length; r++){
    matrix[r][col] = 0;
  }
}

public void setRowZero(int[][] matrix, int row){
  for(int c = 0; c < matrix[0].length; c++){
    matrix[row][c] = 0;
  }
}
