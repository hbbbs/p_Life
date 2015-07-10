package zen.frame.event.event.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HB on 2015/7/7.
 */
public class DataEvent_Read {
    private String serverName;
    private int serverType;
    private Map<String,Object> datas= new HashMap<String,Object>();

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public int getServerType() {
        return serverType;
    }

    public void setServerType(int serverType) {
        this.serverType = serverType;
    }

    public Map<String, Object> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
    }
}
