package Leet.August;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
    public static void main(String[] args) {
        String digits = "";
        List<String> ans = letterCombination(digits);
        System.out.println(ans);
    }
static List<String> letterCombination(String digits){

        List<String> list = new ArrayList<>();
        if (digits.isEmpty()){
            return list;
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backtrack(digits,0,list,new StringBuilder(),map);
        return list;
    }
    static void backtrack(String digits, int index, List<String> list,StringBuilder value,Map<Character,String> map){
        if (index==digits.length()){
            list.add(value.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (char letter:letters.toCharArray()){
            value.append(letter);
            backtrack(digits,index+1,list,value,map);
            value.deleteCharAt(value.length()-1);
        }
    }
}
