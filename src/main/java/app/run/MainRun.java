package app.run;

import app.comm.event.InitEventSystem;
import app.world.nature.weather.domain.model.Weather;
import app.world.nature.weather.services.WeatherServices;
import zen.frame.event.system.ES;

import java.io.IOException;

/**
 * Created by HB .
 */
public class MainRun {
    public static void main(String[] args) throws IOException {
        InitEventSystem.init();

        //app
        Weather[] weathers = WeatherServices.getWeathers("株洲");

        ES.app.eventStream().publish(weathers);


//        ES.app.shutdown();
//        ES.data.shutdown();
    }
}
