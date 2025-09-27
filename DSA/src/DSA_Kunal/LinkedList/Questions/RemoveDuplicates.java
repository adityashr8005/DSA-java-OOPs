package DSA_Kunal.LinkedList.Questions;

public class RemoveDuplicates {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.display();
//        list.removeDuplicate();
        list.display();
        list.removeDup2(-1);
        list.display();
    }

    public static class LL{
        private Node head;
        private Node tail;
        private int size;

        public LL(){
            this.size = 0;
        }

        public void insertFirst(int value){
            Node node = new Node(value);
            node.next = head;
            head = node;

            if (tail == null){
                tail = head;
            }
            size++;
        }

        public void insertLast(int value){
            if (tail==null){
                insertFirst(value);
                return;
            }
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            size++;
        }

        public void removeDuplicate(){
            Node node = head;

            while (node.next!=null){
                if (node.value == node.next.value){
                    node.next = node.next.next;
                    size--;
                }else {
                    node = node.next;
                }
            }
            tail = node;
            tail.next = null;
        }

        public void removeDup2(int val){
            Node s = head;
            Node f = head.next;
            System.out.println(s.value);
            System.out.println(f.value);
            while (f.next != null && s.next != null){
                if (s.value == f.value){
                    head = f.next;
                }else {
                    head = f;
                }
                s=s.next;
                f=f.next;

                ///approach...

                Node dummy = new Node(val);
                dummy.next = head;
                Node prev = dummy;
                Node curr = head;

                while (curr !=null && curr.next != null){
                    if (curr.value == curr.next.value){
                        while (curr.next != null && curr.value == curr.next.value){
                            curr = curr.next;
                        }
                        prev.next = curr.next;
                    }else {
                        prev = prev.next;
                    }
                    curr = curr.next;
                }
            }
        }

        public void display(){
            Node temp = head;
            while (temp!=null){
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }

        public void removeElem(int val) {
            RemoveDuplicates.Node node = head;

            while (head != null && head.value == val) {
                head = head.next;
            }

            while (node != null && node.next != null) {

                if (node.next.value == val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
        }
    }

    public static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}



