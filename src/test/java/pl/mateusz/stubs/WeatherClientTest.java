package pl.mateusz.stubs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    void getWeatherReportUsingMock() {

        WeatherService weatherService = mock(WeatherService.class);
        when(weatherService.getCurrentTemperature("Warszawa")).thenReturn(15.0);
        when(weatherService.getCurrentTemperature("Kraków")).thenReturn(16.0);
        when(weatherService.getCurrentTemperature("New York")).thenReturn(null);


        WeatherClient weatherClient = new WeatherClient(weatherService);


        assertAll(
                () -> {
                    assertEquals("Temperatura w Warszawa wynosi: 15.0C", weatherClient.getWeatherReport("Warszawa"));
                    verify(weatherService).getCurrentTemperature("Warszawa");
                },
                () -> {
                    assertEquals("Temperatura w Kraków wynosi: 16.0C", weatherClient.getWeatherReport("Kraków"));
                    verify(weatherService).getCurrentTemperature("Kraków");
                },
                () -> {
                    assertEquals("Podano nieprawidłowe miasto", weatherClient.getWeatherReport("New York"));
                    verify(weatherService).getCurrentTemperature("New York");
                }


                );

    }




}