package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class personel_form extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
	public static JTable tbl_uyeler;
	public static JTable tbl_kitaplar;
	public static JTable tbl_kira;
	public static JTable tbl_yazar;
	public static JTable tbl_yayinevi;
	
	
	//-------------------------------------------------Uye Deðiþkenleri-----------------------
	static DefaultTableModel mymdl= new DefaultTableModel();
	Object [] kln= {"Kimlik Numarasý","Adý","Soyadý","Telefon Numarasý","E-Posta"};
	static Object[] str= new Object[5];
	private JTextField txtfld_uyeler_ara;
	static ekle ekleformu;
	static duzenle duzenleformu;
	static sil silformu;
	//-----------------------------------------Kitap Deðiþkenelri---------------------------------
	static DefaultTableModel mymdlktp= new DefaultTableModel();
	Object [] klnktp= {"Kitap ÝD","Kitap Stoðu","Kitap Adý","Basým Yýlý","Sayfa sayýsý","Yayýn Evi ","Yazar","Türü"};
	static Object[] strktp= new Object[8];
	private JTextField txtfld_kitaplar_ara;
	static ekle_ktp ekleformu_ktp;
	static duzenle_ktp duzenleformu_ktp;
	static sil_ktp silformu_ktp;
	private JTextField txtfld_kira_ara;
	public static String kitapid;
	//--------------------------------------------Kira Deðiþkenleri----------------------------
	static DefaultTableModel mymdlkira= new DefaultTableModel();
	Object [] klnkira= {"Kira ÝD","Kitap ÝD ","Kiralayan TC","Kira Baþlangýç","Kira Bitiþ ","Ýade Durumu"};
	static Object[] strkira= new Object[6];
	static ekle_kira ekleformu_kira;
	static duzenle_kira duzenleformu_kira;
	static sil_kira silformu_kira;
	public static String kitap;
	public static String kiraidp;
	//-----------------------------------------Personel Deðiþkenleri--------------------------
	static DefaultTableModel mymdlprsnl= new DefaultTableModel();
	Object [] klnprsnl= {"Personel ÝD","Ad ","Soyad ","Kullanýcý Ad ","Þifre","Maaþ","Baþlangýç Tarihi","Doðum Yýlý","Telefon","Eposta","Bitiþ Tarihi"};
	static Object[] strprsnl= new Object[11];
	static ekle_personel ekleformu_personel;
	static duzenle_personel duzenleformu_personel;
	static sil_personel silformu_personel; 
	//-----------------------------------------Personel Deðiþkenleri--------------------------
	static DefaultTableModel mymdlyzr= new DefaultTableModel();
	Object [] klnyzr= {"Yazar ÝD"," Ad ","Soyad ","Doðum Yýlý ","Ölüm Yýlý"};
	static Object[] stryzr= new Object[5];
	static DefaultTableModel mymdlynev= new DefaultTableModel();
	Object [] klnynev= {"Yayýnevi ÝD","Ad ","Bölge "};
	static Object[] strynev= new Object[3];
	private JTextField txtfld_yzr_ara;
	private JTextField txtfld_ynev_ara;
	static ekle_yazar ekleformu_yazar;
	static duzenle_yazar duzenleformu_yazar;
	static ekle_yayinevi ekleformu_yayinevi;
	static duzenle_ynev duzenleformu_yayinevi;
	public static String yazarid;
	public static String yayineviid;
	/**
	 * Launch the application.
	 */
	
	static void listele() {  //Table 'ýn oluþturulmasý için methot
		mymdl.setRowCount(0);
		ResultSet rs=vt_islem.uyeler_listele_prsnl();
		try {
			while(rs.next()) {
				str[0]=rs.getString("tc");
				str[1]=rs.getString("ad");
				str[2]=rs.getString("soyad");
				str[3]=rs.getString("tel");
				str[4]=rs.getString("eposta");
				mymdl.addRow(str);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		tbl_uyeler.setModel(mymdl);
		vt_islem.kpt();
	}
	static void listele_ktp() {  //Table 'ýn oluþturulmasý için methot(Kitaplar)
		mymdlktp.setRowCount(0);
		
		ResultSet rsk=vt_islem.kitap_listele();
		try {
			while(rsk.next()) {
				strktp[0]=rsk.getString("ktp_id");
				strktp[1]=rsk.getString("ktp_stok");
				strktp[2]=rsk.getString("ktp_ad");
				strktp[3]=rsk.getString("ktp_bsm");
				strktp[4]=rsk.getString("ktp_sayfa");
				strktp[5]=rsk.getString("ynev_ad");
				strktp[6]=rsk.getString("yzr_ad")+" "+rsk.getString("yzr_soyad");
				strktp[7]=rsk.getString("tur_ad");
				mymdlktp.addRow(strktp);
				kitapid=rsk.getString("ktp_id");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		tbl_kitaplar.setModel(mymdlktp);
		vt_islem.kpt();
	}
	static void listele_kira() {  //Table 'ýn oluþturulmasý için methot
		mymdlkira.setRowCount(0);
		
		ResultSet rsi=vt_islem.kira_listele();
		try {
			while(rsi.next()) {
				strkira[0]=rsi.getString("kira_id");
				strkira[1]=rsi.getString("kitap_id");
				strkira[2]=rsi.getString("tc");
				strkira[3]=rsi.getString("baslangic_gn");
				strkira[4]=rsi.getString("bitis_gn");
				strkira[5]=rsi.getString("iade_drm");
				mymdlkira.addRow(strkira);
				kiraidp=rsi.getString("kira_id");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		tbl_kira.setModel(mymdlkira);
		vt_islem.kpt();
	}
	static void listele_kira_edilmedi() {  //Table 'ýn oluþturulmasý için methot
		mymdlkira.setRowCount(0);
		
		ResultSet rsi=vt_islem.kira_listele_edilmedi();
		try {
			while(rsi.next()) {
				strkira[0]=rsi.getString("kira_id");
				strkira[1]=rsi.getString("kitap_id");
				strkira[2]=rsi.getString("tc");
				strkira[3]=rsi.getString("baslangic_gn");
				strkira[4]=rsi.getString("bitis_gn");
				strkira[5]=rsi.getString("iade_drm");
				mymdlkira.addRow(strkira);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		tbl_kira.setModel(mymdlkira);
		vt_islem.kpt();
	}
	static void listele_kira_edildi() {  //Table 'ýn oluþturulmasý için methot
		mymdlkira.setRowCount(0);
		
		ResultSet rsi=vt_islem.kira_listele_edildi();
		try {
			while(rsi.next()) {
				strkira[0]=rsi.getString("kira_id");
				strkira[1]=rsi.getString("kitap_id");
				strkira[2]=rsi.getString("tc");
				strkira[3]=rsi.getString("baslangic_gn");
				strkira[4]=rsi.getString("bitis_gn");
				strkira[5]=rsi.getString("iade_drm");
				mymdlkira.addRow(strkira);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		tbl_kira.setModel(mymdlkira);
		vt_islem.kpt();
	}
	static void listele_yzr() {  //Table 'ýn oluþturulmasý için methot
		mymdlyzr.setRowCount(0);
		ResultSet rsz=vt_islem.yazar_listele();
		try {
			while(rsz.next()) {
				stryzr[0]=rsz.getString("yzr_id");
				stryzr[1]=rsz.getString("yzr_ad");
				stryzr[2]=rsz.getString("yzr_soyad");
				stryzr[3]=rsz.getString("yzr_dgm");
				stryzr[4]=rsz.getString("yzr_olm");
				mymdlyzr.addRow(stryzr);
				yazarid=rsz.getString("yzr_id");

				//yazar ile son id yi al
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		tbl_yazar.setModel(mymdlyzr);
		vt_islem.kpt();
	}
	static void listele_yayinevi() {  //Table 'ýn oluþturulmasý için methot
		mymdlynev.setRowCount(0);
		
		ResultSet rse=vt_islem.yayinevi_listele();
		try {
			while(rse.next()) {
				strynev[0]=rse.getString("ynev_id");
				strynev[1]=rse.getString("ynev_ad");
				strynev[2]=rse.getString("ynev_blge");
				mymdlynev.addRow(strynev);
				yayineviid=rse.getString("ynev_id");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		tbl_yayinevi.setModel(mymdlynev);
		vt_islem.kpt();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personel_form frame = new personel_form();
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
	public personel_form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kütüphane Çalýþan Tablosu");
		setBounds(100, 100, 900, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1,1,1,1));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 11));
		tabbedPane.setBounds(0, 0, 887, 432);
		tabbedPane.setBackground((new Color(0,200,200)));
		tabbedPane.setForeground((new Color(0,0,0)));
		contentPane.add(tabbedPane);
		//------------------------------------------------------Kitap Kiralama Paneli-----------------------//------------------------------------------------------Kitap Kiralama Paneli-----------------------
		//------------------------------------------------------Kitap Kiralama Paneli-----------------------//------------------------------------------------------Kitap Kiralama Paneli-----------------------
		//------------------------------------------------------Kitap Kiralama Paneli-----------------------//------------------------------------------------------Kitap Kiralama Paneli-----------------------
		//------------------------------------------------------Kitap Kiralama Paneli-----------------------//------------------------------------------------------Kitap Kiralama Paneli-----------------------
		//------------------------------------------------------Kitap Kiralama Paneli-----------------------//------------------------------------------------------Kitap Kiralama Paneli-----------------------
		//------------------------------------------------------Kitap Kiralama Paneli-----------------------//------------------------------------------------------Kitap Kiralama Paneli-----------------------
		JPanel pnl_krlm = new JPanel();
		tabbedPane.addTab("Kitap Kiralama", null, pnl_krlm, null);
		pnl_krlm.setLayout(null);
		pnl_krlm.setBackground((new Color(0,200,200)));
		
		JLabel lbl_kira_ara = new JLabel("Ara :");
		lbl_kira_ara.setFont(new Font("Arial", Font.BOLD, 11));
		lbl_kira_ara.setBounds(10, 330, 30, 30);
		pnl_krlm.add(lbl_kira_ara);
		
		JScrollPane scrl_kira = new JScrollPane();
		scrl_kira.setBounds(10, 10, 862, 310);
		pnl_krlm.add(scrl_kira);
		
		tbl_kira = new JTable();
		tbl_kira.setFont(new Font("Arial", Font.BOLD, 11));
		scrl_kira.setViewportView(tbl_kira);
		tbl_kira.setSelectionBackground(new Color(244,119,0));
		tbl_kira.setSelectionForeground(new Color(0,0,0));
		tbl_kira.setBackground(new Color(255,255,255));
		tbl_kira.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mymdlkira.setColumnIdentifiers(klnkira);
		
		listele_kira();
		vt_islem.kpt();
		
		JComboBox cmbox_kira_ara = new JComboBox();
		cmbox_kira_ara.setFont(new Font("Arial", Font.BOLD, 11));
		cmbox_kira_ara.setModel(new DefaultComboBoxModel(new String[] {"Emanet Alan Tc", "Kitap ÝD"}));
		cmbox_kira_ara.setBounds(40, 330, 130, 30);
		cmbox_kira_ara.setToolTipText("Sorgulanacak Veriyi Se\u00E7iniz");
		pnl_krlm.add(cmbox_kira_ara);
		
		cmbox_kira_ara.setBackground((new Color(244,119,0)));
		cmbox_kira_ara.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_kira_drm = new JComboBox();
		cmbox_kira_drm.setFont(new Font("Arial", Font.BOLD, 11));
		cmbox_kira_drm.setModel(new DefaultComboBoxModel(new String[] {"Tümü","Ýade Edilmedi", "Ýade Edildi"}));
		cmbox_kira_drm.setBounds(722, 330, 110, 30);
		pnl_krlm.add(cmbox_kira_drm);
		
		cmbox_kira_drm.setBackground((new Color(244,119,0)));
		cmbox_kira_drm.setForeground((new Color(0,0,0)));
		
		txtfld_kira_ara = new JTextField();
		txtfld_kira_ara.setFont(new Font("Arial", Font.BOLD, 11));
		txtfld_kira_ara.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_kira_ara.setText("Aranýlacak Kimlik Numarasý");
		txtfld_kira_ara.setBounds(180, 330, 190, 30);
		txtfld_kira_ara.setToolTipText("Sorgulanacak Veriyi Yazýnýz");
		txtfld_kira_ara.setColumns(10);
		pnl_krlm.add(txtfld_kira_ara);
		
		//----------------------------------------------------------------------
		cmbox_kira_drm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = cmbox_kira_drm.getSelectedIndex();
				if(a==0) {
					listele_kira();
				}else if(a==1){
					listele_kira_edilmedi();
				}else if(a==2){
					listele_kira_edildi();
				}
					
			}
		});
		
		tbl_kira.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String a =((String) mymdlkira.getValueAt(tbl_kira.getSelectedRow(),5));
				if(a.equals("Edilmedi")) {
				duzenleformu_kira= new duzenle_kira();
				duzenleformu_kira.setVisible(true);
			}}
		});
		//------------------------------------------------------------------------------------------
		txtfld_kira_ara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_kira_ara.setText("");
			}
		});
		
		txtfld_kira_ara.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				mymdlkira.setRowCount(0);
				String sqlara_kira = null;

				String srchk =txtfld_kira_ara.getText();

				ResultSet rsi=null;
				
				if(cmbox_kira_ara.getSelectedIndex()==0) {
					if(cmbox_kira_drm.getSelectedIndex() ==0) {
						sqlara_kira = "select * from tbl_ktp_kira WHERE tc like '%"+Integer.parseInt(srchk)+"%' order by kira_id desc ";
					}else if (cmbox_kira_drm.getSelectedIndex() ==1 ) {
						sqlara_kira = "select * from tbl_ktp_kira WHERE tc like '%"+Integer.parseInt(srchk)+"%'and iade_drm='Edilmedi' order by kira_id desc";
					}else if (cmbox_kira_drm.getSelectedIndex() ==2 ){
						sqlara_kira = "select * from tbl_ktp_kira WHERE tc like '%"+Integer.parseInt(srchk)+"%' and iade_drm='Edildi' order by kira_id desc";
					}
					
				}else if (cmbox_kira_ara.getSelectedIndex()==1){
					if(cmbox_kira_drm.getSelectedIndex() ==0) {
						sqlara_kira = "select * from tbl_ktp_kira WHERE kitap_id like '%"+Integer.parseInt(srchk)+"%' order by kira_id desc ";
					}else if (cmbox_kira_drm.getSelectedIndex() ==1 ) {
						sqlara_kira = "select * from tbl_ktp_kira WHERE kitap_id like '%"+Integer.parseInt(srchk)+"%'and iade_drm='Edilmedi' order by kira_id desc";
					}else if (cmbox_kira_drm.getSelectedIndex() ==2 ){
						sqlara_kira = "select * from tbl_ktp_kira WHERE kitap_id like '%"+Integer.parseInt(srchk)+"%' and iade_drm='Edildi' order by kira_id desc";
					}
				}
				
			
				rsi= vt_islem.ara_uyeler(sqlara_kira);
				
				try {
					while(rsi.next()) {
						strkira[0]=rsi.getString("kira_id");
						strkira[1]=rsi.getString("kitap_id");
						strkira[2]=rsi.getString("tc");
						strkira[3]=rsi.getString("baslangic_gn");
						strkira[4]=rsi.getString("bitis_gn");
						strkira[5]=rsi.getString("iade_drm");
						mymdlkira.addRow(strkira);
					}
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				tbl_kira.setModel(mymdlkira);
				vt_islem.kpt();
			}
			
		
		});
		//----------------------------------------Butonlar---------------------------------------
		Image img= new ImageIcon(this.getClass().getResource("/ref30xb.png")).getImage();//refresh butonu
		Image img2= new ImageIcon(this.getClass().getResource("/add30xy.png")).getImage();//ekle butonu
		Image img3= new ImageIcon(this.getClass().getResource("/del30xb.png")).getImage();//sil butonu
		Image img6= new ImageIcon(this.getClass().getResource("/kira30xg.png")).getImage();//Kira Ver
		Image img7= new ImageIcon(this.getClass().getResource("/kira30xm.png")).getImage();//Kira al
		
		//----------------------------------------Butonlar---------------------------------------
		JLabel btn_kira_yenile = new JLabel("");
		//JButton btn_kira_yenile = new JButton("");
		btn_kira_yenile.setOpaque(true);
		btn_kira_yenile.setBounds(842, 330, 30, 30);
		btn_kira_yenile.setToolTipText("Liste Yenileme Butonu");
		pnl_krlm.add(btn_kira_yenile);
		btn_kira_yenile.setIcon(new ImageIcon(img));
		btn_kira_yenile.setBackground(new Color(244,119,0,255));
		btn_kira_yenile.setBorder(new MatteBorder(1, 1, 1, 1, (Color)new Color(0,0,0))); 
		
		
		JLabel btn_kira_kyd = new JLabel("Kitap Ver");
		btn_kira_kyd.setForeground(Color.GREEN);
		btn_kira_kyd.setHorizontalAlignment(SwingConstants.CENTER);
		//JButton btn_kira_kyd = new JButton("Kaydet");
		btn_kira_kyd.setOpaque(true);
		btn_kira_kyd.setFont(new Font("Arial", Font.BOLD, 11));
		btn_kira_kyd.setBounds(422, 330, 140, 30);
		btn_kira_kyd.setToolTipText("Girilen Verileri Kaydetmek Ýçin Basýnýz");
		pnl_krlm.add(btn_kira_kyd);
		btn_kira_kyd.setBackground(new Color(244,119,0));
		btn_kira_kyd.setIcon(new ImageIcon(img6));	
		btn_kira_kyd.setBorder(new MatteBorder(1, 2, 1, 1, (Color) new Color(0, 0, 0))); 
		
		JLabel btn_kira_sl  = new JLabel("Ýade Al");
		btn_kira_sl.setHorizontalAlignment(SwingConstants.CENTER);
		//JButton btn_kira_sl = new JButton("Kay\u0131t Sil");
		btn_kira_sl.setOpaque(true);
		btn_kira_sl.setFont(new Font("Arial", Font.BOLD, 11));
		btn_kira_sl.setBounds(572, 330, 140, 30);
		btn_kira_sl.setToolTipText("Girilen Verileri Silmek Ýçin Basýnýz");
		pnl_krlm.add(btn_kira_sl);
		btn_kira_sl.setBackground(new Color(244,119,0));
		btn_kira_sl.setForeground(new Color(17,51,165));
		btn_kira_sl.setIcon(new ImageIcon(img7));	
		btn_kira_sl.setBorder(new MatteBorder(1, 2, 1, 1, (Color) new Color(0, 0, 0))); 
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(244,119,0));
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(396, 330, 2, 30);
		pnl_krlm.add(separator_3);
		
		//----------------------------------------------------------------------------------------
		
		btn_kira_yenile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = cmbox_kira_drm.getSelectedIndex();
				if(a==0) {
					listele_kira();
				}else if(a==0){
					listele_kira_edilmedi();
				}else if(a==2){
					listele_kira_edildi();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_kira_yenile.setBackground(new Color(255,145,40));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xg.png")).getImage();
				btn_kira_yenile.setIcon(new ImageIcon(img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_kira_yenile.setBackground(new Color(244,119,0,255));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xb.png")).getImage();
				btn_kira_yenile.setIcon(new ImageIcon(img));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_kira_yenile.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_kira_yenile.setBackground(new Color(244,119,0,255));
			}
		});
		btn_kira_kyd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ekleformu_kira = new ekle_kira();
				ekleformu_kira.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_kira_kyd.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_kira_kyd.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_kira_kyd.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_kira_kyd.setBackground(new Color(244,119,0,255));
			}
			
		});
		
		btn_kira_sl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				silformu_kira = new sil_kira();
				silformu_kira.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_kira_sl.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_kira_sl.setBackground(new Color(244,119,0));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_kira_sl.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_kira_sl.setBackground(new Color(244,119,0));
			}
		});
		
		//------------------------------------------------------Diðer Panel-----------------------//------------------------------------------------------Diðer Panel-----------------------
		//------------------------------------------------------Diðer Panel-----------------------//------------------------------------------------------Diðer Panel-----------------------
		//------------------------------------------------------Diðer Panel-----------------------//------------------------------------------------------Diðer Panel-----------------------
		
		JPanel pnl_uyeler = new JPanel();
		pnl_uyeler.setToolTipText("");
		tabbedPane.addTab("Üye Ýþlemleri", null, pnl_uyeler, null);
		pnl_uyeler.setLayout(null);
		pnl_uyeler.setBackground((new Color(0,200,200)));
		//new Color(255,228,86,150)
		
		JScrollPane scrl_uyeler = new JScrollPane();
		scrl_uyeler.setBounds(10, 10, 862, 310);
		pnl_uyeler.add(scrl_uyeler);
		
		scrl_uyeler.setBackground(new Color(255,255,255));
		scrl_uyeler.setForeground(new Color(0,0,0));
		
		tbl_uyeler = new JTable();
		tbl_uyeler.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_uyeler.setBorder(null);
		tbl_uyeler.setFont(new Font("Arial", Font.BOLD, 11));
		mymdl.setColumnIdentifiers(kln);
		scrl_uyeler.setViewportView(tbl_uyeler);
		
		tbl_uyeler.setSelectionBackground(new Color(244,119,0));
		tbl_uyeler.setSelectionForeground(new Color(0,0,0));
		tbl_uyeler.setBackground(new Color(255,255,255));
		tbl_uyeler.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listele(); // 
		vt_islem.kpt();
		
		JLabel lbl_uyeler_ara = new JLabel("Ara :");
		lbl_uyeler_ara.setFont(new Font("Arial", Font.BOLD, 11));
		lbl_uyeler_ara.setBounds(10, 330, 30, 30);
		pnl_uyeler.add(lbl_uyeler_ara);
	
		//---------------------------------------------------------Text Fields-----------------------------------
		
		
		txtfld_uyeler_ara = new JTextField();
		txtfld_uyeler_ara.setText("Aran\u0131lacak Veriyi Giriniz");
		txtfld_uyeler_ara.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_uyeler_ara.setFont(new Font("Arial", Font.BOLD, 11));
		txtfld_uyeler_ara.setToolTipText("Sorgulanacak Veriyi Yazýnýz");
		txtfld_uyeler_ara.setBounds(225, 330, 170, 30);
		pnl_uyeler.add(txtfld_uyeler_ara);
		txtfld_uyeler_ara.setColumns(10);
		
		txtfld_uyeler_ara.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),1));
		
		
		
		//---------------------------------------------------------Combo Boxs-----------------------------------
		
		JComboBox cmbox_uyeler_ara = new JComboBox();
		cmbox_uyeler_ara.setFont(new Font("Arial", Font.BOLD, 11));
		cmbox_uyeler_ara.setToolTipText("Sorgulanacak Veriyi Se\u00E7iniz");
		cmbox_uyeler_ara.setBounds(45, 330, 170, 30);
		cmbox_uyeler_ara.setModel(new DefaultComboBoxModel(new String[] {"Kimlik Numarasý", "Üye Adý", "Üye Soyadý", "Telefon Numarasý", "E Postasý"}));
		pnl_uyeler.add(cmbox_uyeler_ara);
		cmbox_uyeler_ara.setBackground((new Color(244,119,0)));
		cmbox_uyeler_ara.setForeground((new Color(0,0,0)));
		
		
		
		//-------------------------------------------------Buttons-----------------------------------------------------
		
		JLabel btn_uyeler_yenile = new JLabel("");
		//JButton btn_uyeler_yenile = new JButton("");
		btn_uyeler_yenile.setOpaque(true);
		btn_uyeler_yenile.setBackground(new Color(244,119,0,255));
		btn_uyeler_yenile.setToolTipText("Liste Yenileme Butonu");
		btn_uyeler_yenile.setBounds(842, 330, 30, 30);	
		pnl_uyeler.add(btn_uyeler_yenile);
		btn_uyeler_yenile.setIcon(new ImageIcon(img));	
		btn_uyeler_yenile.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); // kenarlýk ekliyor
		
		//JButton btn_uyeler_kyd = new JButton("Üye Ekle");
		JLabel btn_uyeler_kyd = new JLabel("Üye Ekle");
		btn_uyeler_kyd.setHorizontalAlignment(SwingConstants.CENTER);
		btn_uyeler_kyd.setOpaque(true);
		btn_uyeler_kyd.setBackground(new Color(244,119,0));
		btn_uyeler_kyd.setForeground(Color.GREEN);
		btn_uyeler_kyd.setFont(new Font("Arial", Font.BOLD, 11));
		btn_uyeler_kyd.setToolTipText("Girilen Verileri Kaydetmek Ýçin Basýnýz");
		btn_uyeler_kyd.setBounds(692, 330, 140, 30);	
		pnl_uyeler.add(btn_uyeler_kyd);
		btn_uyeler_kyd.setBackground(new Color(244,119,0));
		btn_uyeler_kyd.setIcon(new ImageIcon(img2));	
		btn_uyeler_kyd.setBorder(new MatteBorder(1, 2, 1, 1, (Color) new Color(0, 0, 0)));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(244,119,0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(436, 330, 8, 30);
		pnl_uyeler.add(separator_2);
		
	

		//----------------------------------------------------------Ýþlemler-------------------------------------------------------------------------
		txtfld_uyeler_ara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_uyeler_ara.setText("");
			}
		});
		

		txtfld_uyeler_ara.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				mymdl.setRowCount(0);
				String sqlara = null;
				
				String srch =txtfld_uyeler_ara.getText();
				

				ResultSet rs = null;
				
				
				int clikc = cmbox_uyeler_ara.getSelectedIndex();
				
				
				
				if(clikc ==0) {
					sqlara = "SELECT * FROM tbl_uye WHERE tc like '%"+Integer.parseInt(srch)+"%'";
				}else if (clikc ==1 ) {
					sqlara = "SELECT * FROM tbl_uye WHERE ad like '%"+srch+"%'";
				}else if (clikc ==2 ){
					sqlara = "SELECT * FROM tbl_uye WHERE soyad like '"+srch+"%'";
				}else if (clikc ==3 ){
					sqlara = "SELECT * FROM tbl_uye WHERE tel like '%"+Integer.parseInt(srch)+"%'";
				}else if (clikc ==4 ){
					sqlara = "SELECT * FROM tbl_uye WHERE eposta like '%"+srch+"%'";
				}
				
				rs= vt_islem.ara_uyeler(sqlara);
				
				try {
					while(rs.next()) {
						str[0]=rs.getString("tc");
						str[1]=rs.getString("ad");
						str[2]=rs.getString("soyad");
						str[6]=rs.getString("tel");
						str[7]=rs.getString("eposta");
						mymdl.addRow(str);
					}
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				tbl_uyeler.setModel(mymdl);
				vt_islem.kpt();
			}
			
		});
		cmbox_uyeler_ara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cmbox_uyeler_ara.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cmbox_uyeler_ara.setBackground(new Color(244,119,0));
			}
		});
		
		
		btn_uyeler_yenile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_uyeler_yenile.setBackground(new Color(255,145,40));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xg.png")).getImage();
				btn_uyeler_yenile.setIcon(new ImageIcon(img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_uyeler_yenile.setBackground(new Color(244,119,0,255));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xb.png")).getImage();
				btn_uyeler_yenile.setIcon(new ImageIcon(img));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_uyeler_yenile.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_uyeler_yenile.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				listele();
				vt_islem.kpt();
			}
		});
		
		
		btn_uyeler_kyd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ekleformu =new ekle();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ekleformu.setVisible(true);

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_uyeler_kyd.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_uyeler_kyd.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_uyeler_kyd.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_uyeler_kyd.setBackground(new Color(244,119,0,255));
			}
		});
		
		
		
		//------------------------------------------------------Kitap Paneli-----------------------	//------------------------------------------------------Kitap Paneli-----------------------
		//------------------------------------------------------Kitap Paneli-----------------------	//------------------------------------------------------Kitap Paneli-----------------------
		//------------------------------------------------------Kitap Paneli-----------------------	//------------------------------------------------------Kitap Paneli-----------------------
		//------------------------------------------------------Kitap Paneli-----------------------	//------------------------------------------------------Kitap Paneli-----------------------
		//------------------------------------------------------Kitap Paneli-----------------------	//------------------------------------------------------Kitap Paneli-----------------------

		JPanel pnl_ktp_kyt = new JPanel();
		tabbedPane.addTab("Kitap Ýþlemleri", null, pnl_ktp_kyt, null);
		pnl_ktp_kyt.setLayout(null);
		pnl_ktp_kyt.setBackground((new Color(0,200,200)));
		
		JScrollPane scrl_kitaplar = new JScrollPane();
		scrl_kitaplar.setBounds(10, 10, 862, 310);
		pnl_ktp_kyt.add(scrl_kitaplar);
		
		tbl_kitaplar = new JTable();
		tbl_kitaplar.setFont(new Font("Arial", Font.BOLD, 11));
		mymdlktp.setColumnIdentifiers(klnktp);
		scrl_kitaplar.setViewportView(tbl_kitaplar);
		
		tbl_kitaplar.setSelectionBackground(new Color(244,119,0));
		tbl_kitaplar.setSelectionForeground(new Color(0,0,0));
		tbl_kitaplar.setBackground(new Color(255,255,255));
		tbl_kitaplar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listele_ktp();
		vt_islem.kpt();

		JLabel lbl_kitaplar_ara = new JLabel("Ara :");
		lbl_kitaplar_ara.setFont(new Font("Arial", Font.BOLD, 11));
		lbl_kitaplar_ara.setBounds(10, 330, 30, 30);
		pnl_ktp_kyt.add(lbl_kitaplar_ara);
		
		JComboBox cmbox_kitaplar_ara = new JComboBox();
		cmbox_kitaplar_ara.setFont(new Font("Arial", Font.BOLD, 11));
		cmbox_kitaplar_ara.setModel(new DefaultComboBoxModel(new String[] {"Kitap ÝD", "Kitap Adý", "Kitap Türü", "Basým Yýlý", "Yayýn Evi", "Yazar"}));
		cmbox_kitaplar_ara.setBounds(45, 330, 170, 30);
		cmbox_kitaplar_ara.setToolTipText("Sorgulanacak Veriyi Seçiniz");
		pnl_ktp_kyt.add(cmbox_kitaplar_ara);
		
		cmbox_kitaplar_ara.setBackground((new Color(244,119,0)));
		cmbox_kitaplar_ara.setForeground((new Color(0,0,0)));
		
		txtfld_kitaplar_ara = new JTextField();	
		txtfld_kitaplar_ara.setFont(new Font("Arial", Font.BOLD, 11));
		txtfld_kitaplar_ara.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_kitaplar_ara.setText("Aranýlacak Veriyi Giriniz");
		txtfld_kitaplar_ara.setBounds(225, 330, 170, 30);
		txtfld_kitaplar_ara.setToolTipText("Sorgulanacak Veriyi Yazýnýz");
		txtfld_kitaplar_ara.setColumns(10);
		pnl_ktp_kyt.add(txtfld_kitaplar_ara);
		
		//-------------------------------------------------------------------------------------------
		JLabel btn_kitaplar_yenile = new JLabel("");
		//JButton btn_kitaplar_yenile = new JButton("");
		btn_kitaplar_yenile.setBounds(842, 330, 30, 30);
		btn_kitaplar_yenile.setOpaque(true);
		btn_kitaplar_yenile.setToolTipText("Liste Yenileme Butonu");
		pnl_ktp_kyt.add(btn_kitaplar_yenile);
		btn_kitaplar_yenile.setIcon(new ImageIcon(img));
		btn_kitaplar_yenile.setBackground(new Color(244,119,0,255));
		btn_kitaplar_yenile.setBorder(new MatteBorder(1, 1, 1, 1, (Color)new Color(0,0,0))); // kenarlýk ekliyor
		
		Image img4= new ImageIcon(this.getClass().getResource("/book30xg.png")).getImage();
		Image img5= new ImageIcon(this.getClass().getResource("/book30xm.png")).getImage();
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBackground(Color.WHITE);
		separator_2_1.setForeground(new Color(244,119,0));
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(419, 330, 2, 30);
		pnl_ktp_kyt.add(separator_2_1);
		//-------------------------------------------------------------------------
		
		txtfld_kitaplar_ara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_kitaplar_ara.setText("");
			}
		});
		
		
		txtfld_kitaplar_ara.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				mymdlktp.setRowCount(0);
				String sqlara_ktp = null;
				
				String srch =txtfld_kitaplar_ara.getText();
				

				ResultSet rs = null;
				
				
				int clikc1 = cmbox_kitaplar_ara.getSelectedIndex();
				

				if(clikc1 ==0) {
					
					sqlara_ktp = "select ktp.ktp_id, ktp.ktp_stok,ktp.ktp_ad,ktp.ktp_bsm,ktp.ktp_sayfa,ynev.ynev_ad,yzr.yzr_ad,yzr.yzr_soyad,tur.tur_ad from tbl_ktp as ktp inner join tbl_ynev as ynev on ktp.ynev_id=ynev.ynev_id inner join  tbl_yzr_ktp as yzrktp on yzrktp.yzr_id=yzr.yzr_id inner join tbl_yzr as yzr on yzrktp.ktp_id= ktp.ktp_id inner join tbl_ktp_tur as turktp on turktp.tur_id=tur.tur_id inner join tbl_tur as tur on turktp.ktp_id=ktp.ktp_id WHERE ktp.ktp_id like '%"+Integer.parseInt(srch)+"%'";
				
				}else if (clikc1 ==1 ) {
					sqlara_ktp = "select ktp.ktp_id,ktp.ktp_stok, ktp.ktp_ad,ktp.ktp_bsm,ktp.ktp_sayfa,ynev.ynev_ad,yzr.yzr_ad,yzr.yzr_soyad,tur.tur_ad from tbl_ktp as ktp inner join tbl_ynev as ynev on ktp.ynev_id=ynev.ynev_id inner join  tbl_yzr_ktp as yzrktp on yzrktp.yzr_id=yzr.yzr_id inner join tbl_yzr as yzr on yzrktp.ktp_id= ktp.ktp_id inner join tbl_ktp_tur as turktp on turktp.tur_id=tur.tur_id inner join tbl_tur as tur on turktp.ktp_id=ktp.ktp_id WHERE ktp.ktp_ad like '%"+srch+"%'";
					
				}else if (clikc1 ==2 ){
					sqlara_ktp = "select ktp.ktp_id,ktp.ktp_stok, ktp.ktp_ad,ktp.ktp_bsm,ktp.ktp_sayfa,ynev.ynev_ad,yzr.yzr_ad,yzr.yzr_soyad,tur.tur_ad from tbl_ktp as ktp inner join tbl_ynev as ynev on ktp.ynev_id=ynev.ynev_id inner join  tbl_yzr_ktp as yzrktp on yzrktp.yzr_id=yzr.yzr_id inner join tbl_yzr as yzr on yzrktp.ktp_id= ktp.ktp_id inner join tbl_ktp_tur as turktp on turktp.tur_id=tur.tur_id inner join tbl_tur as tur on turktp.ktp_id=ktp.ktp_id WHERE tur.tur_ad like '"+srch+"%'";
					
				}else if (clikc1 ==3 ){
					sqlara_ktp = "select ktp.ktp_id,ktp.ktp_stok, ktp.ktp_ad,ktp.ktp_bsm,ktp.ktp_sayfa,ynev.ynev_ad,yzr.yzr_ad,yzr.yzr_soyad,tur.tur_ad from tbl_ktp as ktp inner join tbl_ynev as ynev on ktp.ynev_id=ynev.ynev_id inner join  tbl_yzr_ktp as yzrktp on yzrktp.yzr_id=yzr.yzr_id inner join tbl_yzr as yzr on yzrktp.ktp_id= ktp.ktp_id inner join tbl_ktp_tur as turktp on turktp.tur_id=tur.tur_id inner join tbl_tur as tur on turktp.ktp_id=ktp.ktp_id WHERE ktp.ktp_bsm  like  '%"+srch+"%'";
					
				}else if (clikc1 ==4 ){
					sqlara_ktp = "select ktp.ktp_id,ktp.ktp_stok, ktp.ktp_ad,ktp.ktp_bsm,ktp.ktp_sayfa,ynev.ynev_ad,yzr.yzr_ad,yzr.yzr_soyad,tur.tur_ad from tbl_ktp as ktp inner join tbl_ynev as ynev on ktp.ynev_id=ynev.ynev_id inner join  tbl_yzr_ktp as yzrktp on yzrktp.yzr_id=yzr.yzr_id inner join tbl_yzr as yzr on yzrktp.ktp_id= ktp.ktp_id inner join tbl_ktp_tur as turktp on turktp.tur_id=tur.tur_id inner join tbl_tur as tur on turktp.ktp_id=ktp.ktp_id WHERE ynev.ynev_ad like  '%"+srch+"%'";
				
				}else if (clikc1 ==5 ){
					sqlara_ktp = "select ktp.ktp_id,ktp.ktp_stok, ktp.ktp_ad,ktp.ktp_bsm,ktp.ktp_sayfa,ynev.ynev_ad,yzr.yzr_ad,yzr.yzr_soyad,tur.tur_ad from tbl_ktp as ktp inner join tbl_ynev as ynev on ktp.ynev_id=ynev.ynev_id inner join  tbl_yzr_ktp as yzrktp on yzrktp.yzr_id=yzr.yzr_id inner join tbl_yzr as yzr on yzrktp.ktp_id= ktp.ktp_id inner join tbl_ktp_tur as turktp on turktp.tur_id=tur.tur_id inner join tbl_tur as tur on turktp.ktp_id=ktp.ktp_id WHERE yzr.yzr_ad  like  '%"+srch+"%'";
					
				}
				
				rs= vt_islem.ara_ktp(sqlara_ktp);
				
				try {
					while(rs.next()) {
						strktp[0]=rs.getString("ktp_id");
						strktp[1]=rs.getString("ktp_stok");
						strktp[2]=rs.getString("ktp_ad");
						strktp[3]=rs.getString("ktp_bsm");
						strktp[4]=rs.getString("ktp_sayfa");
						strktp[5]=rs.getString("ynev_ad");
						strktp[6]=rs.getString("yzr_ad")+" "+rs.getString("yzr_soyad");
						strktp[7]=rs.getString("tur_ad");
						mymdlktp.addRow(strktp);
					}
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				tbl_kitaplar.setModel(mymdlktp);
				vt_islem.kpt();
			}
			
		});
	//---------------------------------------Buton Ýþlemleri---------------------------------

		btn_kitaplar_yenile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listele_ktp();
				vt_islem.kpt();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_kitaplar_yenile.setBackground(new Color(255,145,40));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xg.png")).getImage();
				btn_kitaplar_yenile.setIcon(new ImageIcon(img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_kitaplar_yenile.setBackground(new Color(244,119,0,255));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xb.png")).getImage();
				btn_kitaplar_yenile.setIcon(new ImageIcon(img));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_kitaplar_yenile.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_kitaplar_yenile.setBackground(new Color(244,119,0,255));
			}
		});
		
		

		
		//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------
		//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------
		//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------
		//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------
		//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------
		//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------//---------------------------------------------------------------------Diðer Ýþlemelr Paneli-----------------------------------
		JPanel pnl_diger = new JPanel();
		tabbedPane.addTab("Diðer Ýþlemler", null, pnl_diger, null);
		pnl_diger.setLayout(null);
		pnl_diger.setBackground((new Color(0,200,200)));
		
		JScrollPane scrl_diger = new JScrollPane();
		scrl_diger.setBounds(10, 34, 390, 280);
		pnl_diger.add(scrl_diger);
		tbl_yazar = new JTable();
		tbl_yazar.setFont(new Font("Arial", Font.BOLD, 11));
		scrl_diger.setViewportView(tbl_yazar);
		tbl_yazar.setSelectionBackground(new Color(244,119,0));
		tbl_yazar.setSelectionForeground(new Color(0,0,0));
		tbl_yazar.setBackground(new Color(255,255,255));
		tbl_yazar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrl_ynev = new JScrollPane();
		scrl_ynev.setBounds(482, 34, 390, 280);
		pnl_diger.add(scrl_ynev);
		tbl_yayinevi = new JTable();
		tbl_yayinevi .setFont(new Font("Arial", Font.BOLD, 11));
		scrl_ynev.setViewportView(tbl_yayinevi);
		tbl_yayinevi.setSelectionBackground(new Color(244,119,0));
		tbl_yayinevi.setSelectionForeground(new Color(0,0,0));
		tbl_yayinevi.setBackground(new Color(255,255,255));
		tbl_yayinevi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		mymdlyzr.setColumnIdentifiers(klnyzr);
		mymdlynev.setColumnIdentifiers(klnynev);
		
		listele_yzr();
		vt_islem.kpt();
		listele_yayinevi();
		vt_islem.kpt();
		
		//------------------------------------------------------
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(244,119,0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(442, 0, 2, 382);
		pnl_diger.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(244,119,0));
		separator_1.setBounds(10, 28, 390,2);
		pnl_diger.add(separator_1);
		
		//---------------------------------------------------------
		txtfld_yzr_ara = new JTextField();
		txtfld_yzr_ara.setBounds(160, 330, 200, 30);
		pnl_diger.add(txtfld_yzr_ara);
		txtfld_yzr_ara.setColumns(10);
		
		txtfld_ynev_ara = new JTextField();
		txtfld_ynev_ara.setColumns(10);
		txtfld_ynev_ara.setBounds(522, 330, 200, 30);
		pnl_diger.add(txtfld_ynev_ara);
		//-----------------------------------------------------------
		JLabel lblNewLabel = new JLabel("Ara");
		lblNewLabel.setBounds(10, 330, 30, 30);
		pnl_diger.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ara");
		lblNewLabel_1.setBounds(842, 330, 30, 30);
		pnl_diger.add(lblNewLabel_1);
		//-----------------------------------------------------------
		JComboBox cmbox_yzr_ara = new JComboBox();
		cmbox_yzr_ara.setModel(new DefaultComboBoxModel(new String[] {"Ad", "Soyada", "ÝD", "Doðumum"}));
		cmbox_yzr_ara.setBounds(45, 330, 106, 30);
		pnl_diger.add(cmbox_yzr_ara);
		
		cmbox_yzr_ara.setBackground((new Color(244,119,0)));
		cmbox_yzr_ara.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_ynev_ara = new JComboBox();
		cmbox_ynev_ara.setModel(new DefaultComboBoxModel(new String[] {"Ad", "Bölge", "ÝD"}));
		cmbox_ynev_ara.setBounds(732, 330, 105, 30);
		pnl_diger.add(cmbox_ynev_ara);
		
		cmbox_ynev_ara.setBackground((new Color(244,119,0)));
		cmbox_ynev_ara.setForeground((new Color(0,0,0)));
		
		
		//-------------------------------------------------------------
		//JButton btn_yzr_ynl = new JButton("");
		JLabel btn_yzr_ynl = new JLabel("");
		btn_yzr_ynl.setOpaque(true);
		btn_yzr_ynl.setBounds(370, 330, 30, 30);
		pnl_diger.add(btn_yzr_ynl);
		btn_yzr_ynl.setIcon(new ImageIcon(img));
		btn_yzr_ynl.setBackground(new Color(244,119,0,255));
		btn_yzr_ynl.setBorder(new MatteBorder(1, 1, 1, 1, (Color)new Color(0,0,0)));
		
		//JButton btn_ynev_ynl = new JButton("");
		JLabel btn_ynev_ynl = new JLabel("");
		btn_ynev_ynl.setOpaque(true);
		btn_ynev_ynl.setBounds(482, 330, 30, 30);
		pnl_diger.add(btn_ynev_ynl);
		btn_ynev_ynl.setIcon(new ImageIcon(img));
		btn_ynev_ynl.setBackground(new Color(244,119,0,255));
		btn_ynev_ynl.setBorder(new MatteBorder(1, 1, 1, 1, (Color)new Color(0,0,0)));
		
		JLabel lblNewLabel_2 = new JLabel("Yazarlar");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(178, 0, 51, 30);
		pnl_diger.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Yayýnevleri");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(628, 0, 95, 30);
		pnl_diger.add(lblNewLabel_2_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(244,119,0));
		separator_1_1.setBounds(482, 28, 390, 2);
		pnl_diger.add(separator_1_1);
		
	
	
		//--------------------------------------------------------------
		txtfld_yzr_ara.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				mymdlyzr.setRowCount(0);
				String sqlara = null;
				
				String srch =txtfld_yzr_ara.getText();
				ResultSet rsz = null;
				
				
				int clikc = cmbox_yzr_ara.getSelectedIndex();
				

				if(clikc ==0) {
					sqlara = "SELECT * FROM tbl_yzr WHERE yzr_ad like '%"+srch+"%'";
				}else if (clikc ==1 ) {
					sqlara = "SELECT * FROM tbl_yzr WHERE yzr_soyad like '%"+srch+"%'";
				}else if (clikc ==2 ){
					sqlara = "SELECT * FROM tbl_yzr WHERE yzr_id like '"+srch+"%'";
				}else if (clikc ==3 ){
					sqlara = "SELECT * FROM tbl_yzr WHERE yzr_dgm  like  '%"+srch+"%'";
				}
				rsz= vt_islem.ara_uyeler(sqlara);
				try {
					while(rsz.next()) {
						stryzr[0]=rsz.getString("yzr_id");
						stryzr[1]=rsz.getString("yzr_ad");
						stryzr[2]=rsz.getString("yzr_soyad");
						stryzr[3]=rsz.getString("yzr_dgm");
						stryzr[4]=rsz.getString("yzr_olm");
						mymdlyzr.addRow(stryzr);
					}
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				tbl_yazar.setModel(mymdlyzr);
				vt_islem.kpt();
			}
			
			
		});
		
		txtfld_ynev_ara.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				mymdlynev.setRowCount(0);
				String sqlara = null;
				
				String srche =txtfld_ynev_ara.getText();
				ResultSet rse = null;
				
				
				int clikce = cmbox_ynev_ara.getSelectedIndex();
				

				if(clikce ==0) {
					sqlara = "SELECT * FROM tbl_ynev WHERE ynev_ad like '%"+srche+"%'";
				}else if (clikce ==1 ) {
					sqlara = "SELECT * FROM tbl_ynev WHERE ynev_blge like '%"+srche+"%'";
				}else if (clikce ==2 ){
					sqlara = "SELECT * FROM tbl_ynev WHERE ynev_id like '"+srche+"%'";
				}
				rse= vt_islem.ara_uyeler(sqlara);
				try {
					while(rse.next()) {
						strynev[0]=rse.getString("ynev_id");
						strynev[1]=rse.getString("ynev_ad");
						strynev[2]=rse.getString("ynev_blge");			
						mymdlynev.addRow(strynev);
					}
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				tbl_yayinevi.setModel(mymdlynev);
				vt_islem.kpt();
			}
			
			
			
		});
		
		//-------------------------------------------------------
		btn_yzr_ynl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listele_yzr();
				vt_islem.kpt();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_yzr_ynl.setBackground(new Color(255,145,40));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xg.png")).getImage();
				btn_yzr_ynl.setIcon(new ImageIcon(img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_yzr_ynl.setBackground(new Color(244,119,0,255));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xb.png")).getImage();
				btn_yzr_ynl.setIcon(new ImageIcon(img));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_yzr_ynl.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_yzr_ynl.setBackground(new Color(244,119,0,255));
			}
		});
		btn_ynev_ynl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listele_yayinevi();
				vt_islem.kpt();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_ynev_ynl.setBackground(new Color(255,145,40));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xg.png")).getImage();
				btn_ynev_ynl.setIcon(new ImageIcon(img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_ynev_ynl.setBackground(new Color(244,119,0,255));
				Image img= new ImageIcon(this.getClass().getResource("/ref30xb.png")).getImage();
				btn_ynev_ynl.setIcon(new ImageIcon(img));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_ynev_ynl.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_ynev_ynl.setBackground(new Color(244,119,0,255));
			}
		});
		
	}

}
