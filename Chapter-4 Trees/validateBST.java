/*
  Implement a function to check if a binary tree is a binary search tree
  LeetCode(https://leetcode.com/problems/validate-binary-search-tree/description/)
*/

/*

*/

public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
}

public boolean helper(TreeNode root, Integer min, Integer max){
  if(root==null) return true;

  if(min!=null&&root.val<=min){
    return false;
  }
  else if(max!=null&&root.val>=max){
    return false;
  }

  return helper(root.left, min, root.val)&&helper(root.right, root.val, max);
}


/*
  
*/
