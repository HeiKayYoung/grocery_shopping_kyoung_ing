package km.grocery.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.grocery.controller.KmController;

public class KmGroJoinusController implements KmController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//groJoinPro.jsp 으로 보내라
		request.getRequestDispatcher("groJoin.jsp").forward(request, response);
		
	}

}
