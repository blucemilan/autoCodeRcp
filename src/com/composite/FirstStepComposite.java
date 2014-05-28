package com.composite;

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

import com.utils.CommonData;
import com.utils.Core;
import com.utils.Utils;
@SuppressWarnings({"unused", "unchecked", "rawtypes"})
public class FirstStepComposite extends Composite {
	private int height = 20;
	// 工程路径
	private Text text_projectPath;
	private Label label_projectPath;
	// 页面类型
	private Combo combo_pageType;
	private Label label_pageType;
	// 页面源码
	private Text text_pageSrc;
	private Label label_pageSrc;
	// 页面类路径
	private Text text_pageClassPath;
	private Label label_pageClassPath;
	// 页面类路径->是否覆盖文件
	private Combo combo_pageClassIsOverLoad;
	private Label label_pageClassIsOverLoad;
	// 服务类路径
	private Text text_serviceClassPath;
	private Label label_serviceClassPath;
	// 服务类路径->是否覆盖文件
	private Combo combo_serviceClassIsOverLoad;
	private Label label_serviceClassIsOverLoad;
	// 测试类路径
	private Text text_tcClassPath;
	private Label label_tcClassPath;
	// 测试类路径->是否覆盖文件
	private Combo combo_tcClassIsOverLoad;
	private Label label_tcClassIsOverLoad;
	// 测试类方法
	private Text text_testMethod;
	private Label label_testMethod;
	// 服务类测试方法
	private Text text_serviceMethod;
	private Label label_serviceMethod;
	// 所有控件类型
	private Label label_allControl;
	private List<Button> list_AllControlType = new ArrayList<Button>();
	// setData包含的控件类型
	private Label label_setDataControl;
	private List<Button> list_setDataControlType = new ArrayList<Button>();
	// 提交按钮的控件类型
	private Label label;
	private List<Button> list_submitBtnType = new ArrayList<Button>();
	//按钮
	private Button button_analysis;
	private Button button_reset;
	//外框
	private Group group_firststep;
	private List isOverLoadList = new ArrayList();
	private List pageTypeList = new ArrayList();
	
	public void initData(){
		isOverLoadList.add(Utils.ISOVERLOAD_YES);
		isOverLoadList.add(Utils.ISOVERLOAD_NO);
		isOverLoadList.add(Utils.ISOVERLOAD_NOTCREATE);
		pageTypeList.add("add");
		pageTypeList.add("edit");
		pageTypeList.add("view");
		pageTypeList.add("search");
	}
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public FirstStepComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(null);
		initData();
		group_firststep = Core.initGroup(this, "源信息", SWT.NONE, 10, 10, 1000, 2000);
		
//		工程路径			
		label_projectPath = Core.initLabelControl(group_firststep, "工程Src路径  ：", 30, height, 140, 17);
		text_projectPath = Core.initTextControl(group_firststep, Utils.FIRSTSTEP_INIT_PROJECTPATH, SWT.BORDER, true, 190, height, 300, 23);
//		页面类型
		label_pageType = Core.initLabelControl(group_firststep, "页面类型：", 480, height, 140, 17);
		combo_pageType = Core.initComboControl(group_firststep, pageTypeList, null, 640, height, 100, 23);		
		addHeight();
//		页面源码
		label_pageClassPath = Core.initLabelControl(group_firststep, "页面源码  ：", 30, height, 140, 17);
		text_pageSrc = Core.initTextControl(group_firststep, "", SWT.MULTI | SWT.V_SCROLL | SWT.BORDER, true, 190, height, 750, 300);
		addHeight(330);
//		setData方法名称 	
		label_serviceMethod = Core.initLabelControl(group_firststep, "服务类方法名称 ：", 30, height, 140, 17);
		text_serviceMethod = Core.initTextControl(group_firststep, Utils.SERVICE_METHODNAME, SWT.BORDER, true, 190, height, 300, 23);
//		测试方法	
		label_testMethod = Core.initLabelControl(group_firststep, "测试类方法 ：", 480, height, 140, 17);
		text_testMethod = Core.initTextControl(group_firststep, Utils.FIRSTSTEP_INIT_TESTMETHOD, SWT.BORDER, true, 640, height, 300, 23);
		addHeight();
//		页面类路径	
		label_pageClassPath = Core.initLabelControl(group_firststep, "页面类路径  ：", 30, height, 140, 17);
		text_pageClassPath = Core.initTextControl(group_firststep, Utils.FIRSTSTEP_INIT_PAGECLASSPATH, SWT.BORDER, true, 190, height, 300, 23);
// 		页面类路径->是否覆盖文件	
		label_pageClassIsOverLoad = Core.initLabelControl(group_firststep, "是否覆盖文件  ：", 480, height, 140, 17);
		combo_pageClassIsOverLoad = Core.initComboControl(group_firststep, isOverLoadList, Utils.PAGECLASSISOVERLOAD, 640, height, 100, 23);
		addHeight();
//		服务类路径	
		label_serviceClassPath = Core.initLabelControl(group_firststep, "服务类路径 ：", 30, height, 140, 17);
		text_serviceClassPath = Core.initTextControl(group_firststep, Utils.FIRSTSTEP_INIT_SERVICECLASSPATH, SWT.BORDER, true, 190, height, 300, 23);
// 		服务类路径->是否覆盖文件	
		label_serviceClassIsOverLoad = Core.initLabelControl(group_firststep, "是否覆盖文件  ：", 480, height, 140, 17);
		combo_serviceClassIsOverLoad = Core.initComboControl(group_firststep, isOverLoadList, Utils.SERVICECLASSISOVERLOAD, 640, height, 100, 23);
		addHeight();
//		测试类路径	
		label_tcClassPath = Core.initLabelControl(group_firststep, "测试类路径 ：", 30, height, 140, 17);
		text_tcClassPath = Core.initTextControl(group_firststep, Utils.FIRSTSTEP_INIT_TCCLASSPATH, SWT.BORDER, true, 190, height, 300, 23);
// 		测试类路径->是否覆盖文件	
		label_tcClassIsOverLoad = Core.initLabelControl(group_firststep, "是否覆盖文件  ：", 480, height, 140, 17);
		combo_tcClassIsOverLoad = Core.initComboControl(group_firststep, isOverLoadList, Utils.TCCLASSISOVERLOAD, 640, height, 100, 23);
		addHeight();
//		所有控件类型			
		label_allControl = Core.initLabelControl(group_firststep, "所有控件类型 ：", 30, height, 140, 17);
		genControl(group_firststep, Utils.ALLCONTROL, Utils.ALLCONTROL_CHECKED, 190, 50, height, list_AllControlType);
		addHeight();
//		setData包含的控件类型			
		label_setDataControl = Core.initLabelControl(group_firststep, "setData包含的控件类型 ：", 30, height, 140, 17);
		genControl(group_firststep, Utils.SETDATA, Utils.SETDATA_CHECKED, 190, 50, height, list_setDataControlType);
		addHeight();
//		提交按钮的控件类型	
		label_setDataControl = Core.initLabelControl(group_firststep, "提交按钮的控件类型 ：", 30, height, 140, 17);
		genControl(group_firststep, Utils.SUBMITCONTROL, Utils.SUBMITCONTROL_CHECKED, 190, 50, height, list_submitBtnType);	
		addHeight(40);
//		按钮
		button_analysis = Core.initBtnControl(group_firststep, "分析", SWT.NONE, 400, height, 61, 25);
		button_reset = Core.initBtnControl(group_firststep, "重置", SWT.NONE, 600, height, 61, 25);
	}
	
	//生成控件过滤条件
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void genControl(Group group, String controls, String controls_checked, int widthStart, int width, int height, List<Button> listContain){
		String[] control = Core.dealString(controls).split(";");
		String control_checked = controls_checked;
		Button checkbox = null;
		for(int i=0;i<control.length;i++){
			checkbox = new Button(group, SWT.CHECK);
			if(control_checked.indexOf(control[i])!=-1){
				checkbox.setSelection(true);
			}
			checkbox.setText(control[i]);
			checkbox.setBounds(widthStart + width*i, height, width, 23);
			listContain.add(checkbox);
		}
	}
	
	private void addHeight(){
		height += 30;
	}
	
	private void addHeight(int increment){
		height += increment;
	}	

	public Combo getCombo_pageClassIsOverLoad() {
		return combo_pageClassIsOverLoad;
	}

	public Combo getCombo_serviceClassIsOverLoad() {
		return combo_serviceClassIsOverLoad;
	}

	public Combo getCombo_tcClassIsOverLoad() {
		return combo_tcClassIsOverLoad;
	}

	public Text getText_pageSrc() {
		return text_pageSrc;
	}

	public Text getText_pageClassPath() {
		return text_pageClassPath;
	}

	public Text getText_serviceClassPath() {
		return text_serviceClassPath;
	}

	public Text getText_tcClassPath() {
		return text_tcClassPath;
	}

	public Text getText_testMethod() {
		return text_testMethod;
	}

	public Text getText_projectPath() {
		return text_projectPath;
	}

	public Button getButton_analysis() {
		return button_analysis;
	}

	public Button getButton_reset() {
		return button_reset;
	}
	public Group getGroup_firststep() {
		return group_firststep;
	}
	public List<Button> getList_AllControlType() {
		return list_AllControlType;
	}
	public List<Button> getList_setDataControlType() {
		return list_setDataControlType;
	}
	public List<Button> getList_submitBtnType() {
		return list_submitBtnType;
	}

	public Text getText_serviceMethod() {
		return text_serviceMethod;
	}
	public Combo getCombo_pageType() {
		return combo_pageType;
	}
	
}
