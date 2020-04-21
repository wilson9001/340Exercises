import java.util.Date;

public class Part1ScheduledProxy implements Part1ScheduledInterface
{
    private int startOfWorkWeek = 1;
    private int endOfWorkWeek = 5;
    private int startOfWorkHours = 9;
    private int endOfWorkHours = 17;
    private Part1Part1ScheduledClass part1ScheduledClass;

    public Part1ScheduledProxy()
    {
        part1ScheduledClass = new Part1Part1ScheduledClass();
    }

    public void printAtWork() throws Exception
    {
        Date currentDate = new Date();
        if (currentDate.getDay() < startOfWorkWeek || currentDate.getDay() > endOfWorkWeek || currentDate.getHours() < startOfWorkHours || currentDate.getHours() > endOfWorkHours)
        {
            throw new Exception();
        }

        part1ScheduledClass.printAtWork();
    }

    public void printOffWork() throws Exception
    {
        Date currentDate = new Date();
        if (currentDate.getDay() > startOfWorkWeek && currentDate.getDay() < endOfWorkWeek && currentDate.getHours() > startOfWorkHours && currentDate.getHours() < endOfWorkHours)
        {
            throw new Exception();
        }

        part1ScheduledClass.printOffWork();

    }
}
