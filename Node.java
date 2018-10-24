import java.util.ArrayList;
import java.util.*;

public class Node
{
    int node_id;
    String node_name;
    List<String> dependency_names;
    int duration;
    int checked;
    static List<Node> details = new ArrayList<Node>();
    List<Node> child_list;
    List<Node> parent_list;
    int early_start;
    int early_finish;
    int latest_start;
    int latest_finish;
    int slag_time;

    public Node (int node_id, String node_name, int duration, List<String> dependencies)
    {
        this.node_id = node_id;
        this.node_name = node_name;
        this.duration = duration;
        dependency_names = new ArrayList<String>();
        this.dependency_names = dependencies;
        this.early_finish = 0;
        this.early_start = 0;
        this.latest_finish = 0;
        this.latest_start = 0;
        this.slag_time = 0;
        child_list = new ArrayList<Node>();
        parent_list = new ArrayList<Node>();

        details.add(this);

    }


    public Node get_node_by_id(int node_id)
    {
        return details.get(node_id);
    }

    public Node get_node_by_name(String name)
    {
        Node x = null;
        for(int i = 0; i < details.size(); i++)
        {
            if(details.get(i).node_name.equals(name))
            {
                x = details.get(i);
            }
        }
        return x;
    }

    public static void print_answer()
    {

        System.out.printf("|%15s |%15s |%15s |%15s |%15s |%15s|\n","process name","early start","early finish","latest start","latest finish","slag time");

        for(int i = 0; i < details.size(); i++)
        {
            Node x = details.get(i);
            System.out.printf("|%15s |%15d |%15d |%15d |%15d |%15d|\n",x.node_name,x.early_start,x.early_finish,x.latest_start,x.latest_finish,x.slag_time);
        }
    }

    public static void critical_paths(Node m,String path)
    {
        int verify =0;
        if(m.slag_time == 0)
        {
            // System.out.println(path);
            path = path + " -> "+ m.node_name;
            // System.out.println(path);
            verify = 1;
        }
        if(verify == 1)
        {
            if(m.child_list.size() == 0)
            {
                System.out.println(path);
            }
            for(int i = 0; i < m.child_list.size(); i++)
            {
                // System.out.println(path);
                critical_paths(m.child_list.get(i), path);
            }
        }

    }




    
}