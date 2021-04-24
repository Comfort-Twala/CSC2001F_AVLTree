import java.io.FileNotFoundException;

/**
 * Application AVLApp to store and retrieve data using the AVL data structures.
 * 
 * @author TWLCOM001 - Comfort Twala 
 * @version 1.0
 */
public class AccessAVLApp {
	// Instance Variable of AVLApp with methods required to be accessed.
	private static AVLApp avlApp;

	/**
	 * Driver method to access AVLApp methods and run Application
	 * 
	 * @param args studentNumber when searching for student in the AVLTree
	 * @throws FileNotFoundException if "oklist.txt" file is not found
	 */
	public static void main(String[] args) throws FileNotFoundException{
		avlApp = new AVLApp();
		if (args.length == 0){
			avlApp.printAllStudents();
		} else {
			System.out.println(avlApp.printStudent(args[0]));
		}
	}	
}