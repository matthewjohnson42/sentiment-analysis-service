package com.matthewjohnson42.sentimentanalysis.util.resourceparsers;

import com.matthewjohnson42.sentimentanalysis.data.lexicon.SimpleSentiWordNet;
import com.matthewjohnson42.sentimentanalysis.data.wordrep.SimpleSWNWord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
* This is a class to use the SentiWordNet resource as a sentiment lexicon in a simple, word-sense-free manner.
* The method for using the lexicon is to reference the first word sense of a given word, and to prefer the use of the
* word as a noun over its use as other parts of speech. It is in this way naive and simple.
*/
public class SentiWordNetSimpleParser {

	private static final Logger log = LoggerFactory.getLogger(SentiWordNetSimpleParser.class);

	/**
	* Read in the resource.
	*/
	public static SimpleSentiWordNet readResource(Resource resource) {
		log.info("Beginning parse of SentiWordNet resource");
		HashMap<String, SimpleSWNWord> wordMap = new HashMap<>();
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			String line = reader.readLine();
			while (line != null) {
				String[] lineParts = line.split("\t");
				if(lineParts.length > 5 && !lineParts[0].startsWith("#")) {
					for(String word: Arrays.asList(lineParts[4].split("\\s"))) {
						String[] wordAndRank = word.split("#");
						String trimmedWord = wordAndRank[0];
						if(wordMap.containsKey(trimmedWord) && lineParts[0].contains("n") && wordAndRank.length > 1 && Integer.parseInt(wordAndRank[1]) == 1){
							SimpleSWNWord simpleSWNWord = wordMap.get(trimmedWord);
							simpleSWNWord.setPos(lineParts[0]);
							simpleSWNWord.setPositiveValue(Float.parseFloat(lineParts[2]));
							simpleSWNWord.setNegativeValue(Float.parseFloat(lineParts[2]));
						} else if (!lineParts[0].equals("")){
							if(wordAndRank.length > 1 && Integer.parseInt(wordAndRank[1]) == 1) {
								wordMap.put(trimmedWord, new SimpleSWNWord(trimmedWord, lineParts[0], Float.parseFloat(lineParts[2]), Float.parseFloat(lineParts[3]), lineParts[5]));
							}
						}
					}
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			log.error("failed to parse the senti word net file", e);
		}
		SimpleSentiWordNet sentiWordNet = new SimpleSentiWordNet().setLexicon(wordMap);
		log.info("Completed parse of SentiWordNet resource");
		return sentiWordNet;
	}
}
