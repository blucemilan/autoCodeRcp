package com.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.bo.FirstStepBo;
import com.composite.AnalysisWindows;
import com.composite.FirstStepComposite;
import com.utils.BackgroundUtils;
import com.utils.Utils;


public class FirstStepView extends ViewPart {
	public static final String ID = "com.view.FirstStepView"; 
	private FirstStepComposite firstStepComposite;
	private AnalysisWindows analysisWindow;
	//private SashForm sashForm;//将空间分隔成多个子空间，是一个容器控件
	
	public FirstStepView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		Composite container = new Composite(parent, SWT.NONE);
		BackgroundUtils.setShallowGrayBackgroundColor(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			ViewForm viewForm = new ViewForm(container, SWT.NONE);
			{
				firstStepComposite = new FirstStepComposite(viewForm, SWT.NONE);
				viewForm.setTopLeft(firstStepComposite);
			}
		}
		createActions();
	}
	/**
	 * Create the actions.
	 */
	private void createActions() {
		// 分析按钮
		firstStepComposite.getButton_analysis().addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// 判断窗口是否打开
					if (analysisWindow != null && analysisWindow.getShell() != null) {
						analysisWindow.getShell().forceActive();
					} else {
						analysisWindow = new AnalysisWindows(getFirstStepData());
						analysisWindow.open();		
						// 设置title名称
						analysisWindow.getShell().setText("分析");
					}
				}
			});
		// 重置按钮
		firstStepComposite.getButton_reset().addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					firstStepComposite.getText_projectPath().setText(Utils.FIRSTSTEP_INIT_PROJECTPATH);
					firstStepComposite.getText_pageSrc().setText("");
					firstStepComposite.getText_pageClassPath().setText(Utils.FIRSTSTEP_INIT_PAGECLASSPATH);
					firstStepComposite.getText_serviceClassPath().setText(Utils.FIRSTSTEP_INIT_SERVICECLASSPATH);
					firstStepComposite.getText_tcClassPath().setText(Utils.FIRSTSTEP_INIT_TCCLASSPATH);
					firstStepComposite.getText_testMethod().setText(Utils.FIRSTSTEP_INIT_TESTMETHOD);
				}
			});
	}
	
	@SuppressWarnings("unchecked")
	public FirstStepBo getFirstStepData(){
		FirstStepBo firstStepBo = new FirstStepBo();
		firstStepBo.setList_AllControlType(getCheckedBox(firstStepComposite.getList_AllControlType()));
		firstStepBo.setList_setDataControlType(getCheckedBox(firstStepComposite.getList_setDataControlType()));
		firstStepBo.setList_submitBtnType(getCheckedBox(firstStepComposite.getList_submitBtnType()));
		firstStepBo.setPageClassPath(firstStepComposite.getText_pageClassPath().getText());
		firstStepBo.setPageSrc(firstStepComposite.getText_pageSrc().getText());
		firstStepBo.setProjectPath(firstStepComposite.getText_projectPath().getText());
		firstStepBo.setServiceClassPath(firstStepComposite.getText_serviceClassPath().getText());
		firstStepBo.setTcClassPath(firstStepComposite.getText_tcClassPath().getText());
		firstStepBo.setTestMethod(firstStepComposite.getText_testMethod().getText());
		firstStepBo.setPageClassIsOverLoad(checkIsOverLoad(firstStepComposite.getCombo_pageClassIsOverLoad()));
		firstStepBo.setServiceClassIsOverLoad(checkIsOverLoad(firstStepComposite.getCombo_serviceClassIsOverLoad()));
		firstStepBo.setTcClassIsOverLoad(checkIsOverLoad(firstStepComposite.getCombo_tcClassIsOverLoad()));
		firstStepBo.setServiceMethodName(firstStepComposite.getText_serviceMethod().getText());
		firstStepBo.setPageType(firstStepComposite.getCombo_pageType().getText());
		return firstStepBo;
	}
	
	public Boolean checkIsOverLoad(Combo combo){
		if(Utils.ISOVERLOAD_YES.equals(combo.getText())){
			return true;
		}else if(Utils.ISOVERLOAD_NO.equals(combo.getText())){
			return false;
		}else{
			return null;
		}
	}
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List getCheckedBox(List<Button> list){
		List result = new ArrayList();
		for(Button btn : list){
			if(btn.getSelection()){
				result.add(btn.getText());
			}
		}
		return result;
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
