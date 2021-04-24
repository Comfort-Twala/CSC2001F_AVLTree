/**
 *  Hussein's Binary Tree
 * 
 * @author Hussein Suleman
 * @version 26 March 2017
 */
public class BinaryTreeNode<dataType>
{
   // Instance Variables
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;
   
   /**
    * Constructor to set values

    * @param d data
    * @param l left
    * @param r right
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
   /**
    * Method to get left node
    *
    * @return left node
    */
   BinaryTreeNode<dataType> getLeft () { return left; }

   /**
    * Method to get right node
    *
    * @return right node
    */
   BinaryTreeNode<dataType> getRight () { return right; }
}
