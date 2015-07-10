package app.world.god.date.domain.event.event;

import app.world.common.base.model.interfaces.IDateModel;

/**
 * Created by HB on 2015/7/7.
 */
public class DateGodEvent {
    private IDateModel[] dateModels;

    public IDateModel[] getDateModels() {
        return dateModels;
    }

    public void setDateModels(IDateModel[] dateModels) {
        this.dateModels = dateModels;
    }
}
