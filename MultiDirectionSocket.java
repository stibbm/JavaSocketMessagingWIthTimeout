import java.util.*;
import java.io.*;
import java.net.*;

class MultiDirectionSocket{

    Queue<Message> messagesReceived;
    Thread inboundSocket;
    Thread outboundSocket;

    
    class MultiDirectionSocket(){
        messagesReceived = new LinkedList<>();
        inboundSocket = new Thread(new InboundSocket());
        

    }

}