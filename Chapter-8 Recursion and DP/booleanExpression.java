
/*
==========================================================================
  With memoizing
==========================================================================
*/

public int countEval(String s, boolean result){
    return countEval(s, result, new HashMap<>());
}

public int countEval(String s, boolean result, HashMap<String, Integer> cache){
    if(s.length()==0) return 0;
    if(s.length()==1) return stringToBool(s)==result?1:0;
    // did not realize that I can use (result + s) as the key for the hashmap, very clever
    if(cache.containsKey(result + s)) return cache.get(result + s);

    int numOfWays = 0;
    for(int i = 1; i < s.length(); i+=2){
        String left = s.substring(0, i);
        String right = s.substring(i+1);
        char operator = s.charAt(i);

        int leftTrue = countEval(left, true);
        int leftFalse = countEval(left, false);
        int rightTrue = countEval(right, true);
        int rightFalse = countEval(right, false);
        int total = (leftTrue+leftFalse)*(rightTrue+rightFalse);
        int totalTrue = 0;

        if(operator=='^') {
            totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
        }
        else if(operator=='|') {
            totalTrue = leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
        }
        else if(operator=='&'){
            totalTrue = leftTrue*rightTrue;
        }

        int ways = result?totalTrue:total-totalTrue;
        numOfWays += ways;

    }
    cache.put(result+s, numOfWays);
    return numOfWays;
}

public boolean stringToBool(String s){
    switch(s){
        case "1":
            return true;
        case "0":
            return false;

            default:
                return false;
    }
}
