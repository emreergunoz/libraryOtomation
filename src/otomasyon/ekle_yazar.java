package otomasyon;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.ResultSet;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

public class ekle_yazar extends JFrame {

	private JPanel contentPane;
	private JTextField txtfld_yazar_ad;
	private JTextField txtfld_yazar_soyad;
	private JTextField txtfld_yazar_id ;
	
	public static int yl=0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ekle_yazar frame = new ekle_yazar();
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
	public ekle_yazar() throws ParseException {

		setBounds(100, 100, 270, 323);
		setTitle("Yazar Ekle");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		JLabel lblNewLabel = new JLabel("Yazar ID :");
		lblNewLabel.setBounds(10, 10, 87, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Yazar Adý :");
		lblNewLabel_1.setBounds(10, 55, 87, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Yazar Soyadý :");
		lblNewLabel_2.setBounds(10, 100, 87, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Doðum Tarihi ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setBounds(10, 140, 87, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Ölüm Tarihi");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setBounds(162, 140, 87, 30);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_3 = new JLabel("Yaþýyormu ");
		lblNewLabel_3.setBounds(99, 149, 75, 13);
		contentPane.add(lblNewLabel_3);
		
		//------------------------------------------------------------------
		txtfld_yazar_ad = new JTextField();
		txtfld_yazar_ad.setBounds(99, 55, 150, 30);
		contentPane.add(txtfld_yazar_ad);
		txtfld_yazar_ad.setColumns(10);
		
		txtfld_yazar_soyad = new JTextField();
		txtfld_yazar_soyad.setColumns(10);
		txtfld_yazar_soyad.setBounds(99, 100, 150, 30);
		contentPane.add(txtfld_yazar_soyad);
		
		txtfld_yazar_id = new JTextField();
		txtfld_yazar_id.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_yazar_id.setColumns(10);
		txtfld_yazar_id.setBounds(99, 11, 150, 30);
		contentPane.add(txtfld_yazar_id);
		
		//---------------------------------------------------------------------

		JRadioButton rdbtn_evet = new JRadioButton("Evet");
		rdbtn_evet.setSelected(true);
		rdbtn_evet.setBounds(99, 168, 57, 21);
		contentPane.add(rdbtn_evet);
		
		JRadioButton rdbtn_hayir = new JRadioButton("Hayýr");
		rdbtn_hayir.setBounds(99, 193, 57, 21);
		contentPane.add(rdbtn_hayir);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtn_evet);
		bg.add(rdbtn_hayir);
		rdbtn_evet.setBackground(new Color(0,200,200));
		rdbtn_hayir.setBackground(new Color(0,200,200));
		//------------------------------------------------
		JComboBox cmbox_ekle_yl = new JComboBox();
		cmbox_ekle_yl.setEditable(true);
		cmbox_ekle_yl.setBounds(10, 180, 76, 30);
		contentPane.add(cmbox_ekle_yl);
		cmbox_ekle_yl.setBackground((new Color(244,119,0)));
		cmbox_ekle_yl.setForeground((new Color(0,0,0)));
		
		JComboBox cmbox_ekle_yl_1 = new JComboBox();
		cmbox_ekle_yl_1.setEnabled(false);
		cmbox_ekle_yl_1.setEditable(true);
		cmbox_ekle_yl_1.setBounds(172, 180, 76, 30);
		contentPane.add(cmbox_ekle_yl_1);	
		cmbox_ekle_yl_1.setBackground((new Color(244,119,0)));
		cmbox_ekle_yl_1.setForeground((new Color(0,0,0)));
		
		//JButton btn_ekle_ekle = new JButton("Ekle");
		Image img= new ImageIcon(this.getClass().getResource("/add60xg.png")).getImage();
		JLabel btn_ekle_ekle = new JLabel("Yazar\u0131 Ekle ");
		btn_ekle_ekle.setFont(new Font("Arial", Font.BOLD, 20));
		btn_ekle_ekle.setHorizontalAlignment(SwingConstants.CENTER);
		btn_ekle_ekle.setBounds(10, 220, 239, 60);
		contentPane.add(btn_ekle_ekle);
		btn_ekle_ekle.setOpaque(true);
		btn_ekle_ekle.setBackground(new Color(244,119,0,255));
		btn_ekle_ekle.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))); 
		btn_ekle_ekle.setIcon(new ImageIcon(img));
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1.setForeground(new Color(244, 119, 0));
		separator_3_1.setBounds(162, 149, 2, 65);
		contentPane.add(separator_3_1);
		
		JSeparator separator_3_1_1 = new JSeparator();
		separator_3_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1_1.setForeground(new Color(244, 119, 0));
		separator_3_1_1.setBounds(95, 149, 2, 60);
		contentPane.add(separator_3_1_1);
		
		JSeparator separator_3_1_2 = new JSeparator();
		separator_3_1_2.setForeground(new Color(244, 119, 0));
		separator_3_1_2.setBounds(10, 139, 239, 2);
		contentPane.add(separator_3_1_2);

		
		//-------------------------------------------------------------------
		try {
			ResultSet rs=vt_islem.combobox_yillar();
			while (rs.next()) {
				String ay = rs.getString("yýl");
				cmbox_ekle_yl.addItem(ay);	
			}
		} catch (Exception e) {
		}
		try {
			ResultSet rs=vt_islem.combobox_yillar();
			while (rs.next()) {
				String ay = rs.getString("yýl");
				cmbox_ekle_yl_1.addItem(ay);	
			}
		} catch (Exception e) {
		}
		//-------------------------------------------------------------------------------
		rdbtn_hayir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtn_hayir.isSelected()) {
					yl=1 ;
					cmbox_ekle_yl_1.setEnabled(true);
				}else if (rdbtn_evet.isSelected()){
					yl=0 ;
					cmbox_ekle_yl_1.setEnabled(false);
				}
			}
		});
		
		rdbtn_evet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtn_hayir.isSelected()) {
					yl=1 ;
					cmbox_ekle_yl_1.setEnabled(true);

				}else if (rdbtn_evet.isSelected()){
					yl=0 ;
					cmbox_ekle_yl_1.setEnabled(false);
					
				}
			}
		});
		//------------------------------------Son Yazar Ýd Bulma--------------------
		txtfld_yazar_id.setText(Integer.toString(Integer.parseInt(admin_form.yazarid)+1));
	
		//-------------------------------------------------------------------
		btn_ekle_ekle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String kimlikno,ad,soyad,dgmyl ,dgmyl1,sqllnk;
				if(yl==0) {
				
				kimlikno = txtfld_yazar_id.getText();
				ad = txtfld_yazar_ad.getText();
				soyad = txtfld_yazar_soyad.getText();
				
				dgmyl =(String) cmbox_ekle_yl.getSelectedItem().toString();	

				sqllnk = "INSERT INTO tbl_yzr (yzr_id,yzr_ad,yzr_soyad,yzr_dgm) VALUES ('"
						+kimlikno+"',"+"'"+ad+"',"+"'"+soyad+"','"+dgmyl+"')";
				
				vt_islem.add_uye(sqllnk);
				
				}else if (yl==1) {

					kimlikno = txtfld_yazar_id.getText();
					ad = txtfld_yazar_ad.getText();
					soyad = txtfld_yazar_soyad.getText();
					
					dgmyl =(String) cmbox_ekle_yl.getSelectedItem().toString();	
					dgmyl1 =(String) cmbox_ekle_yl_1.getSelectedItem().toString();	

					sqllnk = "INSERT INTO tbl_yzr (yzr_id,yzr_ad,yzr_soyad,yzr_dgm,yzr_olm) VALUES ('"
							+kimlikno+"',"+"'"+ad+"',"+"'"+soyad+"','"+dgmyl+"','"+dgmyl1+"')";
					
					vt_islem.add_uye(sqllnk);
				}
				yl=0;
				
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
