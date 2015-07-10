package app.world.nature.weather.services;

import org.junit.Test;

/**
 * Created by HB on 2015/7/10.
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