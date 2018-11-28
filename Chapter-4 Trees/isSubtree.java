/*
========================================================
  Approach one: compare nodes recursively
========================================================
*/
public boolean isSubtree(TreeNode s, TreeNode t) {
    if(s==null) return false;
    if(isIdentical(s, t)) return true;

    return isSubtree(s.left, t)||isSubtree(s.right, t);
}

public boolean isIdentical(TreeNode t1, TreeNode t2){
    if(t1==null&&t2==null) return true;
    else if(t1==null||t2==null) return false;

    if(t1.val!=t2.val){
        return false;
    }

    return isIdentical(t1.left, t2.left)&&isIdentical(t1.right, t2.right);
}

/*
========================================================
  Approach two: Preorder traversal
========================================================
*/
public boolean isSubtree(TreeNode s, TreeNode t) {
    StringBuilder one = new StringBuilder();
    StringBuilder two = new StringBuilder();

    preorder(s, one);
    preorder(t, two);

    return one.indexOf(two.toString()) != -1;
}

public void preorder(TreeNode root, StringBuilder sb){
    if(root!=null){
        sb.append("#"+String.valueOf(root.val));
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
    else{
        sb.append("X");
        return;
    }
}
