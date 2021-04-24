/**
 * Hussein's Binary Tree
 *
 * BinaryTree data structure of type <dataType>
 * 
 * @author Hussein Suleman, modified by Comfort Twala
 * @version 26 March 2017
 * @param <dataType>
 */
public class BinaryTree<dataType>
{
   // Instance Variables
   BinaryTreeNode<dataType> root;
   int findCount;
   int insertCount;
   
   /**
    * Constructor to set root, and instrumentation counters as 0
    */
   public BinaryTree ()
   {
      root = null;
      findCount = 0;
      insertCount = 0;
   }
   
   /**
    * Method to get height of the Tree

    * @return height of the tree
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   /**
    * Method to get Size of the tree
    *
    * @return size of the tree
    */
   public int getSize ()
   {
      return getSize (root);
   }   
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   /**
    * Method to print out the data of the node
    *
    * @param node which data must be printed
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   
   /**
    * Method to print the tree in reverse order
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }


   /**
    * Method used to copy the tree 
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }

   /**
    * Method to print the tree in order
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }

   /**
    * Method to print the tree by level
    */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }

   /**
    * Method to increment instrumentation counters depending on type
    *
    * @param type of count to be incremented, "f" for findCount and "i" for insertCount
    */
   public void incrementOpCount(String type){
      if (type.equals("f")){
         this.findCount++;
      } else{
         this.insertCount++;
      }
   }

   /**
    * Method to set counters back to 0
    */
   public void resetCount(){
      this.insertCount = 0;
      this.findCount = 0;
   }

   /**
    * Method to return the counter value depending on type 
    *
    * @param type to be returned, "f" for findCount and "i" for insertCount
    * @return count depending on type
    */
   public int opCounter(String type){
      if (type.equals("f"))
         return this.findCount;
      return this.insertCount;
   }
}
