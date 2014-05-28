package com.bo;

import java.util.List;

public class FirstStepBo {
	private String projectPath;
	private String pageSrc;
	private String pageClassPath;
	private String serviceClassPath;
	private String tcClassPath;
	private String testMethod;
	private Boolean pageClassIsOverLoad;
	private Boolean serviceClassIsOverLoad;
	private Boolean tcClassIsOverLoad;
	private List<String> list_AllControlType;
	private List<String> list_setDataControlType;
	private List<String> list_submitBtnType;
	private String serviceMethodName;
	private String pageType;
		
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getServiceMethodName() {
		return serviceMethodName;
	}
	public void setServiceMethodName(String serviceMethodName) {
		this.serviceMethodName = serviceMethodName;
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
	public String getProjectPath() {
		return projectPath;
	}
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	public String getPageSrc() {
		return pageSrc;
	}
	public void setPageSrc(String pageSrc) {
		this.pageSrc = pageSrc;
	}
	public String getPageClassPath() {
		return pageClassPath;
	}
	public void setPageClassPath(String pageClassPath) {
		this.pageClassPath = pageClassPath;
	}
	public String getServiceClassPath() {
		return serviceClassPath;
	}
	public void setServiceClassPath(String serviceClassPath) {
		this.serviceClassPath = serviceClassPath;
	}
	public String getTcClassPath() {
		return tcClassPath;
	}
	public void setTcClassPath(String tcClassPath) {
		this.tcClassPath = tcClassPath;
	}
	public String getTestMethod() {
		return testMethod;
	}
	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}
	public List<String> getList_AllControlType() {
		return list_AllControlType;
	}
	public List<String> getList_setDataControlType() {
		return list_setDataControlType;
	}
	public void setList_setDataControlType(List<String> list_setDataControlType) {
		this.list_setDataControlType = list_setDataControlType;
	}
	public List<String> getList_submitBtnType() {
		return list_submitBtnType;
	}
	public void setList_submitBtnType(List<String> list_submitBtnType) {
		this.list_submitBtnType = list_submitBtnType;
	}
	public void setList_AllControlType(List<String> list_AllControlType) {
		this.list_AllControlType = list_AllControlType;
	}

	
}
