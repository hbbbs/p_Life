package app;

import app.comm.event.InitEventSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import zen.frame.global.Global;

/**
 * Created by HB on 14-3-15.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        //初始化事件系统
        InitEventSystem.init();

        //程序运行
        Global.ctx = SpringApplication.run(Application.class);
    }
}
