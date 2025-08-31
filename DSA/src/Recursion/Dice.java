package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public static void main(String[] args) {
        dice("",4);
        System.out.println(diceCombination("",5));
    }
    static void dice(String p, int up){
        if (up==0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i<=up ; i++) {
            dice(p+i, up-i);
        }
    }

    static List<String> diceCombination(String p, int target){
        if (target==0){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        for (int i=1; i<=6 && i<=target; i++){
            list.addAll(diceCombination(p+i, target-i));
        }
        return list;
    }
}
