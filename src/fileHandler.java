import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * file handling class that will:
 *   -open file
 *   -get file contents
 *   -slice relevant data 
 *   -return AVLTree of data
 * 
 * @author TWLCOM001 - Comfort Twala
 * @version 1.0
 * */
public class fileHandler {
	//Instance variables
	private AVLTree<Student> tree;
	private Scanner fileReader;

	/**
	 * Constructor to create fileHandler and assign values to instance variables
	 * 
	 * @param file file that needs to be opened
	 * @throws FileNotFoundException when file cannot be found
	 */
	public fileHandler(String file) throws FileNotFoundException{
		this.tree = new AVLTree<>();
		this.fileReader = new Scanner(new File(file));
	}

	/**
	 * Method to populate a AVLTree structure with data from file 
	 * 
	 */
	private void populate(){
		Student student;
		while (this.fileReader.hasNextLine()){
			String data = this.fileReader.nextLine();
			student = new Student(data);
			this.tree.insert(student);
		}	
		this.fileReader.close();
	}

	/**
	 * Method to return populated AVLTree
	 * 
	 * @return tree
	 */
	public AVLTree<Student> dataTree() {
		populate();
		return this.tree;		
	}
}
