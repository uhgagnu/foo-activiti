package cn.sunyboy.activiti.servlet.processinstance;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 根据流程定义id查询流程实例
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016年7月6日 上午11:21:13
 * @version 1.0
 */
@WebServlet("/queryProcessInstance.action")
public class QueryProcessInstanceServlet extends HttpServlet {
	
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
		/**  创建流程实例查询对象 */
		ProcessInstanceQuery piq = rs.createProcessInstanceQuery();
		/** 根据流程定义id查询流程实例 */
		List<ProcessInstance> piLists = piq.processDefinitionId(pdId) // 查询条件
				.orderByProcessInstanceId() // 按流程实例进行排序
				.asc().list();
		
		request.setAttribute("piLists", piLists);
		request.getRequestDispatcher("/processInstance.jsp").forward(request, response);
	}
}
