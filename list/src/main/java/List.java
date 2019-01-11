public interface List {
    /**
     * 清空线性表
     */
    public void clear();

    /**
     * 判空
     * @return
     */
    public boolean isEmpty();

    /**
     * 线性表的长度
     * @return
     */
    public int length();

    /**
     * 获取相应位置的元素
     * @param index
     * @return
     */
    public Object get(int index);

    /**
     * 获取线性表中第一个相应的位置
     * @param o
     * @return
     */
    public int indexOf(Object o);

    /**
     * 获取当前元素的前驱
     * @param o
     * @return
     */
    public Object pre(Object o);

    /**
     * 获取当前元素的后继
     * @param o
     * @return
     */
    public Object next(Object o);

    /**
     * 在对应位置插入元素
     * @param i
     * @param o
     */
    public void insert(int index, Object o);

    /**
     * 删除相应位置的元素
     * @param i
     */
    public void delete(int index);

    /**
     * 打印线性表
     */
    public void display();
}
