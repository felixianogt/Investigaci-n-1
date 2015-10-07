//http://users.cis.fiu.edu/~weiss/dsaajava/code/DataStructures/
// SplayTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Exceptions are thrown by insert and remove if warranted

/**
 * Implements a top-down splay tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class SplayTree implements WordSet 
{
    /**
     * Construct the tree.
     */
    public SplayTree( )
    {
        root = nullNode;
    }

    private static BinaryNode newNode = null;  // Used between different inserts
    
    /**
     * Insert into the tree.
     * @param x the item to insert.
     * @throws DuplicateItemException if x is already present.
     */
    public void add( Word wordObject )
    {
        if( newNode == null )
            newNode = new BinaryNode( null );
        newNode.element = wordObject;

        if( root == nullNode )
        {
            newNode.left = newNode.right = nullNode;
            root = newNode;
        }
        else
        {
            root = splay( wordObject, root );
            if( wordObject.compareTo( root.element ) < 0 )
            {
                newNode.left = root.left;
                newNode.right = root;
                root.left = nullNode;
                root = newNode;
            }
            else
            if( wordObject.compareTo( root.element ) > 0 )
            {
                newNode.right = root.right;
                newNode.left = root;
                root.right = nullNode;
                root = newNode;
            }
            //else
                //throw new DuplicateItemException( wordObject.toString( ) );
        }
        newNode = null;   // So next insert will call new
    }
    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public Comparable find( Word x )
    {
        root = splay( x, root );

        if( isEmpty( ) || root.element.compareTo( x ) != 0 )
            return null;

        return root.element;
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = nullNode;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == nullNode;
    }

    private static BinaryNode header = new BinaryNode( null ); // For splay
    
    /**
     * Internal method to perform a top-down splay.
     * The last accessed node becomes the new root.
     * @param x the target item to splay around.
     * @param t the root of the subtree to splay.
     * @return the subtree after the splay.
     */
    private BinaryNode splay( Word x, BinaryNode t )
    {
        BinaryNode leftTreeMax, rightTreeMin;

        header.left = header.right = nullNode;
        leftTreeMax = rightTreeMin = header;

        nullNode.element = x;   // Guarantee a match

        for( ; ; )
            if( x.compareTo( t.element ) < 0 )
            {
                if( x.compareTo( t.left.element ) < 0 )
                    t = Rotations.WithLeftChild( t );
                if( t.left == nullNode )
                    break;
                // Link Right
                rightTreeMin.left = t;
                rightTreeMin = t;
                t = t.left;
            }
            else if( x.compareTo( t.element ) > 0 )
            {
                if( x.compareTo( t.right.element ) > 0 )
                    t = Rotations.WithRightChild( t );
                if( t.right == nullNode )
                    break;
                // Link Left
                leftTreeMax.right = t;
                leftTreeMax = t;
                t = t.right;
            }
            else
                break;

        leftTreeMax.right = t.left;
        rightTreeMin.left = t.right;
        t.left = header.right;
        t.right = header.left;
        return t;
    }

    public Word get( Word word )
    {
        BinaryNode newTree;

            // If x is found, it will be at the root
        root = splay( word, root );
        if( root.element.compareTo( word ) != 0 )
            return null;   // Item not found; do nothing
        else
                return root.element;    // Item found
    }
    
    private BinaryNode root;
    private static BinaryNode nullNode;
    
    static         // Static initializer for nullNode
    {
        nullNode = new BinaryNode( null );
        nullNode.left = nullNode.right = nullNode;
    }
}