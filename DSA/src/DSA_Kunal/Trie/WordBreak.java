package DSA_Kunal.Trie;

public class WordBreak {

    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            for (int i=0; i<26; i++){
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for (int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            if (i == word.length()-1){
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    public static boolean search(String key){
        Node curr = root;
        for (int i=0; i<key.length(); i++){
            int idx = key.charAt(i) - 'a';
            Node node = curr.children[idx];

            if (node == null) return false;

            if (i == key.length()-1 && node.eow == false) return false;

            curr = curr.children[idx];
        }
        return true;
    }

    public static boolean wordBreak(String key){
        if (key.length() == 0) return true;

        for (int i=1; i<=key.length(); i++){
            String first = key.substring(0,i);
            String second = key.substring(i);

            if (search(first) && wordBreak(second)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "u"};
        String key = "iloveu";

        for (int i=0; i< words.length; i++){
            insert(words[i]);
        }
        System.out.println(search("love"));
        System.out.println(wordBreak(key));
    }
}
