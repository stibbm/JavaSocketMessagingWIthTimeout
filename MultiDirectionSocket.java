import java.util.*;
import java.io.*;
import java.net.*;

class MultiDirectionSocket {

    Queue<Message> messagesReceived;
    Thread inboundSocket;
    Thread outboundSocket;
    String remoteIpAddress;
    int remotePort;
    int inboundPort;

    // immediately starts listening for incoming connections
    public MultiDirectionSocket(){
        messagesReceived = new LinkedList<>();
        inboundSocket = new Thread(new InboundSocket(messagesReceived));
        inboundSocket.start();
    }

    public void sendObject(Object obj){
        try{
            Message message = new Message(obj);
            Thread outboundSocket = new Thread(
                new OutboundSocket(message, remoteIpAddress, remotePort));
            outboundSocket.start(); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Message readNextMessage(){
        synchronized(messagesReceived){
            if(messagesReceived.size()==0){
                return null;
            }
            else{
                Message message = (Message)messagesReceived.peek();
                messagesReceived.pop();
                return message;
            }
        }
    }



}