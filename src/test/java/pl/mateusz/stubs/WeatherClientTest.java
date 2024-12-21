package pl.mateusz.stubs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherClientTest {

    @Test
    void getWeatherReportForValidCity() {

        WeatherClient weatherClient = new WeatherClient(new WeatherServiceStub());

        String report = weatherClient.getWeatherReport("Warszawa");
        assertEquals("Temperatura w Warszawa wynosi: 15.0C", report);
    }

    @Test
    void getWeatherReportForInvalidCity() {
        WeatherClient weatherClient = new WeatherClient(new WeatherServiceStub());

        String report = weatherClient.getWeatherReport("Kielce");
        assertEquals("Podano nieprawidłowe miasto", report);
    }


}