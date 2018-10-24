import java.util.*;
public class Input
{
    int no_of_nodes;
    public Input(int nodes)
    {
        this.no_of_nodes = nodes;

    }

    public void node_details()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the node input details : ");
        for(int i = 0; i < no_of_nodes; i++)
        {
            System.out.println("enter the details of the node  " + (i+1));
            
            System.out.println("enter the process_id : ");
            int x = scan.nextInt();
            System.out.println("enter the process_name : ");
            String name = scan.next();
            System.out.println("enter the process_duration : ");
            int dur = scan.nextInt();
            List<String> dependency  = new ArrayList<String>();
            System.out.println("enter the process_dependency_names : ");
            while(true)
            {
                System.out.println("enter dependency name : ");
                String depend = scan.next();
                if(depend.equals("null"))
                {
                    break;
                    
                }
                else
                {
                    dependency.add(depend);
                }
            }
            Node one = new Node(x,name,dur,dependency );
                 

        }

    }
}