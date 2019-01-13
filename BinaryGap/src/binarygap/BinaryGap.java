/*BinaryGap
 * Find the longest sequence of zeros in binary representation of an integer.
 * A binaty gap within a positin integer N is any maximal sequince of 
 * consecutive zeros that in surrouded by ones at both ends in the binary 
 * represention of N.
 */
package binarygap;

public class BinaryGap {

    public int solution(int n) {
        int maxGap = 0;
        int priorIndex1 =0;
        
        while ( n!=0 ) {
            //Returns the number of zero bits following the lowest-order in n
            int index1 = Integer.numberOfTrailingZeros(n);
            int zeroGap = index1 - priorIndex1 - 1;
            
            if (zeroGap > maxGap) {
                maxGap = zeroGap;
            }
            priorIndex1 = index1;
            //Check that the number n contains more than one bit set to one.
            //The logical expression ((n & (n-1))! == 0) is true if n is not a 
            //power of two and is not equal to zero.
            n &= n - 1;
        }//while
        if (maxGap==0){
            System.out.print("\nThere is no binary gap in n = ");
        }
        return maxGap;
    }//solution
    
    public int solution2 ( int n) {
        int max = 0;
        int counter = 0;
        boolean isCounting = false;
        
        while ( n > 0 ) {
            if ((n & 1) == 1) {
                if (isCounting) {
                    max = Math.max(max, counter);
                    counter = 0;
                } else {
                    isCounting = true;
                    counter = 0;
                }
            }
            else {
                if (isCounting) {
                    counter++;
                }
            }
            n >>= 1;
        }//while
        return max;
    }//solution2
    
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryGap a = new BinaryGap();
        //int solution = BinaryGap.solution(200);
        System.out.print("Hello");
        //System.out.print(a.solution(529));
        System.out.print(a.solution(2));
       
    }
    
}
