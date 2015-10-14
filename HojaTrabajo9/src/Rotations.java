final class Rotations
    {
        
        static BinaryNode WithLeftChild( BinaryNode k2 )
        {
            BinaryNode k1 = k2.left;
            k2.left = k1.right;
            k1.right = k2;
            return k1;
        }

        
        static BinaryNode WithRightChild( BinaryNode k1 )
        {
            BinaryNode k2 = k1.right;
            k1.right = k2.left;
            k2.left = k1;
            return k2;
        }

        
        static BinaryNode doubleWithLeftChild( BinaryNode k3 )
        {
            k3.left = WithRightChild( k3.left );
            return WithLeftChild( k3 );
        }

        
        static BinaryNode doubleWithRightChild( BinaryNode k1 )
        {
            k1.right = WithLeftChild( k1.right );
            return WithRightChild( k1 );
        }
    }


