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
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 查询历史流程实例
 * @date 2016年7月7日 上午9:23:24
 * @version 1.0
 */
@WebServlet("/queryHistoryProcessInstance.action")
public class QueryHistoryProcessInstanceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5046959864197824269L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** 获取流程引擎 */
		ProcessEngine pe = ProcessEngineUtils.getProcessEngine();
		/** 获取历史服务业务处理接口 */
		HistoryService hs = pe.getHistoryService();
		/** 创建历史流程实例查询对象.*/
	    HistoricProcessInstanceQuery hpq = hs.createHistoricProcessInstanceQuery();
	    /** 查义所有的历史流程实例 */
	    List<HistoricProcessInstance> hpiLists = hpq.finished() // 完成的
	    		.orderByProcessInstanceStartTime().asc().list();
	    
	    request.setAttribute("hpiLists", hpiLists);
	    request.getRequestDispatcher("/historicProcessInstance.jsp").forward(request, response);
	    
	}
	
	
	
	
}
