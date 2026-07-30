class Solution {
    public int hammingWeight(int n) {
        int count =0;
        while(n>0){
            int k = n%2;
            n=n/2;
            if(k == 1) count++;
        }
        return count;
    }
}