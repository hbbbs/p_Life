package app.world.common.base.model;

import app.world.common.base.model.interfaces.IDateModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.LocalDate;

/**
 * Created by HB on 2015/7/1.
 */
public class KarmaBaseModel_Date extends AKarmaBaseModel implements IDateModel {
    @JsonIgnore
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
        this.getKarma().setKarmaKey(date);
    }

}
