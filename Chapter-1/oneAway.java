/*
  One away: There are 3 types of edit that can be performed on strings:
  1. insert a char 2. remove a char 3. replace a cha.
  Given two strings, write a method to check if they are one edit(or zero edit) away
*/

/*
  example: pale, ple -> true
            pales, pale -> true
            pale, bale -> true
            pale, bake -> false
*/

public boolean isOneAway(String s, String t){
  // check zero edit away
  if(s.equals(t)) return true;
  else if(Math.abs(s.length()-t.length()) > 1) return false;

  if(s.length()==t.length()){
    return checkReplace(s, t);
  }
  // s, t differ in length by 1
  else{
    return s.length()<t.length()?checkInsert(s, t):checkInsert(t, s);
  }
}

public boolean checkReplace(String s, String t){
  int[] map = new int[256];
  boolean oneAway = false;

  for(int i = 0; i < s.length(); i++){
    map[s.charAt(i)]++;
  }

  for(int i = 0; i < t.length(); i++){
    map[t.charAt(i)]--;
    if(map[t.charAt(i)]<0){
      if(oneAway) return false;
      oneAway = true;
    }
  }
  return true;
}

// alternative way to check replacement
public boolean checkReplaceBetter(String s, String t){
  boolean oneAway = false;

  for(int i = 0; i < s.length(); i++){
    if(s.charAt(i)!=t.charAt(i)){
      if(oneAway) return false;
      oneAway = true;
    }
  }
  return true;
}

// string s is the shorter one
public boolean checkInsert(String s, String t){
  int[] map = new int[256];

  for(int i = 0; i < t.length(); i++){
    map[t.charAt(i)]++;
  }

  for(int i = 0; i < s.length(); i++){
    map[s.charAt(i)]--;
    if(map[s.charAt(i)]<0){
      return false;
    }
  }
  return true;
}

public boolean checkInsertBetter(String s, String t){

  int indexShort = 0;
  int indexLong = 0;

  while(indexShort<s.length()&&indexLong<t.length()){
    if(s.charAt(indexShort)!=t.charAt(indexLong)){
      if(indexShort!=indexLong) return false;
      indexLong++;
    }
    else{
      indexShort++;
      indexLong++;
    }
  }
  return true;
}
