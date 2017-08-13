package com.chat.models;


import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Conversation {
    private long conversationId;
    private List<Message> messages;

    public Conversation() {
        conversationId = 0;
        messages = new ArrayList<>();
    }

    public Conversation(long conversationId) {
        this();
        this.conversationId = conversationId;
    }

    public Conversation(long conversationId, BufferedReader reader) throws IOException {
        this();
        this.conversationId = conversationId;

        if (reader == null) return;
        if (!reader.ready()) return;
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            Message message = new Message(line);
            messages.add(message);
        }
    }

    public long getConversationId() {
        return conversationId;
    }

    public void setConversationId(long conversationId) {
        this.conversationId = conversationId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public long getNextMessageId(long conversationId) {
        long result = 0;
        for (int i = 0; i < messages.size(); ++i) {
            Message message = messages.get(i);
            if (message.getMessageId() > result) {
                result = message.getMessageId();
            }
        }
        return ++result;
//        try {
//
//            long messageId = Files.lines(Paths.get(fileName)).count();
//            return messageId + 1;
//        } catch(Exception e) {
//            return 0;
//        }
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Message getMessage(long messageId) {
        for(int i = 0; i < messages.size(); ++i) {
            Message message = messages.get(i);
            if(message.isMe(messageId)) {
                return message;
            }
        }
        return null;
    }
    public Message getPreviousMessage(long messageId) {
        for(int i = 0; i < messages.size(); ++i) {
            Message message = messages.get(i - 1);
            if(message.isMe(messageId)) {
                return message;
            }
        }
        return null;
    }
    public boolean deleteMessage(long messageId) {
        for(int i = 0; i < messages.size(); ++i) {
            Message message = messages.get(i);
            if(message.isMe(messageId)) {
                messages.remove(i);
                return true;
            }
        }
        return false;
    }

    public void printConversation() {
        System.out.println(String.format("ConversationId: %d", conversationId));
        System.out.println("ConversationContent: ");
        for (int i = 0; i < messages.size(); ++i) {
            messages.get(i).printMessage();
        }
        System.out.println("---------------End---------------");
    }

}
