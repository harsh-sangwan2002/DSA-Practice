public class tower_of_hanoi {

    int idx;
    int[][] arr;

    private void helper(int n, int t1, int t2, int t3){

        if(n==0)
        return;

        helper(n-1, t1, t3, t2);

        arr[idx++] = new int[]{n,t1,t3};

        helper(n-1, t2, t1, t3);
    }

    public int[][] towerOfHanoi(int A) {

        idx = 0;
        arr = new int[(1<<A)-1][3];

        helper(A,1,2,3);
        return arr;    
    }
}
