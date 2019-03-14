public class MinTopHeap {
    private int capacity = 10;
    private int size;
    private int[] items;

    MinTopHeap(){
        this.items = new int[capacity + 1];
        size = 0;
    }

    public void insert(int item){
        if(this.size < this.capacity){
            this.items[++this.size] = item;
            int i = this.size;
            while(i/2 != 0){
                if(this.items[i]<this.items[i/2]){
                    swap(i, i/2);
                    i = i/2;
                }else{
                    break;
                }
            }
        }
    }

    public int deleteTop(){
        int re = -1;
        if(this.size != 0){
            swap(1,this.size);
            re = this.items[this.size];
            this.size--;
            int i = 1;
            int minPos = i;
            while(true){
                if(i*2 <= this.size && this.items[i] > this.items[i*2]) minPos = i*2;
                if(i*2+1 <= this.size && this.items[minPos]> this.items[i*2+1]) minPos = i*2+1;
                if(minPos == i) break;
                swap(i, minPos);
                i = minPos;
            }
            return re;

        }
        return re;
    }

    public int getTop(){
        if(this.size != 0){
            return this.items[1];
        }
        return -1;
    }

    public void print(){
        for(int i = 1; i<=this.size;i++){
            System.out.print(this.items[i]+" ");
        }
        System.out.println();
    }
    private void swap(int i, int j){
        int temp = this.items[i];
        this.items[i] = this.items[j];
        this.items[j] = temp;
    }
}
