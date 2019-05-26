package streaming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
  
public class Client {
	
	volatile boolean stop;
	String ip;
	int port;
	
	public Client(String ip,int port) {
		stop = false;
		this.ip = ip;
		this.port = port;
	}
	
	public void runClient() {
		try {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			Socket server = new Socket(ip, port);
			Scanner in = new Scanner(System.in);
			BufferedReader fromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
			PrintWriter out = new PrintWriter(server.getOutputStream());
			String line, res;

			while (!stop) {
				System.out.println("Enter a word to reverse:");
				line = in.nextLine();
				out.println(line);
				out.flush();
				if (line.equals("end")) {
					disconnect();
					break;
				}
				res = fromServer.readLine();
				System.out.println(res);
			}
			in.close();
			fromServer.close();
			out.close();
			server.close();
			System.out.println("Connection has ended.");
		} catch (IOException e) {}
	}
	
	public void disconnect() {
		stop = true;
	}
	
//	public static void main(String[] args) {
//		Client c = new Client(5400);
//		c.runClient();
//	}

}
