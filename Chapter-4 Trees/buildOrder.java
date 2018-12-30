/*
  You are given a list of projects and a list of dependencies(which is a list
  of pairs of projects, where the second project is dependent on the first
  project). All of a project's dependencies must be built before the project is.
  Find a build order that will allow the projects to be built. If there is no
  valid build order, return an error.

  Hints: #26, #47, #60, #85, #125, #133
*/

/*
===================================================================
  Approach one: Using topological sort.
  Idea: Using a directed graph and topological sort.
  If the graph has any cycle, then there is no valid build order.
  NOTE: for methods that are undefined, just assume that they are
  already implemented correctly(most of them are just simple helper
  methods that are not hard to implement)
===================================================================
*/

Project[] findBuildOrder(String[] projects, String[][] dependencies){
  Graph graph = buildGraph(projects, dependencies);
  return orderProjects(graph.getNodes());
}

public Project[] orderProjects(ArrayList<Project> projects){
  Project[] buildOrder = new Project[projects.size()];

  int endOfArr = addNonDependent(buildOrder, projects, 0);
  int toBeProcessed = 0;
  while(toBeProcessed<buildOrder.length){

    Project current = buildOrder[toBeProcessed];

    // we can't find a valid build order bacause there is
    // no node with zero dependencies
    if(current==null){
      return null;
    }

    ArrayList<Project> neighbors = current.getChildren();

    // remove outcoming edges
    for(Project p: neighbors){
      p.decreaseDependency();
    }

    endOfArr = addNonDependent(buildOrder, projects, endOfArr);
    toBeProcessed++;
  }

  return buildOrder;

}

int addNonDependent(Project[] order, ArrayList<Project> projects, int offset){
  for(Project project: projects){
    if(project.getNumberDependencies()==0){
      order[offset] = project;
      offset++;
    }
  }
  return offset;
}

/*
===================================================================
  Approach two: Using DFS.
  Idea: instead of figuring out what to build first, we used DFS
  on an arbitrary node in the graph to figure out what to build
  last.
===================================================================
*/

Stack<Project> findBuildOrder(String[] projects, String[][] dependencies){
  Graph graph = buildGraph(projects, dependencies);
  return orderProjects(graph.getNodes());
}

Stack<Project> orderProjects(ArrayList<Project> projects){
  Stack<Project> buildOrder = new Stack<>();
  for(Project p: projects){
    // we only visit the node that has not been visited before
    if(p.getState()==Project.State.BLANK){
      boolean result = doDFS(p, buildOrder);
      // there is a cycle in the graph and thus no valid build order
      if(!result) return null;
    }
  }
  return buildOrder;
}

boolean doDFS(Project project, Stack<Project> buildOrder){

  if(project.getState()==Project.State.PARTIAL){
    return false;
  }

  if(project.getState()==Project.State.BLANK){
    project.setState(Project.State.PARTIAL);

    ArrayList<Project> children = project.getChildren();
    for(Project p: children){
      boolean result = doDFS(p, buildOrder);
      if(!result) return false;
    }
    project.setState(Project.State.COMPLETE);
    buildOrder.push(project);
  }

  return true;
}
