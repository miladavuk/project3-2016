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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Poraz extends JDialog {

	private final JPanel contentPanel = new JPanel();


	public Poraz() {
		setBounds(100, 100, 350, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);

			BufferedImage slika;
			try {
				slika = ImageIO.read(this.getClass().getResource("/resursi/Loseeer.jpg"));
				JLabel ikona = new JLabel(new ImageIcon(slika));
				panel.add(ikona);
				{
					JPanel panel_South = new JPanel();
					contentPanel.add(panel_South, BorderLayout.SOUTH);
					{
						JLabel lblNewLabel = new JLabel("YOU LOSE!");
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
						PocetniProzor p = new PocetniProzor();
						p.setVisible(true);
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
