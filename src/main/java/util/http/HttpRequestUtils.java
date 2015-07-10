package util.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.http.dic.HttpBackType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by HB on 2015/6/21.
 */
public class HttpRequestUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);    //日志记录

    public static void main(String[] args) {
        System.out.println(HttpRequestUtils.httpGet_Json("http://wthrcdn.etouch.cn/weather_mini?city=株洲"));
    }

    public static String httpGet_String(String url) {
        return (String) httpGet(url, HttpBackType.String);
    }

    public static ObjectNode httpGet_Json(String url) {
        return (ObjectNode) httpGet(url, HttpBackType.Json);
    }

    private static Object httpGet(String url, HttpBackType type) {
        Object responseContent = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            try {
                HttpEntity entity = response1.getEntity();
                switch (type) {
                    case String:
                        responseContent = getRespString(entity);
                        break;
                    case Json:
                        responseContent = getRespJson(entity);
                        break;
                }

                EntityUtils.consume(entity);
            } finally {
                response1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    private static ObjectNode getRespJson(HttpEntity entity) throws Exception {
        if (entity == null) {
            return null;
        }
        InputStream is = entity.getContent();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        ObjectNode jNode = (ObjectNode) mapper.readValue(br, ObjectNode.class);
        return jNode;
    }

    private static String getRespString(HttpEntity entity) throws Exception {
        if (entity == null) {
            return null;
        }
        InputStream is = entity.getContent();
        StringBuffer strBuf = new StringBuffer();

        byte[] buffer = new byte[4096];
        int r = 0;
        while ((r = is.read(buffer)) > 0) {
            strBuf.append(new String(buffer, 0, r, "UTF-8"));
        }
        return strBuf.toString();
    }
}


