package cn.sunyboy.activiti.servlet.history;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 查询历史任务实例
 * @date 2016年7月7日 上午9:23:24
 * @version 1.0
 */
@WebServlet("/queryHistoricTaskInstance.action")
public class QueryHistoryTaskInstanceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5046959864197824269L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/** 接收历史流程实例id */
		String hpiId = request.getParameter("hpiId");
		/** 获取流程引擎 */
		ProcessEngine pe = ProcessEngineUtils.getProcessEngine();
		/** 获取历史服务业务处理接口 */
		HistoryService hs = pe.getHistoryService();
		/** 创建历史任务实例查询对象.*/
		HistoricTaskInstanceQuery htiq = hs.createHistoricTaskInstanceQuery();
		/** 根据历史流程实例id查看历史任务实例 */
		List<HistoricTaskInstance> htiLists = htiq.processInstanceId(hpiId).orderByTaskCreateTime().asc().list();
	   
	    
	    request.setAttribute("htiLists", htiLists);
	    request.getRequestDispatcher("/historicTaskInstance.jsp").forward(request, response);
	    
	}
	
	
	
	
}
