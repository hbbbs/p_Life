package app.world.god.action.domain;

import app.world.common.dic.RequiredLevelType;
import app.world.common.domain.Tag;
import app.world.god.action.domain.model.ActivityPlanModel;
import app.world.god.action.tag.外出.市内活动;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HB .
 */
public class ActivityPlan extends ActivityPlanModel {


    public Map<String, RequiredLevelType> getAllBackPack(){
        Map<String, RequiredLevelType> map_return  = new HashMap<String, RequiredLevelType>();

        map_return.putAll(this.getBackPack());

        for (Tag tag : this.getList_tag()) {
            map_return.putAll(tag.getBackPack());
        }

        return map_return;
    }

    public static void main(String[] args) {
        ActivityPlan 神农城_喷泉 = new ActivityPlan();
        神农城_喷泉.setName("神农城_喷泉");
        神农城_喷泉.getBackPack().put("潜水眼镜", RequiredLevelType.recommend);
        神农城_喷泉.getList_tag().add(new 市内活动());

        Map<String, RequiredLevelType> map = 神农城_喷泉.getAllBackPack();

        for (Map.Entry<String, RequiredLevelType> entry : map.entrySet()) {
            System.out.println(entry.getKey() +  "\t\t\t" + entry.getValue().name());
        }
    }
}
