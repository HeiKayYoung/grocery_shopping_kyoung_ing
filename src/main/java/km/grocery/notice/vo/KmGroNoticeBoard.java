package km.grocery.notice.vo;

import java.util.Date;

public class KmGroNoticeBoard {
	
	private int kmno;
	private String kmtitle;
	private String kmcontent;
	private String kmwriter;
	private Date kmdate;
	private int kmcnt;
	private String kmfile;
	
	public int getKmno() {
		return kmno;
	}
	public void setKmno(int kmno) {
		this.kmno = kmno;
	}
	public String getKmtitle() {
		return kmtitle;
	}
	public void setKmtitle(String kmtitle) {
		this.kmtitle = kmtitle;
	}
	public String getKmcontent() {
		return kmcontent;
	}
	public void setKmcontent(String kmcontent) {
		this.kmcontent = kmcontent;
	}
	public String getKmwriter() {
		return kmwriter;
	}
	public void setKmwriter(String kmwriter) {
		this.kmwriter = kmwriter;
	}
	public Date getKmdate() {
		return kmdate;
	}
	public void setKmdate(Date kmdate) {
		this.kmdate = kmdate;
	}
	public int getKmcnt() {
		return kmcnt;
	}
	public void setKmcnt(int kmcnt) {
		this.kmcnt = kmcnt;
	}
	public String getKmfile() {
		return kmfile;
	}
	public void setKmfile(String kmfile) {
		this.kmfile = kmfile;
	}
	
	
	
}
