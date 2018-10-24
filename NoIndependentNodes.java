public class NoIndependentNodes extends Exception
{
    public NoIndependentNodes(String msg)
    {
        super(msg);
    }

    public NoIndependentNodes()
    {
        super("this system has no independent nodes");
    }
}