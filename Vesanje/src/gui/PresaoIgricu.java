package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PresaoIgricu extends JFrame {

	
	private static final long serialVersionUID = 2345120619413977345L;
	private JPanel contentPane;
	private JPanel jpnlSlika;
	@SuppressWarnings("unused")
	private JLabel jlblZaSliku;
	private JPanel jpnlNaslov;
	private JLabel lblYouWonThe;
	private JButton btnOk;
	private JPanel jpnlDugme;

	
	public PresaoIgricu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PresaoIgricu.class.getResource("/resursi/ghosticon.png")));
		setTitle("Hangman");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		contentPane.add(getPanel_2(), BorderLayout.SOUTH);
	}

	private JPanel getPanel() {
		if (jpnlSlika == null) {
			jpnlSlika = new JPanel();
		}
		Image slikaminiona;
		try {
			slikaminiona = ImageIO.read(this.getClass().getResource("/resursi/funminions.jpg"));
			JLabel jlblZaSliku = new JLabel(new ImageIcon(slikaminiona));
			jpnlSlika.add(jlblZaSliku);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jpnlSlika;
	}

	private JPanel getPanel_1() {
		if (jpnlNaslov == null) {
			jpnlNaslov = new JPanel();
			jpnlNaslov.setPreferredSize(new Dimension(10, 40));
			jpnlNaslov.add(getLblYouWonThe());
		}
		return jpnlNaslov;
	}
	private JLabel getLblYouWonThe() {
		if (lblYouWonThe == null) {
			lblYouWonThe = new JLabel("YOU WON THE WHOLE GAME!");
			lblYouWonThe.setForeground(Color.BLUE);
			lblYouWonThe.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return lblYouWonThe;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOk.setPreferredSize(new Dimension(70, 30));
		}
		return btnOk;
	}
	private JPanel getPanel_2() {
		if (jpnlDugme == null) {
			jpnlDugme = new JPanel();
			jpnlDugme.setPreferredSize(new Dimension(10, 40));
			jpnlDugme.add(getBtnOk());
		}
		return jpnlDugme;
	}
}
