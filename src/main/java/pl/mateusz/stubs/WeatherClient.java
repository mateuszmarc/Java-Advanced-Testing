package pl.mateusz.stubs;

public class WeatherClient {

    private final WeatherService weatherService;

    public WeatherClient(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String getWeatherReport(String city) {
        Double temperature = weatherService.getCurrentTemperature(city);
        if (temperature == null) {
            return "Podano nieprawidłowe miasto";
        }
        return "Temperatura w " + city + " wynosi: " + temperature + "C";
    }
}
