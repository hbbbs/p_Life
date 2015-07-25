package app.world.god.action.domain;

import app.world.common.base.model.karma.Karma;
import app.world.god.action.domain.model.ActionModel;

/**
 * Created by HB .
 */
public class Action extends ActionModel {
    public int $add_suitValue(Karma karma,int num) {
        this.setSuitValue(this.getSuitValue()+num);
        return this.getSuitValue();
    }

}
