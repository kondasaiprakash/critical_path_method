public class CircularDependency extends Throwable
{
    public CircularDependency(String msg)
    {
        super(msg);
    }

    public CircularDependency()
    {
        super("there is circular dependency in the system");
    }
    
}