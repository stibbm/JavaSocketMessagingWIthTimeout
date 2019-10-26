import java.io.Serializable;

public class Message implements Serializable {

  Object message;
  
  public Message(Object message){
    this.message = message;
  }

}
