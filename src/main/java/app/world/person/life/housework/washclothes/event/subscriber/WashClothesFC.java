package app.world.person.life.housework.washclothes.event.subscriber;

import akka.actor.UntypedActor;
import app.world.god.date.domain.event.event.DateGodEvent;
import app.world.nature.weather.domain.model.Weather;
import app.world.person.life.housework.washclothes.domain.model.WashClothes;
import app.world.person.life.housework.washclothes.st.WashClothesST;
import zen.frame.event.system.ES;

/**
 * Created by HB on 2015/6/22.
 */
public class WashClothesFC  extends UntypedActor {

    @Override
    public void onReceive(Object msg) throws Exception {
        Weather[] weathers = (Weather[])msg;
        WashClothes[] wcs = new WashClothes[weathers.length];

        for (int i = 0; i <weathers.length ; i++) {
            wcs[i] = new WashClothes();
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