public boolean isUnique(String s){
	// assume ASCII char sets
	if(s.length()>128) return false;
	boolean[] map = new boolean[126];

	for(int i = 0; i < s.length(); i++){
		char c = s.charAt(i);
		if(map[c]) return false;
		else map[c] = true;
	}

	return true;
}

// another way to do it with a bit vector
public boolean isUniqueWithBit(String s) {
	// assume that string s only contains letters so that
	// a 32-bit integer is enough to cover all cases
	int bitV = 0;
	String ls = s.toLowerCase();
	for(int i = 0; i < ls.length(); i++) {
		int bit = ls.charAt(i) - 'a';
		if( (bitV & (1<<bit)) == 0){
				// set the bit to 1
				bitV |= (1<<bit);
		}
		else return false;
	}

	return true;
}
