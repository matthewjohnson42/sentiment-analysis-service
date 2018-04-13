import java.lang.Float;
class WordFloatTriple extends WordRepresentation{
	private float negValue;
	private float posValue;
	public WordFloatTriple(String word, float negValue, float posValue){
		this.word = word;
		this.negValue = negValue;
		this.posValue = posValue;
	}
	public void setPosValue(float posValue){
		this.posValue = posValue;
	}
	public void setNegValue(float negValue){
		this.negValue = negValue;
	}
	public float getNegValue(){
		return negValue;
	}
	public float getPosValue(){
		return posValue;
	}
	public int getIntValue(){
		return (int) (negValue + posValue);
	}
 	public float getFloatValue(){
		return posValue + negValue;
	}
}