/*
  Given an arithmetic equation consisting of positive integers, +,-,* and / (no
  parentheses), compute the result
*/


/*
========================================================================
  Approach one: Using a stack
========================================================================
*/

public int calculate(String s){
  Stack<Integer> nums = new Stack<>();

  int num = 0;
  char sign = '+';
  for(int i = 0; i < s.length(); i++){
    char c = s.charAt(i);
    if(Character.isDigit(c)){
      num = num*10+c-'0';
    }
    if((!Character.isDigit(c)&&c!=' ')||i==s.length()-1){
      switch(sign){
        case '+':
          nums.push(num);
          break;
        case '-':
          nums.push(-num);
          break;
        case '*':
          nums.push(nums.pop()*num);
          break;
        case '/':
          nums.push(nums.pop()/num);
          break;
      }
      sign = c;
      num = 0;
    }
  }


  int result = 0;
  for(int i: nums){
    result+=i;
  }

  return result;

}
