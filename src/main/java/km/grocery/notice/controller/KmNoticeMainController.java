package km.grocery.notice.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.grocery.controller.KmController;
import km.grocery.notice.dao.KmNoticeDao;
import km.grocery.notice.vo.KmGroNoticeBoard;

public class KmNoticeMainController implements KmController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//search (파람값으로 f와 s가 오게 된다)그 값이 request에 오게 된다
		String field=request.getParameter("f");
		if (field==null||field.equals("")) {
			field="kmtitle";
		}
		
		System.out.println("field : "+field);
		String search=request.getParameter("s");
		System.out.println("search :"+search);
		if (search==null) {
			search="";
		}
		
		
		KmNoticeDao dao=new KmNoticeDao();
		
		List<KmGroNoticeBoard> blist= dao.showNoticeAll(field,search);
		
		request.setAttribute("blist", blist);
		request.setAttribute("search", search);
		
		System.out.println(Arrays.asList(blist));
		
		
		//groJoinPro.jsp 으로 보내라
		request.getRequestDispatcher("noticeMain.jsp").forward(request, response);
		
	}

}
