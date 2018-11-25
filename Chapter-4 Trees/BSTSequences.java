public ArrayList<LinkedList<Integer>> allSequences(TreeNode root){
    ArrayList<LinkedList<Integer>> result = new ArrayList<>();
    if(root==null){
        LinkedList<Integer> list = new LinkedList<>();
        result.add(list);
        return result;
    }

    LinkedList<Integer> prefix = new LinkedList<>();
    prefix.add(root.val);
    ArrayList<LinkedList<Integer>> left = allSequences(root.left);
    ArrayList<LinkedList<Integer>> right = allSequences(root.right);
    for(LinkedList<Integer> l: left){
        for(LinkedList<Integer> r: right){
            weaveList(l, r, result, prefix);
        }
    }
    return result;
}

public void weaveList(LinkedList<Integer> first, LinkedList<Integer> second,
                      ArrayList<LinkedList<Integer>> result, LinkedList<Integer> prefix){

    if(first.isEmpty()||second.isEmpty()){
        LinkedList<Integer> list = new LinkedList<>(prefix);
        if(first.isEmpty()){
            list.addAll(second);
        }
        else{
            list.addAll(first);
        }
        result.add(list);
        return;
    }

    prefix.add(first.removeFirst());
    weaveList(first, second, result, prefix);
    first.addFirst(prefix.removeLast()); // recover first
    prefix.add(second.removeFirst());
    weaveList(first, second, result, prefix);
    second.addFirst(prefix.removeLast());
}
