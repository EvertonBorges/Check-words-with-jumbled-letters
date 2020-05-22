package br.com.cesar.checkwordswithjumbledletters;

class Utils {

    static boolean checkPartialPermutation(String firstWord, String secondWord) {
        if (firstWord == null || secondWord == null) return false;
        if (firstWord.charAt(0) != secondWord.charAt(0)) return false;
        if (firstWord.length() != secondWord.length()) return false;

        boolean hasSameLetters = checkEachLetter(firstWord, secondWord);
        if (!hasSameLetters) return false;

        if (firstWord.length() > 3) return checkByNumberPartialPermutation(firstWord, secondWord);

        return true;
    }

    private static boolean checkByNumberPartialPermutation(String firstWord, String secondWord) {
        int countNumberOfPermutations = 0;
        for(int i = 1; i < firstWord.length(); i++) {
            if (firstWord.charAt(i) != secondWord.charAt(i)) {
                countNumberOfPermutations++;
            }
        }
        float twoThirdsOfPermutations = (float) 2 / 3 * firstWord.length();
        return countNumberOfPermutations < twoThirdsOfPermutations;
    }

    private static boolean checkEachLetter(String firstWord, String secondWord) {
        for(Character character: firstWord.toCharArray()) {
            int occurrencesInFirstWord = occurrencesIn(firstWord, character);
            int occurrencesInSecondWord = occurrencesIn(secondWord, character);

            if (occurrencesInFirstWord != occurrencesInSecondWord) return false;
        }

        return true;
    }

    private static int occurrencesIn(String word, Character character) {
        return word.replaceAll("[^" + character + "]", "").length();
    }

}