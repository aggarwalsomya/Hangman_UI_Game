package com.ggl.hangman.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.ggl.hangman.Hangman;
import com.ggl.hangman.command.IMenuInvoker;

public class optionListener implements ActionListener {

	IMenuInvoker menuInvoker_;
	public optionListener(IMenuInvoker menuInvoker) {
		this.menuInvoker_ = menuInvoker;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		menuInvoker_.invoke(e.getActionCommand());
	}
}
