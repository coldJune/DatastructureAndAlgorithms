public class MatrixGraph {
    private int v;
    private int[][]  items;
    MatrixGraph(int v){
        this.v = v;
        this.items = new int[v][v];
    }

    public void addEdge(int i, int j){
        this.items[i][j] = 1;
        this.items[j][i] = 1;
    }

    public void bfs(int s, int t){
        boolean[] visited = new boolean[this.v];
        int[] prev = new int[this.v];
        for(int i=0; i < this.v; i++){
            prev[i] = -1;
        }
        CircleQueue queue = new CircleQueue();
        queue.enqueue(s);
        while(!queue.isEmpty()){
            int temp =  queue.dequeue();
            for(int i=0; i<this.v;i++){
                if(this.items[temp][i]== 1 ){
                    if(!visited[i]){
                        prev[i] = temp;
                        if(i == t){
                            print(prev, s, t);
                            break;
                        }
                        visited[i] = true;
                        queue.enqueue(i);
                    }
                }
            }
        }
    }

    public void dfs(int s, int t){
        int[] prev = new int[this.v];
        boolean[] visited = new boolean[this.v];
        for(int i = 0; i < this.v; i++){
            prev[i] = -1;
        }
        recurDfs(prev, visited, s, t);
        print(prev, s, t);
    }

    private void recurDfs(int[] prev, boolean[] visited, int s, int t){
        visited[s] = true;
        if(s == t){
            return;
        }
        for(int i = 0 ;i < this.v; i++){
            if(this.items[s][i] == 1){
                if(!visited[i]){
                    prev[i] = s;
                    recurDfs(prev, visited, i, t);
                }
            }

        }
    }

    public void print(int[] prev, int s, int t){
        if(prev[t] != -1 && s != t){
            print(prev, s,prev[t]);
        }
        System.out.print(t + " ");
    }

    public void display(){
        for(int i = 0; i < this.v; i++){
            for(int j = 0; j < this.v; j++){
                System.out.print(this.items[i][j] + " ");
            }
            System.out.println();
        }
    }
}
