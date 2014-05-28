package com.bo;

import java.util.List;

import com.analysisControl.ControlBo;
import com.utils.Core;

public class AnalysisBo {
	private String projectPath;
	private String message;
	private String submitMessage;
	private String testMethod;
	private Boolean pageClassIsOverLoad;
	private Boolean serviceClassIsOverLoad;
	private Boolean tcClassIsOverLoad;
	private String pageClassFullPath;
	private String serviceClassFullPath;
	private String tcClassFullPath;
	private String pageClassPackagePath;
	private String serviceClassPackagePath;
	private String tcClassPackagePath;
	private String excelFullPath;
	private String excelPath;
	private List<ControlBo> list_allControl;
	private List<ControlBo> list_setDataControl;
	private List<ControlBo> list_submitBtn;
	private boolean isDataDriver;
	private String pageExcelPoJoFullPath;
	private String pageExcelPoJoPackagePath;
	private String serviceMethodName;
	private String pageType;
	
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getExcelPath() {
		return excelPath;
	}
	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}
	public String getServiceMethodName() {
		return serviceMethodName;
	}
	public void setServiceMethodName(String serviceMethodName) {
		this.serviceMethodName = serviceMethodName;
	}
	public String getPageClassPackagePath() {
		return pageClassPackagePath;
	}
	public void setPageClassPackagePath(String pageClassPackagePath) {
		this.pageClassPackagePath = pageClassPackagePath;
	}
	public String getServiceClassPackagePath() {
		return serviceClassPackagePath;
	}
	public void setServiceClassPackagePath(String serviceClassPackagePath) {
		this.serviceClassPackagePath = serviceClassPackagePath;
	}
	public String getTcClassPackagePath() {
		return tcClassPackagePath;
	}
	public void setTcClassPackagePath(String tcClassPackagePath) {
		this.tcClassPackagePath = tcClassPackagePath;
	}
	public String getPageExcelPoJoFullPath() {
		return Core.getExcelPoJoFilePath(pageClassFullPath);
	}
	public void setPageExcelPoJoFullPath(String pageExcelPoJoFullPath) {
		this.pageExcelPoJoFullPath = pageExcelPoJoFullPath;
	}
	public String getPageExcelPoJoPackagePath() {
		return Core.getExcelPoJoFileName(pageClassPackagePath);
	}
	public void setPageExcelPoJoPackagePath(String pageExcelPoJoPackagePath) {
		this.pageExcelPoJoPackagePath = pageExcelPoJoPackagePath;
	}
	public boolean isDataDriver() {
		return isDataDriver;
	}
	public void setDataDriver(boolean isDataDriver) {
		this.isDataDriver = isDataDriver;
	}
	public String getProjectPath() {
		return projectPath;
	}
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	public String getSubmitMessage() {
		return submitMessage;
	}
	public void setSubmitMessage(String submitMessage) {
		this.submitMessage = submitMessage;
	}
	public String getExcelFullPath() {
		return excelFullPath;
	}
	public void setExcelFullPath(String excelFullPath) {
		this.excelFullPath = excelFullPath;
	}
	public String getTestMethod() {
		return testMethod;
	}
	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}
	
	public Boolean isPageClassIsOverLoad() {
		return pageClassIsOverLoad;
	}
	public void setPageClassIsOverLoad(Boolean pageClassIsOverLoad) {
		this.pageClassIsOverLoad = pageClassIsOverLoad;
	}
	public Boolean isServiceClassIsOverLoad() {
		return serviceClassIsOverLoad;
	}
	public void setServiceClassIsOverLoad(Boolean serviceClassIsOverLoad) {
		this.serviceClassIsOverLoad = serviceClassIsOverLoad;
	}
	public Boolean isTcClassIsOverLoad() {
		return tcClassIsOverLoad;
	}
	public void setTcClassIsOverLoad(Boolean tcClassIsOverLoad) {
		this.tcClassIsOverLoad = tcClassIsOverLoad;
	}
	public String getPageClassFullPath() {
		return pageClassFullPath;
	}
	public void setPageClassFullPath(String pageClassFullPath) {
		this.pageClassFullPath = pageClassFullPath;
	}
	public String getServiceClassFullPath() {
		return serviceClassFullPath;
	}
	public void setServiceClassFullPath(String serviceClassFullPath) {
		this.serviceClassFullPath = serviceClassFullPath;
	}
	public String getTcClassFullPath() {
		return tcClassFullPath;
	}
	public void setTcClassFullPath(String tcClassFullPath) {
		this.tcClassFullPath = tcClassFullPath;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ControlBo> getList_allControl() {
		return list_allControl;
	}
	public void setList_allControl(List<ControlBo> list_allControl) {
		this.list_allControl = list_allControl;
	}
	public List<ControlBo> getList_setDataControl() {
		return list_setDataControl;
	}
	public void setList_setDataControl(List<ControlBo> list_setDataControl) {
		this.list_setDataControl = list_setDataControl;
	}
	public List<ControlBo> getList_submitBtn() {
		return list_submitBtn;
	}
	public void setList_submitBtn(List<ControlBo> list_submitBtn) {
		this.list_submitBtn = list_submitBtn;
	}
	
}
