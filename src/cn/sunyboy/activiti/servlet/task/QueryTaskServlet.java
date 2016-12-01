package cn.sunyboy.activiti.servlet.task;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 根据流程实例id查询任务
 * @date 2016年7月6日 下午4:18:53
 * @version 1.0
 */
@WebServlet("/queryTask.action")
public class QueryTaskServlet extends HttpServlet {
	
	private static final long serialVersionUID = -328352833749987227L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** 获取流程实例id */
		String piId = request.getParameter("piId");
		/** 获取流程引擎 */
		ProcessEngine processEngine = ProcessEngineUtils.getProcessEngine();
		/** 获取任务服务 */
		TaskService taskService = processEngine.getTaskService();
		/** 创建任务查询对象 */
		TaskQuery taskQuery = taskService.createTaskQuery();
		/** 根据流程实例id来查询任务 */
		List<Task> taskLists = taskQuery.processInstanceId(piId)// 添加流程实例id作为查询条件
				 .list();
		
		request.setAttribute("taskLists", taskLists);
		request.getRequestDispatcher("/task.jsp").forward(request, response);
	}
}
