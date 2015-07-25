package app.world.god.action.domain.model;

import app.world.common.base.model.basemodel.KarmaBaseModel_Date;
import app.world.god.action.domain.ActivityPlan;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by HB .
 */
public class ActionModel extends KarmaBaseModel_Date {
    private int suitValue;          //适合值
    @DBRef
    private ActivityPlan activityPlan;

    public int getSuitValue() {
        return suitValue;
    }

    public void setSuitValue(int suitValue) {
        this.suitValue = suitValue;
    }

    public ActivityPlan getActivityPlan() {
        return activityPlan;
    }

    public void setActivityPlan(ActivityPlan activityPlan) {
        this.activityPlan = activityPlan;
    }
}
