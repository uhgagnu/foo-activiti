package cn.sunnyboy.activiti.common;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 流程引擎工具类
 * @date 2016年7月5日 下午5:32:33
 * @version 1.0
 */
public class ProcessEngineUtils {
	/** 定义流程引擎对象 */
	private static ProcessEngine processEngine;
	static{
		/** 创建流程引擎配置信息对象(创建一个独立的流程引擎配置信息对象) */
		ProcessEngineConfiguration pec = ProcessEngineConfiguration
					.createStandaloneProcessEngineConfiguration();
		/** 调用流程引擎配置信息对象中的方法设置配置信息 */
		/** 设置数据库类型 */
		pec.setDatabaseType("mysql");
		/** 
		 * 设置创建数据库表的方式:
		 * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE(true):  如果没有数据库表就会创建表，有的话就不创建，如果是版本升级就会修改
		 * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE(false): 不会创建创建数据库表
		 * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP(create-drop): 每次都会先创建数据库表，再删除
		 */
		pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		/** 设置数据库驱动 */
		pec.setJdbcDriver("com.mysql.jdbc.Driver");
		/** 设置连接数据库的URL */
		pec.setJdbcUrl("jdbc:mysql://localhost:3306/activiti?useUnicode=true&characterEncoding=utf-8");
		/** 设置连接数据库的用户名 */
		pec.setJdbcUsername("root");
		/** 设置连接数据库的密码 */
		pec.setJdbcPassword("root");
		/** 设置流程图节点上的字体 */
		pec.setActivityFontName("宋体");
		/** 设置连接线上面的字体 */
		pec.setLabelFontName("宋体");
		/** 设置xml文件的编码 */
		pec.setXmlEncoding("utf-8");
		
		/** 用流程引擎配置信息对象构建流程引擎 */
		processEngine = pec.buildProcessEngine();
	}
	
	public static ProcessEngine getProcessEngine(){
		return processEngine;
	}
}
