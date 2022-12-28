package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;

public class ekle_kira extends JFrame {
	
	private JPanel contentPane;
	public static JTable tbl_kullanici;
	public static JTable tbl_kitap;
	public static String kitap , üye;
	public static String kiraid,baslangicgn,baslangicay,baslangicyl,bitisgn,bitisay,bitisyl,stok,sqllnk,sqllnk2,a,b,c;
	public static int stok1;
	//-----------------------------------------------------------------
	static DefaultTableModel mymdlkitap= new DefaultTableModel();
	Object [] klnkitap= {"Kitap ÝD","Stok","Kitap Adý "};
	static Object[] strkitap= new Object[3];
	//-----------------------------------------------------------------
	static DefaultTableModel mymdltc= new DefaultTableModel();
	Object [] klntc= {"Üye Tc","Üye Adý "};
	static Object[] strtc= new Object[2];
	//-----------------------------------------------------------------
	private JTextField txtfld_kira_id;
	private JTextField txtfld_uye;
	private JTextField txtfld_ktp;
	//-----------------------------------------------------------------
	
	static void listele_tc() {  //Table 'ýn oluþturulmasý için methot
		mymdltc.setRowCount(0);
		
		ResultSet rs=vt_islem.kiratc_listele();
		try {
			while(rs.next()) {
				strtc[0]=rs.getString("tc");
				strtc[1]=rs.getString("ad")+"-"+rs.getString("soyad");
				mymdltc.addRow(strtc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		tbl_kullanici.setModel(mymdltc);
		vt_islem.kpt();
		
	}static void listele_ktp() {  //Table 'ýn oluþturulmasý için methot
		mymdlkitap.setRowCount(0);
		
		ResultSet rs=vt_islem.kiraktp_listele();
		
		try {
			while(rs.next()) {
				strkitap[0]=rs.getString("ktp_id");
				strkitap[1]=rs.getString("ktp_stok");
				strkitap[2]=rs.getString("ktp_ad");
				mymdlkitap.addRow(strkitap);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		tbl_kitap.setModel(mymdlkitap);
		vt_islem.kpt();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ekle_kira frame = new ekle_kira();
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
	public ekle_kira() {
		setBounds(100, 100, 295, 445);
		setTitle("Kitap Kirala");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		setBounds(100, 100, 485, 345);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 207, 171);
		getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(250, 10, 207, 171);
		getContentPane().add(scrollPane_1);
		
		tbl_kullanici = new JTable();
		tbl_kullanici.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mymdltc.setColumnIdentifiers(klntc);
		scrollPane.setViewportView(tbl_kullanici);
		tbl_kullanici.setSelectionBackground(new Color(244,119,0));
		tbl_kullanici.setSelectionForeground(new Color(0,0,0));
		tbl_kullanici.setBackground(new Color(255,255,255));

		tbl_kitap = new JTable();
		tbl_kitap.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mymdlkitap.setColumnIdentifiers(klnkitap);
		scrollPane_1.setViewportView(tbl_kitap);
		tbl_kitap.setSelectionBackground(new Color(244,119,0));
		tbl_kitap.setSelectionForeground(new Color(0,0,0));
		tbl_kitap.setBackground(new Color(255,255,255));
		
		JLabel lblNewLabel = new JLabel("Kira \u0130D :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 231, 77, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kira Tarihi : ");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 271, 77, 29);
		getContentPane().add(lblNewLabel_1_1);
		

		txtfld_kira_id = new JTextField();
		txtfld_kira_id.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_kira_id.setEditable(false);
		txtfld_kira_id.setBounds(97, 232, 205, 30);
		getContentPane().add(txtfld_kira_id);
		txtfld_kira_id.setColumns(10);

		txtfld_uye = new JTextField();
		txtfld_uye.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_uye.setText("Ara");
		txtfld_uye.setBounds(97, 191, 83, 30);
		getContentPane().add(txtfld_uye);
		txtfld_uye.setColumns(10);
		
		txtfld_ktp = new JTextField();
		txtfld_ktp.setText("Ara");
		txtfld_ktp.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_ktp.setColumns(10);
		txtfld_ktp.setBounds(290, 192, 83, 30);
		getContentPane().add(txtfld_ktp);
		
		
		JComboBox cmbox_ktp = new JComboBox();
		cmbox_ktp.setFont(new Font("Arial", Font.BOLD, 10));
		cmbox_ktp.setModel(new DefaultComboBoxModel(new String[] {"Kitap \u0130d", "Kitap Ad"}));
		cmbox_ktp.setBounds(380, 191, 77, 30);
		getContentPane().add(cmbox_ktp);
		cmbox_ktp.setBackground((new Color(244,119,0)));
		cmbox_ktp.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_uye = new JComboBox();
		cmbox_uye.setFont(new Font("Arial", Font.BOLD, 10));
		cmbox_uye.setModel(new DefaultComboBoxModel(new String[] {"\u00DCye Tc", "\u00DCye Ad"}));
		cmbox_uye.setBounds(10, 191, 77, 30);
		getContentPane().add(cmbox_uye);
		cmbox_uye.setBackground((new Color(244,119,0)));
		cmbox_uye.setForeground((new Color(0,0,0)));
	
		
		JComboBox cmbox_bts_gn = new JComboBox();
		cmbox_bts_gn.setFont(new Font("Arial", Font.BOLD, 10));
		cmbox_bts_gn.setBounds(97, 270, 60, 30);
		getContentPane().add(cmbox_bts_gn);
		cmbox_bts_gn.setBackground((new Color(244,119,0)));
		cmbox_bts_gn.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_bts_ay = new JComboBox();
		cmbox_bts_ay.setFont(new Font("Arial", Font.BOLD, 10));
		cmbox_bts_ay.setBounds(167, 270, 45, 30);
		getContentPane().add(cmbox_bts_ay);
		cmbox_bts_ay.setBackground((new Color(244,119,0)));
		cmbox_bts_ay.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_bts_yl = new JComboBox();
		cmbox_bts_yl.setFont(new Font("Arial", Font.BOLD, 10));
		cmbox_bts_yl.setBounds(222, 270, 80, 30);
		getContentPane().add(cmbox_bts_yl);
		cmbox_bts_yl.setBackground((new Color(244,119,0)));
		cmbox_bts_yl.setForeground((new Color(0,0,0)));
		
		
		//--------------------------------------------------------------
		Image img= new ImageIcon(this.getClass().getResource("/ref30xb.png")).getImage();
		Image img2= new ImageIcon(this.getClass().getResource("/kira30xg.png")).getImage();
		//--------------------------------------------------------------
		JLabel btn_tc_res = new JLabel("Kira Tarihi : ");
		//JButton btn_tc_res = new JButton("");
		btn_tc_res.setBounds(187, 191, 30, 30);
		getContentPane().add(btn_tc_res);
		btn_tc_res.setOpaque(true);
		btn_tc_res.setBackground(new Color(244,119,0,255));
		btn_tc_res.setIcon(new ImageIcon(img));	
		btn_tc_res.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel btn_ktp_res = new JLabel("Kira Tarihi : ");
		//JButton btn_ktp_res = new JButton("");
		btn_ktp_res.setBounds(250, 191, 30, 30);
		getContentPane().add(btn_ktp_res);
		btn_ktp_res.setOpaque(true);
		btn_ktp_res.setBackground(new Color(244,119,0,255));
		btn_ktp_res.setIcon(new ImageIcon(img));	
		btn_ktp_res.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel btn_kira = new JLabel("\u00D6d\u00FCn\u00E7 Ver");
		btn_kira.setFont(new Font("Arial", Font.BOLD, 18));
		btn_kira.setHorizontalAlignment(SwingConstants.CENTER);
		//JButton btn_kira = new JButton("Kirala");
		btn_kira.setBounds(312, 231, 145, 69);
		getContentPane().add(btn_kira);
		btn_kira.setOpaque(true);
		btn_kira.setIcon(new ImageIcon(img2));
		btn_kira.setBackground(new Color(244,119,0,255));
		btn_kira.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); // kenarlýk ekliyor
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(new Color(244, 119, 0));
		separator_3.setBounds(232, 10, 2, 212);
		contentPane.add(separator_3);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setForeground(new Color(244, 119, 0));
		separator_3_1.setBounds(10, 225, 450, 2);
		contentPane.add(separator_3_1);
		
		//--------------------------------------------------------------
		
		if(giris.durum==1) {
			txtfld_kira_id.setText(Integer.toString(Integer.parseInt(admin_form.kiraid)+1));
		}else if(giris.durum==2){
			txtfld_kira_id.setText(Integer.toString(Integer.parseInt(personel_form.kiraidp)+1));
		}
		
		
		//--------------------------------------------------------------
		try {
			ResultSet rs=vt_islem.combobox_gun();
			while (rs.next()) {
				String ay = rs.getString("gun");
				cmbox_bts_gn.addItem(ay);	
				//cmbox_kira_gn.addItem(ay);
			}
		} catch (Exception e) {
		}vt_islem.kpt();
		
		try {
			ResultSet rs=vt_islem.combobox_ay();
			while (rs.next()) {
				String ay = rs.getString("ay");
				cmbox_bts_ay.addItem(ay);	
				//cmbox_kira_ay.addItem(ay);
			}
		} catch (Exception e) {
		}vt_islem.kpt();
		
		try {
			ResultSet rs=vt_islem.combobox_yil();
			while (rs.next()) {
				String ay = rs.getString("yýl");
				cmbox_bts_yl.addItem(ay);	
				//cmbox_kira_yl.addItem(ay);	
			}
		} catch (Exception e) {
		}vt_islem.kpt();
		
		listele_ktp();
		listele_tc();
		
		//--------------------------------------------------Arama----------------
		txtfld_uye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_uye.setText("");
			}
		});
		txtfld_ktp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_ktp.setText("");
			}
		});
		
		txtfld_uye.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				mymdltc.setRowCount(0);
				String sqlara_kira_tc = null;
				String srch =txtfld_uye.getText();
				ResultSet rs = null;
				int clikc = cmbox_uye.getSelectedIndex();
				if(clikc == 0) {
					sqlara_kira_tc ="SELECT tc,ad,soyad FROM tbl_uye WHERE tc like '%"+Integer.parseInt(srch)+"%'"; 
				}else if (clikc ==1 ) {
					sqlara_kira_tc = "SELECT tc,ad,soyad FROM tbl_uye WHERE ad like '%"+srch+"%'";
				}
				rs= vt_islem.ara_uyeler(sqlara_kira_tc);
				try {
					while(rs.next()) {
						strtc[0]=rs.getString("tc");
						strtc[1]=rs.getString("ad")+"-"+rs.getString("soyad");
						mymdltc.addRow(strtc);
					}
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				tbl_kullanici.setModel(mymdltc);
				vt_islem.kpt();

				}
		});
		txtfld_ktp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				mymdlkitap.setRowCount(0);
				String sqlara_kira_ktp = null;
				String srch1 =txtfld_ktp.getText();
				ResultSet rss = null;
				int clikc1 = cmbox_ktp.getSelectedIndex();
				if(clikc1 ==0) {
					sqlara_kira_ktp = "SELECT ktp_id,ktp_stok,ktp_ad FROM tbl_ktp WHERE ktp_id like '%"+Integer.parseInt(srch1)+"%'";
				}else if (clikc1 ==1 ) {
					sqlara_kira_ktp = "SELECT ktp_id,ktp_stok,ktp_ad FROM tbl_ktp WHERE ktp_ad like '%"+srch1+"%'";
				}
				rss= vt_islem.ara_ktp(sqlara_kira_ktp);
				try {
					while(rss.next()) {
						strkitap[0]=rss.getString("ktp_id");
						strkitap[1]=rss.getString("ktp_stok");
						strkitap[2]=rss.getString("ktp_ad");
						mymdlkitap.addRow(strkitap);
					}
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				tbl_kitap.setModel(mymdlkitap);
				vt_islem.kpt();
				}
			
		});
		
		//--------------------------------------------------------Tablo Týklama------------------
		tbl_kitap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kitap=(String) mymdlkitap.getValueAt(tbl_kitap.getSelectedRow(),0);
				stok1=Integer.parseInt(stok=(String) mymdlkitap.getValueAt(tbl_kitap.getSelectedRow(),1));
				
			}
		});
		tbl_kullanici.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				üye=(String) mymdltc.getValueAt(tbl_kullanici.getSelectedRow(),0);
			}
		});
		
		//----------------------------------------------------Tarih Alma-------------------------
		Date tarih = new Date ();
		DateFormat tfd = new SimpleDateFormat("dd-MM-yyyy");
		baslangicgn=tfd.format(tarih);
		
		
		
		//----------------------------------------------Butonlar-------------------------------------
		
		btn_tc_res.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listele_tc();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_tc_res.setBackground(new Color(255,145,40));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xg.png")).getImage();
				btn_tc_res.setIcon(new ImageIcon(img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_tc_res.setBackground(new Color(244,119,0,255));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xb.png")).getImage();
				btn_tc_res.setIcon(new ImageIcon(img));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_tc_res.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_tc_res.setBackground(new Color(244,119,0,255));
			}
		});
		btn_ktp_res.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listele_ktp();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_ktp_res.setBackground(new Color(255,145,40));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xg.png")).getImage();
				btn_ktp_res.setIcon(new ImageIcon(img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_ktp_res.setBackground(new Color(244,119,0,255));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xb.png")).getImage();
				btn_ktp_res.setIcon(new ImageIcon(img));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_ktp_res.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_ktp_res.setBackground(new Color(244,119,0,255));
			}
		});
		
		
		
		btn_kira.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				kiraid=txtfld_kira_id.getText();
				bitisgn=(String)cmbox_bts_gn.getSelectedItem().toString();
				bitisay=(String)cmbox_bts_ay.getSelectedItem().toString();
				bitisyl=(String)cmbox_bts_yl.getSelectedItem().toString();

				sqllnk = "INSERT INTO tbl_ktp_kira (kira_id,kitap_id,tc,baslangic_gn,bitis_gn,iade_drm) VALUES ('"
						+kiraid+"',"+"'"+kitap+"',"+"'"+üye+"',"+"'"+baslangicgn+"',"+"'"+bitisgn+"-"+bitisay+"-"+bitisyl+"',"+"'Edilmedi')";
				
				
				vt_islem.add_kira(sqllnk);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_kira.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_kira.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_kira.setBackground(new Color(255,51,40));
				int stok2 = stok1-1;
				sqllnk2="UPDATE tbl_ktp SET ktp_stok ='"+stok2+"' WHERE ktp_id="+kitap;
			
				vt_islem.guncelle(sqllnk2);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_kira.setBackground(new Color(244,119,0,255));
			}
		});
		
		
	}
}
