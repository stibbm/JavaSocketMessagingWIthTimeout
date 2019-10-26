class ClientMessageGrabber implements Runnable {

  Queue<Message> inboundMessageQueue;
  Socket clientSocket;


  // 
  public ClientMessageGrabber(Socket clientSocket,
    Queue<Message> inboundMessageQueue){
    this.inboundMessageQueue = inboundMessageQueue;
    this.clientSocket = clientSocket;
  }

  // recieves the message from the client and stores it in the Queue
  // @Param Socket clientSocket
  // --> The socket connection to the client we are accepting the
  // message from
  // @Param Queue<Message>
  // --> Will place the message into the message queue
  @Override
  public void run(){

  }
}
