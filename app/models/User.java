package models;

import akka.actor.ActorRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    private long id;
    private ActorRef ref;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public User() {
        id = 0;
        ref = ActorRef.noSender();
    }

    public User(long userId, ActorRef ref) {
        this.setId(userId);
        this.setRef(ref);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ActorRef getRef() {
        return ref;
    }

    public void setRef(ActorRef ref) {
        this.ref = ref;
    }

    public void send(Message message) {
        ref.tell(message, ActorRef.noSender());
    }

    public void send(String message) {
        logger.info("sending.......... " + message);
        ref.tell(message, ActorRef.noSender());
    }

}
