package com.utils;

import org.eclipse.osgi.util.NLS;

public class Utils  extends NLS {
	private static final String BUNDLE_NAME = System.getProperty("user.dir")+"\\configuration\\config";
	//private static final String BUNDLE_NAME = "configuration.config";
	
	public static String FIRSTSTEP_INIT_PAGECLASSPATH;
	public static String FIRSTSTEP_INIT_SERVICECLASSPATH;
	public static String FIRSTSTEP_INIT_TCCLASSPATH;
	public static String FIRSTSTEP_INIT_TESTMETHOD;
	public static String FIRSTSTEP_INIT_PROJECTPATH;
	public static String ALLCONTROL;
	public static String ALLCONTROL_CHECKED;
	public static String SETDATA;
	public static String SETDATA_CHECKED;
	public static String SUBMITCONTROL;
	public static String SUBMITCONTROL_CHECKED;
	public static String EXCEL_PATH;
	public static String EXCEL_PREFIXPATH;
	public static String FILE_SUFFIX;
	public static String SERVICE_METHODNAME;
	public static String PAGECLASSISOVERLOAD;
	public static String SERVICECLASSISOVERLOAD;
	public static String TCCLASSISOVERLOAD;
	public static String ISOVERLOAD_YES;
	public static String ISOVERLOAD_NO;
	public static String ISOVERLOAD_NOTCREATE;
	
	private Utils() {
		
	}

	static {
		// initialize resource bundle
		//NLS.initializeMessages(BUNDLE_NAME, Utils.class);
		NLSUtils.load(BUNDLE_NAME, Utils.class);
	}
}
