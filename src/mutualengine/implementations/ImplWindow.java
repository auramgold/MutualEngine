/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualengine.implementations;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import mutualengine.MutualEngine;

/**
 *
 * @author auramgold
 */
public class ImplWindow extends JFrame implements mutualengine.interfaces.Window
{
	private JTextArea log;
	private JTextField input;
	private JScrollPane scroll;
	private static int grayLevel = 240;
	
	public ImplWindow(String title, String greetingMessage)
	{
		super(title);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPan = new JPanel(new BorderLayout());
		
		log = new JTextArea();
		log.setEditable(false);
		log.setLineWrap(true);
		log.setBackground(new Color(grayLevel, grayLevel, grayLevel));
		scroll = new JScrollPane(log);
		scroll.setBorder
		(
			BorderFactory.createCompoundBorder
			(
				BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK), 
				new EmptyBorder(2, 2, 2, 2)
			)
		);
		scroll.setBackground(new Color(grayLevel, grayLevel, grayLevel));
		
		mainPan.add(scroll, BorderLayout.CENTER);
		
		log.append(greetingMessage);
		DefaultCaret caret = (DefaultCaret) log.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		Color shiftGray = new Color(grayLevel - 15, grayLevel - 15, grayLevel - 15);
		JPanel enterPan = new JPanel(new BorderLayout());
		JLabel lbl = new JLabel(">");
		lbl.setBorder(BorderFactory.createMatteBorder(1, 2, 2, 0, Color.BLACK));
		lbl.setBackground(shiftGray);
		enterPan.add(lbl, BorderLayout.LINE_START);
		input = new JTextField();
		input.setBorder(BorderFactory.createMatteBorder(1, 0, 2, 2, Color.BLACK));
		input.setBackground(shiftGray);
		enterPan.add(input, BorderLayout.CENTER);
		mainPan.add(enterPan, BorderLayout.PAGE_END);
		
		Action action = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String res = input.getText().toLowerCase();
				if(!res.equals(""))
				{
					MutualEngine.logLine(" > " + res);
					List<String> splitCommand = new ArrayList<>
					(
						Arrays.asList(res.split("(?U)\\s+"))
						//the U is for unicode space characters
					);
					boolean turnRan = MutualEngine.game.runCommand(splitCommand);
					input.setText("");
				}
			}
		};
		
		input.addActionListener(action);
		
		add(mainPan);
	}
	
	@Override
	public void addToLog(String what)
	{
		log.append(what);
		log.setCaretPosition(log.getDocument().getLength());
	}
	
	@Override
	public void display()
	{
		super.setVisible(true);
	}
}
