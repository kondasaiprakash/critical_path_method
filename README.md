# critical_path_method
this is an algorithm for finding critical path method in java 
---- EXPLANATION OF EACH FILE ----------
1. NODE.JAVA
    -- This file contains all the parameters you need to (give/calculate) to a process(means the task)
    -- eg (nodeid, name of the process, dependency names, early start, early finish, late start, late finish, .... etc)
    -- It also contains some general methods like get_node_by_id, get_node_by_name
    -- the other method is print answer(it prints the value of all parameters at the last)
    -- critical_paths method finds all the critical paths in the graph
    
    
 2. INPUT.JAVA
    -- This takes values from the user about the parameters in the above node(like duration, name , dependencies.. etc)
    
 3. GRAPH_FORMATION.JAVA
    -- Now you have given all the information about the process like dependencies
    -- This will form the graph using the provided information
    -- This also has two methods that will calculate early times and latest times
    
 4. FINAL.JAVA
    -- This is the driver program
    -- It also has two methods that faciliate to carry out robust calculations using forward and backward methods
    -- It can also handle circular dependencies in the given connections
   
 5. NoIndependentNodes.java
    -- This is custom exception class
    -- This will exit the program if there wil be no indenpendent nodes
    
 6 CircularDependency.java
    -- This is custom exception class
    -- This will infrom if there are any circular dependencies
  
  

  
 You can modify the program as you want if any help required you can connect me at 
 saisinner965158@gmail.com
 
