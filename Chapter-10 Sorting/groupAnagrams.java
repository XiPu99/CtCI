/*
  Write a method to sort an array of strings so that all the anagrams
  are next to each other.
*/

public List<List<String>> groupAnagrams(String[] strs) {
  List<List<String>> result = new ArrayList<>();
  HashMap<String, List<String>> map = sort(strs);
  for(String s: map.keySet()){
    result.add(map.get(s));
  }
  return result;
}

public HashMap<String, List<String>> sort(String[] strs){
  HashMap<String, List<String>> map = new HashMap<>();

  for(int i = 0; i < strs.length; i++){
    String original = strs[i];
    char[] chars = original.toCharArray();
    Arrays.sort(chars);
    String sorted = new String(chars);
    if(!map.containsKey(sorted)){
      map.put(sorted, new ArrayList<String>());
    }
    map.get(sorted).add(original);
  }

  return map;
}
