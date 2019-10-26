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
				Thread.sleep(1000);
			}catch(Exception e){
			}
			System.out.println(inboundMessageQueue);
		}


	}

}
