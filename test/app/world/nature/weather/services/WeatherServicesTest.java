package app.world.nature.weather.services;

import org.junit.Test;

/**
 * Created by HB .
 */
public class WeatherServicesTest {

    @Test
    public void testGetWeather_curDate() throws Exception {
        WeatherServices.getWeather_curDate("株洲");
    }

    @Test
    public void testGetWeathers() throws Exception {
        WeatherServices.getWeathers("株洲");
    }
}