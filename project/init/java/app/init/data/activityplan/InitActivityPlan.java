package app.init.data.activityplan;

import app.world.common.domain.Tag;
import app.world.common.domain.repository.TagRepository;
import app.world.god.action.domain.ActivityPlan;
import app.world.god.action.domain.repository.ActivityPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitActivityPlan {

    @Autowired
    private ActivityPlanRepository repository;
    @Autowired
    private TagRepository tagRepository;

    public void init() {
        deleteAll();
        save();
    }

    public void save(){
        Tag 市内活动 = tagRepository.findOneByName("市内活动");

        List<ActivityPlan> list = new ArrayList<ActivityPlan>();

        ActivityPlan ap = new ActivityPlan();
        ap.setName("啦啦好_玩玩具");
        ap.getList_tag().add(市内活动);
        list.add(ap);

        ap = new ActivityPlan();
        ap.setName("神农城_喷泉");
        ap.getList_tag().add(市内活动);
        list.add(ap);

        ap = new ActivityPlan();
        ap.setName("洗衣服");
        list.add(ap);

        repository.save(list);
    }

    public void deleteAll(){
        repository.deleteAll();
    }


}
