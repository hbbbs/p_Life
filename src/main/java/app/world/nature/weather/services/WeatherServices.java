package app.world.nature.weather.services;

import app.world.nature.weather.domain.model.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dc.network.http.HttpRequestUtils;
import org.joda.time.LocalDate;

import java.io.IOException;

/**
 * Created by HB .
 */
public class WeatherServices {
    private static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?city=";

    public static Weather getWeather_curDate(String city) throws IOException {

        ObjectNode jnode = HttpRequestUtils.httpGet_Json(WEATHER_URL + city);

        String str= jnode.with("data").get("forecast").get(0).toString();
        ObjectMapper mapper = new ObjectMapper();
        Weather weather = mapper.readValue(str,Weather.class);
        weather.setDate(LocalDate.now());
        return weather;
    }

    public static Weather[] getWeathers(String city) throws IOException {

        ObjectNode jnode = HttpRequestUtils.httpGet_Json(WEATHER_URL + city);

        String str= jnode.with("data").get("forecast").toString();
        ObjectMapper mapper = new ObjectMapper();
        Weather[] weathers = mapper.readValue(str,Weather[].class);
        for (int i = 0; i <weathers.length ; i++) {
            weathers[i].setDate(LocalDate.now().plusDays(i));
        }
        return weathers;
    }

}
