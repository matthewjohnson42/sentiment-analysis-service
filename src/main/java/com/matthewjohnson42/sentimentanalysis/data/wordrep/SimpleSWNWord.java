package com.matthewjohnson42.sentimentanalysis.data.wordrep;

/**
 * A simple representation of a SentiWordNet word, containing the word, the part of speech, the positive and negative
 * sentiment values, and the gloss for the word. Excludes the synset from the representation.
 */
public class SimpleSWNWord extends WordRepresentation{

	private float negativeValue;
	private float positiveValue;
	private String pos;
	private String gloss;

	public SimpleSWNWord(String word, String pos, float positiveValue, float negativeValue, String gloss) {
		this.word = word;
		this.pos = pos;
		this.positiveValue = positiveValue;
		this.negativeValue = negativeValue;
		this.gloss = gloss;
	}

	public SimpleSWNWord(SimpleSWNWord source) {
		this.word = source.word;
		this.pos = source.pos;
		this.positiveValue = source.positiveValue;
		this.negativeValue = source.negativeValue;
		this.gloss = source.gloss;
	}

	public String getWord() { return word; }

	public SimpleSWNWord setWord(String word) { this.word = word; return this; }

	public String getPos() { return pos; }

	public SimpleSWNWord setPos(String pos) { this.pos = pos; return this; }

	public float getPositiveValue(){
		return positiveValue;
	}
	public SimpleSWNWord setPositiveValue(float positiveValue){
		this.positiveValue = positiveValue;
		return this;
	}

	public float getNegativeValue(){
		return negativeValue;
	}
	public SimpleSWNWord setNegativeValue(float negativeValue){
		this.negativeValue = negativeValue;
		return this;
	}

	public int getIntValue(){
		return (int) (negativeValue + positiveValue);
	}

 	public float getFloatValue(){
		return negativeValue + positiveValue;
	}
}