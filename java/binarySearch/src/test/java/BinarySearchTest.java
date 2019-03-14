import junit.framework.TestCase;

public class BinarySearchTest extends TestCase {
    public BinarySearchTest(String testName){
        super(testName);
    }

    public void testBinarySearch(){
        int[] a = {1, 2, 6, 9, 16, 17, 40, 40, 43, 43, 47, 51, 58, 67, 74, 74, 80, 81, 89, 93 };
        BinarySearch bs = new BinarySearch();
        int fe = bs.findFirstEqual(a, 43, 20);
        int le = bs.findLastEqual(a,43, 20);
        int fge = bs.findFirstGe(a, 74,20);
        int lle = bs.findLastLe(a, 74, 20);
        System.out.println("第一个等于给定值43的下标为："+fe+
                            "\n最后一个等于给定值43的下标为："+le+
                            "\n第一个大于等于给定值的74下标为："+ fge+
                            "\n最后一个小于等于给定值74的下标为："+ lle);

    }
}
