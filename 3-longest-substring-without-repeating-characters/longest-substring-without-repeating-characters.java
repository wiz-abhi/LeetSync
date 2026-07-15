class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =0,j=0,len=0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        while(j<s.length()){
            char c = s.charAt(j);
            if(!set.contains(c)) {
                len++;
                maxLen = Math.max(maxLen,len);
                set.add(c);
                j++;
            }

            else{
                while(i<j && s.charAt(i) != c){
                    set.remove(s.charAt(i));
                    i++;len--;
                }

                set.remove(s.charAt(i)); len--;
                i++;
            }
        }

        return maxLen;
    }
}