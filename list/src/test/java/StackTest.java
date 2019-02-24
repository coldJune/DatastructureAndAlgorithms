import junit.framework.TestCase;

public class StackTest extends TestCase {
    public StackTest(String testName){
        super(testName);
    }

    public void testStack(){
        System.out.println("----------初始化栈----------");
        Stack stack = new Stack();
        System.out.println("栈大小："+stack.size());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.print("栈内元素");
        stack.display();

        System.out.println("----------获取栈顶----------");
        System.out.println("栈顶："+stack.getPop());
        System.out.println("栈大小："+stack.size());
        System.out.print("栈内元素");
        stack.display();

        System.out.println("----------弹栈----------");
        stack.pop();
        System.out.println("栈顶："+stack.getPop());
        System.out.println("栈大小："+stack.size());
        System.out.print("栈内元素");
        stack.display();

        System.out.println("--------判空---------");
        stack.isEmpty();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.isEmpty();
        System.out.println("栈大小："+stack.size());
        System.out.print("栈内元素");
        stack.display();

    }
    /*************************栈的应用*****************************/
    /**
     * 进制转换
     */
    public void testConversion(){
        int in = 7;
        int N = 2;
        Stack stack = new Stack();
        while(in != 0){
            stack.push(in % N);
            in /= N;
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
    //浏览器前进后退
    public void testPreAndBack(){
        Stack back = new Stack();
        Stack pre = new Stack();
        back.push(1);
        back.push(2);
        back.push(3);
        pre.push(back.pop());
        pre.push(back.pop());
        back.display();
        System.out.println();
        pre.display();
    }
}
