import java.io.IOException;
import java.net.ServerSocket;
import java.util.Queue;

public class InboundSocket implements Runnable {
  public InboundSocket(){
      static final int DEFAULT_PORT = 8987;
      static final long DEFAULT_BASE_TIMEOUT = 100;

      int serverPort;
      ServerSocket serverSocket;
      Queue<Object> inboundMessageQueue;

      // constructor for inbound serverSocket
      // @Param Queue<Object> inboundMessageQueue
      // -> Used to store the inbound messages so that the creator
      // of the thread has a handle to access them
      public InboundSocket(Queue<Object> inboundMessageQueue){
        this.inboundMessageQueue = inboundMessageQueue;
        initServerSocket(DEFAULT_PORT); // init server on given port
      }

      // Sets up a serverSocket to listen for incoming connections
      // tries 10 different ports before failing
      // returns whether was successful
      private boolean initServerSocket(int port){
        for(int attempt=0;attempt<10;attempt++){
          try{
            this.serverSocket = new ServerSocket(port + attempt);
            this.setSoTimeout(DEFAULT_BASE_TIMEOUT); // set the socket timeout
            // could just throw an exception here instead
            return true;
          }catch(Exeption e){
            e.printStackTrace().
          }
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



      @Overrides
      public void run(){




      }





  }
}
