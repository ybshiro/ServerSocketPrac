import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class SimpleServer{
    public static void main(String[] args) throws IOException {
	//check args length
	if(args.length != 0){
	    System.err.println("Usage:  SimpleServer");
	    System.exit(1);
	}

	try{
	    //create a serversocket object listening on any free port
	    ServerSocket server = new ServerSocket(0);
	    //get the port server is listening on
	    System.out.println("listening on port: " + server.getLocalPort());
	    //wait until a client starts up and requests a connection. When a  connection is requested and successfully established, return a new socket object bound to the same local port with remote address and port set to that of the client
	    Socket client = server.accept();
	    //send message to client 
	    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
	    //get message from client
	    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
	    //get client ip address
	    InetAddress ip = client.getInetAddress();
	    //write requested lines
	    writer.println("Hello, " + ip.getHostName() + ".\n" + "Your IP address is " + ip.getHostAddress());
	    client.close();
	}catch(IOException e){
	    System.out.println(e.getMessage());
	}
    }
}