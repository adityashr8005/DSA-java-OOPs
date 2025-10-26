package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Binary_Tree{
        static int idx = -1;

        public static Node buildTree(int[] nodes){
            idx++;

            if (nodes[idx] == -1){
                return null;
            }
            Node node = new Node(nodes[idx]);
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);

            return node;
        }
    }

    public static void preOrder(Node root){
        if (root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if (root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static List<Integer> inOrderTraversal(Node root){
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }

        list.addAll(inOrderTraversal(root.left));
        list.add(root.data);
        list.addAll(inOrderTraversal(root.right));

        return list;
    }

    public static void postOrder(Node root){
        if (root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root){
        if (root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node currNode = q.remove();

            if (currNode == null){
//                System.out.println();
                if (q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null){
                    q.add(currNode.left);
                }
                if (currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countNodes(Node node){
        if (node == null){
            return 0;
        }

        int left = countNodes(node.left);
        int right = countNodes(node.right);

        return left + right + 1;
    }

    public static int sumOfNodes(Node node){
        if (node == null){
            return 0;
        }

        int left = sumOfNodes(node.left);
        int right = sumOfNodes(node.right);

        return left + right + node.data;
    }

    public static int heightNode(Node node){
        if (node == null){
            return 0;
        }

        int left = heightNode(node.left);
        int right = heightNode(node.right);

        int maxHeight = Math.max(left, right) + 1;

        return maxHeight;
    }

    //Time Complexity O(N^2)
    public static int diameterNode(Node node){
        if (node == null){
            return 0;
        }

        int diam1 = diameterNode(node.left);
        int diam2 = diameterNode(node.right);
        int diam  = heightNode(node.left) + heightNode(node.right) + 1;

        return Math.max(diam , Math.max(diam1, diam2));
    }

    static class treeInfo{
        int ht;
        int diam;

        public treeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    public static treeInfo diameter2(Node node){
        if (node == null){
            return new treeInfo(0,0);
        }

        treeInfo left = diameter2(node.left);
        treeInfo right = diameter2(node.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int mydiam =  Math.max(Math.max(diam1, diam2), diam3);

        treeInfo myInfo = new treeInfo(myHeight, mydiam);
        return myInfo;
    }

    public static void countKthNodes(Node node){
        if (node == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);

        int k = 1;
        int count = 0;
        while (!q.isEmpty()){
            Node currNode = q.remove();

            if (currNode == null){
                k++;
                System.out.println();
                if (q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                System.out.print(currNode.data + " ");

                if (currNode.left != null){
                    q.add(currNode.left);
                }
                if (currNode.right != null){
                    q.add(currNode.right);
                }

                if (k==3){
                    count++;
                }
            }
        }
        System.out.println("Kth Nodes : " + count);
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary_Tree tree = new Binary_Tree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

        System.out.println("PreOrder");
        preOrder(root);
        System.out.println();

        System.out.println("InOrder");
        inOrder(root);
        System.out.println();

        System.out.println("PostOrder");
        postOrder(root);
        System.out.println();

        System.out.println("Level Order");
        levelOrder(root);
        System.out.println();

        System.out.print("Total Nodes : ");
        System.out.println(countNodes(root));

        System.out.print("Total sum of Nodes : ");
        System.out.println(sumOfNodes(root));

        System.out.print("Total height of Tree : ");
        System.out.println(heightNode(root));

        System.out.print("Diameter of Tree : ");
        System.out.println(diameterNode(root));
        System.out.println(diameter2(root).diam);
        System.out.println();

        System.out.println("InOrder");
        System.out.println(inOrderTraversal(root));
        System.out.println();

        countKthNodes(root);
    }
}
