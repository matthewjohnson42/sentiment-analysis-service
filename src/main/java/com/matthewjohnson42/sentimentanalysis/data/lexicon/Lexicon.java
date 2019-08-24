package com.matthewjohnson42.sentimentanalysis.data.lexicon;

import com.matthewjohnson42.sentimentanalysis.data.wordrep.WordRepresentation;

import java.util.List;

/**
 * A class used to describe a sentiment lexicon.
 * To be populated from a resource such as SentiWordNet, and used as the sentiment reference lexicon.
 */
public abstract class Lexicon<U extends WordRepresentation> {

    public abstract List<U> getLexicon();

    public abstract Lexicon setLexicon(List<U> lexicon);

    public abstract U getWord(String word);
}
