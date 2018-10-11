/*
  Given a circular linked list, implement an algorithm that returns
  the node at the beginning of the loop
*/

public ListNode loopDetect(ListNode head){
  // first step: determine if there is a loop in the linked list
  ListNode fast = head;
  ListNode slow = head;

  while(fast!=null&&fast.next!=null){
    fast = fast.next.next;
    slow = slow.next;
    if(fast==slow){
      break;
    }
  }

  // no loop is detected, return null
  if(fast==null||fast.next==null){
    return null;
  }

  fast = head;
  while(fast!=slow){
    fast = fast.next;
    slow = slow.next;
  }
  return fast;
}
