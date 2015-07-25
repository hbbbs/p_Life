package app;

import app.init.data.activityplan.InitActivityPlan;
import app.init.data.company.InitCompany;
import app.init.data.tag.InitTag;
import dc.library.spring.SpringUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class InitDatas {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Application.main(new String[0]);
    }

    @Test
    public void init() {
        //Bean
        InitActivityPlan initActivityPlan = (InitActivityPlan) SpringUtil.getBean("initActivityPlan");
        InitTag initTag = (InitTag) SpringUtil.getBean("initTag");
        InitCompany initCompany = (InitCompany) SpringUtil.getBean("initCompany");


        //初始化
        initTag.init();

        initCompany.init();

        initActivityPlan.init();

    }


}
