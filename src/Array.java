import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
//        int[] arr = new int[5];
//        arr[0]=3;
//        arr[1]=33;
//        arr[2]=333;
//        arr[3]=3333;
//        arr[4]=33333;
//        System.out.println(arr[2]);


        //Array objects are in heap
        //Objects are not continuous
        //Dynamic memory allocation

        //Array of Primitives.

//        Scanner input = new Scanner(System.in);
//        int[] arr = new int[5];  //new is used to create an object
//        //Input
//        for(int i=0 ; i< arr.length ; i++){
//            arr[i] = input.nextInt();
//        }
        //Output
//        //Method 1
//        System.out.println(Arrays.toString(arr));
//        //Method 2
//        for(int i=0 ; i< arr.length ; i++) {
//            System.out.print(arr[i]+" ");
//        }
        //Method 3
//        for(int num : arr){         //For every element in array, print the array.
//            System.out.print(num + " "); //Here num represent element of array.
//        }


        //Array of Object

//        Scanner input = new Scanner(System.in);
//        String[] str = new String[4];
//        for(int i=0 ; i< str.length ; i++){
//            str[i] = input.next();
//        }
//        System.out.print(Arrays.toString(str));
//        //Modify object
//        str[2] = "Samir";
//        System.out.print(Arrays.toString(str));


        //2 Dimension array

//        Scanner input = new Scanner(System.in);
//        int[][] arr = new int[3][3];
//        //INPUT
//        for(int row=0 ; row<arr.length ; row++){
//            for(int col=0 ; col<arr[row].length ; col++){
//                arr[row][col] = input.nextInt();
//            }
//        }
////        OUTPUT
////        Method 1
//        for(int row=0 ; row<arr.length ; row++){
//            for(int col=0 ; col<arr[row].length ; col++){
//                System.out.print(arr[row][col] + " ");
//            }
//            System.out.println();
//        }

        //Method 2
//            for(int[] a : arr){
//                System.out.println(Arrays.toString(a));
//            }

        //Method 3
//        for(int row=0 ; row< arr.length ; row++){
//            System.out.println(Arrays.toString(arr[row]));
//        }


        //For Unequal Column
//        int[][] arr = {
//                {1,2,3,4},
//                {5,6},
//                {7,8,9}
//        };
//
//        for(int row=0 ; row<arr.length ; row++){
//            for(int col=0 ; col<arr[row].length ; col++){
//                System.out.print(arr[row][col] + " ");
//            }
//            System.out.println();
//        }



        //ArrayList

//        Scanner input = new Scanner(System.in);
//      ArrayList<Integer> list = new ArrayList<>(5);
//
//      list.add(10);
//      list.add(100);
//      list.add(1000);
//      list.add(101);
//      list.add(1011);
//      list.add(111);
//        System.out.println(list);
//
    //User Input
//    Scanner input = new Scanner(System.in);
//    ArrayList<Integer> list = new ArrayList<>();
//
//    for(int i=0 ; i<5 ; i++){
//        list.add(input.nextInt());
//    }
//        for(int i=0 ; i<5 ; i++){
//            System.out.print(list.get(i) + " "); //pass index here , list[index] syntax will not work.
//        }


        //2D ArrayList
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //Initilize list
        for(int i=0 ; i<3 ; i++){
            list.add(new ArrayList<>());
        }

        //Input
        for(int i=0 ; i<3 ;i++){
            for(int j=0 ; j<3 ; j++){
                list.get(i).add(input.nextInt());
            }
        }
        System.out.println(list);

        }

    public static class SwapConsecutiveArr {
        public static void main(String[] args) {
            int[] arr = {1,2,3,4,5,6};
            System.out.println(Arrays.toString(arr));
            swap(arr);
            System.out.println("After swaping");
            System.out.println(Arrays.toString(arr));
        }
        static void swap(int[] arr){
            int i=0;
            int j=0;
            while(i< arr.length){
                j=i+1;
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
                i+=2;
            }
        }
    }
}