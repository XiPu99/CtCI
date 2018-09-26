/*
  Check whether string s2 is a rotation of string s1.
  Assume we have a method called isSubstring that check
  if one word is a substring of another.
  CONSTRAINT: We can only call isSubstring once.
*/

public boolean isRotation(String s1, String s2){
  int len = s1.length();
  for(len==s2.length()){
    return isSubstring(s1, s2+s2);
  }
  return false;
}
