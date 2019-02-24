import junit.framework.TestCase;

public class CircleQueueTest extends TestCase {
    public CircleQueueTest(String testString){
        super(testString);
    }

    public void testCircle(){
        CircleQueue queue = new CircleQueue();
        for(int i = 0; i < 20;i++){
            int rand = (int)(Math.random()*10);
            try {
                if(rand%2==0){
                    queue.enqueue(i);
                }else{
                    queue.dequeue();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.print("第"+i+"轮:");
            queue.display();
        }
    }

}
