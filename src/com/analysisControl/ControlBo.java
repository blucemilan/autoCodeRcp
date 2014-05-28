package com.analysisControl;

public class ControlBo {
	private String identifyFlag;
	private String identify;
	private String type;
	private String methodName;
	private String findMethod;
	private String controlObject;
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getFindMethod() {
		return findMethod;
	}
	public void setFindMethod(String findMethod) {
		this.findMethod = findMethod;
	}
	public String getControlObject() {
		return controlObject;
	}
	public void setControlObject(String controlObject) {
		this.controlObject = controlObject;
	}
	public String getIdentifyFlag() {
		return identifyFlag;
	}
	public void setIdentifyFlag(String identifyFlag) {
		this.identifyFlag = identifyFlag;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public ControlBo(String identifyFlag, String identify, String type) {
		setIdentifyFlag(identifyFlag);
		setIdentify(identify);
		setType(type);
		setMethodName(ControlUtils.getMethodName(identify));
		setFindMethod(ControlUtils.getFindMethod(type));
		setControlObject(ControlUtils.getControlObject(type));
	}
	
}
