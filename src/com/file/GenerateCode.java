package com.file;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import com.analysisControl.ControlBo;
import com.bo.AnalysisBo;
import com.utils.FileUtils;

@SuppressWarnings("unused")
public class GenerateCode {
	private static String pageClass = "com.wonders.pagewrapper.issue.MainPage";
	private static String serviceClass = "com.wonders.service.base.MainPageService";
	private static String testClass = "com.wonders.testcases.issueFields.TC_JIRA_ISSUE_005";
	private static String testMethod = "JIRA_ISSUE_005";
	private static String modelloadPath = getModelPath();

	public static String getModelPath(){
		return FileUtils.getPath() + "vm/";
	}
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		/*// 初始化并取得Velocity引擎
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();
		p.put(Velocity.FILE_RESOURCE_LOADER_PATH, modelloadPath);
		ve.init(p);
		PreContext.genPage(ve, pageClass, "page.vm", null);
		PreContext.genService(ve, serviceClass, pageClass, "service.vm");
		PreContext.genCase(ve, testClass, testMethod, serviceClass, "case.vm");*/
	}

	
	public static String createJavaFiles(AnalysisBo analysisBo) {
		String message = "";
		try{
			// 初始化并取得Velocity引擎
			VelocityEngine ve = new VelocityEngine();
			Properties p = new Properties();
			p.put(Velocity.FILE_RESOURCE_LOADER_PATH, modelloadPath);
			ve.init(p);
			if(!PreContext.genPage(ve, analysisBo, "page.vm")){
				message += "生成页面类失败！\n";
			}
			if(!PreContext.genPageExcelPoJo(ve, analysisBo, "pageData.vm")){
				message += "生成页面数据类失败！\n";
			}
			if(!PreContext.genCase(ve, analysisBo, "case.vm")){
				message += "生成页面用例类失败！\n";
			}
			if(!PreContext.genService(ve, analysisBo, "service.vm")){
				message += "生成页面服务类失败！\n";
			}
			return message;
		}catch(Exception e){
			e.printStackTrace();
			return "生成文件错误";
		}	
	}

}
