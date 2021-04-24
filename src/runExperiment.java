import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Driver class to run Experiment class and perform experiments and write captured data onto a file
 * 
 * @author TWLCOM001 - Comfort Twala
 */
public class runExperiment {
    // Instance Variables
    private static Experiment experiment;
    private static File insertFile;
    private static File findFile;
    private static FileWriter writer;

    /**
     * Driver method to run experiment
     * 
     * @param args
     * @throws CloneNotSupportedException
     * @throws IOException
     */
    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        for (int n = 500; n < 5001; n += 500){
            // Create a Experiment instance of subset length n
            experiment = new Experiment(n);
            try {
                // INSERTION  
                insertFile = new File("data/experiment/insert/AVL_insert_n_" + Integer.toString(n) + ".txt");
                writer = new FileWriter(insertFile);
                writer.write("Insert opcount when n = " + Integer.toString(n) + "\n");
                String[] result = experiment.insertion(n);
                for (String entry: result){
                    writer.write(entry);
                }    
                writer.close();
                // SEARCHING
                findFile = new File("data/experiment/find/AVL_find_n_" + Integer.toString(n) + ".txt");
                writer = new FileWriter(findFile);
                writer.write("Find opcount when n = " + Integer.toString(n) + "\n");
                result = experiment.searching(n);
                for (String entry: result){
                    writer.write(entry);
                }
            } catch (Exception e) {
                System.out.println("Something went wrong");
            } finally {
                writer.close();
            }
        }
    }
}