/*
  Imagine a robot sitting on the upper left corner of grid with r rows
  and c columns. The robot cannot step on them. Design an algorithm to
  find a path for the robot from the top left to the bottom right.
*/

/*
======================================================================
  Approach one: At each grid, there will be two recursive calls,
  which will lead to some repetive calls
======================================================================
*/
public ArrayList<Point> getPath(boolean[][] maze){
  ArrayList<Point> path = new ArrayList<>();
  if(getPath(maze, maze.length-1, maze[0].length-1, path)){
    return path;
  }
  return null;
}

public boolean getPath(boolean[][] maze, int r, int c, ArrayList<Point> path){
  if(r < 0 || c < 0 || !maze[r][c]){
    return false;
  }

  boolean isAtOrigin = (r==0)&&(c==0);

  if(isAtOrigin || getPath(maze, r-1, c, path) || getPath(maze, r, c-1, path)){
    path.add(new Point(r, c));
    return true;
  }

  return false;
}

/*
======================================================================
  Approach two: Using dynamic programming to cache results in order
  to get rid of repetitive calls
======================================================================
*/
public ArrayList<Point> getPath(boolean[][] maze){
  ArrayList<Point> path = new ArrayList<>();
  HashSet<Point> failedPoints = new HashSet<>();
  if(getPath(maze, maze.length-1, maze[0].length-1, path, failedPoints)){
    return path;
  }
  return null;
}

public boolean getPath(boolean[][] maze, int r, int c, ArrayList<Point> path, HashSet<Point> failedPoints){
  if(r < 0 || c < 0 || !maze[r][c]){
    return false;
  }

  if(failedPoints.contains(new Point(r, c))){
    return false;
  }

  boolean isAtOrigin = (r==0)&&(c==0);

  if(isAtOrigin || getPath(maze, r-1, c, path, failedPoints) || getPath(maze, r, c-1, path, failedPoints)){
    path.add(new Point(r, c));
    return true;
  }

  failedPoints.add(new Point(r, c));
  return false;

}
