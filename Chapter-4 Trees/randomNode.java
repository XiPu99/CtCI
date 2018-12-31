/*
  You are implementing a binary tree class from scratch which, in addition to
  insert, find and delete, has a method getRandomNode() which returns a random
  node from the tree. All nodes should be equally likely to be chosen. Design
  and implement an algorithm for getRandomNode, and explain how you would
  implement the rest of the methods.

  Hint: #42, #54, #62, #75, #89, #99, #112, #119
*/

/*
=============================================
  Approach one: we can use in order traversal
  to put all nodes into an array. Then, based
  on the size of this array, let's say it's n
  we can then generate a random number between
  0 and n-1 (inclusive) to achieve randomness.
=============================================
*/


/*
===============================================
  Approahc two: assume that there are n nodes
  in the binary tree, then we just need
===============================================
*/

class Tree{
  TreeNode root = null;

  public TreeNode getRandomNode(){
    if(root==null) return null;
    Random random = new Random();
    int i = random.nextInt(root.size());
    return root.getIthNode(i);
  }

}

class TreeNode{
  private int data;
  public TreeNode left;
  public TreeNode right;
  private int size = 0; // number of children, including the current node

  public int size(){
    return size;
  }

  public TreeNode getIthNode(int i){
    int leftSize = left==null?0:left.size();

    if(i<leftSize){
      // go to left branch
      return left.getIthNode(i);
    }
    else if(i==leftSize){
      // choose current node
      return this;
    }
    else{
      // go to right branch(we need to adjust the local index)
      return right.getIthNode(i-(leftSize+1));
    }
  }
}
