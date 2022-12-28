package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class duzenle_ktp extends JFrame {

	private JPanel contentPane;
	private JTextField txtfld_duzenle_ktpid;
	private JTextField txtfld_duzenle_ktpad;
	private JTextField txtfld_duzenle_ktpsyfa;
	private JTextField txtfld_duzenle_ktpyl;

	public static int yazar,tur,yayinevi;
	public static String kitapid,kitapstok,sayfasayisi,basimyili,ktpad, sqlupd,sqllnk2,sqllnk3;
	public static String kitapid1,sayfasayisi1,basimyili1,ktpad1;
	String yazar1,tur1,yayinevi1;
	private JTextField txtfld_duzenle_stok;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					duzenle_ktp frame = new duzenle_ktp();
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
	public duzenle_ktp() {
		setBounds(100, 100, 295, 450);
		setTitle("Kitap Düzenle");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		JLabel lblKitapAdc = new JLabel("Kitap Adý :");
		lblKitapAdc.setBounds(10, 49, 87, 30);
		contentPane.add(lblKitapAdc); 
		JLabel lblNewLabel_1 = new JLabel("Sayfa Sayýsý :");
		lblNewLabel_1.setBounds(10, 94, 87, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Yayýn Evi : ");
		lblNewLabel_4.setBounds(10, 255, 87, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Türü  :");
		lblNewLabel_5.setBounds(10, 295, 87, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Kayýt ID :");
		lblNewLabel_5_1.setBounds(10, 10, 87, 30);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6 = new JLabel("Basým Yýlý :");
		lblNewLabel_6.setBounds(10, 134, 87, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("Yazar :");
		lblNewLabel_3.setBounds(10, 215, 87, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("Stok Sayýsý :");
		lblNewLabel_7.setBounds(10, 174, 87, 30);
		contentPane.add(lblNewLabel_7);
		
		txtfld_duzenle_ktpid = new JTextField();
		txtfld_duzenle_ktpid.setText("11");
		txtfld_duzenle_ktpid.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_duzenle_ktpid.setEditable(false);
		txtfld_duzenle_ktpid.setColumns(10);
		txtfld_duzenle_ktpid.setBounds(99, 10, 177, 30);
		contentPane.add(txtfld_duzenle_ktpid);
		
		txtfld_duzenle_ktpad = new JTextField();
		txtfld_duzenle_ktpad.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_duzenle_ktpad.setEditable(false);
		txtfld_duzenle_ktpad.setColumns(10);
		txtfld_duzenle_ktpad.setBounds(99, 49, 177, 30);
		contentPane.add(txtfld_duzenle_ktpad);
		
		txtfld_duzenle_ktpsyfa = new JTextField();
		txtfld_duzenle_ktpsyfa.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_duzenle_ktpsyfa.setEditable(false);
		txtfld_duzenle_ktpsyfa.setColumns(10);
		txtfld_duzenle_ktpsyfa.setBounds(99, 94, 177, 30);
		contentPane.add(txtfld_duzenle_ktpsyfa);
		
		txtfld_duzenle_ktpyl = new JTextField();
		txtfld_duzenle_ktpyl.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_duzenle_ktpyl.setEditable(false);
		txtfld_duzenle_ktpyl.setColumns(10);
		txtfld_duzenle_ktpyl.setBounds(99, 135, 177, 30);
		contentPane.add(txtfld_duzenle_ktpyl);
		
		txtfld_duzenle_stok = new JTextField();
		txtfld_duzenle_stok.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_duzenle_stok.setEditable(false);
		txtfld_duzenle_stok.setText((String) null);
		txtfld_duzenle_stok.setColumns(10);
		txtfld_duzenle_stok.setBounds(99, 175, 177, 30);
		contentPane.add(txtfld_duzenle_stok);
		
		
		JComboBox cmbox_ktp_yzr = new JComboBox();
		cmbox_ktp_yzr.setBounds(99, 215, 177, 30);
		contentPane.add(cmbox_ktp_yzr);
		cmbox_ktp_yzr.setBackground((new Color(244,119,0)));
		cmbox_ktp_yzr.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_ktp_ynev = new JComboBox();
		cmbox_ktp_ynev.setBounds(99, 255, 177, 30);
		contentPane.add(cmbox_ktp_ynev);
		cmbox_ktp_ynev.setBackground((new Color(244,119,0)));
		cmbox_ktp_ynev.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_ktp_tur = new JComboBox();
		cmbox_ktp_tur.setBounds(99, 295, 177, 30);
		contentPane.add(cmbox_ktp_tur);
		cmbox_ktp_tur.setBackground((new Color(244,119,0)));
		cmbox_ktp_tur.setForeground((new Color(0,0,0)));
		
		Image img= new ImageIcon(this.getClass().getResource("/save55xg.png")).getImage();
		JLabel btn_ktp_duzenle=new JLabel("Düzenle");
		btn_ktp_duzenle.setFont(new Font("Arial", Font.BOLD, 20));
		btn_ktp_duzenle.setHorizontalAlignment(SwingConstants.CENTER);
		//JButton btn_ktp_duzenle = new JButton("Düzenle");
		btn_ktp_duzenle.setBounds(10, 335, 266, 60);
		contentPane.add(btn_ktp_duzenle);
		btn_ktp_duzenle.setOpaque(true);
		btn_ktp_duzenle.setBackground(new Color(244,119,0,255));
		btn_ktp_duzenle.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); 
		btn_ktp_duzenle.setIcon(new ImageIcon(img));
		//-------------------------------------------------------------KOMBO BOXLAR----------------------
		try {
			ResultSet rs=vt_islem.combobox_yazar();
			while (rs.next()) {
				String yr = rs.getString("yzr_ad")+" "+rs.getString("yzr_soyad");
				cmbox_ktp_yzr.addItem(yr);	
			}
		} catch (Exception e) {
		}vt_islem.kpt();
		try {
			ResultSet rs=vt_islem.combobox_yayinevi();
			while (rs.next()) {
				String yn = rs.getString("ynev_ad");
				cmbox_ktp_ynev.addItem(yn);	
			}
		} catch (Exception e) {
		}vt_islem.kpt();
		try {
			ResultSet rs=vt_islem.combobox_tur();
			while (rs.next()) {
				String tr = rs.getString("tur_ad");
				cmbox_ktp_tur.addItem(tr);	
			}vt_islem.kpt();
		} catch (Exception e) {
		}vt_islem.kpt();
		//--------------------------------------------------------ANA TABLODAN VERÝ ALMA-------------
		txtfld_duzenle_ktpid.setText((String) admin_form. mymdlktp.getValueAt(admin_form.tbl_kitaplar.getSelectedRow(),0));
		txtfld_duzenle_stok.setText((String) admin_form.mymdlktp.getValueAt(admin_form.tbl_kitaplar.getSelectedRow(),1));
		txtfld_duzenle_ktpad.setText((String) admin_form.mymdlktp.getValueAt(admin_form.tbl_kitaplar.getSelectedRow(),2));
		txtfld_duzenle_ktpyl.setText((String)admin_form.mymdlktp.getValueAt(admin_form.tbl_kitaplar.getSelectedRow(),3));
		txtfld_duzenle_ktpsyfa.setText((String) admin_form.mymdlktp.getValueAt(admin_form.tbl_kitaplar.getSelectedRow(),4));
		
		kitapid1=(String) admin_form. mymdlktp.getValueAt(admin_form.tbl_kitaplar.getSelectedRow(),0);
		
		cmbox_ktp_tur.setSelectedItem((String) admin_form.mymdlktp.getValueAt(admin_form.tbl_kitaplar.getSelectedRow(),7));
		cmbox_ktp_ynev.setSelectedItem((String) admin_form.mymdlktp.getValueAt(admin_form.tbl_kitaplar.getSelectedRow(),5));
		cmbox_ktp_yzr.setSelectedItem((String) admin_form.mymdlktp.getValueAt(admin_form.tbl_kitaplar.getSelectedRow(),6));
		
		//-------------------------------------------------------TEXTFÝELDLARI AÇMA------------------------
		txtfld_duzenle_ktpad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_duzenle_ktpad.setEditable(true);
			}
		});
		txtfld_duzenle_stok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_duzenle_stok.setEditable(true);
			}
		});
		txtfld_duzenle_ktpyl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_duzenle_ktpyl.setEditable(true);
			}
		});
		txtfld_duzenle_ktpsyfa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_duzenle_ktpsyfa.setEditable(true);
			}
		});
		
		
		//------------------------------------------------------------KAYIT----------
		
		btn_ktp_duzenle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				kitapid=txtfld_duzenle_ktpid.getText() ;
				kitapstok=txtfld_duzenle_stok.getText();
				ktpad=txtfld_duzenle_ktpad.getText();
				sayfasayisi=txtfld_duzenle_ktpsyfa.getText();
				basimyili=txtfld_duzenle_ktpyl.getText();
				yayinevi=cmbox_ktp_ynev.getSelectedIndex()+1;
				
				tur=cmbox_ktp_tur.getSelectedIndex()+1;
				yazar=cmbox_ktp_yzr.getSelectedIndex()+1;
				
				try {
					ResultSet rs=vt_islem.turalma();
					while (rs.next()) {
						String yzr = rs.getString("tur_id");
						tur1=yzr;
					}
				} catch (Exception e1) {
				}vt_islem.kpt();
				System.out.println(tur1);
				try {
					ResultSet rs=vt_islem.yazaralma();
					while (rs.next()) {
						String ay = rs.getString("yzr_id");
						yazar1=ay;
					}
				} catch (Exception e1) {
				}vt_islem.kpt();

			
				
				Timer t = new Timer();
				TimerTask ts = new TimerTask() {
					public  void run() {
						sqlupd=	"UPDATE tbl_ktp SET ktp_id ="+kitapid+","+
								"ynev_id='"+yayinevi+"',ktp_ad ='"+ktpad+"',ktp_bsm = '"+basimyili+"',ktp_sayfa='"+sayfasayisi+"',ktp_stok='"+kitapstok+"'WHERE ktp_id="+kitapid;

						vt_islem.guncelle(sqlupd);
						vt_islem.kpt();
					}
				};
				TimerTask tss = new TimerTask() {
					public  void run() {
						sqlupd="UPDATE tbl_ktp_tur SET tur_id ="+tur+","+"ktp_id="+kitapid+" WHERE tur_id ="+tur1+" AND ktp_id="+kitapid1;
						vt_islem.guncelle(sqlupd);
						vt_islem.kpt();
					}
				};
				TimerTask tsss = new TimerTask() {
					public  void run() {
						sqlupd="UPDATE tbl_yzr_ktp SET yzr_id="+yazar+","+"ktp_id="+kitapid+" WHERE yzr_id ="+yazar1+" AND ktp_id="+kitapid1;

						vt_islem.guncelle(sqlupd);
						vt_islem.kpt();
						
						
					}
				};
				TimerTask tc = new TimerTask() {
					public void run() {
						t.cancel();
						}
				};

				t.schedule(ts, 0,500);
				t.schedule(tss,50,500);
				t.schedule(tsss,100,500);
				t.schedule(tc, 300,500);

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_ktp_duzenle.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_ktp_duzenle.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_ktp_duzenle.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_ktp_duzenle.setBackground(new Color(244,119,0,255));
			}
		});
		
		
		
	}
}
