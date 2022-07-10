package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

 */
public class WordLadder {

    static class Word {
        String str;
        int level;

        public Word(String str, int level) {
            this.str = str;
            this.level = level;
        }
    }

    public static void getWordLadder(String start, String end, List<String> wordList) {
        List<String> shortestLadder = null;

        Map<Integer, String> wordLadder = new HashMap<>();

        Stack<Word> stack = new Stack<>();
        stack.add(new Word(start,0));

        while (! stack.isEmpty()) {
            Word word = stack.pop();
            if ( word.str.equals(end)) {
                if ( wordLadder.size() > word.level) {
                    for (int i = word.level+1; i < wordLadder.size(); i++) {
                        wordLadder.remove(i);
                    }
                }
                if ( shortestLadder == null || wordLadder.size() < shortestLadder.size()) {
                    if ( shortestLadder == null) shortestLadder = new LinkedList<>();
                    shortestLadder.clear();
                    for ( String val : wordLadder.values()) {
                        shortestLadder.add(val);
                    }
                    shortestLadder.add(end);
                }
                continue;
            }

            wordLadder.put(word.level, word.str);

            int currLevel = word.level;
            //Get alternatives to word
            List<String> possiblePathWords = new ArrayList<>();
            for ( String dictWord : wordList) {
                boolean abort = false;
                for (int level = 0; level <= currLevel; level++) {
                    if (wordLadder.get(level).equals(dictWord)) {
                        abort = true;
                        break;
                    }
                }
                if ( abort) continue;

                for (int i = 0; i < dictWord.length(); i++) {
                    String pattern = word.str.substring(0, i) + "*" + word.str.substring(i + 1, word.str.length());
                    if (isMatch(pattern, dictWord)) {
                        possiblePathWords.add(dictWord);
                    }
                }

            }

            for ( String possibleWord : possiblePathWords) {
                stack.add(new Word(possibleWord, currLevel+1));
            }

        }


        System.out.println("Shorted Word Path has : " + ((shortestLadder == null) ? 0 : shortestLadder.size()) + " words");
        if ( shortestLadder != null) {
            for (String str : shortestLadder) {
                System.out.print(" " + str);
            }
        }

    }

    public static boolean isMatch(String word, String dictWord) {

        for (int i = 0,  j = 0;  i < word.length(); i++, j++) {
            if ( word.charAt(i) == '*' ) continue;
            if ( word.charAt(i) != dictWord.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        List<String> wordList = Arrays.asList(new String [] {"hot", "dot", "dog", "lot", "log", "cog"});
        getWordLadder( "hit", "cog", wordList);   // hit hot lot log cog

        System.out.println("\n");
        wordList = Arrays.asList(new String [] {"hot", "dot", "dog", "lot", "log"});
        getWordLadder( "hit", "cog", wordList);   // NO RESULT

        System.out.println("\n");
        wordList = Arrays.asList(new String [] {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"});
        getWordLadder( "TOON", "PLEA", wordList);   // TOON POON POIN POIE PLIE PLEE PLEA

        System.out.println("\n");
        wordList = Arrays.asList(new String [] {"ABCD", "EBAD", "EBCD", "XYZA"});
        getWordLadder( "ABCV", "EBAD", wordList);   // ABCV ABCD EBCD EBAD


    }

}
