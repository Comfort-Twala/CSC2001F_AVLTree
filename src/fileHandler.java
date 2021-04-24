import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * file handling class that will:
 *   -open file
 *   -get file contents
 *   -slice relevant data 
 *   -return AVLTree and ArrayList of data
 * 
 * @author TWLCOM001 - Comfort Twala
 * @version 2.0
 * */
public class fileHandler {
	//Instance variables
	private AVLTree<Student> tree;
	private List<Student> list;
	private Scanner fileReader;

	/**
	 * Constructor to create fileHandler and assign values to instance variables
	 * 
	 * @param file file that needs to be opened
	 * @throws FileNotFoundException when file cannot be found
	 */
	public fileHandler(String file) throws FileNotFoundException{
		this.tree = new AVLTree<>();
		this.list = new ArrayList<>();
		this.fileReader = new Scanner(new File(file));
	}

	/**
	 * Method to populate a AVLTree or Array structure with data from file depending on the type
	 *  
	 * @param type 't' for AVLtree and 'l' for list
	 */
	private void populate(String type){
		Student student;
		while (this.fileReader.hasNextLine()){
			String data = this.fileReader.nextLine();
			student = new Student(data);
			if (type.equals("t")){
				this.tree.insert(student);
			} else {
				this.list.add(student);
			}
		}	
		this.fileReader.close();
	}

	/**
	 * Method to return populated AVLTree
	 * 
	 * @return tree
	 */
	public AVLTree<Student> dataTree() {
		populate("t");
		return this.tree;		
	}

	/**
	 * Method to return populated ArrayList
	 * 
	 * @return list
	 */
	public List<Student> dataList() {
		populate("l");
		return this.list;
	}
}
