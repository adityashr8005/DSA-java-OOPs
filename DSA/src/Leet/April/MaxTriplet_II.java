package Leet.April;

public class MaxTriplet_II {
    public static void main(String[] args) {
        int[] arr = {888206, 358855, 527734, 461505, 593345, 753201, 126791, 262520, 98254, 346686, 887690, 961450, 506029,
                     129226, 516613, 71491, 244767, 830154, 601635, 602849, 702247, 278111, 198394, 324498, 48489, 459258,
                     280518, 181212, 47301, 759448, 84691, 580806, 857663, 310435, 666559, 155294, 970587, 883826, 640595,
                     552229, 983029, 208691, 214074, 461062, 675520, 350464, 549394, 109138, 933356, 424314, 845600, 775473,
                     256544, 913011, 762604, 881369, 672307, 528942, 985740, 414623, 114378, 694109, 936307, 87004, 414769,
                     487713, 223521, 427045, 860425, 738551, 454546, 734440, 958490, 255692, 88688, 47621, 925987, 155040,
                     929626, 879259, 203008, 848751, 753394, 305249, 939317, 172931, 668258, 868525, 262847, 842625, 639435,
                     974373, 303872, 930576, 746561, 386094, 792062, 392532, 242273, 13105};

        long ans = maxTripletValue(arr);
        System.out.println(ans);
    }

    static long maxTripletValue(int[] nums){
        long maxTriplet=0;
        long max_xy=0;
        long value=nums[0];

//      Compute max triplet value
        for (int i=1; i<nums.length-1; i++){
//            max_xy = Math.max(max_xy, value-nums[i]);
            //Max difference (x-y)
            if (max_xy < value-nums[i]){
                max_xy = value-nums[i];
            }

//            maxTriplet = Math.max(maxTriplet, max_xy*nums[i+1]);
            //Calculation of Max triplet
            if (maxTriplet< max_xy*nums[i+1]){
                maxTriplet = max_xy*nums[i+1];
            }

//            value = Math.max(value,nums[i]);
            //Updating value(x) if found greater than earlier.
            if (value<nums[i]){
                value=nums[i];
            }
        }

        return maxTriplet;
    }
}
