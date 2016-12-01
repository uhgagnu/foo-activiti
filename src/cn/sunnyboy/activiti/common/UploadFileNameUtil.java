package cn.sunnyboy.activiti.common;

public class UploadFileNameUtil {

	public static String getUploadFileName(String str, String open, String close){
		if (str == null || open == null || close==null) {
			return null;
		}
		int startIndex = str.indexOf(open);
		if (startIndex != -1) {
			int endIndex = str.indexOf(close, startIndex+open.length());
			if (endIndex != -1) {
				return str.substring(startIndex+open.length(), endIndex);
			}
			return null;
		}
		return null;
	}
}
