package CodeWars;

public class CountAndSum {

    public static int solution(int n){
        int ans = 0;

        for (int i=1; i<n; i++){
            if (i%3 == 0 || i%5 == 0) ans += i;
        }

        return ans;
    }

    public static void main(String[] args) {
        //take multiple of 3 and 5 only -> 3, 5, 6, 9 => sum it (gives = 23)
        //ans = 23;

        //n=20
        //ans=78
        int n = 10;
        System.out.println(solution(n));
    }
}
