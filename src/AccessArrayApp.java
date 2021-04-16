import java.io.FileNotFoundException;

/**
 * Class to access ArrayApp class and invoke it's methods.
 * 
 * @author TWLCOM001 - Comfort Twala 
 * @version 1.0
 */
public class AccessArrayApp {
	private static ArrayApp arrayApp;

	public static void main(String[] args) throws FileNotFoundException{
		arrayApp = new ArrayApp();
		if (args.length == 0){
			arrayApp.printAllStudents();
		} else {
			System.out.println(arrayApp.printStudent(args[0]));
			System.out.println(arrayApp.opCounter());
		}	
	}
}
