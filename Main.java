import java.util.*;
import java.io.*;
import java.net.*;


public class Main {

	public static void main(String[] args) {
		Queue<Message> inboundMessageQueue = new LinkedList<>();
		Thread inboundSocket = new Thread(new InboundSocket(inboundMessageQueue));
		inboundSocket.start();

		while(true){
			try{
				//Thread.sleep(10000);
				String messageText = "messageText";
				Message message = new Message(messageText);
				String localhost = "127.0.0.1";
				int remotePort = 8987;
				Thread outboundSocket = new Thread(
					new OutboundSocket(message, localhost, remotePort));
				outboundSocket.start();	
			}catch(Exception e){
				e.printStackTrace();
			}
			synchronized(inboundMessageQueue){
				System.out.println(inboundMessageQueue);
			}
			
		}


	}

}
