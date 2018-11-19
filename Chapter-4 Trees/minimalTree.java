/*
  Given a sorted(increasing order) array with unique integer elements, write
  an algorithm to create a binary search tree with minimal height
  LeetCode:(https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/)
*/

public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length-1);
}

public TreeNode helper(int[] arr, int low, int up){
    if(low>up) return null;
    int mid = (low + up)/2;
    TreeNode root = new TreeNode(arr[mid]);
    root.left = helper(arr, low, mid-1);
    root.right = helper(arr, mid+1, up);
    return root;
}
