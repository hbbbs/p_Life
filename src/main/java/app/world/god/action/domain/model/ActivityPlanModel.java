package app.world.god.action.domain.model;

import app.world.common.dic.RequiredLevelType;
import app.world.common.domain.Tag;
import app.world.god.place.domain.Place;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.index.Indexed;
import zen.frame.domain.model.BaseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HB .
 *
 * 活动
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityPlanModel extends BaseModel {

    @Indexed(unique = true)
    private String name;

    private Place place;

    private Map<String, RequiredLevelType> backPack = new HashMap<String, RequiredLevelType>();
    private List<Tag> list_tag = new ArrayList<Tag>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Map<String, RequiredLevelType> getBackPack() {
        return backPack;
    }

    public void setBackPack(Map<String, RequiredLevelType> backPack) {
        this.backPack = backPack;
    }

    public List<Tag> getList_tag() {
        return list_tag;
    }

    public void setList_tag(List<Tag> list_tag) {
        this.list_tag = list_tag;
    }
}
