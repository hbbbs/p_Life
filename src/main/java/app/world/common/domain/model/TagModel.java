package app.world.common.domain.model;

import app.world.common.dic.RequiredLevelType;
import org.springframework.data.mongodb.core.index.Indexed;
import zen.frame.domain.model.BaseModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HB .
 */
public class TagModel extends BaseModel{
    @Indexed(unique = true)
    private String name;

    private Map<String, RequiredLevelType> backPack = new HashMap<String, RequiredLevelType>();

    public Map<String, RequiredLevelType> getBackPack() {
        return backPack;
    }

    public void setBackPack(Map<String, RequiredLevelType> backPack) {
        this.backPack = backPack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
