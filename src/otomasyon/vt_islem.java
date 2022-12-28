package otomasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class vt_islem {
	static String db_yol = "jdbc:sqlite:D://Dokunma/vt_kutuphane_otomasyon.db";//"jdbc:sqlite:D://Dokunma/vt_kutuphane_otomasyon.db"//jdbc:sqlite:D://vt_kutuphaneotomasyon.db
	static Connection lnk;
	static Statement st;
	
	public static void kpt() {
		try {
			lnk.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static ResultSet baglan() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_uye");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	static ResultSet uyeler_listele() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_uye");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet combobox_iller() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_iller");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet combobox_gunler() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select gun from tbl_tarih limit 31");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}static ResultSet combobox_aylar() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select ay from tbl_tarih limit 12");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}static ResultSet combobox_yillar() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select yýl from tbl_tarih order by yýl desc");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	static void add_uye(String sqllnk) {
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			st.executeUpdate(sqllnk);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	static void guncelle (String sqlupd) {
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			st.executeUpdate(sqlupd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	
	static void kydsl(String sqlkyd) {
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			st.executeUpdate(sqlkyd);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	static ResultSet ara_uyeler(String sqlara) {
		ResultSet rs=null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs = st.executeQuery(sqlara);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
			
	}
	
	static ResultSet Tc() {
		ResultSet rc=null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rc=st.executeQuery("select tc from tbl_uye");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rc;
	
		
	}
	
	//---------------------------------------------------------------------Admin_uye----------------------------
	static ResultSet kitap_listele() {
		ResultSet rsk= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rsk=st.executeQuery("select ktp.ktp_id, ktp.ktp_ad,ktp.ktp_stok,ktp.ktp_bsm,ktp.ktp_sayfa,ynev.ynev_ad,yzr.yzr_ad,yzr.yzr_soyad,tur.tur_ad from tbl_ktp as ktp inner join tbl_ynev as ynev on ktp.ynev_id=ynev.ynev_id inner join  tbl_yzr_ktp as yzrktp on yzrktp.yzr_id=yzr.yzr_id inner join tbl_yzr as yzr on yzrktp.ktp_id= ktp.ktp_id inner join tbl_ktp_tur as turktp on turktp.tur_id=tur.tur_id inner join tbl_tur as tur on turktp.ktp_id=ktp.ktp_id");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsk;
	}
	
	static ResultSet combobox_yazar() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select yzr_ad,yzr_soyad from tbl_yzr ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet combobox_yayinevi() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select ynev_ad from tbl_ynev ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet combobox_tur() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select tur_ad from tbl_tur");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet txtfld_top1() {
		ResultSet rss= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rss=st.executeQuery("select ktp_id from tbl_ktp order by ktp_id desc limit 1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rss;
	}
	static ResultSet yazaralma () {
		ResultSet rsy = null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			//rsy=st.executeQuery("select yzr.yzr_id from tbl_ktp as ktp inner join tbl_ynev as ynev on ktp.ynev_id=ynev.ynev_id inner join  tbl_yzr_ktp as yzrktp on yzrktp.yzr_id=yzr.yzr_id inner join tbl_yzr as yzr on yzrktp.ktp_id= ktp.ktp_id inner join tbl_ktp_tur as turktp on turktp.tur_id=tur.tur_id inner join tbl_tur as tur on turktp.ktp_id=ktp.ktp_id");
			rsy=st.executeQuery("select yzr.yzr_id from tbl_ktp as ktp inner join  tbl_yzr_ktp as yzrktp on yzrktp.yzr_id=yzr.yzr_id inner join tbl_yzr as yzr on yzrktp.ktp_id="+duzenle_ktp.kitapid1+" limit 1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsy;
	}
	static ResultSet turalma () {
		ResultSet rst = null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			//rst=st.executeQuery("select tur.tur_id from tbl_ktp as ktp inner join tbl_ynev as ynev on ktp.ynev_id=ynev.ynev_id inner join  tbl_yzr_ktp as yzrktp on yzrktp.yzr_id=yzr.yzr_id inner join tbl_yzr as yzr on yzrktp.ktp_id= ktp.ktp_id inner join tbl_ktp_tur as turktp on turktp.tur_id=tur.tur_id inner join tbl_tur as tur on turktp.ktp_id=ktp.ktp_id");
			rst=st.executeQuery("select tur.tur_id from tbl_ktp as ktp inner join tbl_ktp_tur as turktp on turktp.tur_id=tur.tur_id inner join tbl_tur as tur on turktp.ktp_id="+duzenle_ktp.kitapid1+"  limit 1");
			 
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rst;
	}
	static void add_ktp(String sqllnk) {
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			st.executeUpdate(sqllnk);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	static ResultSet ara_ktp(String sqlara) {
		ResultSet rs=null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs = st.executeQuery(sqlara);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
			
	}
	//----------------------------------------------------------------------------------Kira Baðlantýlarý-------------------------------------------------------------
	static ResultSet kira_listele() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_ktp_kira");//select * from tbl_ktp_kira order by kira_id desc son listeden baþa listeleme
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet kira_listele_edilmedi() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_ktp_kira where iade_drm ='Edilmedi' order by kira_id desc ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet kira_listele_edildi() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_ktp_kira where iade_drm ='Edildi' order by kira_id desc ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet kiratc_listele() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select tc,ad,soyad from tbl_uye");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet kiraktp_listele() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select ktp_id,ktp_stok,ktp_ad from tbl_ktp as ktp where ktp_stok>0");//select ktp_id,ktp_ad from tbl_ktp
			//select ktp_id from tbl_ktp as ktp left join  tbl_ktp_kira as kira on ktp.ktp_id = kira.kitap_id where kira.kitap_id is null or ktp.ktp_stok>0
			//select ktp_id,ktp_ad from tbl_ktp as ktp left join  tbl_ktp_kira as kira on ktp.ktp_id = kira.kitap_id where kira.kitap_id is null or kira.iade_drm !='Edilmedi
			//select ktp_id,ktp_ad from tbl_ktp as ktp left join  tbl_ktp_kira as kira on ktp.ktp_id = kira.kitap_id where kira.kitap_id is null or kira.iade_drm !='Edilmedi'
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet txtfldkira_top1() {
		ResultSet rss= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rss=st.executeQuery("select kira_id from tbl_ktp_kira order by kira_id desc limit 1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rss;
	}
	static ResultSet combobox_gun() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select gun from tbl_tarih limit 31");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}static ResultSet combobox_ay() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select ay from tbl_tarih limit 12");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}static ResultSet combobox_yil() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select yýl from tbl_tarih order by yýl desc limit 2");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static void add_kira(String sqllnk) {
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			st.executeUpdate(sqllnk);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	static ResultSet ara_ktpid(String sqlara) {
		ResultSet rs=null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs = st.executeQuery(sqlara);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
			
	}
	static ResultSet ara_stok(String sqlara) {
		ResultSet rs=null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs = st.executeQuery(sqlara);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
			
	}
	//--------------------------------------------------------------------------Personel ------------------------------------------
	
	static ResultSet personel_listele() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_personel");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet personel_listele_maas() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_personel where prsnl_bitis is null order by prsnl_maas desc");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet personel_listele_baslangýc() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_personel where prsnl_bitis is null order by prsnl_baslangic desc");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet personel_listele_bitis() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_personel where prsnl_bitis >0 order by prsnl_bitis desc");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static void add_personel(String sqllnk) {
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			st.executeUpdate(sqllnk);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	static void guncelle_personel(String sqlupd) {
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			st.executeUpdate(sqlupd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	

	}
	//-------------------------------------------------------------------------------
	static ResultSet txtfldynev_top1() {
		ResultSet rss= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rss=st.executeQuery("select ynev_id from tbl_ynev order by ynev_id desc limit 1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rss;
	}
	static ResultSet txtfldyazar_top1() {
		ResultSet rss= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rss=st.executeQuery("select yzr_id from tbl_yzr order by yzr_id desc limit 1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rss;
	}
	//------------------------------------------------------------------------------------
	static ResultSet yazar_listele() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_yzr");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	static ResultSet yayinevi_listele() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_ynev");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	//------------------------------------------------------------------------------Personel_form------------------------------
	//------------------------------------------------------------------------------Personel_form------------------------------
	//------------------------------------------------------------------------------Personel_form------------------------------
	//------------------------------------------------------------------------------Personel_form------------------------------
	//------------------------------------------------------------------------------Personel_form------------------------------
	static ResultSet uyeler_listele_prsnl() {
		ResultSet rs= null;
		try {
			lnk= DriverManager.getConnection(db_yol);
			st= lnk.createStatement();
			rs=st.executeQuery("select * from tbl_uye");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
