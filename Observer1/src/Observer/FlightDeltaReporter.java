package Observer;

public class FlightDeltaReporter implements Observer
{

    private FlightFeed feed;
    private Flight oldFlightData;

    public FlightDeltaReporter(FlightFeed feed)
    {
        this.feed = feed;
        this.oldFlightData = feed.getFlight().clone();
    }

    public void update()
    {
        Flight newFlight = feed.getFlight().clone();

        if (newFlight != null)
        {
            System.out.println(String.format("Δ:\nLongitude: %f\nLatitude %f\nVelocity: %f\nAltitude: %f",
                    oldFlightData.longitude - newFlight.longitude,
                    oldFlightData.latitude - newFlight.latitude,
                    oldFlightData.velocity - newFlight.velocity,
                    oldFlightData.geo_altitude - newFlight.geo_altitude));

            oldFlightData = newFlight;
        }
    }
}
