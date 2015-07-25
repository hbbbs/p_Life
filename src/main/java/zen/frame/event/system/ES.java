package zen.frame.event.system;

import akka.actor.ActorSystem;

/**
 * Created by HB .
 */
public class ES {
    public static final ActorSystem data = ActorSystem.create("frame_data");
    public static final ActorSystem app = ActorSystem.create("app_app");
}
