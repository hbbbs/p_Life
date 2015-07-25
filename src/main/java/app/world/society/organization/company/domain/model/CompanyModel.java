package app.world.society.organization.company.domain.model;

import app.world.god.place.domain.Place;
import zen.frame.domain.model.BaseModel;

/**
 * Created by HB .
 */
public class CompanyModel  extends BaseModel {
    private String name;
    private Place place;

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
}
