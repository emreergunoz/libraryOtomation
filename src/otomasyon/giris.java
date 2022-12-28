package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import otomasyon.vt_islem;
import otomasyon.admin_form;
import otomasyon.personel_form;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class giris extends JFrame {

	private JPanel contentPane;
	private JTextField txtfl_personel_ad;
	private JPasswordField pswfl_personelsifre;
	static String ad;
	static String sifre;
	static admin_form open;
	static personel_form openp;
	public static int durum;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giris frame = new giris();
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
	public giris() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		setTitle("Kütüphane Otomasyonu Giriþ Penceresi");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		contentPane.setLayout(null);

		
		JLabel lbl_personeladi = new JLabel("Kullanýcý Adý :");
		lbl_personeladi.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_personeladi.setBounds(10, 33, 136, 35);
		contentPane.add(lbl_personeladi);
		
		JLabel lbl_personelsifresi = new JLabel("Kullanýcý Þifresi :");
		lbl_personelsifresi.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_personelsifresi.setBounds(10, 90, 136, 32);
		contentPane.add(lbl_personelsifresi);
		
		txtfl_personel_ad = new JTextField();
		txtfl_personel_ad.setToolTipText("Personel Kullanýcý Adýnýzý Giriniz");
		txtfl_personel_ad.setFont(new Font("Arial", Font.BOLD, 16));
		txtfl_personel_ad.setBounds(156, 33, 220, 35);
		contentPane.add(txtfl_personel_ad);
		txtfl_personel_ad.setColumns(10);
		
		pswfl_personelsifre = new JPasswordField();
		pswfl_personelsifre.setToolTipText("Personel Þifrenizi Giriniz");
		pswfl_personelsifre.setFont(new Font("Arial", Font.BOLD, 16));
		pswfl_personelsifre.setBounds(156, 90, 220, 35);
		contentPane.add(pswfl_personelsifre);
		
		Image img= new ImageIcon(this.getClass().getResource("/usr40xg.png")).getImage();
		Image img1= new ImageIcon(this.getClass().getResource("/adm_40xg.png")).getImage();
		JLabel btn_yetkili = new JLabel("Yetkili Giriþi");
		btn_yetkili.setHorizontalAlignment(SwingConstants.CENTER);
	//	JButton btn_yetkili = new JButton("Yetkili Giriþi");
		btn_yetkili.setToolTipText("Yetkili Giriþi Sayfasýný Açmak Ýçin Bu Butona Basýnýz");
		btn_yetkili.setFont(new Font("Arial", Font.BOLD, 12));
		btn_yetkili.setBounds(10, 156, 136, 42);
		contentPane.add(btn_yetkili);
		btn_yetkili.setOpaque(true);
		btn_yetkili.setBackground(new Color(244,119,0,255));
		btn_yetkili.setIcon(new ImageIcon(img1));	
		btn_yetkili.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel btn_giris = new JLabel("Giriþ Yap");
		btn_giris.setHorizontalAlignment(SwingConstants.CENTER);
		//JButton btn_giris = new JButton("Giri\u015F Yap");
		btn_giris.setToolTipText("Bilgiler Girildiyse  Bu Butona Basýnýz");
		btn_giris.setFont(new Font("Arial", Font.BOLD, 20));
		btn_giris.setBounds(156, 156, 220, 42);
		contentPane.add(btn_giris);
		btn_giris.setOpaque(true);
		btn_giris.setBackground(new Color(244,119,0,255));
		btn_giris.setIcon(new ImageIcon(img));	
		btn_giris.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		
		//-----------------------------------------------------------------------------------------------
		btn_yetkili.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				durum=1;
				ad= txtfl_personel_ad.getText();
				char[] girdi = pswfl_personelsifre.getPassword();
				sifre = new String(girdi);

				try {
					open = new admin_form();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String sqlara ="select count(adm_tc) as giriss from tbl_admin where adm_kullanici_ad ='"+ad+"' and adm_kullnici_sifre='"+sifre+"'" ;
				
				//ResultSet rs = vt_islem.baglan();
				ResultSet rs  = null;
				rs=vt_islem.ara_uyeler(sqlara);
				
				try {
					while (rs.next()){
						if(rs.getInt("giriss")==1) {
							setVisible(false);
							open.setVisible(true);
							
						}else {
							JOptionPane.showMessageDialog(null, "Hatalý Giriþ","Hata ",JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vt_islem.kpt();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_yetkili.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_yetkili.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_yetkili.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_yetkili.setBackground(new Color(244,119,0,255));
			}
		});
		
		btn_giris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				durum=2;
				ad= txtfl_personel_ad.getText();
				char[] girdi = pswfl_personelsifre.getPassword();
				sifre = new String(girdi);

				openp = new personel_form();
				
				String sqlara ="select count(prsnl_id) as giriss from tbl_personel where prsnl_kullanici_ad='"+ad+"' and prsnl_kullanici_sifre='"+sifre+"'and prsnl_bitis is null";
				
			//	ResultSet rs = vt_islem.baglan();
				ResultSet rs=null;
				rs=vt_islem.ara_uyeler(sqlara);
				
				try {
					while (rs.next()){
						if(rs.getInt("giriss")==1) {
							setVisible(false);
							openp.setVisible(true);
							
						}else {
							JOptionPane.showMessageDialog(null, "Hatalý Giriþ","Hata ",JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vt_islem.kpt();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_giris.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_giris.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_giris.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_giris.setBackground(new Color(244,119,0,255));
			}
		});
		
		
	}
}

