public class Queue extends LinkedList {
    Queue(){
        super();
    }

    public void enqueue(Object o){
        insert(super.size, o);
    }

    public void dequen(){
        delete(0);
    }
}
