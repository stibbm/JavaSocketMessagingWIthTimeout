import java.util.*;
import java.io.*;
import java.net.*;


public class OutboundSocket {
    
    Socket socket;
    Message message;
    String destIpAddress;

    public OutboundSocket(Message message, String destIpAddress){
        this.message = message;
        this.destIpAddress = destIpAddress;
    }
}