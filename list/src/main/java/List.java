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
     * 平均时间复杂度为O(n/2) -->O(n)
     * @param index
     * @param o
     */
    public void insert(int index, Object o);

    /**
     * 删除相应位置的元素
     * 平均时间复杂度为O((n-1)/2) -->O(n)
     * @param index
     */
    public void delete(int index);

    /**
     * 打印线性表
     */
    public void display();

    /**
     * 两个列表的并集
     * 时间复杂度为O(la.length * lb.length)
     * @param lb
     */
    public void union(List lb);

    /**
     * 按序合并两个线性表
     * 时间复杂度为O(la.length + lb.length)
     * @param lb
     */
    public List merge(List lb);
}
