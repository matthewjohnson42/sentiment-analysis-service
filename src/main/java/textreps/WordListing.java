package textreps;

import java.util.ArrayList;
import wordreps.*;
public class WordListing extends TextRepresentation{
	private ArrayList<WordRepresentation> pairList;
	public WordListing(){
		this.pairList = new ArrayList<WordRepresentation>();
	}
	public void addWord(WordRepresentation word){
		pairList.add(word);
	}
	public void removeAll(String word){
		WordRepresentation wordRep;
		for(int i=0; i < pairList.size(); i++) {
			wordRep = pairList.get(i);
			if(wordRep.toString() == word) {
				pairList.remove(i);
			}
		}
	}
	public int getIntScore(){
		int returnValue = 0;
		for(int i=0; i < pairList.size(); i++){
			returnValue += pairList.get(i).getIntValue();
		}
		return returnValue;
	}
	public float getFloatScore(){
		float returnValue = 0;
		for(int i=0; i < pairList.size(); i++){
			returnValue += pairList.get(i).getFloatValue();
		}
		return returnValue;
	}
}