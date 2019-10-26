import java.util.*;
import java.io.*;
import java.net.*;


class ClientMessageGrabber implements Runnable {

  static final int DEFAULT_BASE_TIMEOUT = 100;
  Queue<Message> inboundMessageQueue;
  Socket clientSocket;


  // constructor
  // @Param Socket clientSocket
  // --> The socket connection to the client we are accepting the
  // message from
  // @Param Queue<Message>
  // --> Will place the message into the message queue
  public ClientMessageGrabber(Socket clientSocket,
    Queue<Message> inboundMessageQueue) throws SocketException{
    this.inboundMessageQueue = inboundMessageQueue;
    this.clientSocket = clientSocket;
    this.clientSocket.setSoTimeout(DEFAULT_BASE_TIMEOUT);

  }

  // recieves the message from the client and stores it in the Queue which can
  // be accessed by the creator of the thread
  @Override
  public void run(){
    try{
      ObjectInputStream ois = new ObjectInputStream(this.clientSocket.getInputStream());
      Object obj = ois.readObject();
      synchronized(inboundMessageQueue){
        inboundMessageQueue.add(new Message(obj));
      }
      ois.close();
      this.clientSocket.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
