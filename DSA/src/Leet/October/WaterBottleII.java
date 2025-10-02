package Leet.October;

/*
ou are given two integers numBottles and numExchange.

numBottles represents the number of full water bottles that you initially have. In one operation, you can perform one of the following operations:

Drink any number of full water bottles turning them into empty bottles.
Exchange numExchange empty bottles with one full water bottle. Then, increase numExchange by one.
Note that you cannot exchange multiple batches of empty bottles for the same value of numExchange. For example, if numBottles == 3 and numExchange == 1, you cannot exchange 3 empty water bottles for 3 full bottles.

Return the maximum number of water bottles you can drink.
Examples:
Input: numBottles = 13, numExchange = 6
Output: 15

Input: numBottles = 10, numExchange = 3
Output: 13
 */
public class WaterBottleII {
    public static void main(String[] args) {
        int a = 13, b = 6;
        System.out.println(waterBottle(a,b));
    }
    static int waterBottle(int numBottles, int numExchange){
        int full = numBottles;
        int empty =0;
        int exchange = numExchange;
        int drunk = 0;
        int fullCount = full;
        while (full!=0){
            drunk += full;
            empty += fullCount;
            full -= fullCount;

            fullCount = 0;
            while (empty >= exchange){
                full++;
                fullCount++;
                empty -= exchange;
                exchange++;
            }
        }
        return drunk;
    }
}
