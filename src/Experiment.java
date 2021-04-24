import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class to perform insertion and searching experiments on AVL Tree to test performance on varying datasets of length n = (500, 1000, ..., 5000)
 * 
 * @author TWLCOM001 - Comfort Twala
 * @version 1.0
 */
public class Experiment {
    // instant variables
    private fileHandler file;
    private AVLTree<Student> tree;
    private List<Student> list;
    private List<Student> sampleList;

    /**
     * Constructor to open dataset file, create dataset list and AVLTree to be tested
     * 
     * @param n subset length
     * @throws FileNotFoundException if dataset file is not found
     * @throws CloneNotSupportedException to help create copy dataset list
     */
    public Experiment(int n) throws FileNotFoundException, CloneNotSupportedException{
        file = new fileHandler("data/oklist.txt");
        list = file.dataList();
        tree = new AVLTree<>();
        sampleList = randomSample(this.list, n); 
    }

    /**
     * Method to add data from sampleList to Tree and capture the number of insertions counts performed
     * 
     * @param n number of Objects inserted
     * @return result list with captured data
     */
    public String[] insertion(int n){
        String[] result = new String[n];
        int i = 0;
        for (Student student: this.sampleList){
            tree.insert(student);
            result[i] = student.toString() + "\n" + Integer.toString(tree.opCounter("i")) + "\n";
            i++;
        }
        return result;
    }

    /**
     * Method to search/find data from sampleList in Tree and capture the number of search counts performed
     *  
     * @param n number of Objects searched
     * @return result list with captured data
     */
    public String[] searching(int n){
        String[] result = new String[n];
        int i = 0;
        for (Student student: this.sampleList){
            tree.find(student);
            result[i] = student.toString() + "\n" + Integer.toString(tree.opCounter("f")) + "\n";
            i++;
        }
        return result;
    }


    /**
     * Method to generate a copy list of dataset list and create a randomSample list of length n using copy list values
     * 
     * @param list dataset 
     * @param n subset length
     * @return newList with random sample of Objects
     * @throws CloneNotSupportedException 
     */
    private List<Student> randomSample(List<Student> list, int n) throws CloneNotSupportedException {
        Random random = new Random();
        List<Student> tempList = new ArrayList<>();
        for (Student student: list){
            tempList.add((Student)student.clone());
        }
        List<Student> newList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int randomIndex = random.nextInt(tempList.size());
            newList.add(tempList.get(randomIndex));
            tempList.remove(randomIndex);
        }
        return newList;
    }
}