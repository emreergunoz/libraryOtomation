package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ekle_ktp extends JFrame {

	private JPanel contentPane;
	private JTextField txtfld_ktp_ad;
	private JTextField txtfld_ktp_syf;
	private JTextField txtfld_ktp_yl;
	private JTextField txtfld_ktp_id;
	public static int yazar,tur,yayinevi,sayac=0;
	public static String kitapid,kitapstok,sayfasayisi,basimyili,ktpad, sqllnk,sqllnk2,sqllnk3;
	private JTextField txtfld_ktp_stok;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ekle_ktp frame = new ekle_ktp();
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
	public ekle_ktp() {
		setBounds(100, 100, 295, 445);
		setTitle("Kitap Ekle");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		JLabel lblNewLabel_5 = new JLabel("Türü :");
		lblNewLabel_5.setBounds(10, 295, 87, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Kayýt ID :");
		lblNewLabel_5_1.setBounds(10, 10, 87, 30);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_3 = new JLabel("Yazar :");
		lblNewLabel_3.setBounds(10, 215, 87, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblKitapAdc = new JLabel("Kitap Adý :");
		lblKitapAdc.setBounds(10, 49, 87, 30);
		contentPane.add(lblKitapAdc);
		
		JLabel lblNewLabel_1 = new JLabel("Sayfa Sayýsý :");
		lblNewLabel_1.setBounds(10, 94, 87, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("Basým Yýlý :");
		lblNewLabel_6.setBounds(10, 134, 87, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Yayýn Evi : ");
		lblNewLabel_4.setBounds(10, 255, 87, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Stok Sayýsý :");
		lblNewLabel_7.setBounds(10, 174, 87, 30);
		contentPane.add(lblNewLabel_7);
		//--------------------------------------------------------------------------------
		txtfld_ktp_ad = new JTextField();
		txtfld_ktp_ad.setColumns(10);
		txtfld_ktp_ad.setBounds(99, 49, 177, 30);
		contentPane.add(txtfld_ktp_ad);
		
		txtfld_ktp_syf = new JTextField();
		txtfld_ktp_syf.setColumns(10);
		txtfld_ktp_syf.setBounds(99, 94, 177, 30);
		contentPane.add(txtfld_ktp_syf);
		
		txtfld_ktp_yl = new JTextField();
		txtfld_ktp_yl.setColumns(10);
		txtfld_ktp_yl.setBounds(99, 135, 177, 30);
		contentPane.add(txtfld_ktp_yl);
		
		txtfld_ktp_id = new JTextField();
		txtfld_ktp_id.setEditable(false);
		txtfld_ktp_id.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_ktp_id.setColumns(10);
		txtfld_ktp_id.setBounds(99, 10, 177, 30);
		contentPane.add(txtfld_ktp_id);
		
		txtfld_ktp_stok = new JTextField();
		txtfld_ktp_stok.setText((String) null);
		txtfld_ktp_stok.setColumns(10);
		txtfld_ktp_stok.setBounds(99, 175, 177, 30);
		contentPane.add(txtfld_ktp_stok);
		
		
		//--------------------------------------------------------------------------------
		JComboBox cmbox_ktp_ynev = new JComboBox();
		cmbox_ktp_ynev.setBounds(99, 255, 177, 30);
		contentPane.add(cmbox_ktp_ynev);
		cmbox_ktp_ynev.setBackground((new Color(244,119,0)));
		cmbox_ktp_ynev.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_ktp_yzr = new JComboBox();
		cmbox_ktp_yzr.setBounds(99, 215, 177, 30);
		contentPane.add(cmbox_ktp_yzr);
		cmbox_ktp_yzr.setBackground((new Color(244,119,0)));
		cmbox_ktp_yzr.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_ktp_tur = new JComboBox();
		cmbox_ktp_tur.setBounds(99, 295, 177, 30);
		contentPane.add(cmbox_ktp_tur);
		cmbox_ktp_tur.setBackground((new Color(244,119,0)));
		cmbox_ktp_tur.setForeground((new Color(0,0,0)));
		//---------------------------------------Textfield Ýd Yazdýrma-----------------------------------------
		
		txtfld_ktp_id.setText(Integer.toString(Integer.parseInt(admin_form.kitapid)+1));
		
		
		//----------------------------------------------------------------------
		Image img= new ImageIcon(this.getClass().getResource("/add55xg.png")).getImage();
		JLabel btn_ktp_ekle = new JLabel("Kitap Ekle");
		btn_ktp_ekle.setHorizontalAlignment(SwingConstants.CENTER);
		btn_ktp_ekle.setFont(new Font("Arial", Font.BOLD, 20));
		//JButton btn_ktp_ekle = new JButton("Ekle");
		btn_ktp_ekle.setBounds(10, 335, 266, 60);
		contentPane.add(btn_ktp_ekle);
		btn_ktp_ekle.setOpaque(true);
		btn_ktp_ekle.setBackground(new Color(244,119,0,255));
		btn_ktp_ekle.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_ktp_ekle.setIcon(new ImageIcon(img));
		//-----------------------------------------------------------------------------------
		
		txtfld_ktp_id.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_ktp_id.setEditable(true);
			}
		});
		
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
		
		
		btn_ktp_ekle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
				kitapid=txtfld_ktp_id.getText() ;
				kitapstok=txtfld_ktp_stok.getText();
				ktpad=txtfld_ktp_ad.getText();
				sayfasayisi=txtfld_ktp_syf.getText();
				basimyili=txtfld_ktp_yl.getText();
				yayinevi=cmbox_ktp_ynev.getSelectedIndex()+1;
				
				tur=cmbox_ktp_tur.getSelectedIndex()+1;
				yazar=cmbox_ktp_yzr.getSelectedIndex()+1;
				
				// stok ekle **
				Timer t = new Timer();
				TimerTask ts = new TimerTask() {
					public  void run() {
						sqllnk = "INSERT INTO tbl_ktp (ktp_id,ynev_id,ktp_ad,ktp_bsm,ktp_sayfa,ktp_stok) VALUES ('"
								+kitapid+"',"+"'"+yayinevi+"',"+"'"+ktpad+"',"+"'"+basimyili+"',"+"'"+sayfasayisi+"',"+"'"+kitapstok+"')";
						vt_islem.add_ktp(sqllnk);
						
					}
				};
				TimerTask tss = new TimerTask() {
					public  void run() {
						sqllnk="INSERT INTO tbl_ktp_tur (tur_id,ktp_id) VALUES ('"
								+tur+"',"+"'"+kitapid+"')";	
						vt_islem.add_ktp(sqllnk);
						
					}
				};
				TimerTask tsss = new TimerTask() {
					public  void run() {
						sqllnk="INSERT INTO tbl_yzr_ktp (yzr_id,ktp_id) VALUES ('"
								+yazar+"',"+"'"+kitapid+"')";
						vt_islem.add_ktp(sqllnk);
						
						t.cancel();
						
					}
				};

				t.schedule(ts, 0,300);
				t.schedule(tss,100,300);
				t.schedule(tsss,200,300);

				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_ktp_ekle.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_ktp_ekle.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_ktp_ekle.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_ktp_ekle.setBackground(new Color(244,119,0,255));
			}
		});	
		
	}
}
