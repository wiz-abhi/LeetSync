class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int vowel = 0;
        int maxi = -1;
        int n = s.length();

        for(int right = 0;right<n;right++){
            char c = s.charAt(right);

            if(right-left+1 <= k){
                if(isVowel(c)) vowel++;
            }
            else{
                if(isVowel(c)) vowel++;
                if(isVowel(s.charAt(left))) vowel--;
                left++;
            }

            maxi = Math.max(vowel,maxi);
            

        }
        return maxi;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}