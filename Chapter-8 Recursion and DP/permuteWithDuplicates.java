/*
  Write a method to compute all permutations of a string whose
  characters are not necessarily unique. The list of permutations
  should not have duplicates.
*/

public List<String> permute(String s){
  List<String> result = new ArrayList<>();
  permute(result, getFreq(s), s.length(), "");
  return result;
}

public HashMap<Character, Integer> getFreq(String s){
  HashMap<Character, Integer> freq = new HashMap<>();
  for(int i = 0; i < s.length(); i++){
    char curr = s.charAt(i);
    if(!freq.containsKey(curr)){
      freq.put(curr, 0);
    }
    freq.put(curr, freq.get(curr)+1);
  }
  return freq;
}

public void permute(List<String> result, HashMap<Character, Integer> map, int length, String prefix){
  if(length==0){
    result.add(prefix);
    return;
  }

  for(Character c: map.keySet()){
    if(map.get(c)>0){
      map.put(c, map.get(c)-1);
      permute(result, map, length-1, prefix+c);
      map.put(c, map.get(c)+1);
    }
  }
}
