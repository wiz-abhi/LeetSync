class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length())
            return ans;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = p.length();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0)
                    count--;

                map.put(ch, map.get(ch) - 1);
            }

            if (right - left + 1 > p.length()) {

                char remove = s.charAt(left);

                if (map.containsKey(remove)) {
                    if (map.get(remove) >= 0)
                        count++;

                    map.put(remove, map.get(remove) + 1);
                }

                left++;
            }

            if (count == 0)
                ans.add(left);
        }

        return ans;
    }
}