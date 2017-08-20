package models;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private long channelId;
    private List<User> members;

    public Channel() {
        channelId = 0;
        members = null;
    }

    public Channel(long channelId) {
        this.channelId = channelId;
        members = new ArrayList<>();
    }

    public void join(User user) {
        //TODO: Check exist user in this channel: loop & check
        members.add(user);
    }

    public void leave(User user) {
        //TODO: check exist & remove
    }

    public void broadcast(Message message) {
        members.stream().forEach(user -> {
            user.send(message.toStringForSend(channelId));
        });
    }
}
