import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class EchoClient {
	public static void main(String[] args) throws Exception {

		try {
			Socket echoSocket = null;
			PrintWriter out = null;
			BufferedReader in = null;
	
			echoSocket = new Socket("192.168.1.118", 9004);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket
					.getInputStream()));
	
			BufferedReader stdIn = new BufferedReader(
						new InputStreamReader(System.in));


		
			while (in!=null) {
				try{						
					System.out.print("client> ");
					out.println(stdIn.readLine());
					System.out.println("echo from server: '" + in.readLine()+"'");
						
		        } catch (Exception e) {
		        	System.out.println("Fehler " + e.getMessage() + " auf dem Client:");
		        	System.out.println(e.getStackTrace());
		        	break;
		        }					
			}

		out.close();
		in.close();
		echoSocket.close();
		
        } catch (Exception e) {
        	System.out.println("Fehler " +e.getMessage() + " beim initalisieren:");
        	System.out.println(e.getStackTrace());
        	
        }
	}
}
