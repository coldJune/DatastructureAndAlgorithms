import junit.framework.TestCase;

public class ListTest extends TestCase {
    public ListTest(String testName){
        super(testName);
    }

    public void testArrayList(){
        System.out.println("-------创建线性表-------");
        ArrayList arrayList = new ArrayList();
        System.out.println("线性表长度:"+arrayList.length());

        System.out.println("-------插入数据-------");
        arrayList.insert(0, 1);
        arrayList.insert(0, 2);
        arrayList.insert(1, 3);
        arrayList.insert(1, 4);
        arrayList.display();
        System.out.println("线性表长度:"+arrayList.length());

        System.out.println("-------获取元素-------");
        System.out.println("第0号元素:"+arrayList.get(0));
        System.out.println("值为1的元素的下标:"+arrayList.indexOf(1));
        System.out.println("值为4的元素的下标:"+arrayList.indexOf(4));
        System.out.println("值为1的元素前驱:"+arrayList.pre(1));
        System.out.println("值为1的元素的后继:"+arrayList.next(1));
        System.out.println("值为2的元素前驱:"+arrayList.pre(2));
        System.out.println("值为2的元素的后继:"+arrayList.next(2));
        System.out.println("值为3的元素前驱:"+arrayList.pre(3));
        System.out.println("值为3的元素的后继:"+arrayList.next(3));

        System.out.println("-------删除数据-------");
        arrayList.delete(0);
        System.out.println("线性表长度:"+arrayList.length());
        arrayList.display();
        arrayList.delete(arrayList.length()-1);
        System.out.println("线性表长度:"+arrayList.length());
        arrayList.display();

        System.out.println("-------清空线性表-------");
        arrayList.clear();
        System.out.println("线性表长度:"+arrayList.length());
        arrayList.display();

        System.out.println("-------判空线性表-------");
        System.out.println("线性表是否为空:"+arrayList.isEmpty());

    }
}
