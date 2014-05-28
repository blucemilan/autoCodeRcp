package com.file;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.analysisControl.ControlBo;
import com.bo.AnalysisBo;
import com.utils.Core;
import com.utils.DateManage;

public class PreContext {
	/**
	 * 生成页面类
	 * @param ve
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws MethodInvocationException
	 * @throws Exception
	 * @return 返回true为成功，返回false则失败
	 */
	public static boolean genPage(VelocityEngine ve, AnalysisBo analysisBo, String modelFile) {
		try {
			if(null!=analysisBo.isPageClassIsOverLoad()){
				if(!analysisBo.isPageClassIsOverLoad()&&CreateFile.checkFileExist(analysisBo.getPageClassFullPath())){
					//不做任何处理
				}else{
					CreateFile.checkFileExistAndCreateFold(analysisBo.getPageClassFullPath());
					// 取得velocity的上下文context
					VelocityContext context = new VelocityContext();
					// 把数据填入上下文
					context.put("package", Core.getPackage(analysisBo.getPageClassPackagePath()));
					context.put("pageClass", Core.getClassName(analysisBo.getPageClassPackagePath()));
					if(null!=analysisBo){
						context.put("pageList", analysisBo.getList_allControl());
					}
					// 输出流
					StringWriter writer = new StringWriter();
					// 取得velocity的模版
					Template t = ve.getTemplate(modelFile, "utf-8");
					// 转换输出
					t.merge(context, writer);	
					CreateFile.fileOutPut(writer, analysisBo.getPageClassFullPath());
				}
			}		
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	/**
	 * 生成用于存储excel文件类
	 * @param ve
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws MethodInvocationException
	 * @throws Exception
	 * @return 返回true为成功，返回false则失败
	 */
	public static boolean genPageExcelPoJo(VelocityEngine ve, AnalysisBo analysisBo, String modelFile){
		try {
			if(analysisBo.isDataDriver()&&null!=analysisBo.isPageClassIsOverLoad()){
				CreateFile.checkFileExistAndCreateFold(analysisBo.getExcelFullPath());
				// 取得velocity的上下文context
				VelocityContext context = new VelocityContext();
				// 把数据填入上下文
				context.put("package", Core.getPackage(analysisBo.getPageExcelPoJoPackagePath()));
				context.put("pageClass", Core.getClassName(analysisBo.getPageExcelPoJoPackagePath()));
				if(null!=analysisBo.getList_setDataControl()){
					context.put("pageList", analysisBo.getList_setDataControl());
				}
				// 输出流
				StringWriter writer = new StringWriter();
				// 取得velocity的模版
				Template t = ve.getTemplate(modelFile, "utf-8");
				// 转换输出
				t.merge(context, writer);
				CreateFile.fileOutPut(writer, analysisBo.getPageExcelPoJoFullPath());
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 	
	}
	/**
	 * 生成服务类
	 * @param ve
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws MethodInvocationException
	 * @throws Exception
	 * @return 返回true为成功，返回false则失败
	 */
	public static boolean genService(VelocityEngine ve, AnalysisBo analysisBo, String modelFile) {	
		try {
			if(null!=analysisBo.isServiceClassIsOverLoad()){
				if(!analysisBo.isServiceClassIsOverLoad()&&CreateFile.checkFileExist(analysisBo.getServiceClassFullPath())){
					//不做处理
				}else{
					CreateFile.checkFileExistAndCreateFold(analysisBo.getServiceClassFullPath());
					// 取得velocity的上下文context
					VelocityContext context = new VelocityContext();
					// 把数据填入上下文
					context.put("isDataDriver",  analysisBo.isDataDriver());
					context.put("serviceClass", Core.getClassName(analysisBo.getServiceClassPackagePath()));
					context.put("package", Core.getPackage(analysisBo.getServiceClassPackagePath()));
					context.put("pageClassPackage", analysisBo.getPageClassPackagePath());
					context.put("pageClass", Core.getClassName(analysisBo.getPageClassPackagePath()));
					context.put("serviceMethodName", analysisBo.getServiceMethodName());
					if(null!=analysisBo.getList_setDataControl()){
						context.put("pageList", analysisBo.getList_setDataControl());
					}
					if(null!=analysisBo.getList_submitBtn()){
						ControlBo subBtn = analysisBo.getList_submitBtn().get(0);
						context.put("submitBtnType", subBtn.getType());
						context.put("submitBtnmethodName", subBtn.getMethodName());
					}
					context.put("pageType", analysisBo.getPageType());
					String excelDataClassName = Core.getClassName(analysisBo.getPageExcelPoJoPackagePath());
					context.put("excelDataClassName", excelDataClassName);
					context.put("excelDataClassNameVar", convertToVar(excelDataClassName));
					context.put("excelDataClassPackage", Core.getPackage(analysisBo.getPageExcelPoJoPackagePath()));
					// 输出流
					StringWriter writer = new StringWriter();
					// 取得velocity的模版
					Template t = ve.getTemplate(modelFile, "utf-8");
					// 转换输出
					t.merge(context, writer);
					CreateFile.fileOutPut(writer, analysisBo.getServiceClassFullPath());
				}
			}		
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 	
	}
	/**
	 * 生成用例类
	 * @param ve
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws MethodInvocationException
	 * @throws Exception
	 * @return 返回true为成功，返回false则失败
	 */
	public static boolean genCase(VelocityEngine ve, AnalysisBo analysisBo, String modelFile) {
		try{
			if(null!=analysisBo.isTcClassIsOverLoad()){
				if(!analysisBo.isTcClassIsOverLoad()&&CreateFile.checkFileExist(analysisBo.getTcClassFullPath())){
					//不做处理
				}else{
					CreateFile.checkFileExistAndCreateFold(analysisBo.getTcClassFullPath());
					// 取得velocity的上下文context
					VelocityContext context = new VelocityContext();
					// 把数据填入上下文			
					context.put("isDataDriver",  analysisBo.isDataDriver());
					context.put("package",  Core.getPackage(analysisBo.getTcClassPackagePath()));
					context.put("caseClass",  Core.getClassName(analysisBo.getTcClassPackagePath()));
					context.put("caseMethod", analysisBo.getTestMethod());
					context.put("serviceClass", Core.getClassName(analysisBo.getServiceClassPackagePath()));
					context.put("serviceMethodName", analysisBo.getServiceMethodName());
					context.put("servicePackage", analysisBo.getServiceClassPackagePath());
					context.put("excelPath", Core.dealExcelPath(analysisBo.getExcelPath()));
					String excelDataClassName = Core.getClassName(analysisBo.getPageExcelPoJoPackagePath());
					context.put("excelDataClassName", excelDataClassName);
					context.put("excelDataClassNameVar", convertToVar(excelDataClassName));
					context.put("excelDataClassPackage", Core.getPackage(analysisBo.getPageExcelPoJoPackagePath()));
					
					context.put("date", DateManage.getNowTime());
					// 输出流
					StringWriter writer = new StringWriter();
					// 取得velocity的模版
					Template t = ve.getTemplate(modelFile, "utf-8");
					// 转换输出
					t.merge(context, writer);
					CreateFile.fileOutPut(writer, analysisBo.getTcClassFullPath());
				}	
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 	
	}
	public static String convertToVar(String str){
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}
}
