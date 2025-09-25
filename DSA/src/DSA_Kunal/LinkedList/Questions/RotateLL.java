package DSA_Kunal.LinkedList.Questions;



public class RotateLL {
    Node head;
    public static void main(String[] args) {
        RotateLL list = new RotateLL();
//        list.insert(5);
//        list.insert(4);
//        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.insert(0);

        list.display();
        list.rotate(4);
        list.display();
    }

    public void insert(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
    }
    public void display(){
        Node curr = head;

        while (curr != null){
            System.out.print(curr.val + "  ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void rotate(int k){
        //Approach 1....

//        if (head.next==null){
//            return;
//        }
//
//        for (int i=0; i<k; i++) {
//            Node curr = head;
//            Node tempHead = head;
//
//            while (curr.next.next != null) {
//                curr = curr.next;
//            }
//            head = curr.next;
//            curr.next.next = tempHead;
//            curr.next = null;
//        }

        //Second approach for time limit

        int length = 1;
        Node dummy = head;

        while (dummy.next != null) {
            dummy = dummy.next;
            length++;
        }

        int position = k % length;
        if (position == 0) return ;

        Node current = head;
        for (int i = 0; i < length - position - 1; i++) {
            current = current.next;
        }
        dummy.next = head;
        head = current.next;
        current.next = null;

    }
    static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}
