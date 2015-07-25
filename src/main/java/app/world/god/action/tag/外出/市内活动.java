package app.world.god.action.tag.外出;

import app.world.common.dic.RequiredLevelType;
import app.world.common.domain.Tag;

/**
 * Created by HB on 2015/7/21.
 */
public class 市内活动 extends Tag{
    public 市内活动() {
        this.getBackPack().put("钥匙", RequiredLevelType.require);
        this.getBackPack().put("钱", RequiredLevelType.require);
        this.getBackPack().put("眼镜", RequiredLevelType.require);
        this.getBackPack().put("手机", RequiredLevelType.require);
    }
}
