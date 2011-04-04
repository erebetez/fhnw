import java.io.*;
import org.omg.CORBA.*;
import math.*;

public class Client {
	public static void main(String args[]) {
		try {
			//"Statistics.ref"
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			String objref = in.readLine();

			// initialize the ORB
			ORB orb = ORB.init(args, null);
			// get object reference from command line
			org.omg.CORBA.Object obj = orb.string_to_object(objref);

			Statistics statistics = StatisticsHelper.narrow(obj);
			if (statistics == null) {
				System.err
						.println("stringified object reference is wrong type");
				System.exit(-1);
			}
			double n[] = { 1, 2, 3, 4, 3, 2, 1 };
			statistics.setNumbers(n);
			System.out.println("Average is " + statistics.getAverage());
		} catch (SystemException ex) {
			System.out.println(ex);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
