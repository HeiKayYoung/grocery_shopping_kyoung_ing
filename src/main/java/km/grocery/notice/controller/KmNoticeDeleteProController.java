package km.grocery.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.grocery.controller.KmController;
import km.grocery.notice.dao.KmNoticeDao;
import km.grocery.notice.vo.KmGroNoticeBoard;

public class KmNoticeDeleteProController implements KmController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String kmno = request.getParameter("c");
		
		KmNoticeDao dao = new KmNoticeDao();
		dao.delete(kmno);
		
		response.sendRedirect("noticeMain.do");
//		request.setAttribute("n", n);
//		request.getRequestDispatcher("noticeEdit.jsp").forward(request, response);
	}

}
