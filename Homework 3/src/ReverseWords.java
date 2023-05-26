public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("Uber Career Prep"));
        System.out.println(reverseWords("Emma lives in Brooklyn, New York."));


    }
    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            while (i < s.length() && s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
                ++i;
            }

            if (temp.length() != 0) {
                // If we find a word we will add it at beginning of result.
                if (res.length() != 0) {
                    res.insert(0, " ");
                    res.insert(0, temp);
                } else {
                    res.append(temp);
                }
                temp.setLength(0);
            }
        }
        return res.toString();
    }

}
