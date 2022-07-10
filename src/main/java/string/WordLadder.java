package string;
/*
 Given a dictionary, and two words ‘start’ and ‘target’ (both of same length).
 Find length of the smallest chain from ‘start’ to ‘target’ if it exists, such that
 adjacent words in the chain only differ by one character and each word in the chain is a valid word

 i.e., it exists in the dictionary.
 It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.
 */

import java.util.*;

public class WordLadder {
    static class Word {
        String word;
        int level;

        public Word(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public static void ChainLen(String start, String end, Set<String> dict) {


        List<Word> queue = new LinkedList<>();

        List<Word> usedWords = new LinkedList<>();

        queue.add(new Word(start,1));

        while ( queue.size() > 0) {


            Word queueWord = queue.remove(0);
            String currWord = queueWord.word;
            System.out.println(">> " + currWord);

            if ( currWord.equals(end)) {
                System.out.println("Found Match at Level:" + queueWord.level);
                return;
            }

            List<String> possibleWords = new ArrayList<String>();
            for (int i = 0; i < currWord.length(); i++) {
                String word = "";
                for (int j = 0; j < currWord.length(); j++) {
                    if ( i == j) {
                        word += "*";
                    } else word += currWord.charAt(j)+"";
                }
                possibleWords.add(word);
            }


            for ( String word : possibleWords) {
                String matched = isMatch(word, queueWord.level, queue, dict);
                if ( matched == null) continue;
                usedWords.add(new Word(matched, queueWord.level+1));
                queue.add(new Word(matched, queueWord.level+1));

            }

        }

        System.out.println("<NO-MATCH>");
    }

    public static String isMatch(String word, int level, List<Word> queue,Set<String> dict) {
        for ( String dictWord : dict) {
            for ( Word wrd : queue) {
                if ( wrd.word.equals(dictWord) && wrd.level < level) continue; //This word is already used
            }

            int dictWordIndex = 0;
            boolean abort = false;
            for (int wordIndex = 0; wordIndex < word.length(); wordIndex++, dictWordIndex++) {
                if ( word.charAt(wordIndex) != '*'  && word.charAt(wordIndex) != dictWord.charAt(dictWordIndex)) {
                    abort = true;
                    break;
                }
            }
            if ( !abort ) return dictWord;
        }
        return null;
    }

    public static void main(String args[]) {
        Set<String> D = new HashSet<String>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";
        ChainLen(start, target, D);
    }
}
