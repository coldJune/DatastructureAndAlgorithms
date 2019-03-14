public class CircleQueue {
    private final int CAPACITY = 5;
    private int items[] ;
    private int size;
    private int head;
    private int tail;

    CircleQueue(){
        items = new int[CAPACITY];
        size = 0;
        head = 0;
        tail = 0;
    }

    public void enqueue(int item){
        if((tail+1)% CAPACITY == head){
            throw new IndexOutOfBoundsException("队列满");
        }
        items[tail] = item;
        tail = (tail+1)%CAPACITY;
        size++;
    }

    public int dequeue(){
        if(head == tail){
            throw new IndexOutOfBoundsException("队列空");
        }
        int ret = items[head];
        head = (head+1)%CAPACITY;
        size--;
        return ret;
    }

    public int getSize(){
        return size;
    }

    public void display(){
        for(int i = head; i != tail; ){
            System.out.print(items[i]+" ");
            i = (i+1)%CAPACITY;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return this.size == 0 ? true : false;
    }
}
