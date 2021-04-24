/**
 * Hussein's AVL Tree
 * reference: kukuruku.co/post/avl-trees/
 * 
 * AVLTree data structure of type <dataType> that extends BinaryTree<dataType> data structure and adds AVLTree specific methods.
 * 
 * @author Hussein Suleman, modified by Comfort Twala 
 * @version 2 April 2017
 * @param <dataType> type of Object the AVLTree stores
 */
public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   /**
    * Method to return the height of a node in the tree.
    *
    * @param node which height is required 
    * @return height of the node
    */
   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   /**
    * Method to determin the balance factor of the node.
    *
    * @param node which balanceFactor is required
    * @return balanceFactor of node
    */
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   
   /**
    * Method to adjust the height of the node.
    *
    * @param node which height needs to be adjusted.  
    */
   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   /**
    * Method to rotate left node to the right node
    * 
    * @param p node that is rotated
    * @return BinaryTreeNode<dataType> 
    */
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   /**
    * Method to rotate right node to the left node
    * 
    * @param q node that is rotated
    * @return BinaryTreeNode<dataType> 
    */
   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   /**
    * Method to balance AVLtree 
    *
    * @param p node at which balancing takes place
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      incrementOpCount("i");
      if (balanceFactor (p) == 2)
      {
         incrementOpCount("i");
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      incrementOpCount("i");
      if (balanceFactor (p) == -2)
      {
         incrementOpCount("i");
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   /**
    * Method to insert Object into AVLTree
    *
    * @param d Object that is inserted
    */
   public void insert ( dataType d )
   {
      resetCount();
      root = insert (d, root);
   }

   /**
    * Method to insert Object at selected node into AVLTree 
    *
    * @param d Object that is inserted
    * @param node at which the Object is inserted at
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      incrementOpCount("i");
      if (node == null)
         return new BinaryTreeNode<dataType> (d, null, null);
      if (d.compareTo (node.data) <= 0){
         incrementOpCount("i");
         node.left = insert (d, node.left);
      } else {
         incrementOpCount("i");
         node.right = insert (d, node.right);
      }
      return balance (node);
   }
   
   /**
    * Method to delete Object from AVLTree 
    *
    * @param d Object that is deleted
    */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   

   /**
    * Method to delete Object at selected node from AVLTree 
    *
    * @param d Object that is deleted
    * @param node at which the Object is deleted at
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   
   /**
    * Method to find the Minimum node
    *
    * @param node to start searching for the minimum node
    * @return minimum node
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   /**
    * Method to remove the Minimum node
    *
    * @param node to start searching for the minimum node
    * @return new tree without node
    */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   /**
    * Method to find Object given
    *
    * @param d Object to be searched
    * @return node where Object is found
    */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      resetCount();
      incrementOpCount("f");
      if (root == null)
         return null;
      else
         return find (d, root);
   }

   /**
    * Method to find Object starting at node 
    * @param d Object to be searched
    * @param node to start searching from
    * @return node where Object is found
    */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      incrementOpCount("f");
      if (d.compareTo (node.data) == 0) 
         return node;
      else if (d.compareTo (node.data) < 0){
         incrementOpCount("f");
         return (node.left == null) ? null : find (d, node.left);
      }
      else{
         incrementOpCount("f");
         return (node.right == null) ? null : find (d, node.right);
      }
   }
   
   /**
    * Method to print AVLTree in order
    */
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }

   /**
    * Method to print AVLTree in order starting at level
    *
    * @param node to start printing at
    * @param level to start printing at
    */
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}
