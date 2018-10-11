/*
  Delete a node in the middle of a singly linked list,
  given access to that node
*/

public void deleteMiddleNode(ListNode node){
  if(node==null||node.next==null) return;
  node.info = node.next.info;
  node.next = node.next.next;
}
