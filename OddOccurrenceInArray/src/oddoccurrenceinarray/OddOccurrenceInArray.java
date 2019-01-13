/* OddOccurrenceInArray
 * Find value thatoccurs in odd number of elements.
 * The array contains an odd number of elements, and each element of the array
 * can be paired with another element that has the same value, except for one
   element that is left unpaired.
 */
package oddoccurrenceinarray;

import java.util.HashSet;

public class OddOccurrenceInArray {
    
    public static int solution (int[] A){
        int result = 0;

        for (Integer i : A) {
            // "a xor a" gives 0. So all numbers will be erased except 
            // the single one.
            result ^= i;
        }
        return result;
    }

    public static int solution2 (int[] A){
        HashSet<Integer> twin = new HashSet<>();
        int result = -1;

        for (Integer i : A) {
            if (twin.add(i)){
                result = i;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("\n" + solution(new int [] {9,9,3,9,3,7,9}));
        System.out.println("\n" + solution2(new int [] {9,9,3,9,3,7,9}));
        
    }
}
