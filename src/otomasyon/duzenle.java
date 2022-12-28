package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class duzenle extends JFrame {

	private JPanel contentPane;
	private JTextField txtfld_duzenle_ad;
	private JTextField txtfld_duzenle_soyad;
	private JTextField txtfld_duzenle_eposta;
	static admin_form adm;
	String vt_tc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					duzenle frame = new duzenle();
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
	public duzenle() throws ParseException {
		setBounds(100, 100, 300, 482);
		setTitle("Üye Bilgileri Düzenle");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		//--------------------------------------------------------Label-------------------------------
		JLabel lblNewLabel = new JLabel("Üye Kimlik No :");
		lblNewLabel.setBounds(10, 10, 87, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Üye Adý :");
		lblNewLabel_1.setBounds(10, 55, 87, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Üye Soyadý :");
		lblNewLabel_2.setBounds(10, 100, 87, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefon No:");
		lblNewLabel_3.setBounds(10, 145, 87, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E postasý : ");
		lblNewLabel_4.setBounds(10, 190, 87, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Doðum Yeri :");
		lblNewLabel_5.setBounds(10, 235, 87, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Doðum Tarihi :");
		lblNewLabel_6.setBounds(10, 280, 87, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cinsiyeti :");
		lblNewLabel_7.setBounds(10, 325, 87, 30);
		contentPane.add(lblNewLabel_7);
		
		//--------------------------------------------------------Formated Field-------------------------------
		MaskFormatter mfno = new MaskFormatter("###########");
		MaskFormatter mf = new MaskFormatter("0### ###-##-##");
		
		JFormattedTextField fmfl_duzenle_kmlk = new JFormattedTextField(mfno);
		fmfl_duzenle_kmlk.setEditable(false);
		fmfl_duzenle_kmlk.setBounds(99, 10, 177, 30);
		contentPane.add(fmfl_duzenle_kmlk);
		
		
		JFormattedTextField fmfl_duzenle_tel = new JFormattedTextField(mf);
		fmfl_duzenle_tel.setEditable(false);
		fmfl_duzenle_tel.setBounds(99, 145, 177, 30);
		contentPane.add(fmfl_duzenle_tel);
		
		//--------------------------------------------------------Text Field-------------------------------
		txtfld_duzenle_ad = new JTextField();
		txtfld_duzenle_ad.setEditable(false);
		txtfld_duzenle_ad.setBounds(99, 55, 177, 30);
		contentPane.add(txtfld_duzenle_ad);
		txtfld_duzenle_ad.setColumns(10);
		
		txtfld_duzenle_soyad = new JTextField();
		txtfld_duzenle_soyad.setEditable(false);
		txtfld_duzenle_soyad.setColumns(10);
		txtfld_duzenle_soyad.setBounds(99, 100, 177, 30);
		contentPane.add(txtfld_duzenle_soyad);
		
		txtfld_duzenle_eposta = new JTextField();
		txtfld_duzenle_eposta.setEditable(false);
		txtfld_duzenle_eposta.setColumns(10);
		txtfld_duzenle_eposta.setBounds(99, 190, 177, 30);
		contentPane.add(txtfld_duzenle_eposta);
		
		//--------------------------------------------------------Radio Button-------------------------------
		JRadioButton rb_duzenle_erkek = new JRadioButton("Erkek");
		
		rb_duzenle_erkek.setBounds(99, 325, 69, 30);
		contentPane.add(rb_duzenle_erkek);
		
		JRadioButton rb_duzenle_kadin = new JRadioButton("Kadýn");
		rb_duzenle_kadin.setBounds(173, 325, 103, 30);
		contentPane.add(rb_duzenle_kadin);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb_duzenle_erkek);
		bg.add(rb_duzenle_kadin);
		rb_duzenle_erkek.setBackground(new Color(0,200,200));
		rb_duzenle_kadin.setBackground(new Color(0,200,200));
		//--------------------------------------------------------Combobox-------------------------------
		JComboBox cmbox_ekle_yr = new JComboBox();
		cmbox_ekle_yr.setEditable(true);
		cmbox_ekle_yr.setBounds(99, 235, 177, 30);
		contentPane.add(cmbox_ekle_yr);
		cmbox_ekle_yr.setBackground((new Color(244,119,0)));
		cmbox_ekle_yr.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_ekle_gn = new JComboBox();
		cmbox_ekle_gn.setBounds(99, 280, 40, 30);
		contentPane.add(cmbox_ekle_gn);
		cmbox_ekle_gn.setBackground((new Color(244,119,0)));
		cmbox_ekle_gn.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_ekle_ay = new JComboBox();
		cmbox_ekle_ay.setBounds(151, 280, 46, 30);
		contentPane.add(cmbox_ekle_ay);
		cmbox_ekle_ay.setBackground((new Color(244,119,0)));
		cmbox_ekle_ay.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_ekle_yl = new JComboBox();
		cmbox_ekle_yl.setEditable(true);
		cmbox_ekle_yl.setBounds(207, 280, 69, 30);
		contentPane.add(cmbox_ekle_yl);
		cmbox_ekle_yl.setBackground((new Color(244,119,0)));
		cmbox_ekle_yl.setForeground((new Color(0,0,0)));
		
		Image img= new ImageIcon(this.getClass().getResource("/save55xg.png")).getImage();
		
		
		JLabel btn_duzenle_duzenle = new JLabel("Düzenle");
		btn_duzenle_duzenle.setHorizontalAlignment(SwingConstants.CENTER);
		//JButton btn_duzenle_duzenle = new JButton("Düzenle");
		btn_duzenle_duzenle.setOpaque(true);
		btn_duzenle_duzenle.setBounds(10, 376, 266, 60);
		contentPane.add(btn_duzenle_duzenle);
		
		btn_duzenle_duzenle.setBackground(new Color(244,119,0,255));
		btn_duzenle_duzenle.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); 
		btn_duzenle_duzenle.setIcon(new ImageIcon(img));
		
		//------------------------------------------------------------------------------------------------------
		fmfl_duzenle_kmlk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fmfl_duzenle_kmlk.setEditable(true);
			}
		});
		fmfl_duzenle_tel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fmfl_duzenle_tel.setEditable(true);
			}
		});
		
		txtfld_duzenle_ad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_duzenle_ad.setEditable(true);
			}
		});
		txtfld_duzenle_soyad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_duzenle_soyad.setEditable(true);
			}
		});
		txtfld_duzenle_eposta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_duzenle_eposta.setEditable(true);
			}
		});
		
		//----------------------------------------Combobox Ýþlemler--------------------------------------------
		
		try {
			ResultSet rs=vt_islem.combobox_iller();
			while (rs.next()) {
				String sehir = rs.getString("il");
				cmbox_ekle_yr.addItem(sehir);
			}
		} catch (Exception e) {
		}
		try {
			ResultSet rs=vt_islem.combobox_gunler();
			while (rs.next()) {
				String ay = rs.getString("gun");
				cmbox_ekle_gn.addItem(ay);	
			}
		} catch (Exception e) {
		}
		try {
			ResultSet rs=vt_islem.combobox_aylar();
			while (rs.next()) {
				String ay = rs.getString("ay");
				cmbox_ekle_ay.addItem(ay);	
			}
		} catch (Exception e) {
		}
		try {
			ResultSet rs=vt_islem.combobox_yillar();
			while (rs.next()) {
				String ay = rs.getString("yýl");
				cmbox_ekle_yl.addItem(ay);	
			}
		} catch (Exception e) {
		}
		//------------------------------------------------Gelen Veri----------------------------------------------------------
		fmfl_duzenle_kmlk.setText((String) admin_form. mymdl.getValueAt(admin_form.tbl_uyeler.getSelectedRow(),0));
		txtfld_duzenle_ad.setText((String) admin_form.mymdl.getValueAt(admin_form.tbl_uyeler.getSelectedRow(),1));
		txtfld_duzenle_soyad.setText((String) admin_form.mymdl.getValueAt(admin_form.tbl_uyeler.getSelectedRow(), 2));
		fmfl_duzenle_tel.setText((String)admin_form. mymdl.getValueAt(admin_form.tbl_uyeler.getSelectedRow(), 6));
		txtfld_duzenle_eposta.setText((String)admin_form. mymdl.getValueAt(admin_form.tbl_uyeler.getSelectedRow(),7));
		cmbox_ekle_yr.setSelectedItem((String)admin_form. mymdl.getValueAt(admin_form.tbl_uyeler.getSelectedRow(),4));
		
		if ((boolean)admin_form. mymdl.getValueAt(admin_form.tbl_uyeler.getSelectedRow(),3).equals("Erkek")) {
			rb_duzenle_erkek.setSelected(true);
		}else if((boolean)admin_form. mymdl.getValueAt(admin_form.tbl_uyeler.getSelectedRow(),3).equals("Kadýn")) {
			rb_duzenle_kadin.setSelected(true);;
		}
		
		String trh =((String)admin_form. mymdl.getValueAt(admin_form.tbl_uyeler.getSelectedRow(),5));
		
		String[] dizi =trh.split("[-]");
		for (String a : dizi) {
			
			cmbox_ekle_ay.setSelectedItem(a); // ilk günü lamadýðý için günü alttaki gibi aldýk
			cmbox_ekle_yl.setSelectedItem(a);
		}
		
		String gn=((String)admin_form. mymdl.getValueAt(admin_form.tbl_uyeler.getSelectedRow(),5));
		
		cmbox_ekle_gn.setSelectedItem(gn.substring(0,2));
		
		
		//------------------------------------------------Ýþlem---------------------------------------------------------------
		
		btn_duzenle_duzenle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
				String kimlikno,ad,soyad,cinsiyet,dgmyeri,dgmgn,dgmay,dgmyl,tel,e_posta, sqlupd;
				
				kimlikno = fmfl_duzenle_kmlk.getText();
				ad = txtfld_duzenle_ad.getText();
				soyad = txtfld_duzenle_soyad.getText();
				tel = fmfl_duzenle_tel.getText();
				e_posta= txtfld_duzenle_eposta.getText();

				dgmgn =(String) cmbox_ekle_gn.getSelectedItem().toString();
				dgmay =(String) cmbox_ekle_ay.getSelectedItem().toString();
				dgmyl =(String) cmbox_ekle_yl.getSelectedItem().toString();
				dgmyeri = (String)cmbox_ekle_yr.getSelectedItem().toString();

				if (rb_duzenle_erkek.isSelected()) {
					cinsiyet =rb_duzenle_erkek.getText() ;
				}else {
					cinsiyet =rb_duzenle_kadin.getText() ;
				}

				
				
				sqlupd = "UPDATE tbl_uye SET tc ="+kimlikno+","+
						"ad='"+ad+"',soyad ='"+soyad+"',tel = '"+tel+"',eposta='"+e_posta+"',cinsiyet = '"+cinsiyet+"',dgm_yer ='"+dgmyeri+
						"',dgm_gn ='"+dgmgn+"-"+dgmay+"-"+dgmyl+
						"' WHERE tc="+kimlikno;
				
				vt_islem.guncelle(sqlupd);
				
				
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_duzenle_duzenle.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_duzenle_duzenle.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_duzenle_duzenle.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_duzenle_duzenle.setBackground(new Color(244,119,0,255));
			}
		});
		
		
	
		
		
	}
}