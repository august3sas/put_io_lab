public class Program {
    public static void main(String[] args)
    {
        Forecast f1=new Forecast.Fake();
        Weather w1=new Weather(f1);
        System.out.println(w1.ActualTemperature());
        assert "10.67".equals(w1.ActualTemperature());
    }
}