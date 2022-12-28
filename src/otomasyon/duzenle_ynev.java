package otomasyon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class duzenle_ynev extends JFrame {

	private JPanel contentPane;
	private JTextField txtfld_yayinevi_id;
	private JTextField txtfld_yayinevi_ad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					duzenle_ynev frame = new duzenle_ynev();
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
	public duzenle_ynev() {
		setBounds(100, 100, 243, 230);
		setTitle("Yay�nevi");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,200,200));
		
		JLabel lblNewLabel = new JLabel("Yay�nevi ID :");
		lblNewLabel.setBounds(10, 10, 83, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Yay�nevi Ad� :");
		lblNewLabel_1.setBounds(10, 47, 83, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("�L :");
		lblNewLabel_2.setBounds(10, 84, 83, 27);
		contentPane.add(lblNewLabel_2);
		//-----------------------------------------------------------------
		txtfld_yayinevi_id = new JTextField();
		txtfld_yayinevi_id.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_yayinevi_id.setEditable(false);
		txtfld_yayinevi_id.setBounds(87, 10, 134, 27);
		contentPane.add(txtfld_yayinevi_id);
		txtfld_yayinevi_id.setColumns(10);
		
		txtfld_yayinevi_ad = new JTextField();
		txtfld_yayinevi_ad.setHorizontalAlignment(SwingConstants.CENTER);
		txtfld_yayinevi_ad.setEditable(false);
		txtfld_yayinevi_ad.setBounds(87, 47, 134, 27);
		contentPane.add(txtfld_yayinevi_ad);
		txtfld_yayinevi_ad.setColumns(10);
		//-----------------------------------------------------------------
		JComboBox cmbox_yayinevi_il = new JComboBox();
		cmbox_yayinevi_il.setEditable(true);
		cmbox_yayinevi_il.setBounds(87, 84, 134, 27);
		contentPane.add(cmbox_yayinevi_il);
		cmbox_yayinevi_il.setBackground((new Color(244,119,0)));
		cmbox_yayinevi_il.setForeground((new Color(0,0,0)));
		//-----------------------------------------------------------------
		Image img= new ImageIcon(this.getClass().getResource("/save55xg.png")).getImage();
		JLabel btn_yayinevi_ekle = new JLabel("D�zenle ");
		btn_yayinevi_ekle.setHorizontalAlignment(SwingConstants.CENTER);
		btn_yayinevi_ekle.setFont(new Font("Arial", Font.BOLD, 20));
		//JButton btn_yayinevi_ekle = new JButton("D\u00FCzenle");
		btn_yayinevi_ekle.setBounds(5, 121, 216, 62);
		contentPane.add(btn_yayinevi_ekle);
		btn_yayinevi_ekle.setOpaque(true);
		btn_yayinevi_ekle.setBackground(new Color(244,119,0,255));
		btn_yayinevi_ekle.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_yayinevi_ekle.setIcon(new ImageIcon(img));
		//-----------------------------------------------------------------
		txtfld_yayinevi_id.setText(((String) admin_form. mymdlynev.getValueAt(admin_form.tbl_yayinevi.getSelectedRow(),0)));
		txtfld_yayinevi_ad.setText(((String) admin_form. mymdlynev.getValueAt(admin_form.tbl_yayinevi.getSelectedRow(),1)));
		cmbox_yayinevi_il.setSelectedItem((((String) admin_form. mymdlynev.getValueAt(admin_form.tbl_yayinevi.getSelectedRow(),2))));
		//----------------------------------------------------------------------
		txtfld_yayinevi_ad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfld_yayinevi_ad.setEditable(true);
			}
		});
		
		//----------------------------------------------------------------------
		try {
			ResultSet rs=vt_islem.combobox_iller();
			while (rs.next()) {
				String sehir = rs.getString("il");
				cmbox_yayinevi_il.addItem(sehir);
			}
		} catch (Exception e) {
		}
		
		//-----------------------------------------------------------------
		btn_yayinevi_ekle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ynevid,ad,bolge,sqllnky;

				ynevid = txtfld_yayinevi_id.getText();
				ad = txtfld_yayinevi_ad.getText();
				bolge = (String) cmbox_yayinevi_il.getSelectedItem();
				
				sqllnky ="UPDATE tbl_ynev SET ynev_id ="+ynevid+","+
						"ynev_ad='"+ad+"',ynev_blge ='"+bolge+"' WHERE ynev_id="+ynevid;
						
				vt_islem.guncelle(sqllnky);

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_yayinevi_ekle.setBackground(new Color(255,145,40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_yayinevi_ekle.setBackground(new Color(244,119,0,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_yayinevi_ekle.setBackground(new Color(255,51,40));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_yayinevi_ekle.setBackground(new Color(244,119,0,255));
			}
		});
	
			
	}

}
