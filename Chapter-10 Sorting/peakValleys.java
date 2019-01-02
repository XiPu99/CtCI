/*
=========================================================================
  Approach one: first sort the array and then swap every other elements
  (at index 0, 2, 4 and so on)
=========================================================================
*/

/*
======================================================================
  Approach two: we actually don't need to sort the array first
  {for any three-nums sequence eg. (0,1,2), we can always swap the
  middle element with the max adjacent element to create a peak}. We
  can then perform the same operation on every other element in the
  array. 
======================================================================
*/
