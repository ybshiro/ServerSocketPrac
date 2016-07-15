import java.net.*;
import java.io.*;

public class SimpleClient{
    public static void main(String[] args) throws IOException {
	//Check args length
	if(args.length != 2){
	    System.err.println("Usage:  java SimpleClient <hostname> <portnumber>");
	    System.exit(1);
	}

	String hostName = args[0];
	int portNumber = Integer.parseInt(args[1]);

	try{
	    //create a socket using the host name and port number to connect server
	    Socket me = new Socket(hostName, portNumber);
	    //send message to server
	    PrintWriter writer = new PrintWriter(me.getOutputStream(), true);
	    //get message from server
	    BufferedReader reader = new BufferedReader(new InputStreamReader(me.getInputStream()));
	    String str;
	    while((str = reader.readLine())!= null){
		System.out.println(str);
	    }

	    // //get first line
	    // String name = reader.readLine();
	    // //get second line
	    // String ip = reader.readLine();
	    me.close();
	    // System.out.println(name);
	    // System.out.println(ip);
	}catch(UnknownHostException e){
	    System.err.println("Don't know about host " + hostName);
	    System.exit(1);
	}catch(IOException e){
	    System.err.println("Couldn't get I/O for the connection to " + hostName);
	    System.err.println(e.getMessage());
	    System.exit(1);
	}
    }
}