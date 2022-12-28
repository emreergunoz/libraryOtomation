package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ekle_personel extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtfld_personel_ad;
	private JTextField txtfld_personel_soyad;
	private JTextField txtfld_personel_eposta;
	private JTextField txtfld_personel_kullanýcýad;
	private JTextField txtfld_personel_sifre;
	public static String baslangic;
	private JTextField txtfld_personel_maas;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ekle_personel frame = new ekle_personel();
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
	public ekle_personel() throws ParseException {
		setBounds(100, 100, 295, 481);
		setTitle("Personel Ekle");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		JLabel lblNewLabel_1 = new JLabel("Adý :");
		lblNewLabel_1.setBounds(10, 130, 87, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Soyadý :");
		lblNewLabel_2.setBounds(10, 170, 87, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefon No:");
		lblNewLabel_3.setBounds(10, 251, 87, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E postasý : ");
		lblNewLabel_4.setBounds(10, 291, 87, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Doðum Tarihi :");
		lblNewLabel_6.setBounds(10, 331, 87, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblPersonelKimlikNo = new JLabel("Kimlik No :");
		lblPersonelKimlikNo.setBounds(10, 10, 129, 30);
		contentPane.add(lblPersonelKimlikNo);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Kullanýcý Adý :");
		lblNewLabel_1_1.setBounds(10, 50, 129, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Personel Þifre :");
		lblNewLabel_2_1.setBounds(10, 90, 129, 30);
		contentPane.add(lblNewLabel_2_1);
		
		
		JLabel lblNewLabel_2_2 = new JLabel("Maaþ  :");
		lblNewLabel_2_2.setBounds(10, 210, 87, 30);
		contentPane.add(lblNewLabel_2_2);
		//-------------------------------------------------------------------
		MaskFormatter mfno = new MaskFormatter("###########");
		MaskFormatter mf = new MaskFormatter("0### ###-##-##");
		
		JFormattedTextField fmfl_prsnelekle_kmlk = new JFormattedTextField((mfno) );
		fmfl_prsnelekle_kmlk.setBounds(100, 11, 177, 30);
		contentPane.add(fmfl_prsnelekle_kmlk);
		
		JFormattedTextField fmfl_personel_tel = new JFormattedTextField((mf) );
		fmfl_personel_tel.setBounds(100, 252, 177, 30);
		contentPane.add(fmfl_personel_tel);
		
		//------------------------------------------------------------------------
		txtfld_personel_ad = new JTextField();
		txtfld_personel_ad.setColumns(10);
		txtfld_personel_ad.setBounds(100, 131, 177, 30);
		contentPane.add(txtfld_personel_ad);
		
		txtfld_personel_soyad = new JTextField();
		txtfld_personel_soyad.setColumns(10);
		txtfld_personel_soyad.setBounds(100, 171, 177, 30);
		contentPane.add(txtfld_personel_soyad);
		
		txtfld_personel_eposta = new JTextField();
		txtfld_personel_eposta.setColumns(10);
		txtfld_personel_eposta.setBounds(100, 292, 177, 30);
		contentPane.add(txtfld_personel_eposta);
		
		txtfld_personel_kullanýcýad = new JTextField();
		txtfld_personel_kullanýcýad.setColumns(10);
		txtfld_personel_kullanýcýad.setBounds(100, 51, 177, 30);
		contentPane.add(txtfld_personel_kullanýcýad);
		
		txtfld_personel_sifre = new JTextField();
		txtfld_personel_sifre.setColumns(10);
		txtfld_personel_sifre.setBounds(100, 91, 177, 30);
		contentPane.add(txtfld_personel_sifre);
		
		txtfld_personel_maas = new JTextField();
		txtfld_personel_maas.setColumns(10);
		txtfld_personel_maas.setBounds(100, 211, 177, 30);
		contentPane.add(txtfld_personel_maas); 
		//---------------------------------------------------------
		JComboBox cmbox_personel_gn = new JComboBox();
		cmbox_personel_gn.setBounds(99, 331, 40, 30);
		contentPane.add(cmbox_personel_gn);
		cmbox_personel_gn.setBackground((new Color(244,119,0)));
		cmbox_personel_gn.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_personel_ay = new JComboBox();
		cmbox_personel_ay.setBounds(152, 331, 46, 30);
		contentPane.add(cmbox_personel_ay);
		cmbox_personel_ay.setBackground((new Color(244,119,0)));
		cmbox_personel_ay.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_personel_yl = new JComboBox();
		cmbox_personel_yl.setBounds(208, 331, 69, 30);
		contentPane.add(cmbox_personel_yl);
		cmbox_personel_yl.setBackground((new Color(244,119,0)));
		cmbox_personel_yl.setForeground((new Color(0,0,0)));
		//----------------------------------------------------------------------------
		Image img= new ImageIcon(this.getClass().getResource("/add60xg.png")).getImage();
		
		JLabel btn_personel_ekle = new JLabel("Personel Ekle");
		btn_personel_ekle.setFont(new Font("Arial", Font.BOLD, 20));
		btn_personel_ekle.setHorizontalAlignment(SwingConstants.CENTER);
		//JButton btn_personel_ekle = new JButton("Personel Ekle");
		btn_personel_ekle.setBounds(10, 371, 267, 67);
		contentPane.add(btn_personel_ekle);
		btn_personel_ekle.setOpaque(true);
		btn_personel_ekle.setBackground(new Color(244,119,0,255));
		btn_personel_ekle.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); 
		btn_personel_ekle.setIcon(new ImageIcon(img));
		
		//-----------------------------------------------Ýþlemler---------------------
		try {
			ResultSet rs=vt_islem.combobox_gunler();
			while (rs.next()) {
				String ay = rs.getString("gun");
				cmbox_personel_gn.addItem(ay);	
			}
		} catch (Exception e) {
		}
		try {
			ResultSet rs=vt_islem.combobox_aylar();
			while (rs.next()) {
				String ay = rs.getString("ay");
				cmbox_personel_ay.addItem(ay);	
			}
		} catch (Exception e) {
		}
		try {
			ResultSet rs=vt_islem.combobox_yillar();
			while (rs.next()) {
				String ay = rs.getString("yýl");
				cmbox_personel_yl.addItem(ay);	
			}
		} catch (Exception e) {
		}
		//----------------------------------------------------------------------------------------------
		Date tarih = new Date ();
		DateFormat tfd = new SimpleDateFormat("dd-MM-YYYY");
		DateFormat tfm = new SimpleDateFormat("MM");
		DateFormat tfy = new SimpleDateFormat("yyyy");
		baslangic=tfd.format(tarih);

		
		//--------------------------------------------------------------Buton----------
		btn_personel_ekle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String kimlikno,ad,soyad,dgmgn,dgmay,dgmyl,tel,kullanici_ad,kullanici_sifre,e_posta, sqllnkp,maas;

				kimlikno = fmfl_prsnelekle_kmlk.getText();
				kullanici_ad=txtfld_personel_kullanýcýad.getText();
				kullanici_sifre=txtfld_personel_sifre.getText();
				ad = txtfld_personel_ad.getText();
				soyad = txtfld_personel_soyad.getText();
				tel = fmfl_personel_tel.getText();
				e_posta= txtfld_personel_eposta.getText();
				maas=txtfld_personel_maas.getText();

				dgmgn =(String) cmbox_personel_gn.getSelectedItem().toString();
				dgmay =(String) cmbox_personel_ay.getSelectedItem().toString();
				dgmyl =(String) cmbox_personel_yl.getSelectedItem().toString();
				
													//(prsnl_id,prsnl_kullanici_ad,prsnl_kullanici_sifre,prsnl_ad,prsnl_soyad,prsnl_maas,prsnl_baslangic,prsnl_dgm_gn,prsnl_dgm_ay,prsnl_dgm_yl,prsnl_tel,prsnl_eposta
				sqllnkp = "INSERT INTO tbl_personel (prsnl_id,prsnl_kullanici_ad,prsnl_kullanici_sifre,prsnl_ad,prsnl_soyad,prsnl_maas,prsnl_baslangic,prsnl_dgm_gn,prsnl_tel,prsnl_eposta) VALUES ('"
						+kimlikno+"',"+"'"+kullanici_ad+"',"+"'"+kullanici_sifre+"',"+"'"+ad+"',"+"'"+soyad+"',"+"'"+maas+"',"+"'"+baslangic+"',"+"'"+dgmgn+"-"+dgmay+"-"+dgmyl+"',"+"'"+tel+"',"+"'"+e_posta+"')";
				
				vt_islem.add_personel(sqllnkp);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_personel_ekle.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_personel_ekle.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_personel_ekle.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_personel_ekle.setBackground(new Color(244,119,0,255));
			}
			
		});
		
	
	}
}
