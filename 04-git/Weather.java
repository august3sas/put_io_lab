public class Weather {
    private Forecast upcoming;
    public float ActualTemperature()
    {
        return upcoming.TodaysTemperature();
    }
    public Weather(Forecast f)
    {
        this.upcoming=f;
    }
}