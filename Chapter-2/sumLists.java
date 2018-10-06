/*
  You have two numbers represented by a linked list, where each node contains
  a single digit. The digits are stored in reverse order, such that the 1's digit
  is at the head of the list. Write a function that adds the two numbers and
  returns the sum as linked list.
*/

/*
  Example:
    Input: (7->1->6) + (5->9->2) = 617 + 295 = 912
    Output: (2->1->9)
*/

public ListNode sumList(ListNode l1, ListNode l2){
  ListNode result = new ListNode(0);
  ListNode current = result;
  int carry = 0;

  while(l1!=null || l2!=null || carry!=0){
    int one = 0;
    int two = 0;

    if(l1!=null){
      one = l1.val;
      l1 = l1.next;
    }

    if(l2!=null){
      two = l2.val;
      l2 = l2.next;
    }

    int sum = one + two + carry;

    if(sum > 9){
      carry = 1;
      sum = sum % 10;
    }
    else{
      carry = 0;
    }

    current.next = new ListNode(sum);
    current = current.next;
  }

  current.next = null;
  return result.next;

}

/*
  A recursive approach
*/
public ListNode sumList2(ListNode l1, ListNode l2){
  return addList(l1, l2, 0);
}

public ListNode addList(ListNode l1, ListNode l2, int carry){
  if(l1==null&&l2==null&&carry==0){
    return null;
  }

  int one = 0;
  int two = 0;

  if(l1!=null){
    one = l1.val;
  }

  if(l2!=null){
    two = l2.val;
  }

  int sum = one + two + carry;
  ListNode current = new ListNode(sum % 10);
  ListNode node = addList(l1==null?null:l1.next, l2==null?null:l2.next, sum>9?1:0);
  current.next = node;
  return current;
}


/*
  FOLLOW-UP: Suppose the digits are stored in forward order.
*/
