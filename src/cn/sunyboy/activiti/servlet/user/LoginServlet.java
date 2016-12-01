package cn.sunyboy.activiti.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录
 * @date 2016年7月6日 下午4:18:53
 * @version 1.0
 */
@WebServlet("/login.action")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = -328352833749987227L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** 获取请求参数 */
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		
		System.out.println(userId + "==" + pwd);
		
		/** 把用户存入Session */
		request.getSession().setAttribute("session_user", userId);
		
		/** 重定向到查询用户任务的Servlet */
		response.sendRedirect(request.getContextPath() + "/queryUserClaimTask.action");
	}
}
