public class TwoWayLinkedList {
    private int size;
    private Node2 head;
    private Node2 tail;

    TwoWayLinkedList(){
        this.head = new Node2();
        this.tail = new Node2();
        head.next = tail;
        tail.pre = head;
        this.size = 0;
    }

    public void insert(int index, int data){
        if(index > size){
            return;
        }
        Node2 temp = head.next;
        for(;index>0;index--){
            temp = temp.next;
        }
        Node2 newNode2 = new Node2(data);
        newNode2.next = temp;
        newNode2.pre = temp.pre;
        temp.pre.next = newNode2;
        temp.pre = newNode2;
        size++;
    }
    public void add(int data){
        Node2 newNode2 = new Node2(data);
        newNode2.next = tail;
        newNode2.pre = tail.pre;
        tail.pre.next = newNode2;
        tail.pre = newNode2;
        size++;
    }

    public void delete(int data){
        Node2 temp = head;
        while(temp!=null){
            if(temp.data==data){
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                size--;
                break;
            }
            temp = temp.next;
        }
    }

    public void display(){
        Node2 temp = head.next;
        while(temp !=tail && temp.next != tail){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        if(temp!=tail){
            System.out.println(temp.data);
        }
    }
}


class Node2{
    int data;
    Node2 next;
    Node2 pre;
    Node2(int data){
        this.data = data;
    }
    public Node2(){
        next = null;
        pre = null;
    }
}