package app.world.god.place.domain.model;

import zen.frame.domain.model.BaseModel;

/**
 * Created by HB on 2015/7/20.
 */
public class PlaceModel extends BaseModel{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
