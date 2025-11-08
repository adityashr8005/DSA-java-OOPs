package DSA_Kunal.TreeByApna.Questions;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary search tree, return a balanced binary search tree with the same node values.
If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 */
public class IncreasingOrder {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val){
        if (root == null){
            root = new Node(val);
            return root;
        }

        if (root.data > val){
            root.left = insert(root.left, val);
        }else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static List<Integer> inOrder(Node root){
        List<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        list.addAll(inOrder(root.left));
        list.add(root.data);
        list.addAll(inOrder(root.right));

        return list;
    }



    public static Node balanceBST(Node root){
        List<Integer> list = inOrder(root);
        System.out.println(list);

        return null;
    }



    public static Node increasingOrder(Node root){
        List<Integer> list = inOrder(root);

        return tempMethod(list,0);
    }
    public static Node tempMethod(List<Integer> list, int i){
        if (i >= list.size()) return null;

        Node root = new Node(list.get(i));
        root.left = null;
        root.right = tempMethod(list, i + 1);
        return root;
    }

    public static void main(String[] args) {
        int[] nodes = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i=0; i<nodes.length; i++){
            root = insert(root,nodes[i]);
        }

        System.out.println(increasingOrder(root).data);
    }
}
