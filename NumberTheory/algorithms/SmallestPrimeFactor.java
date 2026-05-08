package NumberTheory.algorithms;

/**
 * <h3>Smallest Prime Factor (SPF) Precomputation</h3>
 * 
 * <p>This class implements a modified <b>Sieve of Eratosthenes</b> to find the 
 * smallest prime factor for every number up to a given maximum.</p>
 * 
 * <p><b>How it works:</b></p>
 * <ul>
 *   <li>Initially, it assumes every number is prime (its own smallest factor).</li>
 *   <li>It iterates through numbers starting from 2. When it finds a prime (where {@code ans[i] == i}), 
 *       it "shouts" to all its multiples that {@code i} is their smallest prime factor.</li>
 *   <li>By only updating numbers that haven't been marked yet ({@code ans[j] == j}), 
 *       we ensure only the <i>absolute smallest</i> prime is stored.</li>
 * </ul>
 */
public class SmallestPrimeFactor {

     /**
     * Computes an array where each index {@code i} stores the smallest prime factor of {@code i}.
     * 
     * <p><b>Time Complexity:</b> O(N log log N) — Nearly linear, same as the standard Sieve.</p>
     * <p><b>Space Complexity:</b> O(N) — To store the factor for each number.</p>
     * 
     * @param max The upper bound (inclusive) for the numbers to be factorized.
     * @return An integer array where {@code result[i]} is the smallest prime factor of {@code i}.
     */
    public int[] spf(int max){
        int[] ans = new int[max + 1];
        for(int i = 0 ; i <= max ; i++) ans[i] = i;

        for(int i = 2 ; i*i <= max ; i++){
            if(ans[i] == i){ // i = prime
                for(int j = i*i ; j <= max ; j++){
                    if(ans[j] == j){ // Only if j is not marked by the smallest prime yet
                        ans[j] = i;
                    }
                }
            }
        }
        return ans;
    }
}
