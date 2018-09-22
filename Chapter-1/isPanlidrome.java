/*
  check if a string's permutation is panlidrome
*/

public boolean isPanlidrome(String s){
  int[] map = new int['z'-'a'+1];

  for(char c: s.toCharArray()){
    int x = getCharNum(c);
    if(x!=-1){
      map[x]++;
    }
  }
  return checkOdds(map);
}

public int getCharNum(char c){
  int a = Character.getNumericalValue('a');
  int z = Character.getNumericalValue('z');
  int val = Character.getNumericalValue(c);

  if(a <= val && val <= z){
    return val - a;
  }
  return -1;
}

public boolean checkOdds(int[] map){
  boolean haveOdds = false;
  for(int i = 0; i < map.length; i++){
    if(map[i]%2==1){
      if(haveOdds) return false;
      haveOdds = true;
    }
  }
  return true;
}

/*
  A more optimal approach based on the first one
*/
public boolean isPanlidromeOptimal(String s){
  int[] map = new int['z'-'a'+1];
  int count = 0;
  for(char c: s.toCharArray()){
    int x = getCharNum(c);
    if(x!=-1){
      map[x]++;
      if(map[x]%2==1) count++;
      else count--;
    }
  }
  return count<=1;
}

/*
  using a bit vector instead of an array
*/
public boolean isPanlidromeWithBit(String s){
  int bitV = 0;
  for(char c: s.toCharArray()){
    int x = getCharNum(c);
    bitV = invert(bitV, x);
  }
  return checkOne(bitV);
}

public int invert(int bitV, int bit){
  return bitV^(1<<bit);
}

// 0010000 -> 0001111
public boolean checkOne(int bitV){
  return (bitV&(bitV-1))==0;
}
