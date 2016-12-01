package cn.sunyboy.activiti.servlet.deployment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 查询流程定义
 * @date 2016年7月6日 上午10:13:32
 * @version 1.0
 */
@WebServlet("/queryProcessDefinition.action")
public class QueryProcessDefinitionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8398877177979812299L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		/** 获取流程引擎 */
		ProcessEngine pe = ProcessEngineUtils.getProcessEngine();
		/** 获取仓储服务业务对象 */
		RepositoryService rs = pe.getRepositoryService();
		/** 创建流程定义查询对象 */
		ProcessDefinitionQuery pdq = rs.createProcessDefinitionQuery();
		
		/** 根据部署id进行排序查询得到List集合 */
		List<ProcessDefinition> pdLists = pdq.latestVersion(). // 最后一个版本
					orderByDeploymentId().asc().list();
		req.setAttribute("pdLists", pdLists);
		
		req.getRequestDispatcher("/processDefinition.jsp").forward(req, res);
	}
}
