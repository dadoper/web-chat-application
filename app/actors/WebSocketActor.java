package actors;

import akka.actor.*;
import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.ChatService;


public class WebSocketActor extends AbstractActor {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    public static Props props(ActorRef out, Long userId) {
        return Props.create(WebSocketActor.class, out, userId);
    }

    private final ActorRef out;
    private final Long userId;
    private final User user;

    public WebSocketActor(ActorRef out, Long userId) {
        this.out = out;
        this.userId = userId;
        user = new User(userId, out);
    }

    @Override
    public void postStop() {
        //TODO: leave all room, which join before
        logger.info("I'm dead");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message ->
                        ChatService.getInstance().sendMessage(user, message)
                )
                .build();
    }
}