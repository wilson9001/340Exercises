public class Part1Test
{
    public static void main(String[] args)
    {
        Part1ScheduledProxy scheduledProxy = new Part1ScheduledProxy();

        try
        {
            scheduledProxy.printAtWork();
        }
        catch (Exception exc)
        {
            System.out.println("Failed to print at work");
        }

        try
        {
            scheduledProxy.printOffWork();
        }
        catch (Exception ex)
        {
            System.out.println("Failed to print off work");
        }
    }
}
