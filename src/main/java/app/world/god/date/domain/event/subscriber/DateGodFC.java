package app.world.god.date.domain.event.subscriber;

import akka.actor.UntypedActor;
import app.world.common.base.model.interfaces.IDateModel;
import app.world.god.action.domain.Action;
import app.world.god.date.domain.event.event.DateGodEvent;
import app.world.god.date.domain.model.DateGod;
import app.world.god.date.domain.repository.DateGodRepository;
import dc.library.spring.SpringUtil;
import org.joda.time.LocalDate;
import zen.frame.event.event.data.DataEvent_Write;
import zen.frame.event.system.ES;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HB on 2015/6/22.
 */
public class DateGodFC extends UntypedActor {

    @Override
    public void onReceive(Object msg) throws Exception {
        testMainRun(msg);
//        deal(msg);
    }

    private void deal(Object msg) {

        DateGodRepository repository = (DateGodRepository) SpringUtil.getBean("dateGodRepository");

        IDateModel[] dataModels = ((DateGodEvent) msg).getDateModels();
        List<LocalDate> dateList = new ArrayList<LocalDate>();
        for (int i = 0; i < dataModels.length; i++) {
            dateList.add(dataModels[i].getDate());
        }

        List<DateGod> list = repository.findByDateIn(dateList);
        System.out.println(list);

        for (int i = 0; i < dataModels.length; i++) {
            IDateModel dateModel = dataModels[i];
            DateGod dg = null;

            boolean isDeal = false;
            for (DateGod dateGod : list) {
                if (dateGod.getDate().equals(dateModel.getDate())) {
                    dg = dateGod;
                    dg.getRepository().put(dateModel.getClass().getName().replaceAll("\\.", "\\_"), dateModel);
                    isDeal = true;
                    break;
                }

            }
            if (!isDeal) {
                dg = new DateGod();
                dg.setDate(dateModel.getDate());
                dg.getRepository().put(dateModel.getClass().getName().replaceAll("\\.", "\\_"), dateModel);
            }

            DataEvent_Write dw = new DataEvent_Write();
            dw.setServerName("dateGodRepository");
            dw.setServerType(1);
            dw.getDatas().put("dateGod", dg);
            ES.data.eventStream().publish(dw);
        }
    }

    private void testMainRun(Object msg) throws Exception {
        IDateModel[] dataModels = ((DateGodEvent) msg).getDateModels();
        for (int i = 0; i < dataModels.length; i++) {
            System.out.println(dataModels[i].getDate() + "\t" +  ((Action) dataModels[i]).getActivityPlan().getName() + "\t" + ((Action) dataModels[i]).getSuitValue() + "-----------------------------------");
        }
    }

}