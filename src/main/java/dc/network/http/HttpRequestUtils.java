package dc.network.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dc.network.http.dic.HttpBackType;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by HB .
 * <p/>
 * 依赖 HttpClient
 * <p/>
 * <dependency>
 * <groupId>org.apache.httpcomponents</groupId>
 * <artifactId>httpclient</artifactId>
 * <version>4.5</version>
 * </dependency>
 * <p/>
 * 依赖 jackson json
 * <dependency>
 * <groupId>com.fasterxml.jackson.core</groupId>
 * <artifactId>jackson-core</artifactId>
 * <version>2.5.4</version>
 * </dependency>
 * <dependency>
 * <groupId>com.fasterxml.jackson.core</groupId>
 * <artifactId>jackson-databind</artifactId>
 * <version>2.5.4</version>
 * </dependency>
 * <dependency>
 * <groupId>com.fasterxml.jackson.core</groupId>
 * <artifactId>jackson-annotations</artifactId>
 * <version>2.5.4</version>
 * </dependency>
 */

public class HttpRequestUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);    //鏃ュ織璁板綍

    public static void main(String[] args) {
        System.out.println(HttpRequestUtils.httpGet_Json("http://wthrcdn.etouch.cn/weather_mini?city=鏍床"));
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


