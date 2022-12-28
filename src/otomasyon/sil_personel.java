package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class sil_personel extends JFrame {

	private JPanel contentPane;
	public static String bitis;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sil_personel frame = new sil_personel();
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
	public sil_personel() throws ParseException {
		setBounds(100, 100, 400, 100);
		setTitle("Personel Çýkarm Penceresi");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		JLabel lblPersonelTc = new JLabel("Personel Tc :");
		lblPersonelTc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPersonelTc.setBounds(10, 10, 159, 43);
		contentPane.add(lblPersonelTc);
		
		MaskFormatter mfno = new MaskFormatter("###########");
		JFormattedTextField fmfl_personel_sl = new JFormattedTextField(mfno);
		fmfl_personel_sl.setBounds(119, 10, 159, 46);
		contentPane.add(fmfl_personel_sl);
		
		Image img= new ImageIcon(this.getClass().getResource("/del40xm.png")).getImage();
		JLabel btn_ktp_sl = new JLabel("Bitir");
		btn_ktp_sl.setHorizontalAlignment(SwingConstants.CENTER);
		
		//JButton btn_ktp_sl = new JButton("Sil");
		btn_ktp_sl.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_ktp_sl.setBounds(288, 10, 86, 43);
		contentPane.add(btn_ktp_sl);
		btn_ktp_sl.setOpaque(true);
		btn_ktp_sl.setBackground(new Color(244,119,0,255));
		btn_ktp_sl.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); 
		btn_ktp_sl.setIcon(new ImageIcon(img));
		//-------------------------------------------------------------------------------------------
		
		Date tarih = new Date ();
		DateFormat tfd = new SimpleDateFormat("dd-MM-yyyy");
		bitis=tfd.format(tarih);
		
		//---------------------------------------------------------------------------
		btn_ktp_sl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object [] ayar = {"Evet","Hayýr"};
				String id,sqllnk1;
				id=fmfl_personel_sl.getText();
				int a = JOptionPane.showOptionDialog(null, "Personel Çýkarýlsýnmý", "Kayýt Silme", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,ayar,ayar[0]);//özel soru
				if (a==0) {
					sqllnk1="UPDATE tbl_personel SET prsnl_kullanici_ad= '',prsnl_kullanici_sifre= '',prsnl_bitis ='"+bitis+"' WHERE prsnl_id='"+id+"'";
					vt_islem.add_kira(sqllnk1);
					vt_islem.kpt();
					setVisible(false);
				}
				
				
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
