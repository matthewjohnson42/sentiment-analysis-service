public class SentimentAnalysisSession{
	private TextRepresentation representation;
	private TextParser parser;
	public SentimentAnalysisSession(TextParser parser){
		this.parser = parser;
	}
	public void setParser(TextParser parser){
		this.parser = parser;
	}
	public TextRepresentation getRepresentation(){
		return representation;
	}
	public TextParser getParser(){
		return parser;
	}
	public void runSession(){
		representation = parser.parseFile();
	}
}