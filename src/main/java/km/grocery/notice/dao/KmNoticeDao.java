package km.grocery.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import km.grocery.db.DBCon;
import km.grocery.notice.vo.KmGroNoticeBoard;

public class KmNoticeDao {

	public List<KmGroNoticeBoard> showNoticeAll(String field, String search) throws Exception {

//		String sql = "select kmno,kmtitle,kmcontent,kmwriter,kmdate,kmcnt,kmfile from kmgronoticeboard order by kmno desc";
		// 검색기능 추가
		String sql = "select kmno,kmtitle,kmcontent,kmwriter,kmdate,kmcnt,kmfile " + "from kmgronoticeboard where "
				+ field + " like ?" + " order by kmno desc";

		// dbcon
		Connection con = DBCon.getConnection();

		// 실행
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery(sql);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + search + "%");
		ResultSet rs = pstmt.executeQuery();

		List<KmGroNoticeBoard> blist = new ArrayList();
		// 리스트에 담기
		while (rs.next()) {
			KmGroNoticeBoard n = new KmGroNoticeBoard();

			n.setKmno(rs.getInt(1));
			n.setKmtitle(rs.getString("kmtitle"));
			n.setKmcontent(rs.getString("kmcontent"));
			n.setKmwriter(rs.getString(4));
			n.setKmdate(rs.getDate("kmdate"));
			n.setKmcnt(rs.getInt("kmcnt"));
			n.setKmfile(rs.getString("kmfile"));
			blist.add(n);

			System.out.println("젭알 날짜변경좀:" + n.getKmdate() );
		}

		return blist;
	}

	public void countUpDate(String kmno, int kmcount) throws Exception {
		System.out.println("카운트 upppppp" + kmcount);

		String sql = "update kmgronoticeboard set kmcnt=? where kmno=?";

		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, kmcount + 1);
		pstmt.setString(2, kmno);
		pstmt.executeUpdate();

	}

	public KmGroNoticeBoard showTheList(String kmno, String cnt) throws Exception {

		// update cnt
		int kmcount = Integer.parseInt(cnt);
		countUpDate(kmno, kmcount);

		String sql = "select kmno,kmtitle,kmcontent,kmwriter," 
				+ "kmdate,kmcnt,kmfile from kmgronoticeboard where kmno="
				+ kmno;
		// dbcon
		Connection con = DBCon.getConnection();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		KmGroNoticeBoard n = new KmGroNoticeBoard();
		rs.next();
		n.setKmno(rs.getInt("kmno"));
		n.setKmtitle(rs.getString("kmtitle"));
		n.setKmcontent(rs.getString("kmcontent"));
		n.setKmwriter(rs.getString("kmwriter"));
		n.setKmdate(rs.getDate("kmdate"));
		n.setKmcnt(rs.getInt("kmcnt"));
		n.setKmfile(rs.getString("kmfile"));

		return n;

	}

	public KmGroNoticeBoard showTheList(String kmno) throws Exception {

		String sql = "select kmno,kmtitle,kmcontent,kmwriter," 
				+ "kmdate,kmcnt,kmfile from kmgronoticeboard where kmno="
				+ kmno;
		// dbcon
		Connection con = DBCon.getConnection();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		KmGroNoticeBoard n = new KmGroNoticeBoard();
		rs.next();
		n.setKmno(rs.getInt("kmno"));
		n.setKmtitle(rs.getString("kmtitle"));
		n.setKmcontent(rs.getString("kmcontent"));
		n.setKmwriter(rs.getString("kmwriter"));
		n.setKmdate(rs.getDate("kmdate"));
		n.setKmcnt(rs.getInt("kmcnt"));
		n.setKmfile(rs.getString("kmfile"));
		
		System.out.println("에딧에서 과연 값을 받는게 맞는가 :"+n.getKmfile());
		
		return n;

	}

	public void update(KmGroNoticeBoard n) throws Exception {

		String sql = "update kmgronoticeboard set kmtitle=?, kmcontent=? where kmno=?";
		// dbcon
		Connection con = DBCon.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, n.getKmtitle());
		pstmt.setString(2, n.getKmcontent());
		pstmt.setInt(3, n.getKmno());

		pstmt.executeUpdate();

		pstmt.close();
		con.close();

	}

	public void write(KmGroNoticeBoard n) throws Exception {

		String sql = "insert into kmgronoticeboard values(kmgronoticeboard_kmno_seq.nextval,?,?,?,sysdate,0,?)";
		// dbcon
		Connection con = DBCon.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, n.getKmtitle());
		pstmt.setString(2, n.getKmcontent());
		pstmt.setString(3, n.getKmwriter());
		pstmt.setString(4, n.getKmfile());

		pstmt.executeUpdate();

		pstmt.close();
		con.close();

	}

	public void delete(String kmno) throws Exception {

		String sql = "delete from kmgronoticeboard where kmno="+kmno;
		// dbcon
		Connection con = DBCon.getConnection();

		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);

		stmt.close();
		con.close();

	}
}
