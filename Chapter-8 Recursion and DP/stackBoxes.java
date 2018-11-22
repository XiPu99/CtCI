/*
  Implement a method to compute the height of the tallest possible stack.
  The height of a stack is the sum of the heights of each box
*/

/*
======================================================================
  Approach one: Plain recursion
======================================================================
*/
public int createStack(ArrayList<Box> boxes){
  // sort any dimension of boxes in descending orders
  Collections.sort(boxes, new BoxComparator);
  int maxHeight = 0;

  for(int i = 0; i < boxes.size(); i++){
    int height = createStack(boxes, i);
    maxHeight = Math.max(height, maxHeight);
  }
  return maxHeight;
}

public int createStack(ArrayList<Box> boxes, int bottomIndex){
  Box bot = boxes.get(bottomIndex);
  int maxHeight = 0;

  for(int i = bottomIndex + 1; i < boxes.size();i++){
    int height = createStack(boxes, i);
    maxHeight = Math.max(height, maxHeight);
  }

  return bot.height+maxHeight;
}

/*
======================================================================
  Approach two: Recursion with DP
======================================================================
*/
public int createStack(ArrayList<Box> boxes){
  // sort any dimension of boxes in descending orders
  Collections.sort(boxes, new BoxComparator);
  int maxHeight = 0;
  int[] cache = new int[boxes.size()];

  for(int i = 0; i < boxes.size(); i++){
    int height = createStack(boxes, i, cache);
    maxHeight = Math.max(height, maxHeight);
  }
  return maxHeight;
}

public int createStack(ArrayList<Box> boxes, int bottomIndex, int[] cache){
  if(cache[bottomIndex]!=0){
    return cache[bottomIndex];
  }

  Box bot = boxes.get(bottomIndex);
  int maxHeight = 0;

  for(int i = bottomIndex + 1; i < boxes.size();i++){
    if(boxes.get(i).canBeAbove(bot)){
      int height = createStack(boxes, i, cache);
      maxHeight = Math.max(height, maxHeight);
    }
  }
  cache[bottomIndex] = bot.height+maxHeight;
  return cache[bottomIndex];
}

/*
======================================================================
  Approach three: Recursion with DP
======================================================================
*/

public int createStack(ArrayList<Box> boxes){
  Collections.sort(boxes, new BoxComparator());
  int[] cache = new int[boxes.size()];
  return createStack(boxes, )
}

public int createStack(ArrayList<Box> boxes, Box bottom, int index, int[] cache){
  if(index>=boxes.size()) return 0;

  Box current = boxes.get(index);
  int heightWith = 0;

  if(bottom==null||current.canBeAbove(bottom)){
    if(cache[index]==0){
      cache[index] = createStack(boxes, current, index+1, cache);
      cache[index] += current.height;
    }
    heightWith = cache[index];
  }

  int heightWithout = createStack(boxes, bottom, index+1, cache);
  return Math.max(heightWith, heightWithout);
}
