import java.io.FileNotFoundException;

/**
 * Class to access BSTApp class and invoke it's methods.
 * 
 * @author TWLCOM001 - Comfort Twala 
 * @version 1.0
 */
public class AccessBSTApp {
	private static BSTApp bstApp;

	public static void main(String[] args) throws FileNotFoundException{
		bstApp = new BSTApp();
		if (args.length == 0){
			bstApp.printAllStudents();
		} else {
			System.out.println(bstApp.printStudent(args[0]));
			System.out.println(bstApp.opCounter());
		}
	}	
}