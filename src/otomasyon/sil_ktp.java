package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class sil_ktp extends JFrame {

	private JPanel contentPane;
	private JTextField txtfld_ktp_sl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sil_ktp frame = new sil_ktp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sil_ktp() {
		setBounds(100, 100, 400, 100);
		setTitle("Kitap Silme");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		JLabel lblNewLabel = new JLabel("Kitap \u0130D :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 10, 159, 43);
		contentPane.add(lblNewLabel);
		
		txtfld_ktp_sl = new JTextField();
		txtfld_ktp_sl.setBounds(155, 10, 125, 46);
		contentPane.add(txtfld_ktp_sl);
		txtfld_ktp_sl.setColumns(10);
		txtfld_ktp_sl.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		Image img= new ImageIcon(this.getClass().getResource("/del40xm.png")).getImage();
		JLabel btn_ktp_sl = new JLabel("Sil");
		//JButton btn_ktp_sl = new JButton("Sil");
		btn_ktp_sl.setFont(new Font("Arial", Font.BOLD, 20));
		btn_ktp_sl.setBounds(290, 10, 86, 43);
		contentPane.add(btn_ktp_sl);
		btn_ktp_sl.setHorizontalAlignment(SwingConstants.CENTER);
		btn_ktp_sl.setOpaque(true);
		btn_ktp_sl.setBackground(new Color(244,119,0,255));
		btn_ktp_sl.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); // kenarlýk ekliyor
		btn_ktp_sl.setIcon(new ImageIcon(img));
		
		btn_ktp_sl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object [] ayar = {"Evet","Hayýr"};
				String kimlikno,sqllnk;
				kimlikno = txtfld_ktp_sl.getText();
				int a = JOptionPane.showOptionDialog(null, "Bu Kitap Sonsuza Kadar Silinecek", "Kayýt Silme", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,ayar,ayar[0]);//özel soru
				if (a==0) {
					sqllnk = "DELETE FROM tbl_ktp WHERE  ktp_id = "+kimlikno;
					vt_islem.kydsl(sqllnk);
					setVisible(false);
				}
				if (a==0) {
					sqllnk = "DELETE FROM tbl_yzr_ktp WHERE  ktp_id = "+kimlikno;
					vt_islem.kydsl(sqllnk);
					setVisible(false);
				}
				if (a==0) {
					sqllnk = "DELETE FROM tbl_ktp_tur WHERE  ktp_id = "+kimlikno;
					vt_islem.kydsl(sqllnk);
					setVisible(false);
				}
				
				// a deðeri 0 yani yes dersek iþlemi yapýcak no dersek deðer 2 olucak kabul etmicek
				
				vt_islem.kpt();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_ktp_sl.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_ktp_sl.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_ktp_sl.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_ktp_sl.setBackground(new Color(244,119,0,255));
			}
		});
	}
}
