public interface Forecast {
    float TodaysTemperature();
    final class Fake implements Forecast{
        @Override
        public float TodaysTemperature(){return 10.66f;}
    }
}