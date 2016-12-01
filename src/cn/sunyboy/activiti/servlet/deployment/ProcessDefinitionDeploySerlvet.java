package cn.sunyboy.activiti.servlet.deployment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

import cn.sunnyboy.activiti.common.ProcessEngineUtils;
import cn.sunnyboy.activiti.common.UploadFileNameUtil;

/**
 * 流程定义部署
 * @date 2016年7月5日 下午5:19:28
 * @version 1.0
 */
@WebServlet("/deploy.action")
@MultipartConfig() // 代表Servlet3.0的文件上传
public class ProcessDefinitionDeploySerlvet extends HttpServlet {

	private static final long serialVersionUID = -5427461482480208457L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/** 获取请求参数 */
		String processName = request.getParameter("processName");
		/** 获取文件上传的请求参数 */
		Part part = request.getPart("bpmn");
		String header = part.getHeader("content-disposition");
		System.out.println("..."+part.getName());
		System.out.println("%%%%%"+part.getHeader("content-disposition"));
		System.out.println("文件名:"+UploadFileNameUtil.getUploadFileName(header, "filename=\"", "\""));
		System.out.println("文件上传的大小：" + part.getSize());
		System.out.println("文件的输入流：" + part.getInputStream());
		//System.out.println("文件名：" + part.getSubmittedFileName()); // servlet3.1
		
		/** 获取上传的文件名 */
		String contentDisposition = part.getHeader("content-disposition");
		// form-data; name="bpmn"; filename="MyProcess.bpmn"
		String fileName = contentDisposition.substring(contentDisposition.lastIndexOf("=") + 2, contentDisposition.length() -1);
		System.out.println(fileName);
		
		/** 获取流程引擎 */
		ProcessEngine pe = ProcessEngineUtils.getProcessEngine();
		/** 获取仓储服务 */
		RepositoryService rs = pe.getRepositoryService();
		/** 构建流程部署对象 */
		DeploymentBuilder builder = rs.createDeployment();
		/** 设置name */
		builder.name(processName);
		/** 设置分类 */
		builder.category("工作流部署");
		/** 添加要部署的文件
		 *  第一个参数：流程定义文件的文件名
		 *  第二个参数：流程定义文件的输入流
		 */
		builder.addInputStream(fileName, part.getInputStream());
		/** 部署 */
		builder.deploy();
		
		
		request.getRequestDispatcher("/processDefinitionDeploy.jsp").forward(request, response);
		
	}
}
