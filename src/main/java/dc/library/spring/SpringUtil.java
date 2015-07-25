package dc.library.spring;

import zen.frame.global.Global;

/**
 * Created by HB .
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
