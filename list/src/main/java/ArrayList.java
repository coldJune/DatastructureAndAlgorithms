public class ArrayList implements List {
    //线性表的大小
    protected int size;
    //线性表的最大长度
    protected int maxLen;
    //线性表的元素集合
    protected Object[] items;
    //线性表的默认长度
    protected static final int DEFAULT_LENGTH = 3;

    ArrayList(){
        this.size = 0;
        this.items = new Object[DEFAULT_LENGTH];
        this.maxLen = DEFAULT_LENGTH;
    }
    public void clear() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size==0?true:false;
    }

    public int length() {
        return size;
    }

    public Object get(int index) {
        if(index <0 || index > size-1){
            throw new IndexOutOfBoundsException("illegal index:" +index+">"+size);
        }
        return items[index];
    }

    public int indexOf(Object o) {
        if(o == null){
            throw new IllegalArgumentException("illegal item:"+o);
        }
        int i = 0;
        for (Object item:items){
            if(o.equals(item)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public Object pre(Object o) {
        int index = indexOf(o);
        if(index == -1 || index == 0){
            return null;
        }else{
            return items[index - 1];
        }
    }

    public Object next(Object o) {
        int index = indexOf(o);
        if(index == -1 || index == size -1){
            return null;
        }else{
            return items[index + 1];
        }
    }

    public void insert(int index, Object o) {
        if(index< 0 || index > size){
            throw new IndexOutOfBoundsException("illegal index:"+index);
        }
        if(size >= maxLen-1){
            expand();
        }
        for(int i=size; i>= 0; i--){
            if(i==index){
                items[i] = o;
                break;
            }else{
                items[i]=items[i-1];
            }
        }
        size++;
    }

    public void delete(int index) {
        if(index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("illegal index:"+ index);
        }
        for(int i = index; i < size-1;i++){
            items[i]=items[i+1];
        }
        size--;
    }

    public void display() {
        int i = 0;
        for (Object item:
             items) {
            if(i == size){
                System.out.println();
                break;
            }
            System.out.print(item + " ");
            i++;
        }
    }

    protected void expand(){
        maxLen = 2*maxLen;
        Object[] newItems = new Object[maxLen];
        int i = 0;
        for (Object item:items) {
            newItems[i] = item;
            i++;
        }
        items = newItems;
    }

    public void union(List lb) {
        for(int i = 0; i<lb.length();i++){
            if(this.indexOf(lb.get(i)) == -1){
                this.insert(size,lb.get(i));
            }
        }
    }

    public ArrayList merge(List lb) {
        ArrayList newList = new ArrayList();
        int length = lb.length();
        int i,j;
        for( i = size-1,j = length-1;i>=0 && j>=0;){
            if((Integer)items[i]<(Integer) lb.get(j)){
                newList.insert(0,lb.get(j));
                j--;
            }else{
                newList.insert(0,items[i]);
                i--;
            }
        }
        if (i < 0 && j >= 0){
            for(int k=j;k>=0;k--){
                newList.insert(0,lb.get(k));
            }
        }
        if(i >= 0 ){
            for(int k=i;k>=0;k--){
                newList.insert(0,items[k]);
            }
        }
        return newList;
    }
}
