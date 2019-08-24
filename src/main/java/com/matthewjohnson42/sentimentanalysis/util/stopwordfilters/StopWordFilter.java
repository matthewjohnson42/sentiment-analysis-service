package com.matthewjohnson42.sentimentanalysis.util.stopwordfilters;

import java.util.Arrays;
import java.util.List;

/**
 * Taken from {@url https://nlp.stanford.edu/IR-book/html/htmledition/dropping-common-terms-stop-words-1.html}
 */
public class StopWordFilter {
    private static String[] stopWordsArray = {"a", "an", "and", "are", "as", "at", "be", "by", "for", "from", "has",
            "he", "in", "is", "it", "its", "of", "on", "that", "the", "to", "was", "were", "will", "with"};
    private static List<String> stopWords = Arrays.asList(stopWordsArray);

    public static String filterWord(String s) {
        return stopWords.contains(s) ? null : s;
    }

}
