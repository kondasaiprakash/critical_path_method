import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class Final extends Throwable
{
    public static void main(String[] args)
    {
        Final f = new Final();
        System.out.println("enter the number of processes : ");
        Scanner scan = new Scanner(System.in);
        Input takeInput = new Input(scan.nextInt());
        takeInput.node_details();
        Graph_formation graph = new Graph_formation();
        System.out.println("reached here");
        graph.graph_design();
        System.out.println("reached here");
        f.forward(graph);
        f.backtrack(graph);
        Node.print_answer();
        f.cpf(graph);
        

        // Graph_formation graph = new 
    }
    public void forward(Graph_formation one)
    {
        Queue<Node> q = new LinkedList<Node>();
        System.out.println("in forward");
        for(int i = 0; i < one.root.size(); i++)
        {
            q.add(one.root.get(i));
            
        }
        System.out.println("in forward");
        try
        {
            System.out.println("in forward");
            System.out.println(one.root.size());
            if(one.root.size() == 0)
            {
                throw new NoIndependentNodes();

            }



        }
        catch(NoIndependentNodes exp)
        {
            System.out.println(exp.getMessage());
            System.exit(1);
        }
        int count = 0;
        while(q.size() != 0)
        {
            int verified = 0;
            Node x = q.remove();
            one.early_times_calculator(x);
            count++;
            for(int i = 0; i < x.child_list.size(); i++)
            {
                Node child = x.child_list.get(i);
                for(int k = 0; k < child.parent_list.size(); k++)
                {
                    Node parent = child.parent_list.get(k);
                    if(parent.checked != 1)
                    {
                        verified = 0;
                        break;
                    }
                    verified = 1;
                }
                if(verified != 0)
                {
                    q.add(child);
                }
            }
        }
        try
        {
         
            if(count < Node.details.size())
            {
                // System.out.println("this system as circular dependency in it");
                throw new CircularDependency();
            }
        }
        catch(CircularDependency exp)
        {
            System.out.println(exp.getMessage());
            System.exit(1);
        }
   

    }  

    public void backtrack(Graph_formation one)
    {
        Queue<Node> q = new LinkedList<Node>();
        int global_finish= 0;
        for(int i = 0; i < one.end_root.size(); i++)
        {
            q.add(one.end_root.get(i));
            // System.out.println(one.end_root.get(i).node_name);
            if(one.end_root.get(i).early_finish > global_finish)
            {
                global_finish = one.end_root.get(i).early_finish;
            }

        }
        // System.out.println(global_finish);
        while(q.size() != 0)
        {
            int verified = 0;
            Node x = q.remove();
            // System.out.println(x.node_name+ " "+ x.parent_list.get(0).node_name);
            one.latest_times_calculator(x, global_finish);
            for(int i = 0; i < x.parent_list.size(); i++)
            {
                Node parent = x.parent_list.get(i);
                // System.out.println(parent.node_name);
                for(int k = 0; k < parent.child_list.size(); k++)
                {
                    Node child = parent.child_list.get(k);
                    if(child.checked != 0)
                    {
                        verified = 0;
                        break;
                    }
                    verified = 1;
                }
                if(verified != 0)
                {
                    q.add(parent);
                    // System.out.println("added");
                }
            }


        }
    }

    public void cpf(Graph_formation one)
    {
        for(int i = 0; i < one.root.size(); i++)
        {
            Node.critical_paths(one.root.get(i), "");
        }
    }
     

}