package parsers;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.lang.Float;
import textreps.*;

/**
* This is a class to use the SentiWordNet resource as a sentiment lexicon in a simple manner.
* The method for using the lexicon is to sum the negative and positive values for each entry in the lexicon, and then
* take the average of all entries for a given word. For example, the word uncongenial occurs several times in the lexicon.
* The final sentiment score for the word uncongenial is the average of each of the contexts for the word recorded in
* SentiWordNet. It is in this way naive and simple.
* @author Matthew Johnson
*/
public class SentiWordNetSimpleParser extends TextParser{
	/**
	* The SentiWordNet lexicon with simple scores taken from it.
	*/
	private HashMap<String, Float> wordDictionary;
	/**
	* Create a SentiWordNetSimpleParser that will create a TextRepresentation from the specified String.
	* @param inputFilePath The text file to parse using SentiWordNet in a naive manner.
	* @throws FileNotFoundException In the case that inputFilePath is invalid or if the SentiWordNet resource is not where expected.
	* @throws IOException In the case that either the input file or the SentiWordNet resource encounter errors when read.
	*/
	public SentiWordNetSimpleParser(String inputFilePath) throws FileNotFoundException, IOException{
		inputFile = new BufferedReader(new FileReader(inputFilePath));
		wordDictionary = new HashMap<String, Float>();
		readReference();
	}
	/**
	* Parse the text file that we have referenced into a chosen method of representation.
	* @return TextRepresentation A representation of the text file. See {@code TextRepresentation} for variants.
	*/
	public TextRepresentation parseFile(){
		return this.representation;
	}
	/**
	* Read in the reference file, in this case read in the SentiWordNet lexicon in a naive manner.
	* @throws FileNotFoundException In the case that the SentiWordNet resource is not where expected.
	* @throws IOException In the case that the SentiWordNet resource encoutners errors when read.
	*/
	protected void readReference() throws FileNotFoundException, IOException{
		Path currentPath = Paths.get(System.getProperty("user.dir"));
		String sentiWordNetPath = currentPath.toString();
		if (sentiWordNetPath.contains("/")){
			sentiWordNetPath += "/reference/SentiWordNet_3.0.0_20130122.txt";
		} else if (sentiWordNetPath.contains("\\")){
			sentiWordNetPath += "\\reference\\SentiWordNet_3.0.0_20130122.txt";
		}
		BufferedReader dataFile = new BufferedReader(new FileReader(sentiWordNetPath));
		HashMap<String, float[]> wordDictionaryTemp = new HashMap<String, float[]>();
		String currentLine = dataFile.readLine();
		while(currentLine != null) {
			if(currentLine.charAt(0) == 'a' | currentLine.charAt(0) == 'n' | 
					currentLine.charAt(0) == 'r' | currentLine.charAt(0) == 'v'){
				String[] entry = currentLine.split("\t");
				String[] words = entry[4].split(" ");
				float posValue = Float.parseFloat(entry[2]);
				float negValue = Float.parseFloat(entry[3]);
				float sentimentValue = posValue - negValue;
				for (int i = 0; i < words.length; i++) {
					words[i] = words[i].split("#")[0];
					if (!(wordDictionaryTemp.containsKey(words[i]))) {
						wordDictionaryTemp.put(words[i], new float[] { sentimentValue, 1 });
					} else {
						float[] existingValues = (float[]) wordDictionaryTemp.get(words[i]);
						float[] newValues = new float[] {
								existingValues[0] * (existingValues[1] / (existingValues[1] + 1))
										+ sentimentValue / (existingValues[1] + 1),
								existingValues[1] + 1 };
						wordDictionaryTemp.replace(words[i], newValues);
					}
				}
			}
			currentLine = dataFile.readLine();
		}
		dataFile.close();
		Iterator<Entry<String, float[]>> dictionaryIterator = wordDictionaryTemp.entrySet().iterator();
		while(dictionaryIterator.hasNext()) {
			Map.Entry<String,float[]> dictionaryEntry = dictionaryIterator.next();
			wordDictionary.put(dictionaryEntry.getKey(), dictionaryEntry.getValue()[0]);
		}
	}
}