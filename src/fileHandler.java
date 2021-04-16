import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * file handling class that will:
 *   -open file
 *   -get file contents
 *   -slice relevant data 
 *   -return Array or BinarySearchTree of data
 * 
 * @author TWLCOM001 - Comfort Twala
 * @version 1.0
 * */
public class fileHandler {
	//Instance variables
	private Student[] rawData; 
	private BinarySearchTree<Student> tree;
	private Scanner fileReader;

	/**
	 * Constructor to create fileHandler and assign values to instance variables
	 * 
	 * @param file file that needs to be opened
	 * @throws FileNotFoundException when file cannot be found
	 */
	public fileHandler(String file) throws FileNotFoundException{
		this.rawData = new Student[5000];
		this.tree = new BinarySearchTree<>();
		this.fileReader = new Scanner(new File(file));
	}

	/**
	 * Method to populate a data structure with data from file depending which data structure type it is
	 * 
	 * @param type type of datastructure the method needs to populate
	 */
	private void populate(String type){
		Student student;
		int i = 0;
		while (this.fileReader.hasNextLine()){
			String data = this.fileReader.nextLine();
			student = new Student(data);
			if (type.equals("tree")){
				this.tree.insert(student);
			} else {
				this.rawData[i] = student;
			}
			i++;
		}	
		this.fileReader.close();
	}

	/**
	 * Method to return populated BinarySearchTree
	 * 
	 * @return tree
	 */
	public BinarySearchTree<Student> dataTree() {
		populate("tree");
		return this.tree;		
	}
	
	/**
	 * Method to return populated Array
	 * 
	 * @return rawData
	 */
	public Student[] dataArray() {
		populate("array");
		return this.rawData;			
	}
}
