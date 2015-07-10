package app.world.nature.weather.domain.model;

import app.world.common.base.model.KarmaBaseModel_Date;
import app.world.nature.weather.domain.model.dic.WeatherType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by HB on 2015/7/7.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherModel extends KarmaBaseModel_Date {
    @JsonProperty("fengxiang")
    private String wind_direction;  //风向
    @JsonProperty("fengli")
    private String wind_scale;      //风力

    @JsonProperty("high")
    private String high_temperature;    //最高温度
    @JsonProperty("low")
    private String low_temperature;     //最低温度


    @JsonProperty("type")
    private WeatherType weather;             //天气情况

    private String humidity;                //湿度
    private String temperature;             //气温

    public WeatherType getWeather() {
        return weather;
    }

    public void setWeather(WeatherType weather) {
        this.weather = weather;
    }

    public String getLow_temperature() {
        return low_temperature;
    }

    public void setLow_temperature(String low_temperature) {
        this.low_temperature = low_temperature;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getWind_scale() {
        return wind_scale;
    }

    public void setWind_scale(String wind_scale) {
        this.wind_scale = wind_scale;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHigh_temperature() {
        return high_temperature;
    }

    public void setHigh_temperature(String high_temperature) {
        this.high_temperature = high_temperature;
    }
}
