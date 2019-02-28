public class HashTable {
    private int capacity = 10;
    private final double rate = 0.75;
    private int[] item;
    private int size;

    public HashTable(){
        item = new int[capacity];
        size = 0;
    }

    public void insert(int key){
        int index = hash(key);
        while(item[index]!=0 && item[index]!=-1){
            if(item[index]!=key){
                index = (index+1)%capacity;
            }else{
                return;
            }
        }
        item[index] = key;
        size++;
        if(size>=capacity*rate){
            int oldCapacity = capacity;
            this.capacity = capacity * 2;
            int[] temp = new int[capacity];
            for(int i = 0;i< oldCapacity; i++){
                int index_temp;
                if(item[i] != -1 && item[i]!= 0 ){
                    index_temp = hash(item[i]);
                }else{
                    continue;
                }
                while(temp[index_temp]!=0){
                    index++;
                }
                temp[index_temp] = item[i];
            }
            item = temp;
        }
    }

    public void delete(int key){
        int index = hash(key);
        int count = 0;
        while(item[index]!=key){
            index = (index+1)%capacity;
            count++;
            if(count >=capacity){
                return ;
            }
        }
        item[index] = -1;
    }

    private int hash(int key){
        return key%capacity;
    }
    public void print(){
        for (int i = 0; i < capacity; i++) {
            System.out.print(item[i]+" ");
        }
        System.out.println();
    }
}
