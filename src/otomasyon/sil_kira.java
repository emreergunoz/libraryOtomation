package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sil_kira extends JFrame {

	private JPanel contentPane;
	private JTextField txtfld_iade; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sil_kira frame = new sil_kira();
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
	public sil_kira() {
		setBounds(100, 100, 410, 100);
		setTitle("Kitap Ýade");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		JLabel lblNewLabel = new JLabel("Kira \u0130D :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 100, 43);
		contentPane.add(lblNewLabel);
		
		txtfld_iade = new JTextField();
		txtfld_iade.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_iade.setBounds(115, 10, 110, 43);
		contentPane.add(txtfld_iade);
		txtfld_iade.setColumns(10);
		
		Image img= new ImageIcon(this.getClass().getResource("/kira30xm.png")).getImage();
		JLabel btn_iade = new JLabel("Ýade Al");
		btn_iade.setFont(new Font("Arial", Font.BOLD, 20));
		//JButton btn_iade = new JButton("Ýade Al");
		btn_iade.setBounds(235, 10, 151, 43);
		contentPane.add(btn_iade);
		btn_iade.setHorizontalAlignment(SwingConstants.CENTER);
		btn_iade.setOpaque(true);
		btn_iade.setBackground(new Color(244,119,0,255));
		btn_iade.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); 
		btn_iade.setIcon(new ImageIcon(img));
		

		//------------------------------------------------------------------------------
	
		
		
		btn_iade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sqllnk2,id;
				id=txtfld_iade.getText();
				
				sqllnk2="UPDATE tbl_ktp_kira SET iade_drm ='Edildi' Where kira_id ='"+id+"'";
				vt_islem.guncelle(sqllnk2);
				vt_islem.kpt();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_iade.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_iade.setBackground(new Color(244,119,0,255));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_iade.setBackground(new Color(255,51,40));
				String kitap = null,id,sqllnk1;
				int stok1 = 0;
				int stok2;
				String sqlara,sqlaraa = null;
				ResultSet rs,rss = null;
				
				id=txtfld_iade.getText();
				
				sqlara = "select kitap_id from tbl_ktp_kira where kira_id = '"+id+"'";
				rs= vt_islem.ara_ktpid(sqlara);
				
				try {
					while(rs.next()) {
						kitap = rs.getString("kitap_id");
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}vt_islem.kpt();
				//---------------------------------------
				//-------------------------------------Stok Artýrma
				
				sqlaraa = "select ktp_stok from tbl_ktp where ktp_id = '"+kitap+"'";
				rss= vt_islem.ara_stok(sqlaraa);
				try {
					while(rss.next()) {
						stok1 = rss.getInt("ktp_stok");
					}
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}vt_islem.kpt();
				
				stok2=stok1+1;

				sqllnk1="UPDATE tbl_ktp SET ktp_stok ='"+stok2+"' WHERE ktp_id='"+kitap+"'";
				vt_islem.add_kira(sqllnk1);
				vt_islem.kpt();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_iade.setBackground(new Color(244,119,0,255));
			}
		}); 
		
		
	}
}
