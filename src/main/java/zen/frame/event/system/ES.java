package zen.frame.event.system;

import akka.actor.ActorSystem;

/**
 * Created by HB on 2015/7/7.
 */
public class ES {
    public static final ActorSystem data = ActorSystem.create("frame_data");
    public static final ActorSystem app = ActorSystem.create("app_app");
}
