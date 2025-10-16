package Leet.October;

public class PalindromeLL {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(1);

        list.display();

        System.out.println(list.isPalindrome());
        list.display();
    }

    public static class LL{
        ListNode head;
        ListNode tail;
        int size;

        public LL(){
            this.size = 0;
        }

        public void insertFirst(int val){
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;

            if (tail == null){
                tail = head;
            }
            size++;
        }

        public void display(){
            ListNode temp = head;

            while (temp != null){
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }

//        public boolean isPalindrome(){
            //1 -> 2 -> 2 -> 1
//            Node temp1Head = head;
//            reverse();
//            Node temp2Head = head;
//
//            while (temp1Head != null){
//                if (!(temp1Head.value == temp2Head.value)){
//                    return false;
//                }
//                temp1Head = temp1Head.next;
//                temp2Head = temp2Head.next;
//            }
//            return true;
//        }

        // Function to reverse a linked list
        static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode next;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        // Function to check if two lists are identical
        static boolean isIdentical(ListNode n1, ListNode n2) {
            while (n1 != null && n2 != null) {
                if (n1.val != n2.val)
                    return false;
                n1 = n1.next;
                n2 = n2.next;
            }
            return true;
        }
        // Function to check whether the list is palindrome
         boolean isPalindrome() {
            if (head == null || head.next == null)
                return true;

            ListNode slow = head, fast = head;

            while (fast.next != null
                    && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode head2 = reverseList(slow.next);
            slow.next = null;

            boolean ret = isIdentical(head, head2);

            head2 = reverseList(head2);
            slow.next = head2;

            return ret;
        }

//        public void reverse(){
//            Node prev = head;
//            Node curr = head.next;
//
//            while (curr != null){
//                Node nextNode = curr.next;
//                curr.next = prev;
//
//                prev = curr;
//                curr = nextNode;
//            }
//
//            head.next = null;
//            head = prev;
//        }
    }

    public static class ListNode {
        ListNode next;
        int val;

        public ListNode(int value){
            this.val = value;
        }
        public ListNode(ListNode next, int value){
            this.next = next;
            this.val = value;
        }
    }
}
