package app.world.god.date.domain.model;

import app.world.common.base.model.interfaces.IDateModel;
import org.joda.time.LocalDate;
import zen.frame.domain.model.BaseModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HB .
 */
public class DateGodModel extends BaseModel implements IDateModel {
    private LocalDate date;
    private Map<String, Object> repository = new HashMap<String, Object>();

    @Override
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<String, Object> getRepository() {
        return repository;
    }

    public void setRepository(Map<String, Object> repository) {
        this.repository = repository;
    }
}
