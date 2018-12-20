
/*
===================================================
  O(Nlog(N)) solution
===================================================
*/

public int pathSum(TreeNode root, int sum) {
    if(root==null) return 0;

    int count = helper(root, 0, sum);

    count+=pathSum(root.left, sum);
    count+=pathSum(root.right, sum);

    return count;
}

public int helper(TreeNode root, int runningSum, int sum){
    if(root==null) return 0;

    int count = 0;
    runningSum+=root.val;
    if(runningSum==sum) count++;

    count+=helper(root.left, runningSum, sum);
    count+=helper(root.right, runningSum, sum);

    return count;
}



/*
===================================================
  O(N) solution
===================================================
*/

public int pathSum(TreeNode root, int sum) {
    return helper(root, new HashMap<Integer, Integer>(), 0, sum);
}

public int helper(TreeNode root, HashMap<Integer, Integer> map, int runningSum, int targetSum){
    if(root==null) return 0;

    runningSum+=root.val;
    int count = 0;
    count+=map.getOrDefault(runningSum-targetSum, 0);
    if(runningSum==targetSum) count++;

    updateMap(map, runningSum, 1);
    count+=helper(root.left, map, runningSum, targetSum);
    count+=helper(root.right, map, runningSum, targetSum);
    updateMap(map, runningSum, -1);

    return count;

}

public void updateMap(HashMap<Integer, Integer> map, int runningSum, int delta){
    int oldVal = map.getOrDefault(runningSum, 0);
    map.put(runningSum, oldVal+delta);
}
