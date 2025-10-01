package DSA_Kunal.LinkedList.Questions;

public class Reverse {
    private Node head;

    public static void main(String[] args) {
        Reverse rev = new Reverse();
        rev.insert(5);
        rev.insert(4);
        rev.insert(3);
        rev.insert(2);
        rev.insert(1);
        rev.display();
        rev.revDisplay();
        rev.display();
    }

    public void insert(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public void display(){
        Node temp = head;

        while (temp!=null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");

        //Reverse display
    }
    public void revDisplay(){
        if (head == null || head.next == null){
            return;
        }

        Node prev=head;
        Node curr=head.next;

        while (curr!=null){
            Node nextNode = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }

        head.next = null;
        head = prev;

    }

   static class Node{
        int value;
        Node next;

       public Node(int value) {
           this.value = value;
       }
   }

}
