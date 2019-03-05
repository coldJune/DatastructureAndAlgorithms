public class BinarySearchTree {
    private Node root;
    private int size;
    BinarySearchTree(){
        root = new Node();
        size = 0;
    }

    public void insert(Object data){
        if(root.data == null){
            root.data = data;
            root.parent = null;
            size ++;
            return;
        }
        Node temp = root;
        while(temp != null){
            if((int)data>=(int)temp.data){
                if(temp.right == null){
                    temp.right = new Node(data);
                    temp.right.parent = temp;
                    size++;
                    return;
                }
                temp = temp.right;
            }else{
                if(temp.left == null){
                    temp.left = new Node(data);
                    temp.left.parent = temp;
                    size++;

                    return;
                }
                temp = temp.left;
            }
        }
    }

    public void pre(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        pre(root.left);
        pre(root.right);
    }

    public void mid(Node root){
        if(root == null){
            return;
        }
        mid(root.left);
        System.out.print(root.data + " ");
        mid(root.right);
    }

    public void behind(Node root){
        if(root == null){
            return;
        }
        behind(root.left);
        behind(root.right);
        System.out.print(root.data + " ");
    }

    public Node getRoot(){
        return root;
    }

    public int getSize(){
        return size;
    }
}

class Node{
    Node parent;
    Node left;
    Node right;
    Object data;
    Node(){
        parent = null;
        left = null;
        right = null;
        data = null;
    }
    Node(Object data){
        parent = null;
        left = null;
        right = null;
        this.data = data;
    }
}