package app;

import app.comm.event.InitEventSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zen.frame.global.Global;

/**
 * Created by HB on 14-3-15.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //初始化事件系统
        InitEventSystem.init();

        //程序运行
        Global.ctx = SpringApplication.run(Application.class);
        System.out.println(Global.ctx);
    }

}
