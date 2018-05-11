package parsers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import textreps.*;
/**
* This is a generic class used to describe a parser. A parser is a combination of a sentiment lexicon,
* the method by which the sentiment lexicon is utilized, and the method by which the text is parsed.
* 
* @author Matthew Johnson
*/
public abstract class TextParser{
	/**
	* The input file that we are assigning a sentiment score to.
	*/
	protected BufferedReader inputFile;
	/**
	* The representation of the text file after it has been parsed.
	*/
	protected TextRepresentation representation;
	/**
	* Parses the file specified by the constructor of a TextParser child.
	* @return TextRepresentation A representation of the text file.
	*/
	public abstract TextRepresentation parseFile();
	/**
	* Reads in the reference material, most commonly a sentiment lexicon.
	* @throws FileNotFoundException In the case that the text file or resource file are not found.
	* @throws IOException In the case that the text file or resource file errors when being read.
	*/
	protected abstract void readReference() throws FileNotFoundException, IOException;
}