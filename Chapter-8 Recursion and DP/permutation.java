/*
  Write a method to compute all permutation of a string of unique chars
*/

/*
=========================================================================
  Approach 1: eg. permute("abcd"), start with "d", insert "c" to every
  possible location, in this case, the front or the end to generate "cd"
  and "dc". Do the same thing with ("cd", "dc") and "b", now there are
  three places you can insert "b" in and the resulting permutations will
  be ("bcd", "cbd" and "cdb") and ("bdc", "dbc", "dcb").
=========================================================================
*/

public List<String> permute(String s){
  List<String> ret = new ArrayList<>();
  if(s.length()==0){
    result.add("");
    return ret;
  }
  else if(s.length()==1){
    ret.add(s);
    return ret;
  }
  char first = s.charAt(0);
  List<String> perms = permute(s.subString(1))
  for(String s: perms){
    for(int i = 0; i <= s.length(); i++){
      ret.add(insertCharAt(s, first, i));
    }
  }
  return ret;
}

public String insertCharAt(String s, char cha, int k){
  String before = s.substring(0, k);
  String after = s.substring(k);
  return before + cha + after;
}

/*
========================================================================================
  Approach 2: eg. getPerms("abcd"): call getPerms("bcd"), append 'a' to the result
  of getPerms("bcd"); call getPerms("acd"), append 'b' to the result of getPerms("acd");
  call getPerms("abd"), append 'c' to the result of getPerms("abd"); call getperms("abc"),
  append 'd' to the result of getPerms("abc")
========================================================================================
*/
public List<String> getPerms(String s){
  List<String> result = new ArrayList<>();
  if(s.length()==0){
    result.add("");
    return result;
  }

  for(int i = 0; i < s.length(); i++){
    String before = s.substring(0, i);
    String after = s.substring(i+1);
    char current = s.charAt(i);

    List<String> perms = getPerms(before+after);
    for(String perm: perms){
      result.add(current+perm);
    }

  }

  return result;
}
