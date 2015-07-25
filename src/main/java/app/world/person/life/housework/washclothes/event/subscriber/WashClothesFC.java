package app.world.person.life.housework.washclothes.event.subscriber;

import akka.actor.UntypedActor;
import app.world.god.action.domain.Action;
import app.world.god.action.domain.ActivityPlan;
import app.world.god.action.domain.repository.ActivityPlanRepository;
import app.world.god.date.domain.event.event.DateGodEvent;
import app.world.nature.weather.domain.model.Weather;
import app.world.person.life.housework.washclothes.st.WashClothesST;
import dc.library.spring.SpringUtil;
import zen.frame.event.system.ES;

/**
 * Created by HB .
 */
public class WashClothesFC  extends UntypedActor {

    @Override
    public void onReceive(Object msg) throws Exception {
        ActivityPlanRepository repository = (ActivityPlanRepository) SpringUtil.getBean("activityPlanRepository");
        ActivityPlan ap = repository.findOneByName("洗衣服");


        Weather[] weathers = (Weather[])msg;
        Action[] wcs = new Action[weathers.length];

        for (int i = 0; i <weathers.length ; i++) {
            wcs[i] = new Action();
            wcs[i].setActivityPlan(ap);
            wcs[i].setDate(weathers[i].getDate());
        }

        WashClothesST.exec(wcs, weathers);

//        for (int i = 0; i <wcs.length ; i++) {
//
//            DateGod tg = new DateGod();
//            tg.setDate(new LocalDate(wcs[i].getDate()));
//            tg.getRepository().put(WashClothes.class.getName().replaceAll("\\.", "\\_"), wcs[i]);
//
//            DataEvent_Write dw = new DataEvent_Write();
//            dw.setServerName("dateGodRepository");
//            dw.setServerType(1);
//            dw.getDatas().put("dateGod", tg);

//            ES.data.eventStream().publish(dw);
//        }

        DateGodEvent tge = new DateGodEvent();
        tge.setDateModels(wcs);
        ES.app.eventStream().publish(tge);

    }

}