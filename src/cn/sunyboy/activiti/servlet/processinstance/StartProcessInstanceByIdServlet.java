package cn.sunyboy.activiti.servlet.processinstance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
 * 根据流程定义id开启流程实例
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016年7月6日 上午11:21:13
 * @version 1.0
 */
@WebServlet("/startProcessInstanceById.action")
public class StartProcessInstanceByIdServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5237416774931194820L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/** 接收流程定义id */
		String pdId = request.getParameter("pdId");
		/** 获取流程引擎 */
		ProcessEngine pe = ProcessEngineUtils.getProcessEngine();
		/** 获取RuntimeService */
		RuntimeService rs = pe.getRuntimeService();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId1", "test2");
		/**  根据流程定义id开启流程实例 */
		ProcessInstance pi = rs.startProcessInstanceById(pdId, params);
		System.out.println(pi);
		
		/** 设置流程变量 */
		rs.setVariable(pi.getId(), "userId2", "test4");
		
		/** 获取流程变量 */
		System.out.println(rs.getVariable(pi.getId(), "userId1"));
		System.out.println(rs.getVariables(pi.getId()));
		
		
		/** 重定向到查询流程定义Servlet */
		response.sendRedirect(request.getContextPath() + "/queryProcessDefinition.action");
	}
}
