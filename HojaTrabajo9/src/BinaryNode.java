public class BinaryNode {
    BinaryNode( Word theElement )
    {
        this( theElement, null, null);
    }

    BinaryNode( Word theElement, BinaryNode lt, BinaryNode nt)
    {
        element     = theElement;
        left   = lt;
        right = nt;
    }

    public Word   element;
    public BinaryNode left;
    public BinaryNode right;
}