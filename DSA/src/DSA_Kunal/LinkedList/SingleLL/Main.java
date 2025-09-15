package DSA_Kunal.LinkedList.SingleLL;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(7);
        list.insertFirst(11);
        list.insertFirst(18);
        list.insertLast(1);
        list.insertLast(2);
        list.insert(99,3);

        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();
    }
}
