/*
  Partition a linked list around a value x, such that all nodes less than
  x come before all nodes greater than or equal to x.
*/

/*
  =================================================
  Stable version (elements stay in original orders)
  Idea: Create two linked lists, one with every node
  smaller than x and another one with nodes larger
  than or equal to x. Finally, merge these two lists
  =================================================
*/
public ListNode partition(ListNode head, int x){

  ListNode small = new ListNode(0);
  ListNode large = new ListNode(0);
  ListNode smallHead = small;
  ListNode largeHead = large;

  while(head!=null){
    if(head.info<x){
      small.next = new ListNode(head.info);
      small = small.next;
    }
    else{
      large.next = new ListNode(head.info);
      large = large.next;
    }
    head = head.next;
  }

  // merge two lists
  small.next = largeHead.next;
  return smallHead.next;
}

/*
  Anthoer solution. It's not stable and not as straightforward as the first version.
  I spent quite some time figuring out why this code works.
*/

/*
  To be honest, i think the explanation on the ctci is just garbage. And I am
  really curious about how this code actually works. So, I spent some time
  working through an example,

  Example: partition2(3->5->8->2->10, 5)

  start: head = 3->5->8->2->10
          tail = 3->5->8->2->10

  start the while loop(node=3->5->8->2->10 != null):
    next = 5->8->2->10
    node.info=3<5 (enter if statement):
      node.next = head
      head = node
      Results in:
        head = 3->3 (an infinite loop) NOTE: at first I missed the idea that head will be an loop after
        the two lines. I got confused because I thought head at this point will be 1->1->2->3. In this case,
        I missed the fact that node and head are POINTING to the EXACT SAME memory location. So, what
        node.next = head is essentially doing is that it's setting the next pointer to itself.
        same for tail = 3->3


  now: head = 3->3
       tail = 3->3
  second iteration of while loop(node=5->8->2->10 != null):
    next = 8->2->10
    node.info=5>=5 (enter else statement):
      tail.next = node
      tail = node
      results in:
        tail.next = node makes tail become 3->5->8->2->10. NOTE: I missed the idea that this line is
        also changing the head at the same time. So, head will be 3->5->8->2->10

        tail = node makes tail become 5->8->2->10.

   now: head = 3->5->8->2->10
        tail = 5->8->2->10
   third iteration of while loop(node=8->2->10 != null):
    next = 2->10
    node.info=8>=5 (enter else statement):
      tail.next = node
      tail = node
      results in:
        tail.next = node does not change the tail.

        tail = node makes tail become 8->2->10.


  now: head = 3->5->8->2->10
       tail = 8->2->10
  third iteration of while loop(node=2->10 != null):
   next = 10
   node.info=2<5 (enter if statement):
     node.next = head;
     head = node;
     results in:
       (node.next = head) makes node become 2->3->5->8->2(an infinite loop again).
        It makes tail become 8->2->3->5->8
       (head = node) makes head become 2->3->5->8->2

   now: head = 2->3->5->8->2
        tail = 8->2->3->5->8
   third iteration of while loop(node=10 != null):
    next = null
    node.info=10>5 (enter else statement):
      tail.next = node
      tail = node
      results in:
        (tail.next = node) makes tail become 8->10.
        It makes head become 2->3->5->8->10

        (tail = node makes) tail become 10.
*/

public ListNode partition2(ListNode node, int x){

  ListNode head = node;
  ListNode tail = node;

  while(node!=null){
    ListNode next = node.next;
    if(node.info<x){
      node.next = head; // this changes tail as well
      head = node;
    }
    else{
      tail.next = node; // this changes head as well
      tail = node;
    }
    node = next;
  }

  tail.next = null;
  return head;
}
