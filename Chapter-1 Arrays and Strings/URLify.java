
/*
  My first-time WRONG ANSWER
*/

public String URLify(String s, int length){
  char[] chars = s.toCharArray();
  int index = length-1;

  // the condition check here is wrong, should be i >= 0 because
  // we want to go through every character
  for(int i = chars.length-1; i >= chars.length-1-length; i--){
    if(chars[index]!=' '){
      chars[i] = chars[index];
    }
    else{
      chars[i] = '0';
      i--;
      chars[i] = '2';
      i--;
      chars[i] = '%';
    }
    index--;
  }
  return new String(chars);
}

/*
  assume the char array we get just have the enough space to contain
  the URLified string
 */
public void URLify(char[] chars, int length){
    int index = length-1;

    for(int i = chars.length-1; i >= 0; i--){
      if(chars[index]!=' '){
        chars[i] = chars[index];
      }
      else{
        chars[i] = '0';
        chars[i-1] = '2';
        chars[i-2] = '%';
        i -= 2;
      }
      index--;
    }
}

/*
  assume the char array we get just have more than enough space
  to contain the URLified string
 */
public void URLifyWithMoreSpace(char[] chars, int length) {
  // count the number of spaces
  int count = 0;
  for(int i = 0; i < length; i++) {
    if(chars[i]==' ') count++;
  }

  int index = length + 2*count - 1;

  for(int i = length - 1; i>=0; i--) {
    if(chars[i]==' ') {
      chars[index] = '0';
      chars[index-1] = '2';
      chars[index-2] = '%';
      index -= 3;
    }
    else {
      chars[index] = chars[i];
      index--;
    }
  }
}
