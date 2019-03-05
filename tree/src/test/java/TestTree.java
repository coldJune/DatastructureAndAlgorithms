import junit.framework.TestCase;

public class TestTree extends TestCase {
    public TestTree(String testName){
        super(testName);
    }

    public void testBST(){
        BinarySearchTree bst = new BinarySearchTree();
        for(int i=0; i<5; i++){
            int rand = (int)(Math.random() * 100);
            bst.insert(rand);
        }
        bst.pre(bst.getRoot());
        System.out.println();
        bst.mid(bst.getRoot());
        System.out.println();
        bst.behind(bst.getRoot());
        System.out.println();

    }
}
