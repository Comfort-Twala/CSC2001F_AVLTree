/**
 * Hussein's Binary Tree
 * @author Hussein Suleman
 * @version 26 March 2017
 * 
 * @param <dataType>
 */
public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   
   /**
    * Constructor to set values
    * @param n
    * @param nxt
    */
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
