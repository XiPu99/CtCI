/*
  Implement an algorithm to print all valid (properly opened and closed)
  combinations of n pairs of parentheses
  LeetCode(https://leetcode.com/problems/generate-parentheses/)
*/

public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    helper(result, n, n, "");
    return result;
}

public void helper(List<String> result, int left, int right, String s){
  if(right<left || left<0){
    return;
  }
  else if(left==0&&right==0){
    result.add(s.toString());
    return;
  }
  helper(result, left-1, right, s+"(");
  helper(result, left, right-1, s+")");
}
