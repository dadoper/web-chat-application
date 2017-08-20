package services;


import models.*;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.Collectors;


public class MessageStorageService {
    //Settings
    private static String FormatPathStorage = "%s/%d.txt";
    private static String PathStorage = "/Users/sqle/Desktop/CS/ChatApplication/Conversation";
    private Map<Long, Conversation> _conversations;
    private static MessageStorageService _instance;


    private MessageStorageService() {
        _conversations = new HashMap<>();
    }

    public static MessageStorageService getInstance() {
        if (_instance == null) {
            _instance = new MessageStorageService();
        }
        return _instance;
    }

    private String getPath(long conversationId) {
        return String.format(FormatPathStorage, PathStorage, conversationId);
    }
//Another getConversation

//    public Conversation checkExistence(long conversationId) throws IOException {
//        Conversation conversation = _conversations.get(conversationId);
//        if (conversation == null) {
//            //Read data from disk
//            String path = getPath(conversationId);
//            File file = new File(path);
//
//            if (file.exists()) {
//                System.out.println("This conversation has already started");
//            }
//        }
//        return conversation;
//    }



    public Conversation getConversation(long conversationId) throws IOException {
        Conversation conversation = _conversations.get(conversationId);
        if (conversation == null) {
            //Read data from disk
            String path = getPath(conversationId);
            File file = new File(path);

            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                conversation = new Conversation(conversationId, bufferedReader);
                _conversations.put(conversationId, conversation);
//                //TODO: messageId method 2
//                long lines = 0;
//                String line;
//                while (bufferedReader.readLine() != null) {
//                    lines++;
//                    System.out.println();
//                }
                  //TODO: printLines
//                while((line = in.readLine()) != null) System.out.println(line);
                  //TODO: Throws exception
//                in.close();
//                bufferedReader.close();
            } else {
                conversation = new Conversation(conversationId);
            }
        }

        return conversation;
    }

    public void saveConversation(long conversationId, Message message) throws IOException {
        String path = getPath(conversationId);
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        if (message.getMessageId() == 1) {
            bufferedWriter.write(message.toString());
        } else {
            String newLine = System.getProperty("line.separator");
            bufferedWriter.write(newLine + message.toString());
        }
        bufferedWriter.close();
    }
    public boolean deleteMessage(String fileName, long messageId){
        try {
            List<String> messages = Files.lines(Paths.get(fileName)).collect(Collectors.toList());
            int removeId = (int) messageId;
            messages.remove(messages.get(removeId));
            return true;
        } catch (Exception e) {
            System.out.println("The message that you have entered no longer exist.");
            return false;
        }
    }
//deleteMessage() beta

//    public boolean deleteMessage(Conversation conversation, long messageId)  throws IOException {
//        Message message = conversation.getMessage(messageId);
//        if(conversation.deleteMessage(messageId)) {
//            String path = getPath(conversation.getConversationId());
//            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
//            String contentDelete = message.toString();
//            int contentDeleteSize = contentDelete.length();
//            String line;
//            while ((line = randomAccessFile.readLine()) != null)
//            {
//                if (line.contains(contentDelete))
//                {
//                    long currentPosition = randomAccessFile.getFilePointer();
//                    randomAccessFile.seek(currentPosition - contentDeleteSize - 1);
//                    for (int i = 0 ; i < contentDeleteSize; i++) {
//                        randomAccessFile.writeByte(32);
//                    }
//                }
//            }
//            randomAccessFile.close();
//            return true;
//        }
//        return false;
//    }
}
