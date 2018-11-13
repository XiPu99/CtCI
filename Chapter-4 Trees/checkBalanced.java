/*
  Implement a function to check if a binary tree is balanced.
  For the purposes of this question, a balanced tree is
  defined to be a tree such that the heights of the two
  subtrees of any node never differ by more than one.
  LeetCode(https://leetcode.com/problems/balanced-binary-tree/description/)
*/

/*
========================================================
  Approach one: Inefficient with repetitive height()
  calls on the same node
========================================================
*/

public boolean isBalanced(TreeNode root){

  if(root==null) return true;
  int left = height(root.left);
  int right = height(root.right);
  if(Math.abs(left-right)>1) return false;

  return isBalanced(root.left)&&isBalanced(root.right);
}

public int height(TreeNode root){
  if(root==null) return 0;
  return Math.max(1+height(root.left), 1+height(root.right));
}

/*
========================================================
  Approach two: more efficient compared to approach one;
  compute the height while checking balance
========================================================
*/

public boolean isBalanced(TreeNode root){
  return checkHeight(root)!=Integer.MIN_VALUE;
}

public int checkHeight(TreeNode root){
  if(root==null) return 0;
  int left = checkHeight(root.left);
  if(left==Integer.MIN_VALUE) return Integer.MIN_VALUE;
  int right = checkHeight(root.right);
  if(right==Integer.MIN_VALUE) return Integer.MIN_VALUE;

  if(Math.abs(left-right) > 1){
    return Integer.MIN_VALUE;
  }
  else{
    return Math.max(left, right)+1;
  }
}
