package km.grocery.member.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.grocery.controller.KmController;
import km.grocery.member.dao.KmGroJoinusDao;
import km.grocery.member.vo.KmGroMember;

public class KmGroJoinusProController implements KmController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SimpleDateFormat simpledate = new SimpleDateFormat("dd-MM-yyyy");

		String kmid = request.getParameter("kmid");
		String kmpwd1 = request.getParameter("kmpwd1");
		String kmpwd2 = request.getParameter("kmpwd2");
		String kmname = request.getParameter("kmname");
		String kmemail = request.getParameter("kmemail");
		String kmcellphone = request.getParameter("kmcellphone");
		String kmaddr = request.getParameter("kmaddr");
		String kmgender = request.getParameter("gender");
		Date kmbirthday = simpledate.parse(request.getParameter("kmbirthday"));

		// 비밀번호 체크 진행중
		/*
		 * if (kmpwd1 != null && kmpwd2 != null && (!kmpwd1.equals(kmpwd2))) {
		 * request.setAttribute("pwdcheck", "비밀번호 불일치");
		 * request.getRequestDispatcher("loginForm.jsp").forward(request, response); }
		 */

		KmGroMember m = new KmGroMember();
		m.setKmid(kmid);
		m.setKmpwd1(kmpwd1);
		m.setKmname(kmname);
		m.setKmemail(kmemail);
		m.setKmcellphone(kmcellphone);
		m.setKmaddr(kmaddr);
		m.setKmgender(kmgender);

//		m.setKmbirthday(simpledate.parse(kmbirthday));

		System.out.println("생일 :" + m.getKmbirthday());

		KmGroJoinusDao dao = new KmGroJoinusDao();
		dao.joinus(m);

		response.sendRedirect("../index.jsp");
	}

}
