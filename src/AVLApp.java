import java.io.FileNotFoundException;

/**
 * Class that creates AVLTree from data list received from file
 * 
 * @author TWLCOM001 - Comfort Twala
 * @version 1.0
 */
public class AVLApp {
    // Instance variables
    private fileHandler file;
    private AVLTree<Student> tree;

	/**
	 * Constructor to create and assign values to AVLApp
	 * 
	 * @throws FileNotFoundException if Dataset file is not found.
	 */
    public AVLApp() throws FileNotFoundException{
        this.file = new fileHandler("data/oklist.txt");
        this.tree = file.dataTree();
    }

	/**
	 * Method to print student details given the student's studentID
	 * 
	 * @param studentID
	 * @return Student name belonging to studentID.
	 */
    public String printStudent(String studentID) {
        Student student = new Student(studentID, "temp");
        if (tree.find(student) != null){
            return tree.find(student).data.fullName();
        }
		return "Access Denied!";       
    }	

	/**
	 * Method to print all student details within the AVLTree  
	 */	
    public void printAllStudents() {
		tree.treeOrder();
	}

	/**
	 * Method to return number of operations performed when searching and inserting students into AVL tree
	 * 
	 * @param type "f" for find and "i" for insert
	 * @return opCount number of opertions performed by AVL insert and find method
	 */
	public int opCounter(String type){
		if (type.equals("f"))
			return tree.opCounter("f");
		return tree.opCounter("i");
	}
}