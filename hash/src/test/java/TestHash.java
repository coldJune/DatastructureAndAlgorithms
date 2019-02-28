import junit.framework.TestCase;

public class TestHash extends TestCase {
    public TestHash(String testName){
        super(testName);
    }

    public void testHashTable(){
        HashTable ht = new HashTable();
        ht.insert(10);
        ht.insert(30);
        ht.insert(1);
        ht.insert(14);
        System.out.println();
        ht.print();
        ht.delete(30);
        ht.print();
        ht.insert(30);
        ht.print();

    }
}
