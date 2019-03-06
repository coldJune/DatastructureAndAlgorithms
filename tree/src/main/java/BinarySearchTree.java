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

    public void delete(Object data){
        Node temp = root;
        while(temp != null && (int)temp.data != (int)data){
            if((int)data > (int)temp.data){
                temp = temp.right;
            }else{
                temp = temp.right;
            }
        }
        if(temp == null) return;
        if(temp.left != null && temp.right != null){
            Node minTemp = temp.right;
            while(minTemp.left != null){
                minTemp = minTemp.left;
            }
            temp.data = minTemp.data;
            temp = minTemp;
        }
        Node child;
        if(temp.left != null) child = temp.left;
        else if(temp.right != null) child = temp.right;
        else child = null;

        if(temp.parent == null) root=child;
        else if(temp.parent.left == temp) temp.parent.left = child;
        else temp.parent.right = child;


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