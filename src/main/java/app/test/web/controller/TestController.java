package app.test.web.controller;

import app.world.god.action.domain.repository.ActivityPlanRepository;
import app.world.nature.weather.domain.model.Weather;
import app.world.nature.weather.services.WeatherServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zen.frame.event.system.ES;

import java.io.IOException;

/**
 * Created by HB on 14-3-15.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ActivityPlanRepository activityPlanRepository;


    @RequestMapping(value = "/test")
    public String test() throws IOException {

        Weather[] weathers = WeatherServices.getWeathers("株洲");
        ES.app.eventStream().publish(weathers);

        for (Weather weather : weathers) {
            log.info("天气情况：\t" + weather);
        }


//        DateGodRepository repository = (DateGodRepository) SpringUtil.getBean("dateGodRepository");
//        DateGod tg = repository.findOne("559b6c236fb50d1320bd5270");
//        System.out.println(tg.getRepository());

        return "tg";
    }

    @RequestMapping(value = "/_project")
    public String init() throws IOException {
//        InitActivityPlan.init();

        return "init完成";
    }


}
