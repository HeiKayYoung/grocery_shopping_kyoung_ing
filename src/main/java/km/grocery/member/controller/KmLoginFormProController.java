package km.grocery.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.grocery.controller.KmController;
import km.grocery.member.dao.KmGroJoinusDao;
import km.grocery.member.vo.KmGroMember;

public class KmLoginFormProController implements KmController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String kmid=request.getParameter("kmid");
		String kmpwd1=request.getParameter("kmpwd1");
		
		
		KmGroJoinusDao dao = new KmGroJoinusDao();
		KmGroMember kgm = dao.checkMember(kmid);
		
		//상태분류 
		//아이디 없음, 비번틀림, 성공
		if(kgm==null) {  //아이디 없음
			request.setAttribute("error", "아이디 확인해주세요");
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		} else if (!kgm.getKmpwd1().equals(kmpwd1)) { //비번틀림
			request.setAttribute("error", "비밀번호 확인해주세요");
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		} else { //성공
			//아이디 세션에 담고 ../index.jsp로 진행
			request.getSession().setAttribute("kmid", kmid);
			response.sendRedirect("../index.jsp");
		}
		
		
	}

}
