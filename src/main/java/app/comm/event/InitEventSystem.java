package app.comm.event;

import akka.actor.ActorRef;
import akka.actor.Props;
import app.world.god.date.domain.event.event.DateGodEvent;
import app.world.god.date.domain.event.subscriber.DateGodFC;
import app.world.nature.weather.domain.model.Weather;
import app.world.person.life.housework.washclothes.event.subscriber.WashClothesFC;
import zen.frame.domain.repository.event.subscriber.DataWriteFC;
import zen.frame.event.event.data.DataEvent_Write;
import zen.frame.event.system.ES;

/**
 * Created by HB on 2015/7/11.
 */
public class InitEventSystem {
    public static void init() {
        //事件注册

        //app 事件
        final ActorRef washClothesHandler = ES.app.actorOf(Props.create(WashClothesFC.class));
        ES.app.eventStream().subscribe(washClothesHandler, Weather[].class);

        final ActorRef dateGodHandler = ES.app.actorOf(Props.create(DateGodFC.class));
        ES.app.eventStream().subscribe(dateGodHandler, DateGodEvent.class);

        //data 事件
        final ActorRef dataWriteHandler = ES.data.actorOf(Props.create(DataWriteFC.class));
        ES.data.eventStream().subscribe(dataWriteHandler, DataEvent_Write.class);
    }
}
