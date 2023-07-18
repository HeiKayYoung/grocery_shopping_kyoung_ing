package km.grocery.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import km.grocery.db.DBCon;
import km.grocery.member.vo.KmGroMember;

public class KmGroJoinusDao {
	public void joinus(KmGroMember m) throws Exception {

		String sql = "insert into kmgromember values(?,?,?,?,?,?,?,?,sysdate)";

		Connection con = DBCon.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, m.getKmid());
		pstmt.setString(2, m.getKmpwd1());
		pstmt.setString(3, m.getKmname());
		pstmt.setString(4, m.getKmemail());
		pstmt.setString(5, m.getKmcellphone());
		pstmt.setString(6, m.getKmaddr());
		pstmt.setString(7, m.getKmgender());
		pstmt.setDate(8, (Date) m.getKmbirthday());

		pstmt.executeUpdate();
		System.out.println("birthday:" + m.getKmbirthday());

	}

	public KmGroMember checkMember(String kmid) throws Exception {

		String sql = "select kmid, kmpwd1 from kmgromember where kmid=?"; 

		Connection con = DBCon.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, kmid);
		
		//아이디 없으면 null
		ResultSet rs= pstmt.executeQuery();
		KmGroMember kgm=null;
		if (rs.next()) {
			kgm=new KmGroMember();
			kgm.setKmid(rs.getString("kmid"));
			kgm.setKmpwd1(rs.getString("kmpwd1"));
			
			System.out.println("kmid"+kgm.getKmid()+"kmpwd1"+kgm.getKmpwd1());
		}
		
		return kgm;

	}
}
