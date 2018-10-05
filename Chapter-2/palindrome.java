/*
  Implement a function to check if a linked list is a palindrome
*/

public boolean isPalindrome(ListNode head){
  return isIdentical(head, reverse(head));
}

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

public boolean isIdentical(ListNode l1, ListNode l2){
  while(l1!=null&&l2!=null){
    if(l1.info!=l2.info){
      return false;
    }
    l1 = l1.next;
    l2 = l2.next;
  }
  return l1==null&&l2==null;
}
