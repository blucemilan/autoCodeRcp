package com.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.analysisControl.ControlBo;

public class Core {
	
	// 如果字符串最后一个字符是";"，则去除
	public static String dealString(String str) {
		if (";".equals(str.substring(str.length() - 1))) {
			return str.substring(0, str.length() - 1);
		}
		return str;
	}
	//生成用于存储excel文件类路径
	public static String getExcelPoJoFilePath(String pageClassPath) {	
		return pageClassPath.substring(0, pageClassPath.lastIndexOf("."))
				+ Utils.FILE_SUFFIX + pageClassPath.substring(pageClassPath.lastIndexOf("."));
	}
	//传入SRC路径返回工程路径
	public static String getProjectPath(String srcPath) {
		if(srcPath.indexOf("\\src")==-1){
			return srcPath;
		}else{
			return srcPath.substring(0, srcPath.indexOf("\\src"));
		}
	}
	//
	public static String getPackage(String packagePath) {	
		return packagePath.substring(0 ,packagePath.lastIndexOf("."));
	}
	public static String dealExcelPath(String excelPath) {	
		if(excelPath.indexOf("\\")==0){
			return excelPath.substring(1);
		}else{
			return excelPath;
		}
	}
	public static String getClassName(String packagePath) {	
		return packagePath.substring(packagePath.lastIndexOf(".") + 1);
	}
		
	//生成用于存储excel文件类名
	public static String getExcelPoJoFileName(String pageClassName) {	
		return pageClassName + Utils.FILE_SUFFIX;
	}
	
	public static String getDefaultExcelModelFilePath() {	
		String url = System.getProperty("user.dir") + "\\model\\model.xlsx";
		return url;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<ControlBo> removeDuplicate(List<ControlBo> duplicateList)   { 
		List<ControlBo> list = new ArrayList<ControlBo>();
		for(ControlBo duplicateBo : duplicateList){
			if(checkDuplicate(list, duplicateBo)){
				list.add(duplicateBo);
			}
		}
	    return list;
	} 
	/**
	 * 没有重复返回true,有重复返回false
	 * @param list
	 * @param duplicateBo
	 * @return
	 */
	public static boolean checkDuplicate(List<ControlBo> list, ControlBo duplicateBo){
		for(ControlBo bo : list){
			if(bo.getIdentify().equals(duplicateBo.getIdentify())&&bo.getIdentifyFlag().equals(duplicateBo.getIdentifyFlag())){
				return false;
			}
		}
		return true;
	}
	
	// 初始化label
	public static Label initLabelControl(Group parentGroup, 
			String name, int widthStart, int heightStart, int width, int height) {
		Label label = new Label(parentGroup, SWT.NONE);
		label.setAlignment(SWT.RIGHT);
		label.setText(name);
		label.setFont(SWTResourceManager.getFont(CommonData.FONTSTYLE,
				CommonData.FONTSIZE, SWT.NORMAL));
		label.setBounds(widthStart, heightStart, width, height);
		return label;
	}

	// 初始化radio
	public static Button initRadioControl(Group parentGroup, 
			String text, boolean selected, int widthStart, int heightStart,
			int width, int height) {
		Button btn = new Button(parentGroup, SWT.RADIO);
		btn.setText(text);
		btn.setFont(SWTResourceManager.getFont(CommonData.FONTSTYLE, CommonData.FONTSIZE, SWT.NORMAL));
		btn.setBounds(widthStart, heightStart, width, height);
		return btn;
	}

	// 初始化text
	public static Text initTextControl(Group parentGroup,
			String initText, int style, boolean enable, int widthStart,
			int heightStart, int width, int height) {
		Text text = new Text(parentGroup, style);
		text.setFont(SWTResourceManager.getFont(CommonData.FONTSTYLE,
				CommonData.FONTSIZE, SWT.NORMAL));
		text.setBounds(widthStart, heightStart, width, height);
		text.setEnabled(enable);
		text.setText(initText);
		return text;
	}

	// 初始化btn
	public static Button initBtnControl(Group parentGroup, String text, int style, int widthStart,
			int heightStart, int width, int height) {
		Button btn = new Button(parentGroup, style);
		btn.setBounds(widthStart, heightStart, width, height);
		btn.setText(text);
		return btn;
	}
	// 初始化group
	public static Group initGroup(Composite parent, String text, int style, int widthStart,
			int heightStart, int width, int height) {
		Group group = new Group(parent, style);
		group.setText(text);
		group.setFont(SWTResourceManager.getFont(CommonData.FONTSTYLE, CommonData.FONTSIZE, SWT.NORMAL));
		group.setBounds(widthStart, heightStart, width, height);
		return group;
	}
	// 初始化Combo
	public static Combo initComboControl(Group parentGroup, List<String> listData, String selected, int widthStart,
			int heightStart, int width, int height) {
		if(null==selected){
			selected = "0";
		}
		Combo combo = new Combo(parentGroup, SWT.READ_ONLY);
		combo.setBounds(widthStart, heightStart, width, height);
		if(null!=listData){
			for(String data : listData){
				combo.add(data);
			}
			combo.select(Integer.parseInt(selected));
		}else{
			combo.add("yes");
			combo.add("no");
			combo.add("not create");
			combo.select(Integer.parseInt(selected));
		}		
		
		return combo;
	}
	
}
