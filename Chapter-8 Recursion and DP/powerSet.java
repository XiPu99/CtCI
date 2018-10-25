/*
  Write a method to return all subsets of a set
*/

/*
  Using normal recursion
*/

ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
  ArrayList<ArrayList<Integer>> allSubset;
  if(index>=set.size()){
    allSubset = new ArrayList<>();
    allSubset.add(new ArrayList<Integer>());
  }
  else{
    int curr = set.get(index);
    ArrayList<> after = getSubsets(set, index+1);
    for(ArrayList<Integer> list: after){
      list.add(curr);
      allSubset.add(list);
    }
    allSubset.addAll(after);
  }
  return allSubset;
}

/*
  Using backtracking
*/

public List<List<Integer>> getSubset(List<Integer> set){
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<Integer>(), 0, set);
    return result;
  }


public void backtrack(List<List<Integer>> result, List<Integer> numList, int start, List<Integer> set){
    result.add(new ArrayList(numList));
    for(int i = start; i < set.size(); i++){
      numList.add(set.get(i));
      backtrack(result, numList, i+1, set);
      numList.remove(numList.size()-1);
    }
  }
