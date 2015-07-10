package app.world.common.base.model.karma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by HB on 2015/7/1.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KarmaEffection {
    private String fieldName;

    public Integer getEffection() {
        return effection;
    }

    public void setEffection(Integer effection) {
        this.effection = effection;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    private Integer effection;


}
