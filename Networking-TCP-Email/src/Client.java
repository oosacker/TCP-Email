import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		String hostname = "mail.ecs.vuw.ac.nz";
		int serverPort = 25;

		Socket socket = new Socket(hostname, serverPort);

		OutputStream output = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(output, true);

		InputStream input = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));

		String line = reader.readLine();
		System.out.println(line);
		
		
		Scanner sc = new Scanner(System.in);

		writer.println("HELO " + hostname);

		line = reader.readLine();
		System.out.println(line);

		writer.println("MAIL FROM:<haseganats@ecs.vuw.ac.nz>");
		line = reader.readLine();
		System.out.println(line);

		writer.println("RCPT TO:<haseganats@ecs.vuw.ac.nz>");
		line = reader.readLine();
		System.out.println(line);

		writer.println("DATA");
		line = reader.readLine();
		System.out.println(line);     

		writer.println("FROM: haseganats");
		
		System.out.println("Subject?");
		String subject = sc.nextLine();
		writer.println("SUBJECT: "+subject);
		
		System.out.println("Message?");
		String message = sc.nextLine();
		writer.println(message);

		writer.println(".");
		line = reader.readLine();
		System.out.println(line);

		writer.println("QUIT");
		line = reader.readLine();
		System.out.println(line);
		
		input.close();
		output.close();
		socket.close();
		reader.close();
		writer.close();
		sc.close();

	}

}
