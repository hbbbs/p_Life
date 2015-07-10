package app.test.web.controller;

import app.world.god.date.domain.model.DateGod;
import app.world.god.date.domain.repository.DateGodRepository;
import app.world.nature.weather.domain.model.Weather;
import app.world.nature.weather.services.WeatherServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.spring.SpringUtil;
import zen.frame.event.system.ES;

import java.io.IOException;

/**
 * Created by HB on 14-3-15.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/test")
    public String test() throws IOException {

        Weather[] weathers = WeatherServices.getWeathers("株洲");
        ES.app.eventStream().publish(weathers);


        DateGodRepository repository = (DateGodRepository) SpringUtil.getBean("dateGodRepository");
        DateGod tg = repository.findOne("559b6c236fb50d1320bd5270");
        System.out.println(tg);
        return "tg";
    }



}
