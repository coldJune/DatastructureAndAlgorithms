import junit.framework.TestCase;

public class QueueTest extends TestCase {
    public QueueTest(String stringName){
        super(stringName);
    }

    public void testQueue(){
        Queue queue = new Queue();
        System.out.println("-------初始化队列-集合-------");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.display();

        queue.dequen();
        queue.display();
        queue.length();
    }
}
