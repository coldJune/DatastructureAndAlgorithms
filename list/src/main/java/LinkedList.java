public class LinkedList implements List {
    private Node head;
    private int size;
    LinkedList(){
        head = new Node(null,null);
        size = 0;
    }
    public void clear() {
        for(Node p = head;p.next!=null;p=p.next){
            Node q = p.next;
            q.next = null;
            q.data = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    public int length() {
        return size;
    }

    public Object get(int index) {
        if(index <0 || index >=size){
            throw new IndexOutOfBoundsException("illegal index:"+index+">"+size);
        }
        Node p = head;
        for(int i=0;i<=index;i++){
            p = p.next;
        }
        return p.data;
    }

    public int indexOf(Object o) {
        Node p = head.next;
        for(int i = 0;i < size;i++){
            if(p.data.equals(o)){
                return i;
            }
            p = p.next;
        }
        return -1;
    }

    public Object pre(Object o) {
        int index = indexOf(o);
        if(index == -1 ||index == 0){
            return null;
        }else {
            return get(index - 1);
        }
    }

    public Object next(Object o) {
        int index = indexOf(o);
        if(index == -1 || index == 0 || index >= size-1){
            return null;
        }else{
            return get(index+1);
        }
    }

    public void insert(int index, Object o) {
        Node p = head;
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("illegal index:"+index+"{"+size+"}");
        }
        for(int i = 0; i<=index -1;i++){
            p = p.next;
        }

        Node q = new Node(o, null);
        q.next = p.next;
        p.next = q;

        size++;
    }

    public void delete(int index) {
        Node p =head;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("illegal index:"+index+"{"+size+"}");
        }
        for(int i = 0; i<=index -1;i++){
            p = p.next;
        }
        Node back = p.next;
        p.next = p.next.next;
        size--;
    }

    public void display() {
        int i = 0;
        for(Node p = head.next;i<size;p=p.next,i++){
            System.out.print(p.data+" ");
        }
        System.out.println();
    }
    public Node getHead(){
        return head;
    }

    public void union(List lb) {
        Node pa = head;
        Node pb = ((LinkedList)lb).getHead().next;
        Node pc;
        while(pb!=null){
            if(this.indexOf(pb.data)==-1){
                pc = pb.next;
                pb.next = pa.next;
                pa.next = pb;
                pb = pc;
                pa = pa.next;
                size++;
            }else{
                pb = pb.next;
            }
        }
    }

    public List merge(List lb) {
        Node pa = head.next;
        Node pb = ((LinkedList)lb).getHead().next;
        Node pc = head;
        while(pa !=null && pb !=null){
            if((Integer)pa.data <= (Integer)pb.data){
                pc.next = pa;
                pc = pa;
                pa = pa.next;
                size++;
            }else{
                pc.next = pb;
                pc = pb;
                pb = pb.next;
            }
        }

        pc.next = pa!=null?pa:pb;
        return null;
    }
}

class Node{
     Object data;
     Node next;
     Node(Object data, Node next){
         this.data = data;
         this.next = next;
     }

}


