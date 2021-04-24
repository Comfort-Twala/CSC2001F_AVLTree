/**
 * Hussein's Binary Tree
 * @author Hussein Suleman
 * @version 26 March 2017
 * 
 * @param <dataType>
 */
public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;
   
   /**
    * Constructor to set values to null
    */
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
   /**
    * Method to get next node in queue
    *
    * @return next node
    */
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   
   /**
    * Method to add node to the queue
    *
    * @param node
    */
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);
         tail = tail.next;
      }   
   }   
}
