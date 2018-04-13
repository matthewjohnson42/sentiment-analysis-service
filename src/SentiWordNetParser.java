import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class SentiWordNetParser implements TextParser{
	public SentiWordNetParser(String inputFilePath) throws FileNotFoundException{
		inputFile = new BufferedReader(new FileReader(inputFilePath));
		readReference();
	}
	public TextRepresentation parseFile(){
	}
	private void readReference(){
		Path currentPath = Paths.get("");
		String parentPath = currentPath.getParent().toString();
		String sentiWordNetPath = "";
		if (parentPath.contains("/")){
			sentiWordNetPath += "/reference/SentiWordNet_3.0.0_20130122.txt";
		} else if (parentPath.contains("\\")){
			sentiWordNetPath += "\\reference\\SentiWordNet_3.0.0_20130122.txt";
		}
		BufferedReader dataFile = new BufferedReader(new FileReader(sentiWordNetPath));
		ArrayList<ArrayList<Object>> wordsAndCounts = new ArrayList<ArrayList<Object>>();
		String currentLine = dataFile.readLine();
		while(currentLine != null){
			if(!(currentLine.getChar(0) == "#")){
				String[] entry = currentLine.split("\t");
				for(int i=0; i < entry.length; i++){
					System.out.println(entry[i]);
				}
			}
			currentLine = dataFile.readLine();
		}
		//read in all entries
		//add each word from the entry to a list of <word, count> if not in the list, increment count if it is
		//average the value of each word in the list of pairs, adding to a new list and removing from the old one.
	}
}