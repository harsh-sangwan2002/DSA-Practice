public class add_one {
    
    public int[] plusOne(int[] A) {

        int st = 0;

        for(int i=0; i<A.length; i++){

            if(A[i]!=0){
                st = i;
                break;
            }
        }

        int size = A.length-st;
        int[] res = new int[size];

        for(int i=st; i<A.length; i++){

            res[i-st] = A[i];
        }

        for(int i=res.length-1; i>=0; i--){

            if(res[i]!=9){
                res[i]++;
                return res;
            }

            res[i] = 0;
        }

        res = new int[res.length+1];
        res[0] = 1;
        return res;
    }
}
