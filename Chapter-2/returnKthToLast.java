/*
  Implement an algorithm to find the kth to last element of a singly linked list
*/

/*
  Example: 1->2->3->4->5->null
  3rd to last element: 3->4->5
*/

/*
  This iterative version (I like this one better than the recursive version)
*/
public void returnKthToLast(ListNode head, int k){

  ListNode slow = head;
  ListNode fast = head;

  // make the fast points to the kth element in the linkedlist
  while(k>1){
    fast = fast.next;
    k--;
  }

  while(fast!=null){
    slow = slow.next;
    fast = fast.next;
  }

  while(slow!=null){
    System.out.print(slow.info + "->");
    slow = slow.next;
  }
}

/*
  Recursive version
*/

public int recursiveKthToLast(ListNode head, int k){

  // base case
  if(head==null){
    return 0;
  }

  int index = recursiveKthToLast(head.next, k) + 1;

  if(index==k){
    while(head!=null){
      System.out.print(head.info + "->");
      head = head.next;
    }
  }

  return index;
}
