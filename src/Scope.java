public class Scope {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        {
            a = 30;/* We can't initial again a
                      but value can be changed
                      applied in both inside and outside scope. */
            System.out.println("Inside scope a = " + a);
        }
        System.out.println("Outside scope a = " + a);
    }
}
