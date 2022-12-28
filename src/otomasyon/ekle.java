package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ekle extends JFrame {

	private JPanel contentPane;
	private JTextField txtfld_ekle_ad;
	private JTextField txtfld_ekle_soyad;
	private JTextField txtfld_ekle_eposta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ekle frame = new ekle();
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
	public ekle() throws ParseException {
		setBounds(100, 100, 300, 482);
		setTitle("Üye Ekle");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
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
		//-------------------------------------------------------------------
		MaskFormatter mfno = new MaskFormatter("###########");
		MaskFormatter mf = new MaskFormatter("0### ###-##-##");
		
		JFormattedTextField fmfl_ekle_kmlk = new JFormattedTextField(mfno);
		fmfl_ekle_kmlk.setBounds(99, 10, 177, 30);
		contentPane.add(fmfl_ekle_kmlk);
		
		JFormattedTextField fmfl_ekle_tel = new JFormattedTextField(mf);
		fmfl_ekle_tel.setBounds(99, 145, 177, 30);
		contentPane.add(fmfl_ekle_tel);
		//-------------------------------------------------------------------
		txtfld_ekle_ad = new JTextField();
		txtfld_ekle_ad.setBounds(99, 55, 177, 30);
		contentPane.add(txtfld_ekle_ad);
		txtfld_ekle_ad.setColumns(10);
		
		txtfld_ekle_soyad = new JTextField();
		txtfld_ekle_soyad.setColumns(10);
		txtfld_ekle_soyad.setBounds(99, 100, 177, 30);
		contentPane.add(txtfld_ekle_soyad);
		
		txtfld_ekle_eposta = new JTextField();
		txtfld_ekle_eposta.setColumns(10);
		txtfld_ekle_eposta.setBounds(99, 190, 177, 30);
		contentPane.add(txtfld_ekle_eposta);
		//-------------------------------------------------------------------
		JRadioButton rb_ekle_erkek = new JRadioButton("Erkek");
		rb_ekle_erkek.setBounds(99, 325, 69, 30);
		contentPane.add(rb_ekle_erkek);
		
		JRadioButton rb_ekle_kadin = new JRadioButton("Kadýn");
		rb_ekle_kadin.setBounds(173, 325, 103, 30);
		contentPane.add(rb_ekle_kadin);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb_ekle_erkek);
		bg.add(rb_ekle_kadin);
		rb_ekle_erkek.setBackground(new Color(0,200,200));
		rb_ekle_kadin.setBackground(new Color(0,200,200));
		//-------------------------------------------------------------------
		JComboBox cmbox_ekle_yr = new JComboBox();
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
		//-------------------------------------------------------------------
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
		try {
			ResultSet rs=vt_islem.combobox_iller();
			while (rs.next()) {
				String sehir = rs.getString("il");
				cmbox_ekle_yr.addItem(sehir);
			}
		} catch (Exception e) {
		}
		//------------------------------------------------------------------------------
		Image img= new ImageIcon(this.getClass().getResource("/add60xg1.png")).getImage();//refresh butonu
		JLabel btn_ekle_ekle = new JLabel();//"Ekle"
		btn_ekle_ekle.setText("Üye Ekle");
		btn_ekle_ekle.setFont(new Font("Arial", Font.BOLD, 20));
		btn_ekle_ekle.setHorizontalAlignment(SwingConstants.CENTER);
		btn_ekle_ekle.setOpaque(true);
		btn_ekle_ekle.setBounds(10, 376, 266, 60);
		contentPane.add(btn_ekle_ekle);
		btn_ekle_ekle.setBackground(new Color(244,119,0,255));
		btn_ekle_ekle.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); 
		btn_ekle_ekle.setIcon(new ImageIcon(img));	
		
		
		btn_ekle_ekle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					String kimlikno,ad,soyad,cinsiyet,dgmyeri,dgmgn,dgmay,dgmyl,tel,e_posta, sqllnk;

					kimlikno = fmfl_ekle_kmlk.getText();
					ad = txtfld_ekle_ad.getText();
					soyad = txtfld_ekle_soyad.getText();
					tel = fmfl_ekle_tel.getText();
					e_posta= txtfld_ekle_eposta.getText();
					dgmgn =(String) cmbox_ekle_gn.getSelectedItem().toString();
					dgmay =(String) cmbox_ekle_ay.getSelectedItem().toString();
					dgmyl =(String) cmbox_ekle_yl.getSelectedItem().toString();
					dgmyeri = (String)cmbox_ekle_yr.getSelectedItem().toString();

					if (rb_ekle_erkek.isSelected()) {
						cinsiyet =rb_ekle_erkek.getText() ;
					}else {
						cinsiyet =rb_ekle_kadin.getText() ;
					}

													//tc,ad,soyad,cinsiyet,dgm_yer,dgm_gn,dgm_ay,dgm_yl,tel,eposta
					sqllnk = "INSERT INTO tbl_uye (tc,ad,soyad,cinsiyet,dgm_yer,dgm_gn,tel,eposta) VALUES ('"
							+kimlikno+"',"+"'"+ad+"',"+"'"+soyad+"',"+"'"+cinsiyet+"',"+"'"+dgmyeri+"',"+"'"+dgmgn+"-"+dgmay+"-"+dgmyl+"',"+"'"+tel+"',"+"'"+e_posta+"')";
						
					vt_islem.add_uye(sqllnk);
						
					
					vt_islem.kpt();	
						
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_ekle_ekle.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_ekle_ekle.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_ekle_ekle.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_ekle_ekle.setBackground(new Color(244,119,0,255));
			}
		});
		
		
	}
}
