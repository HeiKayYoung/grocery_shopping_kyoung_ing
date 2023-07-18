package km.grocery.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.grocery.controller.KmController;

public class KmLoginFormController implements KmController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//groJoinPro.jsp 으로 보내라
		request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		
	}

}
