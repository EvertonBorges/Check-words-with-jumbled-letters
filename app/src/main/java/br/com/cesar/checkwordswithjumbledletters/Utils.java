package br.com.cesar.checkwordswithjumbledletters;

class Utils {

    static boolean checkPartialPermutation(String firstWord, String secondWord) {
        if (firstWord == null || secondWord == null) return false;
        if (firstWord.charAt(0) != secondWord.charAt(0)) return false;
        if (firstWord.length() != secondWord.length()) return false;
        if (firstWord.length() <= 3) return true;
        int countNumberOfPermutations = 0;
        for(int i = 1; i < firstWord.length(); i++) {
            if (firstWord.charAt(i) != secondWord.charAt(i)) {
                countNumberOfPermutations++;
            }
        }
        float twoThirdsOfPermutations = (float) 2 / 3 * firstWord.length();
        return countNumberOfPermutations < twoThirdsOfPermutations;
    }

}