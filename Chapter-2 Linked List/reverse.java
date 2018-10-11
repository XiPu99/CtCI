/*
  Reverse a linked list
*/

/*
  Iterative approach
*/
public ListNode reverse(ListNode head){
  ListNode previous = null;
  while(head!=null){
    ListNode next = head.next;
    head.next = previous;
    previous = head;
    head = next;
  }
  return previous;
}

/*
  A recursive version: idea is basically the same as the iterative version
*/
public ListNode recursiveReverse1(ListNode head, ListNode previous){
  if(head==null){
    return previous;
  }
  ListNode next = head.next;
  head.next = previous;
  previous = head;
  return recursiveReverse1(next, previous);
}

/*
  Another recursive approach
*/

public ListNode recursiveReverse(ListNode head){
  if(head.next==null){
    return head;
  }
  ListNode rest = recursiveReverse(head.next);
  head.next.next = head;
  head.next = null; // without this line, there will be a loop between the first and second element
  return rest;
}
