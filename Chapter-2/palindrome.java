/*
  Implement a function to check if a linked list is a palindrome
*/

/*
  ===========================================================
  Approach 1: compare with the list's reversed version
  to see if they are equal (Note: you actually only
  need to compare the first half of two lists as if they
  are the same, these two lists are guaranteed to be the
  same. However, this will require us to know the length of
  the linked list
  ===========================================================
*/
public boolean isPalindrome(ListNode head){
  return isIdentical(head, reverse(head));
}

/*
  There are more than one way to reverse linked list.
  The below one is a iterative approach. You can see
  details of other two methods in the reverse.java
  under this folder.
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


/*
  =================================================================
  Approach 2: Using a stack to compare first half and second half of
  the linked list.
  We use the two-runners approach. The fast runner pointer traverse
  two node at a time and the slower one traverse one node at a time.
  As we traverse, we push the value of slow runner pointer to a stack.
  =================================================================
*/
public boolean isPalindromeStack(ListNode head){
  ListNode fast = head;
  ListNode slow = head;
  Stack<Integer> stack = new Stack<>();

  while(fast!=null&&fast.next!=null){
    fast = fast.next.next;
    stack.push(slow.info);
    slow = slow.next;
  }

  // handle the case when the length of the list is odd
  if(fast!=null){
    slow = slow.next;
  }

  while(slow!=null){
    if(slow.info!=stack.pop()){
      return false;
    }
    slow = slow.next;
  }

  return true;
}

/*
  =================================================================
  Approach 3: Recursive.
  Because Java does not support return multiple variables types,
  we create a class called Result to store a boolean and a node.
  =================================================================
*/
class Result{
  ListNode node;
  boolean result;
  Result(ListNode node, boolean result){
      this.node = node;
      this.result = result;
  }
}

public boolean isPalindrome(ListNode head){
  int length = len(head);
  Result r = recurse(head, length);
  return r.result;
}

public Result recurse(ListNode head, int length){
  if(length==0){
    return new Result(head, true);
  }
  else if(length==1){
    return new Result(head.next, true);
  }
  Result after = recurse(head.next, length-2);
  if(after.result==false){
      return after;
  }

  if(head.val==after.node.val){
    return new Result(after.node.next, true);
  }
  else{
    return new Result(after.node.next, false);
  }
}

public int len(ListNode head){
  int length = 0;
  while(head!=null){
    length++;
    head = head.next;
  }
  return length;
}
