public class LinkedGraph {
    private int v;
    private LinkedList graph[];
    LinkedGraph(int v){
        this.graph = new LinkedList[v];
        this.v = v;
        for(int i = 0 ;i < v;i ++){
            this.graph[i] = new LinkedList();
        }
    }

    public void addEdge(int i, int j){
        if(this.v <= i || this.v <=j){
            return;
        }
        this.graph[i].insert(0,j);
        this.graph[j].insert(0,i);

    }

    public void bfs(int s, int t){
        if(s == t) return;
        boolean[] visted = new boolean[this.v];
        visted[s] = true;
        CircleQueue queue = new CircleQueue();
        queue.enqueue(s);
        int[] prev = new int[this.v];
        for(int i=0; i< this.v; i++){
            prev[i] = -1;
        }
        while (!queue.isEmpty()){
            int temp =  queue.dequeue();
            for(int i =0 ; i < this.graph[temp].length();i++){
                int q = (int)this.graph[temp].get(i);
                if(!visted[q]){
                    prev[q] = temp;
                    if(q == t){
                        print(prev, s, t);
                        return;
                    }
                    visted[q] = true;
                    queue.enqueue(q);
                }
            }
        }
    }

    public void dfs(int s, int t){

        int[] prev = new int[this.v];
        boolean[] visited = new boolean[this.v];
        for(int i=0;i <this.v; i++){
            prev[i] = -1;
            visited[i]=false;
        }
        recurDfs(prev, visited, s, t);
        print(prev, s, t);

    }

    private void recurDfs(int[] prev, boolean[] visited, int s, int t){
        visited[s] = true;
        if(s == t){
            return;
        }
        for(int i=0;i<this.graph[s].length();i++){
            int temp = (int)this.graph[s].get(i);
            if(!visited[temp]){
                prev[temp] = s;
                recurDfs(prev, visited, temp, t);
            }
        }

    }

    private void print(int[] prev, int s, int t){
        if(prev[t] != -1 && t != s){
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public void display(){
        for(int i = 0; i < this.v; i++){
            for(int j = 0; j < this.v ; j++){
                if(this.graph[i].indexOf(j) != -1){
                    System.out.print(1 + " ");
                }else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

}
