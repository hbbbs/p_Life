package db;

import app.Application;
import app.world.common.dic.RequiredLevelType;
import app.world.god.action.domain.ActivityPlan;
import app.world.god.action.domain.repository.ActivityPlanRepository;
import dc.library.spring.SpringUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

public class DBTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Application.main(new String[0]);
    }

    @Test
    public void getAllBackPack() {
        ActivityPlanRepository repository = (ActivityPlanRepository) SpringUtil.getBean("activityPlanRepository");

        ActivityPlan ap = repository.findOneByName("神农城_喷泉");
        Map<String, RequiredLevelType> map = ap.getAllBackPack();
        for (Map.Entry<String, RequiredLevelType> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " \t " + entry.getValue().name());
        }
    }

}
