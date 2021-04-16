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
	 * Constructor to craete and assign values to BSTApp
	 * 
	 * @throws FileNotFoundException
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
	 * Method to print all student details within the BinarySearchTree  
	 */	
    public void printAllStudents() {
		tree.inOrder();
	}

	/**
	 * Method to return number of operations performed when searching through BST
	 * 
	 * @return opCount number of opertions performed by BST find method
	 */
	public int opCounter(){
		return tree.opCounter();
	}
}