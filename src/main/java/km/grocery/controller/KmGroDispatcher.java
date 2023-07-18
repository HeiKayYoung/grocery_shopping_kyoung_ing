package km.grocery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.grocery.member.controller.KmGroJoinusController;
import km.grocery.member.controller.KmGroJoinusProController;
import km.grocery.member.controller.KmLoginFormController;
import km.grocery.member.controller.KmLoginFormProController;
import km.grocery.member.controller.KmLogoutProController;
import km.grocery.notice.controller.KmDownloadController;
import km.grocery.notice.controller.KmNoticeDeleteProController;
import km.grocery.notice.controller.KmNoticeDetailController;
import km.grocery.notice.controller.KmNoticeEditController;
import km.grocery.notice.controller.KmNoticeEditProController;
import km.grocery.notice.controller.KmNoticeMainController;
import km.grocery.notice.controller.KmNoticeRegController;
import km.grocery.notice.controller.KmNoticeRegProController;

public class KmGroDispatcher extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		System.out.println(com);
		
		KmController controller=null;
		
		try { if (com.equals("/joinus/groJoin.do")) {
				controller=new KmGroJoinusController();
			} else if (com.equals("/joinus/groJoinPro.do")) {
				controller=new KmGroJoinusProController();
			} else if (com.equals("/notice/noticeMain.do")) {
				controller=new KmNoticeMainController();
			} else if (com.equals("/notice/noticeDetail.do")) {
				controller=new KmNoticeDetailController();
			} else if (com.equals("/notice/noticeEdit.do")) {
				controller=new KmNoticeEditController();
			} else if (com.equals("/notice/noticeEditPro.do")) {
				controller=new KmNoticeEditProController();
			} else if (com.equals("/notice/noticeReg.do")) {
				controller=new KmNoticeRegController();
			} else if (com.equals("/notice/noticeRegPro.do")) {
				controller=new KmNoticeRegProController();
			} else if (com.equals("/notice/noticeDelete.do")) {
				controller=new KmNoticeDeleteProController();
			} else if (com.equals("/login/loginForm.do")) {
				controller=new KmLoginFormController();
			} else if (com.equals("/login/loginFormPro.do")) {
				controller=new KmLoginFormProController();
			} else if (com.equals("/login/logoutPro.do")) {
				controller=new KmLogoutProController();
			} else if (com.equals("/notice/download.do")) {
				controller=new KmDownloadController();
			}
			
			
			
			controller.execute(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
