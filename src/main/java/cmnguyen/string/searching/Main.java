package main.java.cmnguyen.string.searching;

public class Main {

    public static void main(String[] args) {
        testTST();
    }

    private static void testTriesST() {
        TriesST<Integer> triesST = new TriesST<>();

        triesST.put("she", 0);
        triesST.put("sells", 1);
        triesST.put("shore", 2);
        triesST.put("by", 3);
        triesST.put("the", 4);
        triesST.put("sea", 5);
        triesST.put("shells", 6);
        triesST.put("see", 7);
        triesST.put("shelters", 8);

        System.out.println("All keys in tries");
        for (String k: triesST.keys()) {
            System.out.println(k);
        }

        String prefix = "sh";
        System.out.println("All keys in tries which are started with pre " + prefix);
        for (String k: triesST.keysWithPrefix(prefix)) {
            System.out.println(k);
        }

        String pat = "s.e";
        System.out.println("All keys in tries which match " + pat);
        for (String k: triesST.keysThatMatch(pat)) {
            System.out.println(k);
        }

        String longestPrefix = "shelters";
        System.out.printf("Longest prefix of %s which is found in tries %s \n",
                longestPrefix,
                triesST.longestPrefixOf(longestPrefix));
        longestPrefix = "shellshort";
        System.out.printf("Longest prefix of %s which is found in tries %s \n",
                longestPrefix,
                triesST.longestPrefixOf(longestPrefix));

        String delKey = "shells";
        triesST.delete(delKey);
        System.out.println("Delete key " + delKey + " in tries: ");
        for (String k: triesST.keys()) {
            System.out.println(k);
        }
    }

    private static void testTST() {
        TST<Integer> tst = new TST<>();
        tst.put("she", 0);
        tst.put("sells", 1);
        tst.put("by", 3);
        tst.put("the", 4);
        tst.put("sea", 5);
        tst.put("shells", 6);
        tst.put("see", 7);
        tst.put("shelters", 8);

        String key = "see";
        System.out.println("Value of key " + key + " : " + tst.get(key));

        String longestPrefix = "cat";
        System.out.printf("Longest prefix of %s which is found in TST %s \n",
                longestPrefix,
                tst.longestPrefixOf(longestPrefix));
        longestPrefix = "she";
        System.out.printf("Longest prefix of %s which is found in TST %s \n",
                longestPrefix,
                tst.longestPrefixOf(longestPrefix));

        String pat = "se.ls";
        System.out.println("All keys in tries which match " + pat);
        for (String k: tst.keysThatMatch(pat)) {
            System.out.println(k);
        }

        String prefix = "sh";
        System.out.println("All keys in tries which are started with pre " + prefix);
        for (String k: tst.keysWithPrefix(prefix)) {
            System.out.println(k);
        }
    }
}
