package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Intructions extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel;
	private JButton jbtnOk;

	public Intructions() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Intructions.class.getResource("/resursi/ghosticon.png")));
		setTitle("Hangman");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setText("You have 6 categories: MOVIES, COUNTRIES, HYSTORICAL \nPEOPLE, "
					+ "FAMOUS PEOPLE, BRANDS and BOOKS. Every \ncategory has 20 words. Words will go on random.\nYour score of"
					+ " guessed words is being kept.\nYour task is to guess all of the 120 words.\nFor every word, "
					+ "you can choose\nthe wrong letter 6 times. GOOD LUCK!");
			
		}
		return textArea;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.CYAN);
			panel.setPreferredSize(new Dimension(10, 50));
			panel.setLayout(null);
			panel.add(getJbtnOk());
		}
		return panel;
	}
	private JButton getJbtnOk() {
		if (jbtnOk == null) {
			jbtnOk = new JButton("OK");
			jbtnOk.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			jbtnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			jbtnOk.setPreferredSize(new Dimension(30, 30));
			jbtnOk.setBounds(354, 11, 60, 28);
		}
		return jbtnOk;
	}
}
