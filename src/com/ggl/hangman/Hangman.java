package com.ggl.hangman;

import javax.swing.SwingUtilities;
 

import com.ggl.hangman.model.HangmanModel;
import com.ggl.hangman.model.IPhraseFactory;
import com.ggl.hangman.strategy.AgeStrategy;
import com.ggl.hangman.strategy.KidsStrategy;
import com.ggl.hangman.view.HangmanFrame;

//Here Hangman is a thread. new Hangman wherever done will create a new thread and call its run method
public class Hangman implements Runnable {

	private String category;
	private IPhraseFactory phraseFactory_;
	private String ageCategory;
	/*private AgeStrategy ageStrategy;
	
	public void changeStrategy(AgeStrategy s) {
		ageStrategy = s;
	}*/
	
    public Hangman(String ctgry, IPhraseFactory inFactory, String ageCategory) {
		this.category = ctgry;
		this.phraseFactory_ = inFactory;
		this.ageCategory = ageCategory;
		
		
	}

	@Override
    public void run() {
        new HangmanFrame(new HangmanModel(this.phraseFactory_, this.category, this.ageCategory));
    }
}