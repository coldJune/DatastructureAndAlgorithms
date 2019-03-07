import junit.framework.TestCase;

public class TestHeap extends TestCase {
    public TestHeap(String testName){
        super(testName);
    }

    public void testMaxHeap(){
        MaxTopHeap mth = new MaxTopHeap();
        for(int i = 0; i < 5;i++){
            int rand = (int)(Math.random() * 100);
            mth.insert(rand);
        }
        mth.print();
        System.out.println(mth.getTop());
        for(int i = 0 ; i< 5; i++){
            System.out.print(mth.deleteTop() + " ");
        }
    }
}
