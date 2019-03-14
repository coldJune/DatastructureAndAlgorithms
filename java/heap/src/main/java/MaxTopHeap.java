public class MaxTopHeap {
    private int capacity;
    private int size;
    private int[] items;
    MaxTopHeap(){
        this.capacity = 10;
        this.size = 0;
        this.items = new int[capacity + 1];
    }

    public int getTop(){
        if(this.size == 0){
            return -1;
        }
        return this.items[1];
    }

    public void insert(int item){
        if(this.size < this.capacity){
            this.items[++this.size] = item;
            int i = this.size;
            while(i/2!=0){
                if(this.items[i]>this.items[i/2]){
                    swap(i/2, i);
                    i /= 2;
                }else{
                    break;
                }
            }
        }
    }

    public int deleteTop(){
        if(this.size == 0){
            return -1;
        }
        swap(1, size);
        int re = this.items[size];
        size --;
        int i = 1;
        int maxPos = i;
        while(true){
            if(i*2 <=this.size && this.items[i]< this.items[i*2]) maxPos = 2*i;
            if(i*2 + 1<= this.size && this.items[maxPos]< this.items[i*2+1]) maxPos = 2*i + 1;
            if(maxPos == i) break;
            swap(i, maxPos);
            i = maxPos;
        }
        return re;
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
