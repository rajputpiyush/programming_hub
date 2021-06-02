// in this binary_tree i implement two types of traversal
// 1) DFS Traversal - preorder traversal , inorder traversal , postorder traversal
// 2) BFS Traversal / level order traversing
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class binary_tree{
    public static void main(String args[]){
        
        // System.out.println("Hello World: ");
        B_Tree tree = new B_Tree();
        tree.add();
        System.out.println("Inorder traversal : ");
        tree.Inorder_traversal(3);
        System.out.println("Preorder traversal : ");
        tree.Preorder_traversal(1);
        System.out.println("Postorder traversal : ");
        tree.Postorder_traversal(2);
        System.out.println("Level Order traversal : ");
        tree.Levelorder_traversal(0);
        System.out.println("Get root node : ");
        System.out.println(tree.get_root());

  
    }
}

class B_Tree{
    Scanner scanner = new Scanner(System.in);
    Node head;

    public int get_root(){
        return head.data;
    }
    public void add(){
        System.out.println("Note : Enter -1 if there is no node : ");
        System.out.println();
        System.out.println("Enter the root node first: ");
        int root = scanner.nextInt();
        add_childs(root);
    }
    private Node add_childs(int data){
        Node node = null;
        if(data == -1){
            return node;

        }
        node = new Node(data);
        if(head == null){
            head = node;
        }
        System.out.println("Enter the left child node of " + data);
        int left_child = scanner.nextInt();
        node.left = add_childs(left_child);
        System.out.println("Enter the right child node of " + data);
        int right_child = scanner.nextInt();
        node.right = add_childs(right_child);
        return node;
    }
    public void Preorder_traversal(int start){
        Node temp = head;
        Preorder_traversal(temp , start);
    }
    private boolean Preorder_traversal(Node node , int start){
        if(node == null){
            return false;
        }
        if(node.data == start){
            Pre_traversal(node);
        }
        
        if(Preorder_traversal(node.left , start)){
            return true;
        }
       if(Preorder_traversal(node.right , start)){
            return true;
        }
        return false;
    }
    private void Pre_traversal(Node node){
        if(node == null){
            return ;
        }
        System.out.println(node.data);
        Pre_traversal(node.left);
        Pre_traversal(node.right);
    }
    public void Inorder_traversal(int start_node){
        Node temp = head;
        Inorder_traversal(temp , start_node);
    }
    private boolean Inorder_traversal(Node node , int start_nodes){
        if(node ==  null){
            return false;
        }
        if(node.data == start_nodes){
            I_traversal(node);
            return true;
        }
        if(Inorder_traversal(node.left , start_nodes)){
            return true;
        }
        
        if(Inorder_traversal(node.right , start_nodes)){
            return true;
        }
        return false;
    }
    private void I_traversal(Node node){
        if(node == null){
            return ;
        }
        I_traversal(node.left);
        System.out.println(node.data);
        I_traversal(node.right);
    }

    public void Postorder_traversal(int start_node){
        Node temp = head;
        Postorder_traversal(temp , start_node);
    }
    private boolean Postorder_traversal(Node node , int start_nodes){
        if(node ==  null){
            return false;
        }
        if(node.data == start_nodes){
            Post_traversal(node);
            return true;
        }
        if(Postorder_traversal(node.left , start_nodes)){
            return true;
        }
        
        if(Postorder_traversal(node.right , start_nodes)){
            return true;
        }
        return false;
    }
    private void Post_traversal(Node node){
        if(node == null){
            return ;
        }
        Post_traversal(node.left);
        Post_traversal(node.right);
        System.out.println(node.data);
    }
    
    public void Levelorder_traversal(int start){
        Node temp = head;
        Levelorder_traversal(temp , start);
    }
    private Node Levelorder_traversal(Node node , int start){
        if(node == null){
            return null;
        }
        if(node.data == start){
            L_traversal(node);
        }
        Levelorder_traversal(node.left , start);
        Levelorder_traversal(node.right , start);
        return node;
    }
    private Node L_traversal(Node node){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node nodes = queue.poll();
            System.out.println(nodes.data);
            if(nodes.left != null) {
                queue.add(nodes.left);
            }
            if(nodes.right != null) {
        	    queue.add(nodes.right);        	 
            }     
        }
        return node;
    }
}
class Node{
    int data;
    Node right , left;
    Node(int data){
        this.data = data;
        right = left = null;
    }
}
