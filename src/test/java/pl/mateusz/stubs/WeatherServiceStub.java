package pl.mateusz.stubs;

public class WeatherServiceStub implements WeatherService{
    @Override
    public Double getCurrentTemperature(String city) {
        return switch (city) {
            case "Warszawa" -> 15.0;
            case "Kraków" -> 16.0;
            default -> null;
        };
    }
}
