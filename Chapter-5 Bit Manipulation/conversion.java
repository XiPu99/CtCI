public int convert(int a, int b){
  int count = 0;
  for(int c = a^b; c!=0; c = c>>>1){
    count += c&1;
  }
  return count;
}

public int convertAlt(int a, int b){
  int count = 0;
  for(int c = a^b; c!=0; c = c&(c-1)){
    count++;
  }
  return count;
}
