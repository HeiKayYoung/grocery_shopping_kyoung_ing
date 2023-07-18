package km.grocery.notice.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import km.grocery.controller.KmController;
import km.grocery.notice.dao.KmNoticeDao;
import km.grocery.notice.vo.KmGroNoticeBoard;

public class KmNoticeEditProController implements KmController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		String kmno = request.getParameter("kmno");
		String kmtitle = request.getParameter("kmtitle");
		String kmcontent = request.getParameter("kmcontent");
		String kmwriter = request.getParameter("kmwriter");
		String kmdate = request.getParameter("kmdate");
		// 파일 이름 잘 안받아짐
		String kmfile = request.getParameter("kmfile");
		
		
	

		System.out.println("date2 : " + kmdate);

		KmGroNoticeBoard n = new KmGroNoticeBoard();
		SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd");
		n.setKmno(Integer.parseInt(kmno));
		n.setKmtitle(kmtitle);
		n.setKmcontent(kmcontent);
		n.setKmwriter(kmwriter);
		n.setKmfile(kmfile);
		//날짜 바꿈이.. 형식이.. ㅠㅠ 
		n.setKmdate(simpledate.parse(kmdate));

		System.out.println("변경 날짜 :"+n.getKmdate());
		
		KmNoticeDao dao = new KmNoticeDao();
		dao.update(n);

		request.setAttribute("n", n);
		request.getRequestDispatcher("noticeDetail.jsp").forward(request, response);
	}

}
