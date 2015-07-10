package zen.frame.domain.repository.event.subscriber;

import akka.actor.UntypedActor;
import app.world.god.date.domain.model.DateGod;
import app.world.god.date.domain.repository.DateGodRepository;
import util.spring.SpringUtil;
import zen.frame.event.event.data.DataEvent_Write;

/**
 * Created by HB on 2015/6/22.
 */
public class DataWriteFC extends UntypedActor {

    @Override
    public void onReceive(Object msg) throws Exception {
        DataEvent_Write event = (DataEvent_Write)msg;

        DateGodRepository repository = (DateGodRepository) SpringUtil.getBean("dateGodRepository");

        switch (event.getServerType()) {
            case 1:
                repository.save((DateGod)(event.getDatas().get("dateGod")));
                break;
            case 2:
//                responseContent = getRespJson(entity);
                break;
            default:
                break;
        }

    }

}