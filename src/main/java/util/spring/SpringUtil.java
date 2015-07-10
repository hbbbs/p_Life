package util.spring;

import zen.frame.global.Global;

/**
 * Created by HB on 2015/7/7.
 */
public class SpringUtil {
    public static Object getBean(String id) {
        try {
            return Global.ctx.getBean(id);
        } catch (NullPointerException e) {
            e.printStackTrace();;
            return null;
        }
    }
}
