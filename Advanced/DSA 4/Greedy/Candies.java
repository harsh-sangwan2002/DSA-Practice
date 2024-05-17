import java.util.Arrays;

public class Candies {
    public int candy(int[] A) {

        int[] candies = new int[A.length];
        Arrays.fill(candies,1);

        for(int i=1; i<A.length; i++){

            if(A[i]>A[i-1])
            candies[i]=candies[i-1]+1;
        }

        for(int i=A.length-2; i>=0; i--){

            if(A[i]>A[i+1]){

                if(candies[i]<=candies[i+1])
                candies[i] = candies[i+1]+1;
            }
        }

        int sum = 0;

        for(int val : candies)
        sum+=val;

        return sum;
    }
}
