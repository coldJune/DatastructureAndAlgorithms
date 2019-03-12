import junit.framework.TestCase;

public class TestGraph extends TestCase {
    public TestGraph(String testName){
        super(testName);
    }

    public void testLinkedGraph(){
        LinkedGraph lg = new LinkedGraph(5);
        lg.addEdge(0,1);
        lg.addEdge(0,2);
        lg.addEdge(1,2);
        lg.addEdge(2,3);
        lg.addEdge(3,4);
        lg.addEdge(2,4);
        lg.display();
        lg.bfs(0,3);
        System.out.println();
        lg.dfs(0,3);
    }
}
