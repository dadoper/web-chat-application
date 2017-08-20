package services;

import models.Channel;
import models.Message;
import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


//Singleton pattern for only one instance of ChatService
public class ChatService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ChatService _instance;

    public Map<Long, Channel> mapChannels;

    private ChatService(){
        mapChannels = new HashMap<>();
    }

    public static ChatService getInstance() {
        if(_instance == null) {
            _instance = new ChatService();
        }
        return _instance;
    }


    public void sendMessage(User user, String messageRaw) {
        //TODO: we don't set messageId yet, and need to assign messageId somehow
        //Parse message from String -> Message (model) with format channelId|content
        logger.info("user raw content: " + messageRaw);

        String[] array = messageRaw.split("|");
        Long channelId = Long.parseLong(array[0]);
        String content = array[1];
        //TODO: provide messageId
        logger.info("user content: " + content);
        sendMessage(user, channelId, new Message(System.currentTimeMillis(), content));
    }


    public void sendMessage(User user, long channelId, Message message) {
        Channel channel = mapChannels.get(channelId);
        if(channel == null) {
            channel = new Channel(channelId);
            channel.join(user);
            mapChannels.put(channelId, channel);
        }
        channel.broadcast(message);
        //TODO: save to database by channelId
    }

    
}
