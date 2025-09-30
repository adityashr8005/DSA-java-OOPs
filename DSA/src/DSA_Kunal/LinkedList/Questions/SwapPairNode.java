package DSA_Kunal.LinkedList.Questions;

public class SwapPairNode {
    public static void main(String[] args) {
        LL list = new LL();
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.display();
        list.swapPairNode();
        list.display();
    }

    public static class LL {
        Node head;

        public void insert(int val) {
            Node node = new Node(val);
            node.next = head;
            head = node;
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }

        public void swapPairNode() {
            //c
            //1  2  3  4
            //   s  n
            //   2  1  3  4
            //      p  c
            //            s
            //        4 3 null
            if (head == null || head.next == null){
                return;
            }
           Node prev = new Node(0);
           Node curr = head;
           head = curr.next;

           while (curr!=null && curr.next!=null){
               Node nxt = curr.next.next;
               Node second = curr.next;

               second.next = curr;
               curr.next = nxt;
               prev.next = second;

               prev = curr;
               curr = nxt;
           }
        }

        public static class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
            }

            Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }
    }
}
