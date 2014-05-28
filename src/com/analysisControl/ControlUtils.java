package com.analysisControl;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ControlUtils {
	//input button、checkbox、file、hidden、image、password、radio、reset、submit、text     
	//pattern
	public static final String inputPattern = "(?<=<([iI][nN][pP][uU][tT] {0,200})).+?(?=>)";//input
	public static final String divPattern = "(?<=<([dD][iI][vV] {0,200})).+?(?=>)";//div
	public static final String hrefPattern = "(?<=<([aA] {0,200})).+?(?=>)";//a
	public static final String buttonPattern = "(?<=<([bB][uU][tT][tT][oO][nN] {0,200})).+?(?=>)";//button
	public static final String imagePattern = "(?<=<([iI][mM][gG] {0,200})).+?(?=>)";//img
	public static final String selectPattern = "(?<=<([sS][eE][lL][eE][cC][tT] {0,200})).+?(?=>)";//select
	public static final String textareaPattern = "(?<=<([tT][eE][xX][tT][aA][rR][eE][aA] {0,200})).+?(?=>)";//textarea
	public static final String iframePattern = "(?<=<([iI][fF][rR][aA][mM][eE] {0,200})).+?(?=>)";//iframe
	public static final String tablePattern = "(?<=<([tT][aA][bB][lL][eE] {0,200})).+?(?=>)";//table
	public static final String idPattern = "(?<=([iI][dD]=[' \"])).+?(?=[' \"])";//id
	public static final String namePattern = "(?<=([nN][aA][mM][eE]=[' \"])).+?(?=[' \"])";//name
	public static final String typePattern = "(?<=([tT][yY][pP][eE]=[' \"])).+?(?=[' \"])";//type
	//type
	public static final String divType = "div";
	public static final String hrefType = "lnk";
	public static final String buttonType = "btn";
	public static final String imageType = "img";
	public static final String selectType = "sel";
	public static final String textareaType = "txa";
	public static final String iframeType = "fra";	
	public static final String textType = "txt";
	public static final String checkboxType = "chk";
	public static final String radioType = "rdo";
	public static final String submitType = "sbt";	
	public static final String inputType = "input";	
	public static final String passWordType = "pwd";
	public static final String hiddenType = "hdn";
	public static final String tableType = "tbl";
	public static final String ID = "ID";	
	public static final String NAME = "Name";	
	public static Map typePatternMap = null;
	
	static{
		typePatternMap = new HashMap();
		typePatternMap.put(divType, divPattern);
		typePatternMap.put(hrefType, hrefPattern);
		typePatternMap.put(buttonType, buttonPattern);
		typePatternMap.put(imageType, imagePattern);
		typePatternMap.put(selectType, selectPattern);
		typePatternMap.put(textareaType, textareaPattern);
		typePatternMap.put(iframeType, iframePattern);
		typePatternMap.put(inputType, inputPattern);
		typePatternMap.put(tableType, tablePattern);
	}
	//input控件中type类型对应值
	public static String dealInputType(String type){
		type = type.toLowerCase();
		if("file".equals(type)){
			return buttonType;
		}else if("password".equals(type)){
			return passWordType;
		}else if("reset".equals(type)){
			return buttonType;
		}else if("button".equals(type)){
			return buttonType;
		}else if("text".equals(type)){
			return textType;
		}else if("radio".equals(type)){
			return radioType;
		}else if("checkbox".equals(type)){
			return checkboxType;
		}else if("submit".equals(type)){
			return submitType;
		}else if("image".equals(type)){
			return imageType;
		}else if("hidden".equals(type)){
			return hiddenType;
		}else {
			return type;
		}
	}
	
	public static String getMethodName(String identify){
		identify = identify.replaceAll("-", "_");
		identify = identify.replaceAll("[( ) .]", "");
		identify = identify.substring(0, 1).toUpperCase() + identify.substring(1);
		return identify;
	}
	
	public static String getFindMethod(String type){
		if(ControlUtils.divType.equals(type)){
			return "findDiv";
		}else if(ControlUtils.hrefType.equals(type)){
			return "findLink";
		}else if(ControlUtils.buttonType.equals(type)){
			return "findButton";
		}else if(ControlUtils.imageType.equals(type)){
			return "findImage";
		}else if(ControlUtils.selectType.equals(type)){
			return "findSel";
		}else if(ControlUtils.textareaType.equals(type)){
			return "findTextArea";
		}else if(ControlUtils.iframeType.equals(type)){
			return "findElement";
		}else if(ControlUtils.textType.equals(type)){
			return "findTextField";
		}else if(ControlUtils.hiddenType.equals(type)){
			return "findElement";
		}else if(ControlUtils.checkboxType.equals(type)){
			return "findCheckBox";
		}else if(ControlUtils.radioType.equals(type)){
			return "findRadioButton";
		}else if(ControlUtils.submitType.equals(type)){
			return "findSubmitButton";
		}else if(ControlUtils.passWordType.equals(type)){
			return "findPasswordField";
		}else if(ControlUtils.tableType.equals(type)){
			return "findTable";
		}else {
			return null;
		}
	}
	public static String getControlObject(String type){
		if(ControlUtils.divType.equals(type)){
			return "IGenericWebDiv";
		}else if(ControlUtils.hrefType.equals(type)){
			return "IGenericWebLink";
		}else if(ControlUtils.buttonType.equals(type)){
			return "IGenericWebButton";
		}else if(ControlUtils.imageType.equals(type)){
			return "IGenericWebImage";
		}else if(ControlUtils.selectType.equals(type)){
			return "IGenericWebSelect";
		}else if(ControlUtils.textareaType.equals(type)){
			return "IGenericWebTextArea";
		}else if(ControlUtils.iframeType.equals(type)){
			return "IGenericWebElement";
		}else if(ControlUtils.textType.equals(type)){
			return "IGenericWebTextField";
		}else if(ControlUtils.checkboxType.equals(type)){
			return "IGenericWebCheckBox";
		}else if(ControlUtils.radioType.equals(type)){
			return "IGenericWebRadioButton";
		}else if(ControlUtils.submitType.equals(type)){
			return "IGenericWebButton";
		}else if(ControlUtils.passWordType.equals(type)){
			return "IGenericWebTextField";
		}else if(ControlUtils.hiddenType.equals(type)){
			return "IGenericWebElement";
		}else if(ControlUtils.tableType.equals(type)){
			return "IGenericWebTable";
		}else {
			return null;
		}
	}
}
