/*
  Assume each node has a pointer to its parent
*/
public TreeNode getNextNode(TreeNode node){
  if(node.right!=null){
    return getLeftMost(node.right);
  }
  else{
    return findParent(node);
  }
}

public TreeNode getLeftMost(TreeNode root){
  while(root.left!=null){
    root = root.left;
  }
  return root;
}

public TreeNode findParent(TreeNode child){
  TreeNode parent = child.parent;
  while(parent!=null&&parent.left!=child){
    child = parent;
    parent = parent.parent;
  }
  return parent;
}
