package com.matthewjohnson42.sentimentanalysis.data.lexicon;

import com.matthewjohnson42.sentimentanalysis.data.wordrep.SimpleSWNWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A class describing the SentiWordNet lexicon
 * If more lexicons are added, storing this in a DB might be wise.
 */
public class SimpleSentiWordNet extends Lexicon<SimpleSWNWord> {

    private HashMap<String, SimpleSWNWord> lexiconMap = new HashMap<>();

    public SimpleSentiWordNet() {}

    @Override
    public List<SimpleSWNWord> getLexicon() {
        return new ArrayList(lexiconMap.values());
    }

    @Override
    public SimpleSentiWordNet setLexicon(List<SimpleSWNWord> lexicon) {
        lexiconMap = new HashMap<>();
        for(SimpleSWNWord word: lexicon) {
            lexiconMap.put(word.getWord(), word);
        }
        return this;
    }

    public SimpleSentiWordNet setLexicon(HashMap<String, SimpleSWNWord> lexiconMap) {
        this.lexiconMap = lexiconMap;
        return this;
    }

    @Override
    public SimpleSWNWord getWord(String word) {
        return lexiconMap.get(word);
    }

    public SimpleSWNWord getWordCopy(String word) {
        SimpleSWNWord swnWord = lexiconMap.get(word);
        return new SimpleSWNWord(swnWord);
    }

    public void addWord(SimpleSWNWord word) {
        lexiconMap.put(word.getWord(), word);
    }
}
