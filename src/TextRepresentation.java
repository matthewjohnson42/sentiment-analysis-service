/**
* A generic class used to describe a the representation of a text file annotated
* with sentiment scores. 
*/
public abstract class TextRepresentation{
	/**
	* Get the integer sentiment score of the text.
	* @return int The integer sentiment score of the text.
	*/
	public abstract int getIntScore();
	/**
	* Get the float sentiment score of the text.
	* @return float The float sentiment score of the text.
	*/
	public abstract float getFloatScore();
}