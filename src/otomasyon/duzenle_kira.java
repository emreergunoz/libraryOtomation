package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.ResultSet;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class duzenle_kira extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					duzenle_kira frame = new duzenle_kira();
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
	public duzenle_kira() {
		setBounds(100, 100, 450, 125);
		setTitle("Teslim Süresi Deðiþtirme");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u0130\u015Flem Yap\u0131lacak Kira \u0130D : ");
		lblNewLabel_1_1.setBounds(10, 10, 153, 29);
		contentPane.add(lblNewLabel_1_1);
		JLabel lblNewLabel_1 = new JLabel("Yeni Biti\u015F Tarihi : ");
		lblNewLabel_1.setBounds(10, 49, 132, 29);
		contentPane.add(lblNewLabel_1);
		
		JComboBox cmbox_kira_gn = new JComboBox();
		cmbox_kira_gn.setBounds(122, 49, 45, 30);
		contentPane.add(cmbox_kira_gn);
		cmbox_kira_gn.setBackground((new Color(244,119,0)));
		cmbox_kira_gn.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_kira_ay = new JComboBox();
		cmbox_kira_ay.setBounds(177, 49, 45, 30);
		contentPane.add(cmbox_kira_ay);
		cmbox_kira_ay.setBackground((new Color(244,119,0)));
		cmbox_kira_ay.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_kira_yl = new JComboBox();
		cmbox_kira_yl.setBounds(232, 49, 80, 30);
		contentPane.add(cmbox_kira_yl);
		cmbox_kira_yl.setBackground((new Color(244,119,0)));
		cmbox_kira_yl.setForeground((new Color(0,0,0)));
		//----------------------------------------------------------
		
		textField = new JTextField();
		textField.setText("2");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(153, 10, 159, 30);
		contentPane.add(textField);
		
		if(giris.durum==1) {
			textField.setText((String) admin_form. mymdlkira.getValueAt(admin_form.tbl_kira.getSelectedRow(),0));
		}else if(giris.durum==2) {
			textField.setText((String) personel_form. mymdlkira.getValueAt(personel_form.tbl_kira.getSelectedRow(),0));
		}
		

		
		Image img= new ImageIcon(this.getClass().getResource("/uzat60xg.png")).getImage();
		JLabel btn_kira_uzat = new JLabel();//"Uzat"
		btn_kira_uzat.setHorizontalAlignment(SwingConstants.CENTER);
	//	JButton btn_kira_uzat = new JButton("Uzat");
		btn_kira_uzat.setBounds(322, 9, 104, 70);
		contentPane.add(btn_kira_uzat);
		btn_kira_uzat.setOpaque(true);
		btn_kira_uzat.setBackground(new Color(244,119,0,255));
		btn_kira_uzat.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); 
		btn_kira_uzat.setIcon(new ImageIcon(img));
		btn_kira_uzat.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn_kira_uzat.setHorizontalTextPosition(SwingConstants.CENTER);
		
		//--------------------------------------------------------------------------
		try {
			ResultSet rs=vt_islem.combobox_gun();
			while (rs.next()) {
				String ay = rs.getString("gun");	
				cmbox_kira_gn.addItem(ay);
			}
		} catch (Exception e) {
		}vt_islem.kpt();
		
		try {
			ResultSet rs=vt_islem.combobox_ay();
			while (rs.next()) {
				String ay = rs.getString("ay");	
				cmbox_kira_ay.addItem(ay);
			}
		} catch (Exception e) {
		}vt_islem.kpt();
		
		try {
			ResultSet rs=vt_islem.combobox_yil();
			while (rs.next()) {
				String ay = rs.getString("yýl");	
				cmbox_kira_yl.addItem(ay);	
			}
		} catch (Exception e) {
		}vt_islem.kpt();
		
		//-------------------------------------------------------------------------------------------------------
		btn_kira_uzat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String krgn,kray,kryl,kiraid,sqlupd;


				krgn =(String) cmbox_kira_gn.getSelectedItem().toString();
				kray =(String) cmbox_kira_ay.getSelectedItem().toString();
				kryl =(String) cmbox_kira_yl.getSelectedItem().toString();
				kiraid=textField.getText();

				sqlupd = "UPDATE tbl_ktp_kira SET bitis_gn ='"+krgn+"-"+kray+"-"+kryl+"' WHERE kira_id="+kiraid;
				
				vt_islem.guncelle(sqlupd);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_kira_uzat.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_kira_uzat.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_kira_uzat.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_kira_uzat.setBackground(new Color(244,119,0,255));
			}
		});
		
	
	}
}
