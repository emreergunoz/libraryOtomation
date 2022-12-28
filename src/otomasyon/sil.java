package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class sil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sil frame = new sil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public sil() throws ParseException {

		setBounds(100, 100, 400, 100);
		setTitle("Üye Silme");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		JLabel lblNewLabel = new JLabel("Kimlik Numarasý :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 10, 159, 43);
		contentPane.add(lblNewLabel);
		
		MaskFormatter mf = new MaskFormatter("###########");
		JFormattedTextField fmfl_uyeler_tc = new JFormattedTextField(mf);
		fmfl_uyeler_tc.setFont(new Font("Tahoma", Font.BOLD, 15));
		fmfl_uyeler_tc.setBounds(153, 10, 125, 46);
		contentPane.add(fmfl_uyeler_tc);
		
		Image img= new ImageIcon(this.getClass().getResource("/del40xm.png")).getImage();
		//JButton btnNewButton = new JButton("Sil");
		JLabel btnNewButton = new JLabel("");
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(288, 10, 86, 43);
		contentPane.add(btnNewButton);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(new Color(244,119,0,255));
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setIcon(new ImageIcon(img));
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object [] ayar = {"Evet","Hayýr"};
				String kimlikno,sqllnk;
				kimlikno = fmfl_uyeler_tc.getText();
				int a = JOptionPane.showOptionDialog(null, "Bu Kayýt Sonsuza Kadar Silinecek", "Kayýt Silme", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,ayar,ayar[0]);//özel soru
				if (a==0) {
					sqllnk = "DELETE FROM tbl_uye WHERE  tc = "+kimlikno;
					vt_islem.kydsl(sqllnk);
					setVisible(false);
				}
				
				// a deðeri 0 yani yes dersek iþlemi yapýcak no dersek deðer 2 olucak kabul etmicek
				
				vt_islem.kpt();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.setBackground(new Color(244,119,0,255));
			}
		});
		
	}
}
