package km.grocery.notice.controller;

import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.grocery.controller.KmController;
import km.grocery.notice.dao.KmNoticeDao;
import km.grocery.notice.vo.KmGroNoticeBoard;

public class KmDownloadController implements KmController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path=request.getParameter("p");
		String fname=request.getParameter("f");
		String urlPath=path+fname;
		String realPath=request.getServletContext().getRealPath(urlPath);
		System.out.println("realPath: "+realPath);
		
		//네가 브라우저에서 읽을 수 있는건 알지만, 열지말고 첨부 파일을 다운로드 해야라는 명령어,ISO8859_1 이건 한글 처리
		response.setHeader("Content-Disposition", "attachment;filename="+new String(fname.getBytes(),"ISO8859_1"));
		
		//io처리 입출력처리
		FileInputStream fin=new FileInputStream(realPath); //입력스트림
		ServletOutputStream sout=response.getOutputStream(); //출력스트림
		
		
		//파일 전송 방식에서 오류를 줄이기 위해서 큰사이즈를 일부러 사이즈를 작게해서 나눠서 보내는데
		// 버퍼 사이즈 = byte[1024]이 효율적인 사이즈이다.
		byte[] buf=new byte[1024];
		int size=0;
		while ((size=fin.read(buf,0,1024))!=-1) {
			sout.write(buf,0,size);
		}
		fin.close();
		sout.close();
	}

}
