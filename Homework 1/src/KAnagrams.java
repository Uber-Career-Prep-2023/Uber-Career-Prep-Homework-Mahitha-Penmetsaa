public class KAnagrams {
    public static boolean areKAnagrams(String str1, String str2, int k) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] farr = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            farr[ch - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (farr[ch - 'a'] != 0)
                farr[ch - 'a']--;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += farr[i];
        }

        if (diff <= k) {
            return true;
        } else {
            return false;
        }
    }
//Time: O(n)
    //SPACE: O(n)
    //Two arrays/ strings increment/ decrement hashmap counts
}
