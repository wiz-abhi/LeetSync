class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        solve(0,s,res,new StringBuilder());
        return res;
    }   

    void solve(int idx,String s,List<String> res, StringBuilder sb){
        if(sb.length() == s.length()){
            res.add(sb.toString());
            return;
        } 

        if(Character.isDigit(s.charAt(idx))) {
            sb.append(s.charAt(idx));
            solve(idx + 1, s, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        else{
        sb.append(Character.toUpperCase(s.charAt(idx)));
        solve(idx+1,s,res,sb);

        sb.deleteCharAt(sb.length()-1);

        sb.append(Character.toLowerCase(s.charAt(idx)));
        solve(idx+1,s,res,sb);
        sb.deleteCharAt(sb.length()-1);
        }
    }
}