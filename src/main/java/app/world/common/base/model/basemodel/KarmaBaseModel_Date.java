package app.world.common.base.model.basemodel;

import app.world.common.base.model.interfaces.IDateModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.LocalDate;

/**
 * Created by HB .
 */
public class KarmaBaseModel_Date extends KarmaBaseModel implements IDateModel {
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
