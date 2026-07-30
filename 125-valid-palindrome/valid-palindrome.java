class Solution {
    public boolean isPalindrome(String s) {
        String k = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0,j = k.length()-1;
        while(i<=j){
            if(k.charAt(i) != k.charAt(j)) return false;
            ++i;--j;
        }
        // System.out.println(joinedString);
        return true;
    }
}