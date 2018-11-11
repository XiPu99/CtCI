/*
  Eight Queens
*/

public void eightQueens(Integer[] columns, int row){
  if(row >= columns.length){
    for(int i = 0; i < columns.length; i++){
      System.out.println(columns[i]);
    }
    return;
  }

  for(int c = 0; c < columns.length; c++){
    if(validate(columns, row, c)){
      columns[row] = c;
      eightQueens(columns, row+1);
    }
  }
}

public boolean validate(Integer[] board, int row, int col){

  for(int r = 0; r < row; r++){
    // check columns
    int col2 = board[r];
    if(col==col2) return false;

    // check diagonal
    int colDistance = Math.abs(col-col2);
    int rowDistance = row-r;
    if(rowDistance == colDistance){
      return false;
    }
  }
  return true;
}

/*
  N-Queens: LeetCode(https://leetcode.com/problems/n-queens/description/)
*/

public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    List<String> placement = new ArrayList<>();
    // for(int i = 0; i < n; i++){
    //     placement.add(construct(n));
    // }
    placeQueens(result, 0, new Integer[n], placement);
    return result;
}

public void placeQueens(List<List<String>> result, int row, Integer[] columns, List<String> placement){
    if(row>=columns.length){
        result.add(placement);
        return;
    }

    for(int col = 0; col < columns.length; col++){
        if(validate(columns, row, col)){
            String s = construct(columns.length, col);
            columns[row] = col;
            placement.add(s);
            List<String> list = new ArrayList<>();
            list.addAll(placement);
            placeQueens(result, row+1, columns, list);
            placement.remove(row);
        }
    }
}


public boolean validate(Integer[] board, int row, int col){
  for(int r = 0; r < row; r++){
    // check columns
    int col2 = board[r];
    if(col==col2) return false;

    // check diagonal
    int colDistance = Math.abs(col-col2);
    int rowDistance = row-r;
    if(rowDistance == colDistance){
      return false;
    }
  }
  return true;
}


public String construct(int n, int qIndex){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
        if(i==qIndex){
            sb.append("Q");
        }
        else{
            sb.append(".");
        }

    }
    return sb.toString();
}
