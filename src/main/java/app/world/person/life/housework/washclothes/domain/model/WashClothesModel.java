package app.world.person.life.housework.washclothes.domain.model;

import app.world.common.base.model.KarmaBaseModel_Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by HB on 2015/6/22.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WashClothesModel extends KarmaBaseModel_Date {

    private int suitValue;          //适合值

    public int getSuitValue() {
        return suitValue;
    }

    public void setSuitValue(int suitValue) {
        this.suitValue = suitValue;
    }

}

