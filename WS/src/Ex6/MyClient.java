package Ex6;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.net.Socket;

public class MyClient {
	public static void sendLevel(String ip, int port, Level level) throws IOException {
		Socket socket = new Socket(ip, port);
		XMLEncoder xml =  new XMLEncoder(socket.getOutputStream());
		xml.writeObject(level);
		
		// Closing Sources...
		xml.close();
		socket.close();

	}
	
}