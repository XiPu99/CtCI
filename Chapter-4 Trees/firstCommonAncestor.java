/*
  Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
  Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a BST.
  (IMPORTANT ASSUMPTION: assume the two nodes exist in the binary tree)
*/

/*
==================================================================================
  Approach one: Very inefficient solution
==================================================================================
*/
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null) return null;
    if(root==p||root==q) return root;
    boolean leftp = findNode(root.left, p);
    boolean leftq = findNode(root.left, q);

    if(leftp&&leftq) return lowestCommonAncestor(root.left, p, q);
    else if(!leftp&&!leftq) return lowestCommonAncestor(root.right, p, q);
    else return root;
}

public boolean findNode(TreeNode root, TreeNode p){
    if(root==p) return true;
    if(root==null) return false;

    return findNode(root.left, p)||findNode(root.right, p);
}

/*
==================================================================================
  Approach two: A more efficient algorithm after removing duplicated work
==================================================================================
*/
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null) return null;
    if(root==p||root==q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if(left==null&&right==null){
        return null;
    }
    else if(left!=null&&right!=null){
        return root;
    }
    else{
        return left!=null?left:right;
    }
}
