package streaming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	int port;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void runServer() {
		new Thread(() -> {
			try {
				ServerSocket server = new ServerSocket(port);
				System.out.println("Server is open and waiting for clients...");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {}
				Socket client = server.accept();
				System.out.println("Client " + client.getRemoteSocketAddress() + " Connected successfully!");
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream());
				String line = "";
				while (!(line = in.readLine()).equals("end")) {
					out.println(new StringBuilder(line).reverse().toString());
					out.flush();
				}
				
				out.close();
				in.close();
				client.close();
				server.close();
				System.out.println("Server is off.");
			} catch (IOException e) {}
		}).start();
	}
	
	public static void main(String[] args) {
		Server s = new Server(5400);
		Client c = new Client("localhost", 5400);
		s.runServer();
		c.runClient();
	}

}
