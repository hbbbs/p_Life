package app.world.common.base.model.basemodel;

import app.world.common.base.model.interfaces.IKarma;
import app.world.common.base.model.karma.Karma;
import app.world.common.base.model.karma.KarmaAll;
import com.fasterxml.jackson.annotation.JsonIgnore;
import zen.frame.domain.model.BaseModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HB on 2015/7/1.
 */
public class KarmaBaseModel extends BaseModel implements IKarma {

    @JsonIgnore
    private Map<Integer,KarmaAll> karmaEffection = new HashMap<Integer,KarmaAll>();       //因果
    @JsonIgnore
    private Karma karma;                                                    //自身的因的标识

    public KarmaBaseModel() {
        super();
        karma = new Karma();
        karma.setClassStr(this.getClass().getName());
    }


    public Karma getKarma() {
        return karma;
    }

    public void setKarma(Karma karma) {
        this.karma = karma;
    }

    @Override
    public Map<Integer, KarmaAll> getKarmaEffection() {
        return karmaEffection;
    }

    @Override
    public void setKarmaEffection(Map<Integer, KarmaAll> karmaEffection) {
        this.karmaEffection = karmaEffection;
    }
}
