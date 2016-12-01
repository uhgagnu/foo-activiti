package cn.sunyboy.activiti.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 查询用户需要领取的任务
 * @date 2016年7月6日 下午4:18:53
 * @version 1.0
 */
@WebServlet("/queryUserClaimTask.action")
public class QueryUserClaimTaskServlet extends HttpServlet {
	
	private static final long serialVersionUID = -328352833749987227L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** 获取当前Session中的用户 */
		String userId = (String)request.getSession().getAttribute("session_user");
		
		/** 定义组(角色)  */
		Map<String, List<String>> groupMaps = new HashMap<String, List<String>>();
		
		List<String> userLits1 = new ArrayList<>();
		userLits1.add("test1");
		userLits1.add("test2");
		userLits1.add("test3");
		groupMaps.put("role1", userLits1);
		
		List<String> userLits2 = new ArrayList<>();
		userLits2.add("test2");
		userLits2.add("test5");
		userLits2.add("test6");
		groupMaps.put("role2", userLits2);
		
		
		/** 获取流程引擎 */
		ProcessEngine processEngine = ProcessEngineUtils.getProcessEngine();
		/** 获取任务服务 */
		TaskService taskService = processEngine.getTaskService();
		/** 创建任务查询对象 */
		TaskQuery taskQuery = taskService.createTaskQuery();
		
		List<Task> userAllTasks = new ArrayList<Task>();
		
		/** 循环所有的组 */
		for (Map.Entry<String, List<String>> entry : groupMaps.entrySet()){
			
			if (entry.getValue().contains(userId)){
				/** 根据任务候选组来查询任务 */
				List<Task> taskLists = taskQuery.taskCandidateGroup(entry.getKey()) // 添加任务的候选组作为查询条件
						 .list();
				userAllTasks.addAll(taskLists);
			}
		}
		
		
		
		request.setAttribute("taskLists", userAllTasks);
		request.getRequestDispatcher("/userClaimTask.jsp").forward(request, response);
	}
}
