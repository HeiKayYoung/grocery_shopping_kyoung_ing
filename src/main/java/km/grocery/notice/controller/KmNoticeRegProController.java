package km.grocery.notice.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import km.grocery.controller.KmController;
import km.grocery.notice.dao.KmNoticeDao;
import km.grocery.notice.vo.KmGroNoticeBoard;

public class KmNoticeRegProController implements KmController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//파일 upload path
		String path="notice/upload";
		ServletContext ctx=request.getServletContext();
		path=ctx.getRealPath(path);
		System.out.println("real path~~~ :" +path);
		//학원
		path="C:\\javabitsetjsp2023\\jsp_work\\grocery_shopping_kyoung_ing\\src\\main\\webapp\\notice\\upload";
		//인천
		//path="C:\\Users\\HP\\Documents\\LangJspjsp\\Lang_jsp_work\\grocery_shopping_kyoung_ing_230714_atshchool\\src\\main\\webapp\\notice\\upload";
		
		//multipart형식으로 데이터 받기
		MultipartRequest req= new MultipartRequest(request, path, 10*1024*1024,"utf-8",new DefaultFileRenamePolicy());
		// 이제는 파람으로 받을 수 없게 되었다.
		//String title=request.getParameter("title"); 이렇게 못쓴다
		//그리고 파일은.. 
		//String kmfile = req.getFilesystemName("kmfile");
		
		
		String kmid = req.getParameter("kmid");
		String kmtitle = req.getParameter("kmtitle");
		String kmwriter = req.getParameter("kmwriter");
		String kmfile = req.getFilesystemName("kmfile");
		String kmcontent = req.getParameter("kmcontent");
		
		System.out.println("title:"+kmtitle+":"+kmfile);
		
		
		KmGroNoticeBoard n=new KmGroNoticeBoard();
		
		n.setKmtitle(kmtitle);
		n.setKmwriter(kmwriter);
		n.setKmfile(kmfile); //파일은 위치값만 DB 저장
		n.setKmcontent(kmcontent);
		
		KmNoticeDao dao = new KmNoticeDao();
		dao.write(n);
		
		
		response.sendRedirect("noticeMain.do");
	}

}
