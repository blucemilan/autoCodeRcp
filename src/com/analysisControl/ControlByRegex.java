package com.analysisControl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlByRegex {
	/**
	 * <input ... > type：text、button(1)、checkbox、file、image(1)、password、radio、reset、submit
	 * <div ... >
	 * <a ... >
	 * <button ... >
	 * <img ... >
	 * <select ... >
	 * <textarea ... >
	 * <iframe ... >
	 */
	
	public static void main(String[] args) {
		//analyzeString("<TD class=\"text\"><input name=\"enterprise.zjsys\" id=\"enterprise.zjsys\" type=\"text\" class=\"text\" >"
		//		+ "<123><input  id=\"enterprise.1zjsys\" type='text' class=\"text\" ></TD>");
		analyzeString("123123<input 123  Name='name1' type='file' > 213123<div id = 'aa'>213123</div>");
	}

	@SuppressWarnings("rawtypes")
	public static List<ControlBo> analyzeString(String srcCode) {
		List<ControlBo> controlList = new ArrayList<ControlBo>();
		//对控件头进行解析
		Iterator iter = ControlUtils.typePatternMap.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry entry = (Map.Entry) iter.next(); 
			getAnalyzeSet(srcCode, entry.getValue().toString(), entry.getKey().toString(), controlList);
		}
		return controlList;
	}
	
	public static void getAnalyzeSet(String srcCode, String pattern, String type, List<ControlBo> controlList) {
		// 以下为验证正则表达式是否匹配
		Pattern pat = Pattern.compile(pattern);
		Matcher m = pat.matcher(srcCode);
		while (m.find()){
			ControlBo bo = setControlBo(m.group(), type);
			if(null!=bo){
				controlList.add(bo);
			}		
		}
	}
	
	public static ControlBo setControlBo(String text, String type){
		ControlBo bo = null;
		text = text.replaceAll(" ", "");
		if("input".equals(type)){
			type = getType(text);
		}
		//判断是否有id属性
		String identify = getIdAndName(text, ControlUtils.idPattern);	
		if(null!=identify){
			bo = new ControlBo(ControlUtils.ID, identify, type);
		}else{
			//判断是否有name属性
			identify = getIdAndName(text, ControlUtils.namePattern);
			if(null!=identify){
				bo = new ControlBo(ControlUtils.NAME, identify, type);
			}
		}	
		return bo;
	}
	
	public static String getIdAndName(String text, String pattern){
		Pattern pat = Pattern.compile(pattern);
		Matcher m = pat.matcher(text);
		if(m.find()){
			return m.group();
		}
		return null;
	}
	
	public static String getType(String text){
		Pattern pat = Pattern.compile(ControlUtils.typePattern);
		Matcher m = pat.matcher(text);
		if(m.find()){
			return ControlUtils.dealInputType(m.group());
		}
		return null;
	}
}
