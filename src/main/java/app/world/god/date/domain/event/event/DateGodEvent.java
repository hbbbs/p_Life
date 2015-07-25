package app.world.god.date.domain.event.event;

import app.world.common.base.model.interfaces.IDateModel;

/**
 * Created by HB .
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
