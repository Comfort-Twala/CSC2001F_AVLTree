import java.io.FileNotFoundException;

/**
 * Class to access AVLApp class and invoke it's methods.
 * 
 * @author TWLCOM001 - Comfort Twala 
 * @version 1.0
 */
public class AccessAVLApp {
	private static AVLApp avlApp;

	public static void main(String[] args) throws FileNotFoundException{
		avlApp = new AVLApp();
		if (args.length == 0){
			avlApp.printAllStudents();
		} else {
			System.out.println(avlApp.printStudent(args[0]));
			System.out.println("find: " + avlApp.opCounter("f"));
			System.out.println("insert: " + avlApp.opCounter("i"));
		}
	}	
}