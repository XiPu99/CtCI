/*
  Perform basic string compression using the counts of repeated
  characters, eg. "aabcccccaaa" -> "a2b1c5a3". If the compressed
  string is not smaller than the original string, the method should
  return the original string.
*/


/*
  Using a string instead of a stringbuilder will result in a time
  complexity of O(p+k^2). p is the size of the input string s.
  k is the size of character sequence in the compressed string.
  It takes O(k^2) to concatenate a string of size k.
  Using a stringbuilder can avoid this problem.
*/
public String compress(String s){
  // use a string builder instead of a string
  StringBuilder compressed = new StringBuilder();
  char current = s.charAt(0);
  int streak = 1;

  for(int i = 1; i < s.length(); i++){
    if(s.charAt(i)!=current){
      compressed.append(current);
      compressed.append(streak);
      current = s.charAt(i);
      streak = 1;
    }
    else{
      streak++;
    }
  }
  // i forgot to add the following two lines at the end
  compressed.append(current);
	compressed.append(streak);

  return compressed.length()>=s.length() ? s : compressed.toString();

}

/*
  A more concise version of the first approach
*/
public String compress(String s) {
  StringBuilder compressed = new StringBuilder();
  int streak = 0;

  for(int i = 0; i < s.length(); i++) {
    streak++;
    if(((i+1)>=s.length())||(s.charAt(i)!=s.charAt(i+1))) {
      compressed.append(s.charAt(i));
      compressed.append(streak);
      streak = 0;
    }
  }
  return compressed.length()>=s.length() ? s : compressed.toString();
}
