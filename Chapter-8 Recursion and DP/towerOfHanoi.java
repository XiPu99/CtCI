/*
  Tower of Hanoi
*/

class Tower{
  private Stack<Integer> disks;
  private int index;
  public Tower(int i){
    disks = new Stack<>();
    index = i;
  }

  public int index(){
    return index;
  }

  public void add(int d){
    if(!disks.isEmpty() && disks.peek() <= d){
      System.out.println("Error placing disk " + d);
    }else{
      disks.push(d);
    }
  }

  public void moveTopTo(Tower t){
    int top = disks.pop();
    t.add(top);
  }

  // @param n: the number of disks
  public void moveDisks(int n, Tower destination, Tower buffer){
      if(n>=1){
        moveDisk(n-1, buffer, destination);
        moveTopTo(destination);
        buffer.moveDisk(n-1, destination, this);
      }
  }
}
