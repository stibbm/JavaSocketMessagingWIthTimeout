import java.util.*;
import java.io.*;
import java.net.*;


public class OutboundSocket implements Runnable {


    static final int DEFAULT_BASE_TIMEOUT = 150;
    
    Socket socket;
    Message message;
    String remoteIpAddress;
    int remotePort;

    // OutboundSocket constructor
    // @Param Message message
    // --> Wrapper for object that is being sent
    // @Param String remoteIpAddress
    // --> Destination IP Address
    // @Param int remotePort
    // --> Destination port
    public OutboundSocket(Message message, String remoteIpAddress, int remotePort){
        this.message = message;
        this.remoteIpAddress = remoteIpAddress;
        this.remotePort = remotePort;
        try{
            this.socket = new Socket(remoteIpAddress, remotePort);
            this.socket.setSoTimeout(150);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // sends the message to the specified destination
    @Override
    public void run(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(this.message);
            oos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }



}