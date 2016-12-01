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
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 查询流程部署
 * @date 2016年7月6日 上午10:13:32
 * @version 1.0
 */
@WebServlet("/queryProcessDeployment.action")
public class QueryProcessDeploymentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8131739467218760937L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		/** 获取流程引擎 */
		ProcessEngine pe = ProcessEngineUtils.getProcessEngine();
		/** 获取仓储服务业务对象 */
		RepositoryService rs = pe.getRepositoryService();
		/** 创建部署查询对象 */
		DeploymentQuery dq = rs.createDeploymentQuery();
		
		/** 根据部署时间进行排序查询得到List集合 */
		List<Deployment> deployements = dq.orderByDeploymenTime().asc().list();
		req.setAttribute("deployements", deployements);
		
		req.getRequestDispatcher("/processDeployment.jsp").forward(req, res);
	}
}
