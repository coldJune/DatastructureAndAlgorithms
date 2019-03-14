public class LinkedHashTable {
    private int capacity = 11;
    private TwoWayLinkedList item[];
    LinkedHashTable(){
        item = new TwoWayLinkedList[capacity];

    }

    public void insert(int key){
        int index = hash(key);
        if(item[index] == null){
            item[index] = new TwoWayLinkedList();
        }
        item[index].delete(key);
        item[index].add(key);
    }

    public void delete(int key){
        int index = hash(key);
        if(item[index] == null){
            return;
        }
        item[index].delete(key);
        if(item[index].isEmpty()){
            item[index] = null;
        }
    }

    public void display(){
        for(int i = 0; i < capacity; i++){
            if(item[i]!=null){
                item[i].display();
            }else{
                System.out.println("null");
            }
        }
    }


    private int hash(int key){
        return key%capacity;
    }
}
