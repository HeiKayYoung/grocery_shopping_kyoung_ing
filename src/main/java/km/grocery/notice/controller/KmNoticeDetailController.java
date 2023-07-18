package km.grocery.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.grocery.controller.KmController;
import km.grocery.notice.dao.KmNoticeDao;
import km.grocery.notice.vo.KmGroNoticeBoard;

public class KmNoticeDetailController implements KmController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String kmno =request.getParameter("c");
		String cnt = request.getParameter("cnt");
		
		System.out.println("kmno :"+kmno+"cnt: "+cnt);
		
		KmNoticeDao dao=new KmNoticeDao();
		KmGroNoticeBoard n = dao.showTheList(kmno,cnt);
		
		request.setAttribute("n",n);
		request.getRequestDispatcher("noticeDetail.jsp").forward(request, response);
	}

}
