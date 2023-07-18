package km.grocery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface KmController {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
