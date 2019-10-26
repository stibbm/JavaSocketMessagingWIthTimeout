class ClientMessageGrabber implements Runnable {

  Queue<Message> inboundMessageQueue;
  Socket clientSocket;


  // constructor
  // @Param Socket clientSocket
  // --> The socket connection to the client we are accepting the
  // message from
  // @Param Queue<Message>
  // --> Will place the message into the message queue
  public ClientMessageGrabber(Socket clientSocket,
    Queue<Message> inboundMessageQueue){
    this.inboundMessageQueue = inboundMessageQueue;
    this.clientSocket = clientSocket;
  }

  // recieves the message from the client and stores it in the Queue which can
  // be accessed by the creator of the thread
  @Override
  public void run(){
    
  }
}
