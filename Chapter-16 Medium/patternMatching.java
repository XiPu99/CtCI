/*

  Hint: #631, #643, #653, #663, #685, #718, #727
*/

public boolean wordPattern(String pattern, String str) {

  // NOTE: only part of the code

  int firstAlt = pattern.indexOf(altChar);

  for (int mainSize = 0; mainSize <= maxMainSize; mainSize++) {
    int remainingLength = size - mainSize * countOfMain;
    String first = value.substring(0, mainSize);
    if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
      // determine what alternative is
      int altIndex = firstAlt*mainSize; // the main starts at index 0
      // have to handle the case when countOfAlt is 0
      int altLength = remainingLength/countOfAlt;
      String alt = value.substring(altIndex, altIndex+altLength);

    }

}
