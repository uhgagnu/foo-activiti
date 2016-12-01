package cn.sunyboy.activiti.common.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 日期标签处理类
 * @date 2016年7月7日 上午10:28:22
 * @version 1.0
 */
public class DateTag extends SimpleTagSupport {
	/** 定义属性接收标签中的属性 */
	private Long value;
	
	@Override
	public void doTag() throws JspException, IOException {
		// 1小时2分20秒
		StringBuilder str = new StringBuilder();
		if (value > 0){
			/** 计算出秒 */
			long seconds = value / 1000;
			/** 计算出分 */
			long minutes = seconds / 60;
			/** 计算出小时 */
			long hours = minutes / 60;
			
			if (hours > 0){
				str.append(hours + "小时");
			}
			if (minutes > 0){
				str.append((minutes - hours * 60) + "分");
			}
			if (seconds > 0){
				str.append((seconds - minutes * 60) + "秒");
			}
		}else{
			str.append("");
		}
		/** 向当前的jsp页面输出内容 */
		this.getJspContext().getOut().print(str.toString());
	}
	
	/** setter and getter method */
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value == null ? 0 : value;
	}
}
