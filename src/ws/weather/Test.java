package ws.weather;

/**
 * Created by HB on 2015/6/21.
 */
public class Test {
    public static void main(String[] args) {
        WeatherWebService wws = new WeatherWebService();
        WeatherWebServiceSoap wwsp = wws.getWeatherWebServiceSoap();

        ArrayOfString aos = wwsp.getWeatherbyCityName("������");

        for (String s : aos.getString()) {
            System.out.println(s);
        }
    }
}
