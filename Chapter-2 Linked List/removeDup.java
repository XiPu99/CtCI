/*
  Remove duplicates in an unsorted linkedlist
*/

/*
  A space complexity of O(N) and time complexity of O(N) using HashSet
*/

public void removeDup(ListNode head){
    HashSet<Integer> set = new HashSet<>();
    ListNode previous = head;

    while(head!=null){
      if(!set.contains(head.info)){
        set.add(head.info);
        previous = head;
      }
      else{
        previous.next = head.next;
      }
      head = head.next;
    }

  }


/*
  An space complexity O(1) solution with time complexity of O(N^2)
*/

public void removeDupWithoutBuffer(ListNode head){

  while(first!=null){
    ListNode previous = first;
    ListNode second = first.next;
    while(second!=null){
      if(second.info==first.info){
        previous.next = second.next;
      }
      else{
        previous = second;
      }
      second = second.next;
    }
    first = first.next;
  }
}
