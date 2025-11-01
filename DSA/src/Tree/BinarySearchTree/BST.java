package Tree.BinarySearchTree;

import java.util.ArrayList;

public class BST {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){

        if (root == null){
            root = new Node(val);
            return root;
        }

        if (root.data > val){
            root.left = insert(root.left,val);
        }else {
            root.right = insert(root.right,val);
        }

        return root;
    }

    public static void inOrder(Node node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static boolean search(Node node, int key){
        if (node == null){
            return false;
        }

        if (node.data == key){
            return true;
        }else if (node.data > key) {
            return search(node.left, key);
        }else {
            return search(node.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if (root.data > val){
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        }else {

            //Case 1 : No child
            if (root.left == null && root.right == null){
                return null;
            }

            //Case 2 : One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            //Case 3 : Two children
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inOrderSuccessor(Node node){
        while (node.left !=null){
            node = node.left;
        }
        return node;
    }

    public static void printInRange(Node root, int x, int y){
        if (root == null){
            return;
        }

        if (root.data >= x && root.data <= y){
            printInRange(root.left,x,y);
            System.out.print(root.data + " ");
            printInRange(root.right,x,y);
        } else if (root.data >= y) {
            printInRange(root.left,x,y);
        }else {
            printInRange(root.right,x,y);
        }
    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path){
        if (root == null){
            return;
        }

        path.add(root.data);
        if (root.left == null && root.right == null){
            print(path);
        }else {
            rootToLeaf(root.left, path);
            rootToLeaf(root.right, path);
        }

        path.remove(path.size()-1);
    }
    public static void print(ArrayList<Integer> path){
        for (int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] Nodes = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int i=0; i<Nodes.length; i++){
            root = insert(root,Nodes[i]);
        }
        inOrder(root);
        System.out.println();

        if (search(root,6)){
            System.out.println("!!!Found!!!");
        }else {
            System.out.println("!!!Not Found!!!");
        }

//        delete(root,8);
//        delete(root,14);
//        inOrder(root);
//        System.out.println();

        printInRange(root,5,10);
        System.out.println();

        rootToLeaf(root, new ArrayList<>());
    }
}
