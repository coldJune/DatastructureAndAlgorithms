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
    public void testLinkedHashTable(){
        LinkedHashTable lht = new LinkedHashTable();
        int[] items = new int[20];
        for(int i = 0; i< 20; i++){
            int item = (int)(Math.random() * 20 + 1);
            lht.insert(item);
            items[i] = item;
        }
        lht.display();
        System.out.println("-------");
        for(int i = 0; i < 10; i++){
            lht.delete(items[i]);
        }
        lht.display();
    }
}
