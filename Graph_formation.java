import java.util.ArrayList;
import java.util.*;

public class Graph_formation
{
    List<Node> root;
    List<Node> end_root;
    public Graph_formation()
    {
        root = new ArrayList<Node>();
        end_root = new ArrayList<Node>();
    }
    public void graph_design()
    {
        // Graph_formation graph = new Graph_formation();
        int size = Node.details.size();
        for(int i = 0; i < size; i++)
        {
            Node one = Node.details.get(i);
            if(one.dependency_names.size() == 0)
            {
                this.root.add(one);
            }
            
            for(int j= 0; j < one.dependency_names.size(); j++)
            {
                // System.out.println(one.dependency_names.get(j));
                Node x = one.get_node_by_name(one.dependency_names.get(j));
                // System.out.println(j+ "  " + x + " "+ i);
                
                one.parent_list.add(x);
                x.child_list.add(one);
                
            }
        }
        for(int i = 0; i < size; i++)
        {
            if(Node.details.get(i).child_list.size() == 0)
            {
                this.end_root.add(Node.details.get(i));
            }
        }
    }

    public void early_times_calculator(Node x)
    {
        int size = x.parent_list.size();
        int temp = 0;
        for(int i = 0; i < size; i++ )
        {
            Node parent = x.parent_list.get(i);
            int ef = parent.early_finish;
            if(temp < ef)
            {
                temp = ef;
            }

        }
        x.early_start = temp;
        x.early_finish = temp + x.duration;
        x.checked = 1;
    }

    public void latest_times_calculator(Node x, int project_dead_line)
    {
        if(x.child_list.size() == 0)
        {
            x.latest_finish = project_dead_line;
            x.latest_start = project_dead_line - x.duration;
            x.slag_time = x.latest_start - x.early_start;
        }
        else
        {
            int size = x.child_list.size();
            int temp = project_dead_line + 1;
            for(int i = 0; i < size; i++ )
            {
                Node child = x.child_list.get(i);
                int es = child.latest_start;
                if(temp > es)
                {
                    temp = es;
                }
                
            }
            System.out.println(project_dead_line + "  "+ temp);
            x.latest_finish = temp;
            x.latest_start = temp - x.duration;
            x.slag_time = x.latest_start - x.early_start;
        }
        x.checked = 0;
    }
}