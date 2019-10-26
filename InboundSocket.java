import java.io.*;
import java.net.*;
import java.util.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Queue;
import java.net.Socket;


public class InboundSocket implements Runnable {
  static final int DEFAULT_PORT = 8987;
  static final int DEFAULT_BASE_TIMEOUT = 100;

  int serverPort;
  ServerSocket serverSocket;
  Queue<Message> inboundMessageQueue;

  // constructor for inbound serverSocket
  // @Param Queue<Object> inboundMessageQueue
  // -> Used to store the inbound messages so that the creator
  // of the thread has a handle to access them
  public InboundSocket(Queue<Message> inboundMessageQueue){
    this.inboundMessageQueue = inboundMessageQueue;
    initServerSocket(DEFAULT_PORT); // init server on given port
  }

  // Sets up a serverSocket to listen for incoming connections
  // @Return boolean success
  // --> returns whether the serverSocket was successfully
  // initialized
  private boolean initServerSocket(int port) {
    try{
      this.serverSocket = new ServerSocket(port);
      return true;
    }catch(Exception e){
      e.printStackTrace();
    }
    return false;
  }


  // Accepts/Establishes a socket connection for an incoming
  // connection request
  // @Param ServerSocket serverSocket
  // --> Used to accept the incoming connection on
  // @Return Socket clientSocket
  // --> established socket connection to the client
  // @Return on exception
  // --> null if an exception is thrown
  public Socket acceptConnection(ServerSocket serverSocket){
    try{
      Socket clientSocket = serverSocket.accept();
      return clientSocket;
    }
    catch(Exception e){
      return null;
    }
  }



  // accept the incoming connection from the client and e
  @Override
  public void run(){
  // accept incoming client connection requests
    while(true){
      Socket clientSocket = acceptConnection(this.serverSocket);
       if(clientSocket == null){
        continue;
      }
      // start the thread to receive the message and store
      // in the queue
      try{
        Thread clientMessageGrabber = new Thread(
          new ClientMessageGrabber(clientSocket, inboundMessageQueue));
        clientMessageGrabber.start();
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }





  
}
