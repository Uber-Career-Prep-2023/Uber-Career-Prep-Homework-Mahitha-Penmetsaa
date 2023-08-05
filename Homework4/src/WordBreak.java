public class WordBreak {


    public static void main(String[] args) {
        String[] dictionary = new String[]{"elf", "manatee", "quip", "go", "golf",
                "not", "tee", "note", "teen", "man", "pig"};

        System.out.println(wordBreak("mangolf", dictionary));

        System.out.println(wordBreak("manateenotelf", dictionary));

        System.out.println(wordBreak("quipig", dictionary));

        System.out.println(wordBreak("quippig", dictionary));



    }
    public static boolean wordBreak(String s, String[] dictionary){
        boolean[] cache = new boolean[s.length()+5];
        cache[s.length()] = true;

        for (int i = s.length()-1; i > -1; i--){
            for(String word : dictionary){
                if (i + word.length() <= s.length()){
                    if (s.substring(i, i + word.length()).equals(word)){
                        cache[i] = cache[i + word.length()];
                    }
                }
                if (cache[i]) break;
            }
        }
        return cache[0];
    }
}
