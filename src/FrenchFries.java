import java.util.Scanner;


public class FrenchFries {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long number = in.nextLong();
		System.out.println(eats(number));
	}
	
	public static long eats(long N) {
	    long r = (long)Math.sqrt(N-1);
	    while(r*r >= N) --r;
	    while(r*(r+2) < N) ++r;
	    if (N <= r*(r+1)) {
	        return r*r+1;
	    }
	    return r*(r+1)+1;
	}
	
	public static int EatenCandyIndexFaster(int n) {
	    int currIndex = 1;
	    int numSmallerSquares = 1;

	    /* Rather than tracking the next square, track the root of the next
	     * square.  We can just square this to get the next square.
	     */
	    int rootOfNextSquare = 2;

	    while (true) {
	        /* Figure out what our target is. */
	        int target = min(n, rootOfNextSquare * rootOfNextSquare);

	        /* See how many steps are required. */
	        int numSteps = ((target - currIndex) + (numSmallerSquares - 1)) / numSmallerSquares;

	        /* See where we'd end up if we took one fewer than this many steps forward. */
	        int lastIndex = currIndex + (numSteps - 1) * numSmallerSquares;

	        /* Take that many steps forward. */
	        currIndex += numSmallerSquares * numSteps;

	        /* There is an edge case here: if we hit our number but it's a perfect square,
	         * we want to return the previous value.
	         */
	        if (currIndex == n && n == rootOfNextSquare * rootOfNextSquare)
	            return lastIndex;

	        /* Otherwise, if we hit the target number exactly, return it. */
	        if (currIndex == n)
	            return currIndex;

	        /* Otherwise, if we overshot the target number, hand back where we'd be if we
	         * took one fewer step.
	         */
	        if (currIndex > n)
	            return lastIndex;

	        /* Oh well; didn't make it.  If we hit a perfect square, skip it. */
	        if (currIndex == rootOfNextSquare * rootOfNextSquare)
	            ++currIndex;

	        ++numSmallerSquares;
	        ++rootOfNextSquare;
	    }
	}
	
	public static int min(int num1,int num2){
		if(num1>num2){
			return num1;
		}
		else{
			return num2;
		}
		
	}

}
