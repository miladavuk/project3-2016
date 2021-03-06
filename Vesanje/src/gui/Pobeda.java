package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.kontrolor.GUIKontrolor;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Pobeda extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public Pobeda() {
		setResizable(false);
		setTitle("Hangman");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontrolor.pocetniProzor.setVisible(true);
				dispose();
			}

		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pobeda.class.getResource("/resursi/ghosticon.png")));
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		{

			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);

			BufferedImage slika;
			try {
				slika = ImageIO.read(this.getClass().getResource("/resursi/Winneer.jpg"));
				JLabel ikona = new JLabel(new ImageIcon(slika));
				panel.add(ikona);
				{
					JPanel panel_South = new JPanel();
					contentPanel.add(panel_South, BorderLayout.SOUTH);
					{
						JLabel lblNewLabel = new JLabel("YOU WIN!");
						lblNewLabel.setFont(new Font("Palatino", Font.BOLD, 20));
						panel_South.add(lblNewLabel);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GUIKontrolor.pocetniProzor.setVisible(true);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
