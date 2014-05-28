package com.composite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.analysisControl.AnalysisControl;
import com.analysisControl.ControlBo;
import com.analysisControl.ControlUtils;
import com.bo.AnalysisBo;
import com.bo.FirstStepBo;
import com.file.CreateFilesByAnalysis;
import com.utils.BackgroundUtils;
import com.utils.CommonData;
import com.utils.Core;
import com.utils.Utils;
@SuppressWarnings({"unchecked", "unused"})
public class AnalysisWindows extends ApplicationWindow {
	//一行排列几个数据项
	private static final int num = 7;
	private int lineNum = 0;
	private int height = 20;
	private Composite container;
	private ScrolledComposite sc;
	// 消息
	private Text text_message;
	private Label label_message;
    // 第一步页面对象
	private FirstStepBo firstStepBo;
	// 需要生成的所有控件
	private Label label_allControl;
	private List<Button> list_allControl = new ArrayList<Button>();
	// setData包含的控件
	private Label label_setDataControl;
	private List<Button> list_setDataControl = new ArrayList<Button>();
	// 提交按钮的控件
	private Label label_submitBtn;
	private List<Button> list_submitBtn = new ArrayList<Button>();
	// 数据驱动
	private Button button_data_yes;
	private Button button_data_no;
	private Label label_data;
	//excel路径
	private Text text_projectPath;
	private Text text_PrefixExcelPath;
	private Text text_excelPath;
	private Label label_excelPath;
	//按钮
	private Button button_submit;
	private Button button_close;
	
	private Group group_analysis;
	private Group group_analysisExcel;
	private Group group_analysisResult;
	private AnalysisBo analysisBo;
	/**
	 * Create the application window.
	 */
	public AnalysisWindows(FirstStepBo firstStepBo) {
		super(null);
		setShellStyle(SWT.CLOSE);		
		setFirstStepBo(firstStepBo);
		
	}
	
	//初始化部件
	public void initComposite(Composite parent){
		initApplicationWindow(parent);
		parent.setLayout(new FillLayout());
	    ScrolledComposite sc = new ScrolledComposite(parent, SWT.H_SCROLL| SWT.V_SCROLL);
	    container = new Composite(sc, SWT.NONE);
	    container.setLayout(new FillLayout());
		sc.setContent(container);
	    sc.setExpandHorizontal(true);
	    sc.setExpandVertical(true);
	    sc.setMinSize(1280, 1500);
	    BackgroundUtils.setShallowGrayBackgroundColor(container);
	}
	//初始化group
	public void initGroup(){
		group_analysis = Core.initGroup(container, "筛选出的控件", SWT.BOTTOM | SWT.V_SCROLL, 10, 10, 1280, 1500);
		group_analysisExcel = Core.initGroup(group_analysis, "数据驱动", SWT.TOP, 10, 20, 1280, 60);
		group_analysisResult = Core.initGroup(group_analysis, "分析结果", SWT.TOP, 10, 90, 1280, 1400);
	}
	
	//初始化ApplicationWindow
	public void initApplicationWindow(Composite parent){
		Control[] children = parent.getChildren();
        if (children.length > 0)
        {
            Label label = (Label)children[0];
            label.setVisible(false);
            label.dispose();
        }
	}
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	@SuppressWarnings({ "unused", "static-access" })
	protected Control createContents(Composite parent) {
		//初始化部件
		initComposite(parent);
		//获得分析所得的控件
		AnalysisControl analysisControl = new AnalysisControl();
		analysisBo = analysisControl.returnControlByRequireMent(firstStepBo);
		//初始化group
		initGroup();
//		数据驱动		
		label_data = Core.initLabelControl(group_analysisExcel, "数据驱动：", 20, 20, 100, 17);
		button_data_yes = Core.initRadioControl(group_analysisExcel, "yes", false, 150, 20, 50, 23);
		button_data_no = Core.initRadioControl(group_analysisExcel, "no", true, 200, 20, 50, 23);
//		excel路径
		label_excelPath = Core.initLabelControl(group_analysisExcel, "excel路径：", 480, 20, 140, 17);
		text_projectPath = Core.initTextControl(group_analysisExcel, Core.getProjectPath(analysisBo.getProjectPath()), SWT.BORDER, false, 
				640, 20, 270, 23);
		text_PrefixExcelPath = Core.initTextControl(group_analysisExcel, Utils.EXCEL_PREFIXPATH, SWT.BORDER, false, 910, 20, 70, 23);
		text_excelPath = Core.initTextControl(group_analysisExcel, Utils.EXCEL_PATH, SWT.BORDER, false, 980, 20, 170, 23);
//		消息
		label_message = Core.initLabelControl(group_analysisResult, "消息   ：", 20, height, 100, 17);
		text_message = Core.initTextControl(group_analysisResult, analysisBo.getMessage(), SWT.MULTI | SWT.V_SCROLL | SWT.BORDER, true, 130, height, 1000, 120);
		addHeight(150);
//		需要生成的所有控件	
		label_allControl = Core.initLabelControl(group_analysisResult, "所有控件   ：", 20, height, 100, 17);
		lineNum = genControl(group_analysisResult, 130, 160, height, list_allControl, analysisBo.getList_allControl());
		addHeight(30*lineNum);
//		setData包含的控件	
		label_setDataControl = Core.initLabelControl(group_analysisResult, "setData控件   ：", 20, height, 100, 17);
		lineNum = genControl(group_analysisResult, 130, 160, height, list_setDataControl, analysisBo.getList_setDataControl());
		addHeight(30*lineNum);
//		提交按钮的控件
		label_submitBtn = Core.initLabelControl(group_analysisResult, "提交按钮的控件   ：", 20, height, 100, 17);
		lineNum = genSubmitBtn(group_analysisResult, 130, 160, height, list_submitBtn, analysisBo.getList_submitBtn());
		addHeight(30*lineNum);
//		按钮
		button_submit = Core.initBtnControl(group_analysisResult, "生成文件", SWT.BOTTOM, 400, height, 100, 25);
		button_close = Core.initBtnControl(group_analysisResult, "关闭", SWT.BOTTOM, 700, height, 100, 25);

		createActions();
		
		return container;
	}
	
	//生成控件过滤条件,返回行数
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int genControl(Group group, int widthStart, int width, int heightStart, List<Button> listContain, List<ControlBo> list_Control){
		Button checkbox = null;
		int i = 0;
		for(ControlBo controlBo : list_Control){
			i++;
			checkbox = new Button(group, SWT.CHECK);
			checkbox.setSelection(true);
			checkbox.setText(returnCheckBoxName(controlBo.getIdentifyFlag(), controlBo.getIdentify(), controlBo.getType()));
			checkbox.setData(controlBo);
			checkbox.setBounds(getWidthStart(i, width, widthStart), getHeight(i, heightStart), width, 23);
			if(ControlUtils.radioType.equals(controlBo.getType())){
				checkbox.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
			}else if(ControlUtils.checkboxType.equals(controlBo.getType())){
				checkbox.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
			}
			listContain.add(checkbox);
		}
		return returnLineNum(i);
	}
	//生成控件过滤条件,返回行数
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int genSubmitBtn(Group group, int widthStart, int width, int heightStart, List<Button> listContain, List<ControlBo> list_SubmitBtn){
		Button radio = null;
		int i = 0;
		for(ControlBo controlBo : list_SubmitBtn){
			i++;
			radio = new Button(group, SWT.RADIO);
			if(i==1){
				radio.setSelection(true);
			}
			radio.setText(returnCheckBoxName(controlBo.getIdentifyFlag(), controlBo.getIdentify(), controlBo.getType()));
			radio.setData(controlBo);
			radio.setBounds(getWidthStart(i, width, widthStart), getHeight(i, heightStart), width, 23);
			listContain.add(radio);
		}
		return returnLineNum(i);
	}
	
	/**
	 * Create the actions.
	 */
	private void createActions() {
		// 生成文件按钮
		button_submit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setData();
				submitAction(analysisBo);
			} 
		});
		//	关闭按钮
		button_close.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				exitWindow();
			}
		});
//		数据驱动：是
		button_data_yes.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				text_excelPath.setEnabled(true);
				text_projectPath.setEnabled(true);
			}
		});
//		数据驱动：否
		button_data_no.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				text_excelPath.setEnabled(false);
				text_projectPath.setEnabled(false);
			}
		});
	}
	//赋值
	public void setData(){
		analysisBo.setList_allControl(getSelectedControl(list_allControl));
		analysisBo.setList_setDataControl(getSelectedControl(list_setDataControl));
		analysisBo.setList_submitBtn(getSelectedControl(list_submitBtn));
		analysisBo.setDataDriver(button_data_yes.getSelection());
		analysisBo.setExcelFullPath(text_projectPath.getText() + text_PrefixExcelPath.getText() + text_excelPath.getText());
		analysisBo.setExcelPath(text_excelPath.getText());
	}
	//提交【生成文件】后的action
	public void submitAction(AnalysisBo analysisBo){
		//判断文件类型
		if(checkExcelFormat()){
			String finalMessage = CreateFilesByAnalysis.createFiles(analysisBo);
			if("".equals(finalMessage)){
				MessageDialog.openInformation(container.getShell(), "提醒", "成功生成文件!");
				exitWindow();
			}else{
				MessageDialog.openInformation(container.getShell(), "提醒", finalMessage);
			}
		}else{
			MessageDialog.openInformation(container.getShell(), "提醒", "请检查excel路径是否符合要求！");
		}
	}
	
	public boolean checkExcelFormat(){
		if(button_data_yes.getSelection()){
			String path = text_excelPath.getText();
			if("xlsx".equals(path.substring(path.lastIndexOf(".") + 1))){
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<ControlBo> getSelectedControl(List<Button> list_btn){
		List<ControlBo> result = new ArrayList();
		for(Button btn : list_btn){
			if(btn.getSelection()){
				result.add((ControlBo)btn.getData());
			}
		}
		return result;
	}
	
	
	//返回行数
	public int returnLineNum(int nowNum){
		return (nowNum - 1)/num + 1;
	}

	private void addHeight(){
		height += 30;
	}
	
	private void addHeight(int increment){
		height += increment;
	}
		
	public String returnCheckBoxName(String identifyFlag, String identify, String type){
		return identify + "(" + type + ")";
	}
	//计算每个数据项高度
	public int getHeight(int nowNum, int heightStart){
		return heightStart + 30*((nowNum - 1)/num);
	}
	//计算起始位置
	public int getWidthStart(int nowNum, int width, int widthStart){
		return widthStart + width*((nowNum - 1)%num);
	}

	//关闭页面
	public void exitWindow() {
		this.close();
	}
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	/*public static void main(String args[]) {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					AnalysisWindows window = new AnalysisWindows();
					window.setBlockOnOpen(true);
					window.open();
					Display.getCurrent().dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public FirstStepBo getFirstStepBo() {
		return firstStepBo;
	}
	public void setFirstStepBo(FirstStepBo firstStepBo) {
		this.firstStepBo = firstStepBo;
	}
	public Text getText_message() {
		return text_message;
	}
	public Label getLabel_message() {
		return label_message;
	}
	public Button getButton_submit() {
		return button_submit;
	}
	public Button getButton_close() {
		return button_close;
	}

	public Button getButton_data_yes() {
		return button_data_yes;
	}

	public Text getText_excelPath() {
		return text_excelPath;
	}
	
	
}
