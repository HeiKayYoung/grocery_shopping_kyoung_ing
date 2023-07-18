package km.grocery.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.grocery.controller.KmController;
import km.grocery.member.dao.KmGroJoinusDao;
import km.grocery.member.vo.KmGroMember;

public class KmLogoutProController implements KmController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//세션제거  이후 notice.do로 이동
		request.getSession().invalidate();
		response.sendRedirect("../index.jsp");
		
	}

}
