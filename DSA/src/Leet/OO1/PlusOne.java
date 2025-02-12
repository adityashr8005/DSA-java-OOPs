package Leet.OO1;

import java.util.Arrays;

//input: 1,2,3
//Output: 1,2,4
//...123+1=124 ... [1,2,4]
public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {1,0,9};
        int[] ans=plus(arr);

        System.out.println(Arrays.toString(ans));
    }
    static int[] plus(int[] digits){
        int size=digits.length;
        int[] ans = new int[size+1];
        boolean check = true;
        boolean check2 = true;

        int count=0;
        int i;
        for (int p=0; p<digits.length; p++){
            if (digits[p]==9){
                count++;
            }
        }
        if (count==digits.length){
            ans[0]=1;
            for (int q=1; q< ans.length; q++){
                ans[q]=0;
            }
            return ans;
        }
        for ( i = digits.length-1; i>=0; i--){
                while (i>=0 && digits[i] == 9 && check == true) {
                        digits[i] = 0;
                        i--;
                }

            check=false;
            if (digits[i]!=9 && check2) {
                digits[i] = digits[i] + 1;
                check2 = false;
            }
        }
        return digits;
    }
}
