package Leet.October;

import java.util.*;

/*
Example 1:
Input: strings = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strings = [""]
Output: [[""]]

Example 3:
Input: strings = ["a"]
Output: [["a"]]
 */
public class GroupAnagram {
    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = groupAnagrams(arr);
        System.out.println(ans);
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        // Create a map: key = sorted word, value = list of words
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // If key doesn't exist, make a new arrayList.
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            // Add the word to the list corresponding to the sorted key
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
