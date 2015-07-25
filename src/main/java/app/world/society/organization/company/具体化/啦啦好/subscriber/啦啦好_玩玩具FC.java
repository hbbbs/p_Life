package app.world.society.organization.company.具体化.啦啦好.subscriber;

import akka.actor.UntypedActor;
import app.world.god.action.domain.Action;
import app.world.god.action.domain.ActivityPlan;
import app.world.god.action.domain.repository.ActivityPlanRepository;
import app.world.god.date.domain.event.event.DateGodEvent;
import app.world.nature.weather.domain.model.Weather;
import app.world.society.organization.company.具体化.啦啦好.st.啦啦好_玩玩具ST;
import dc.library.spring.SpringUtil;
import zen.frame.event.system.ES;

/**
 * Created by HB on 2015/6/22.
 */
public class 啦啦好_玩玩具FC extends UntypedActor {

    @Override
    public void onReceive(Object msg) throws Exception {
        ActivityPlanRepository repository = (ActivityPlanRepository) SpringUtil.getBean("activityPlanRepository");
        ActivityPlan ap = repository.findOneByName("啦啦好_玩玩具");

        Weather[] weathers = (Weather[]) msg;
        Action[] wcs = new Action[weathers.length];

        for (int i = 0; i < weathers.length; i++) {
            wcs[i] = new Action();
            wcs[i].setActivityPlan(ap);
            wcs[i].setDate(weathers[i].getDate());
        }

        啦啦好_玩玩具ST.exec(wcs, weathers);

        DateGodEvent tge = new DateGodEvent();
        tge.setDateModels(wcs);
        ES.app.eventStream().publish(tge);

    }

}