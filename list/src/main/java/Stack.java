public class Stack extends ArrayList{
    private int top;
    private int base;

    Stack(){
        super();
        this.top = -1;
        this.base = -1;
    }
    public int size(){
        return super.size;
    }

    /**
     * 弹栈
     */
    public Object pop(){
        if(top - base<=0){
            throw new IndexOutOfBoundsException("栈空无法进行弹栈操作");
        }
        size--;
        return this.items[top--];
    }

    /**
     * 入栈
     * @param o
     */
    public void push(Object o){
        this.insert(size,o);
        top++;
    }

    /**
     *获取栈顶元素
     */
    public Object getPop(){
        if(top<0){
            throw new IndexOutOfBoundsException("栈为空");
        }
        return items[top];
    }
    /**
     * 判空
     */
    public boolean isEmpty(){
        return size == 0 ? true:false;
    }

    public void display(){
        for(int i=top;i>base;i--){
            System.out.print(super.items[i]+" ");
        }
    }
}
