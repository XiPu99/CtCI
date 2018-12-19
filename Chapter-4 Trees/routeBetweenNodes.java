/*
  Determine whether there is path between two nodes in a graph using
  breath first search
*/

public boolean findPath(Graph g, Node start, Node end){

  Queue<Node> queue = new LinkedList<>();
  Set<Node> visited = new HashSet<>();
  queue.add(start);
  visited.add(start);

  while(!queue.isEmpty()){
    Node curr = queue.removeFirst();
    for(Node node: curr.getAdjacent()){
      if(!visited.contains(node)){
        if(node==end) return true;
        queue.add(node);
        visited.add(node);
      }
    }
  }

  return false;
}
