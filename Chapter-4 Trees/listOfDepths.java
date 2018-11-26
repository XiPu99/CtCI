/*
  Given a binary tree, design an algorithm which creates a linked list of all
  the nodes at each depth(if you have a tree with depth D, you'll have D linked lists)
  LeetCode(https://leetcode.com/problems/binary-tree-level-order-traversal/description/)
*/

/*
====================================================================================
  Approach one: depth first search by preorder traversal
====================================================================================
*/

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    helper(root, 0, result);
    return result;
}

public void helper(TreeNode root, int depth, List<List<Integer>> result){
    if(root==null) return;

    if(result.size()==depth){
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
    }
    else{
        result.get(depth).add(root.val);
    }
    helper(root.left, depth+1, result);
    helper(root.right, depth+1, result);
}

/*
====================================================================================
  Approach two: breadth-first search
====================================================================================
*/
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<TreeNode> q = new LinkedList<TreeNode>();
    LinkedList<Integer> l = new LinkedList<>();
    if(root!=null){
        q.add(root);
        l.add(root.val);
        result.add(l);
    }

    while(!q.isEmpty()){
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        for(TreeNode t: q){
            if(t.left!=null) list.add(t.left);
            if(t.right!=null) list.add(t.right);
        }
        q = new LinkedList<>();
        q.addAll(list);
        List<Integer> currentLevel = new ArrayList<>();
        for(TreeNode t: list){
            currentLevel.add(t.val);
        }
        if(currentLevel.size()!=0){
            result.add(currentLevel);
        }       
    }
    return result;
}
