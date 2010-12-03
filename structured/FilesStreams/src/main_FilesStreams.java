import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class main_FilesStreams {

	/**
	 * RandomAccessFile
	 * @param args
	 */
	public static void main(String[] args) {
		FileOutputStream fo;
		try {
			fo = new FileOutputStream("test");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataOutputStream dof = new DataOutputStream(fo);
		
	}
	


}
