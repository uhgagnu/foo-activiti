package cn.sunyboy.activiti.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 完成用户任务
 * @date 2016年7月6日 下午4:18:53
 * @version 1.0
 */
@WebServlet("/completeUserTask.action")
public class CompleteUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = -328352833749987227L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** 获取任务id */
		String taskId = request.getParameter("taskId");
		/** 获取流程引擎 */
		ProcessEngine processEngine = ProcessEngineUtils.getProcessEngine();
		/** 获取任务服务 */
		TaskService taskService = processEngine.getTaskService();
		
		/** 完成任务 */
		taskService.complete(taskId);
		
		response.sendRedirect(request.getContextPath() + "/queryUserTask.action");
	}
}
