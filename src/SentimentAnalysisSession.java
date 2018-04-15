import java.io.FileNotFoundException;
import java.io.IOException;
/**
* A class that represents a session in which the sentiment of a given text is ascertained.
*/
public class SentimentAnalysisSession{
	public static void main(String[] args){
		try{
			SentiWordNetSimpleParser swnParser = new SentiWordNetSimpleParser("C:\\1020.log");
			swnParser.parseFile();
		} catch (FileNotFoundException ex){
			System.out.println(ex.toString());
		} catch (IOException ex){
			System.out.println(ex.toString());
		}
	}
}