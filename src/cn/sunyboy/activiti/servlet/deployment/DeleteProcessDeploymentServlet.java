package cn.sunyboy.activiti.servlet.deployment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;

/**
 * 删除流程部署
 * @date 2016年7月6日 上午10:13:32
 * @version 1.0
 */
@WebServlet("/deleteProcessDeployment.action")
public class DeleteProcessDeploymentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8131739467218760937L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		/** 获取部署id */
		String id = req.getParameter("id");
		/** 获取流程引擎 */
		ProcessEngine pe = ProcessEngineUtils.getProcessEngine();
		/** 获取仓储服务业务对象 */
		RepositoryService rs = pe.getRepositoryService();
		/** 根据流程部署id删除流程部署 */
		rs.deleteDeployment(id, true);
		
		res.sendRedirect(req.getContextPath() + "/queryProcessDeployment.action");
		
	}
}
