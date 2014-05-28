package com.analysisControl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.bo.AnalysisBo;
import com.bo.FirstStepBo;
import com.file.CreateFile;
import com.utils.Core;

public class AnalysisControl {
	//分析在第一步页面获得的数据
	public static AnalysisBo returnControlByRequireMent(FirstStepBo firstStepBo){
		AnalysisBo analysisBo = new AnalysisBo();
		analysisBo.setProjectPath(firstStepBo.getProjectPath());
		
		List<ControlBo> allControl = ControlByRegex.analyzeString(firstStepBo.getPageSrc());
		analysisBo.setList_allControl(matchSelectType(allControl, firstStepBo.getList_AllControlType()));
		analysisBo.setList_setDataControl(matchSelectType(allControl, firstStepBo.getList_setDataControlType()));
		analysisBo.setList_submitBtn(matchSelectType(allControl, firstStepBo.getList_submitBtnType()));
		
		analysisBo.setPageClassPackagePath(firstStepBo.getPageClassPath());
		analysisBo.setServiceClassPackagePath(firstStepBo.getServiceClassPath());
		analysisBo.setTcClassPackagePath(firstStepBo.getTcClassPath());
		analysisBo.setPageClassFullPath(getFullPath(firstStepBo.getProjectPath(), firstStepBo.getPageClassPath()));
		analysisBo.setServiceClassFullPath(getFullPath(firstStepBo.getProjectPath(), firstStepBo.getServiceClassPath()));
		analysisBo.setTcClassFullPath(getFullPath(firstStepBo.getProjectPath(), firstStepBo.getTcClassPath()));
		analysisBo.setPageType(firstStepBo.getPageType());
		
		analysisBo.setMessage(generateMessage(analysisBo, analysisFile(analysisBo, firstStepBo)));
		analysisBo.setPageClassIsOverLoad(firstStepBo.isPageClassIsOverLoad());
		analysisBo.setServiceClassIsOverLoad(firstStepBo.isServiceClassIsOverLoad());
		analysisBo.setTcClassIsOverLoad(firstStepBo.isTcClassIsOverLoad());
		analysisBo.setTestMethod(firstStepBo.getTestMethod());
		analysisBo.setServiceMethodName(firstStepBo.getServiceMethodName());
		return analysisBo;
	}
	
	//匹配所有已经选择的类型
	public static List<ControlBo> matchSelectType(List<ControlBo> allControl, List<String> typeList){
		List<ControlBo> controlList = new ArrayList<ControlBo>();
		for(ControlBo controlBo : allControl){
			for(String type : typeList){
				if(type.equals(controlBo.getType())){
					controlList.add(controlBo);
				}
			}
		}
		return Core.removeDuplicate(controlList);
	}
	
	public static String getFullPath(String projectPath, String classPath){
		return CreateFile.outFile(projectPath, classPath);
	}
	
	//分析3个文件是否存在
	public static String analysisFile(AnalysisBo analysisBo, FirstStepBo firstStepBo){
		String fileMessage = "";
		Boolean pageClassIsExist = CreateFile.checkFileExist(analysisBo.getPageClassFullPath());
		fileMessage += generateFileMessage(analysisBo.getPageClassFullPath(), pageClassIsExist, firstStepBo.isPageClassIsOverLoad());
		Boolean serviceClassIsExist = CreateFile.checkFileExist(analysisBo.getServiceClassFullPath());
		fileMessage += generateFileMessage(analysisBo.getServiceClassFullPath(), serviceClassIsExist, firstStepBo.isServiceClassIsOverLoad());
		Boolean tcClassIsExist = CreateFile.checkFileExist(analysisBo.getTcClassFullPath());
		fileMessage += generateFileMessage(analysisBo.getTcClassFullPath(), tcClassIsExist, firstStepBo.isTcClassIsOverLoad());
		return fileMessage;
	}
	
	
	
	//生成文件消息
	public static String generateFileMessage(String filePath, Boolean isExsit, Boolean isOverload){
		StringBuffer message = new StringBuffer();
		if(null!=isOverload){
			message.append(filePath);
			if(null==isExsit){
				message.append("文件格式有误，请输入正确格式");
			}else{
				if(isExsit&&isOverload){
					message.append("已经存在,文件将被覆盖");
				}else if(!isExsit){
					message.append("不存在,文件将被新建");
				}else{
					message.append("已经存在,不进行任何处理");
				}
			}
			message.append("\n");
		}	
		return message.toString();
	}
	
	public static String generateMessage(AnalysisBo analysisBo, String fileMessage){
		StringBuffer message = new StringBuffer();
		message.append(fileMessage);
		message.append("所有控件共有：").append(analysisBo.getList_allControl().size()).append("个\n");
		message.append("setData包含的控件共有：").append(analysisBo.getList_setDataControl().size()).append("个\n");
		message.append("提交按钮的控件共有：").append(analysisBo.getList_submitBtn().size()).append("个\n");	
		return message.toString();
	}
	
	public static String dealProjectPath(String projectPath){
		if(!"\\".equals(projectPath.substring(projectPath.length() - 1))){
			projectPath = projectPath + "\\";
		}
		return null;
	}
	
	
}
