package com.ggl.hangman.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ggl.hangman.factory.IPhrase;



public class MoviePhrase implements IPhrase{

	private int             randomInt;
	 
    private List<String>  phrases;
 
    private Random          random;
 
    private String          phrase;
 
    
	
	
    public MoviePhrase() {
        random = new Random();
        this.randomInt = -1;
 
       
        /*this.phrases = new ArrayList<String>();
        this.phrases.add("Terminator");
        this.phrases.add("Big Daddy");
        this.phrases.add("Legally Blonde");*/
    }
	
    @Override
    public void setPhrases(List<String> phrases) {
    	this.phrases = phrases;
    	
    }
   
    public String getPhrase() {
        int nextInt = randomInt;
        while (nextInt == randomInt) {
            nextInt = random.nextInt(phrases.size());
        }
        this.randomInt = nextInt;
 
        this.phrase = phrases.get(randomInt);
        return phrase;
    }
   
   public String getHiddenPhrase() {
       StringBuilder builder = new StringBuilder();
       for (int i = 0; i < phrase.length(); i++) {
           String s = phrase.substring(i, i + 1);
           if (s.equals(" ") || s.equals(",")) {
               builder.append(s);
           } else {
               builder.append("_");
           }
       }
       return builder.toString();
   }

}