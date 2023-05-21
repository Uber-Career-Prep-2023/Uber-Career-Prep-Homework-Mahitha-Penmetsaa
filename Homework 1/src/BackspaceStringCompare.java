public class BackspaceStringCompare {

    public static boolean backspaceStringCompare(String one, String two) {

        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) == '#') {
                one = one.substring(0, i - 1) + one.substring(i + 1);
            }
            for (int j= 0; j < two.length();j++) {
                if (two.charAt(i) == '#') {
                    two = two.substring(0, j - 1) + two.substring(j + 1);
                }
                if (one.equals(two)) {
                    return true;
                }
            }
            return false;

        }

        return false;
    }

    //Time: O(n^2)
    //although I didn't notice during my implementation this can easily be made into an O(n) solution
    //Space: O(1)
    //Reset/catch up two pointer
}
