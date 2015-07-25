package app.world.society.organization.company.具体化.神农城.subscriber;

import akka.actor.UntypedActor;
import app.world.god.action.domain.Action;
import app.world.god.action.domain.ActivityPlan;
import app.world.god.action.domain.repository.ActivityPlanRepository;
import app.world.god.date.domain.event.event.DateGodEvent;
import app.world.nature.weather.domain.model.Weather;
import app.world.society.organization.company.具体化.神农城.st.神农城_喷泉ST;
import dc.library.spring.SpringUtil;
import zen.frame.event.system.ES;

/**
 * Created by HB .
 */
public class 神农城_喷泉FC extends UntypedActor {

    @Override
    public void onReceive(Object msg) throws Exception {
        ActivityPlanRepository repository = (ActivityPlanRepository) SpringUtil.getBean("activityPlanRepository");
        ActivityPlan ap = repository.findOneByName("神农城_喷泉");

        Weather[] weathers = (Weather[]) msg;
        Action[] wcs = new Action[weathers.length];

        for (int i = 0; i < weathers.length; i++) {
            wcs[i] = new Action();
            wcs[i].setActivityPlan(ap);
            wcs[i].setDate(weathers[i].getDate());
        }

        神农城_喷泉ST.exec(wcs, weathers);

        DateGodEvent tge = new DateGodEvent();
        tge.setDateModels(wcs);
        ES.app.eventStream().publish(tge);

    }

}