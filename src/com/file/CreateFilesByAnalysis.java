package com.file;

import com.bo.AnalysisBo;

public class CreateFilesByAnalysis {
	//
	public static String createFiles(AnalysisBo analysisBo) {
		String message = "";
		// 创建excel
		if (analysisBo.isDataDriver()) {
			CreateExcel createExcel = new CreateExcel(analysisBo.getExcelFullPath());
			message += createExcel.createExcel(analysisBo.getList_setDataControl());
		}
		message += GenerateCode.createJavaFiles(analysisBo);
		return message;
	}

}
