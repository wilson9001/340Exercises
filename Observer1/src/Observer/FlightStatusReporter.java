package Observer;

public class FlightStatusReporter implements Observer
{
    FlightFeed feed;

    public FlightStatusReporter(FlightFeed feed)
    {
        this.feed = feed;

        update();
    }

    public void update()
    {
        Flight flight = feed.getFlight();

        if(flight != null)
        {
            System.out.println(flight.toString());
        }
        else
        {
            System.out.println("Flight Over");
        }
    }
}
