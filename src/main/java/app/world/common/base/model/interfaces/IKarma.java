package app.world.common.base.model.interfaces;

import app.world.common.base.model.karma.Karma;
import app.world.common.base.model.karma.KarmaAll;

import java.util.Map;

/**
 * Created by HB on 2015/7/1.
 */
public interface IKarma {
    public Karma getKarma();

    public void setKarma(Karma karma);

    public Map<Integer,KarmaAll> getKarmaEffection();

    public void setKarmaEffection(Map<Integer,KarmaAll> karmaEffection);

}
