/*
  Given two singly linked lists, determine if the two lists intersect.
  Return the intersecting node.

  1 -> 2 -> 3 -> 4 -> 5 -> 6
            ^
            |
  3 -> 4 ---
*/

class Result{
  ListNode tail;
  int size;
  Result(ListNode tail, int size){
    this.tail = tail;
    this.size = size;
  }
}

public ListNode intersect(ListNode l1, ListNode l2){
  int len1 = len(l1);
  int len2 = len(l2);

  Result one = getTailNodeAndSize(l1);
  Result two = getTailNodeAndSize(l2);

  // check if there is intersection
  if(one.tail!=two.tail){
    return null;
  }

  if(one.size>two.size){
    l1 = advance(l1, one.size-two.size);
  }
  else if(len2>len1){
    l2 = advance(l2, two.size-one.size);
  }

  while(l1!=l2){
    l1 = l1.next;
    l2 = l2.next;
  }

  return l1;
}

// get the last node and length of the linked list
public Result getTailNodeAndSize(ListNode head){
  int len = 1;

  while(head.next!=null){
    head = head.next;
    len++;
  }
  return new Result(head, len);
}

public ListNode advance(ListNode head, int i){
  while(i>0){
    head = head.next;
    i--;
  }
  return head;
}
