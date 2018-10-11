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

/*
  A iterative approach
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
  Example:     Input: (7->1->6) + (5->9->2) = 716 + 592 = 1308
               Output: 1->3->0->8

               Input: (7->1->6->4) + (5->9->2) = 7164 + 592 = 7756
               Output: 7->7->5->6

*/

/*
  NOTE: With the digits stored in forward order, we cannot add number on the run.
  In addition, we need to pass the carry forward instead of backward in this case
*/

class PartialSum{
  ListNode node;
  int carry;
  PartialSum(ListNode node, int carry){
    this.node = node;
    this.carry = carry;
  }
}

public ListNode addTwoNumbers(ListNode l1, ListNode l2){
  int length1 = len(l1);
  int length2 = len(l2);

  if(length1>length2){
    l2 = addPadding(l2, length1-length2);
  }
  else if(length2>length1){
    l1 = addPadding(l1, length2-length1);
  }

  PartialSum result = addList(l1, l2);

    if(result.carry!=0){
        ListNode head = new ListNode(result.carry);
        head.next = result.node;
        return head;
    }
    else{
        return result.node;
    }

}

public PartialSum addList(ListNode l1, ListNode l2){
  if(l1==null&&l2==null){
    return new PartialSum(null, 0);
  }

  // get the result for the rest of nodes until the end
  PartialSum after = addList(l1.next, l2.next);

  // get the sum for current digit
  int one = 0;
  int two = 0;
  if(l1!=null){
    one = l1.val;
  }
  if(l2!=null){
    two = l2.val;
  }
  int sum = one + two + after.carry;
  ListNode current = new ListNode(sum % 10);
  current.next = after.node;
  after.node = current;
  after.carry = sum>9?1:0;

  return after;
}

public int len(ListNode head){
  int length = 0;
  while(head!=null){
    length++;
    head = head.next;
  }
  return length;
}

public ListNode addPadding(ListNode head, int num){
  while(num>0){
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    head = newHead;
    num--;
  }
  return head;
}

public void printList(ListNode head) {
  while(head!=null){
    System.out.print(head.val+"->");
    head = head.next;
  }
  System.out.println();
}
