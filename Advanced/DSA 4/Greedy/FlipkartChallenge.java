import java.util.Arrays;
import java.util.PriorityQueue;

public class FlipkartChallenge {

    private static class Pair{

        int expiry;
        int margin;

        Pair(int expiry, int margin){
            this.expiry = expiry;
            this.margin = margin;
        }
    }

    public int solve(int[] A, int[] B) {

        Pair[] pairs = new Pair[A.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<A.length; i++)
        pairs[i] = new Pair(A[i],B[i]);

        Arrays.sort(pairs,(p1,p2)->p1.expiry-p2.expiry);

        long ans = 0, mod = (long)(1e9+7);
        int t = 0;

        for(int i=0; i<pairs.length; i++){

            Pair p = pairs[i];

            if(t<p.expiry){
                pq.add(p.margin);
                t++;
            }

            else{

                if(p.margin>pq.peek()){
                    pq.remove();
                    pq.add(p.margin);
                }
            }
        }

        while(pq.size()!=0)
        ans = (ans+pq.remove())%mod;

        return (int)ans;
    }
}
