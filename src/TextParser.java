public abstract class TextParser{
	private BufferedInputStream inputFile;
	private TextRepresentation representation;
	public abstract TextRepresentation parseFile();
	private abstract void readReference();
}