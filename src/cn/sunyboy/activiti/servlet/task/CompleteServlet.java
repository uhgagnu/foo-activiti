package cn.sunyboy.activiti.servlet.task;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 完成任务(管理人员)
 * @date 2016年7月6日 下午4:18:53
 * @version 1.0
 */
@WebServlet("/completeTask.action")
public class CompleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = -328352833749987227L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/** 获取流程实例id */
		String piId = request.getParameter("piId");
		/** 获取任务id */
		String taskId = request.getParameter("taskId");
		/** 获取流程引擎 */
		ProcessEngine processEngine = ProcessEngineUtils.getProcessEngine();
		/** 获取任务服务 */
		TaskService taskService = processEngine.getTaskService();
		
		
		System.out.println("=======complete========");
		
		/** 获取流程变量 */
		System.out.println(taskService.getVariable(taskId, "userId2"));
		System.out.println(taskService.getVariables(taskId));
		
		/** 定义流程变量 */
		Map<String, Object> params = new HashMap<>();
		params.put("userId2", "test4");
		params.put("userId3", "test5");
		/** 完成任务 */
		taskService.complete(taskId, params);
		
		
		
		response.sendRedirect(request.getContextPath() + "/queryTask.action?piId=" + piId);
	}
}
