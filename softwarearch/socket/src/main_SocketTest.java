import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class main_SocketTest {

	public static void main(String[] args) {
		try {
			Socket echoSocket = null;
			PrintWriter out = null;
			BufferedReader in = null;
	
			echoSocket = new Socket("10.199.12.100", 9001);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket
					.getInputStream()));
	
			BufferedReader stdIn = new BufferedReader(
						new InputStreamReader(System.in));

		
			while (in!=null) {
				try{						
					System.out.print("client> ");
					out.println(stdIn.readLine());
					System.out.println("test: echo from server: '" + in.readLine()+"'");

		        } catch (Exception e) {
		        	System.out.println("Fehler " + e.getMessage() + " auf dem teset:");
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
