package cn.sunyboy.activiti.servlet.processinstance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 发送信号让流程实例“走一步”
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016年7月6日 上午11:21:13
 * @version 1.0
 */
@WebServlet("/signalProcessInstance.action")
public class SignalProcessInstanceServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5237416774931194820L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/** 接收流程实例id */
		String piId = request.getParameter("piId");
		String pdId = request.getParameter("pdId");
		/** 获取流程引擎 */
		ProcessEngine pe = ProcessEngineUtils.getProcessEngine();
		/** 获取RuntimeService */
		RuntimeService rs = pe.getRuntimeService();
		/** 发送信号让流程实例“走一步” */
		rs.signal(piId);
		
		response.sendRedirect(request.getContextPath() + "/queryProcessInstance.action?pdId=" + pdId);
		
		
	}
}
