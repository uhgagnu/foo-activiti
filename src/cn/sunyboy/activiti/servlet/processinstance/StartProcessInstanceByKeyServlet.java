package cn.sunyboy.activiti.servlet.processinstance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 根据流程定义key开启流程实例
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016年7月6日 上午11:21:13
 * @version 1.0
 */
@WebServlet("/startProcessInstanceByKey.action")
public class StartProcessInstanceByKeyServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5237416774931194820L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/** 接收流程定义key */
		String pdKey = request.getParameter("pdKey");
		/** 获取流程引擎 */
		ProcessEngine pe = ProcessEngineUtils.getProcessEngine();
		/** 获取RuntimeService */
		RuntimeService rs = pe.getRuntimeService();
		/**  根据流程定义Key开启流程实例 */
		ProcessInstance pi = rs.startProcessInstanceByKey(pdKey);
		System.out.println(pi);
		
		/** 重定向到查询流程定义Servlet */
		response.sendRedirect(request.getContextPath() + "/queryProcessDefinition.action");
	}
}
