package com.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

public class CreateFile {
	private static String outFilePath = new File("").getAbsolutePath()
			+ "\\src\\main\\java\\";
	private static String fileSuffix = ".java";
	
	public static void fileOutPut(StringWriter writer, String outFile)
			throws UnsupportedEncodingException, IOException {
		// 输出信息
		//System.out.println(writer.toString());
		// 输出到文件
		FileOutputStream of = new FileOutputStream(outFile);
		of.write(writer.toString().getBytes("UTF-8"));
		of.flush();
		of.close();
	}

	public static Boolean checkFileExist(String classFullPath) {
		try{
			File file = new File(classFullPath);
			if (!file.exists()) {	
				return false;
			}else{
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
	
	public static Boolean checkFileExistAndCreateFold(String classFullPath) {
		try{
			File file = new File(classFullPath);
			if (!file.exists()) {
				File foldPath = new File(classFullPath.substring(0, classFullPath.lastIndexOf("\\")));
				if(!foldPath.exists() && !foldPath.isDirectory()){
					foldPath.mkdirs();
				}		
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static String outFile(String packagePath) {
		return outFilePath + packagePath.replace('.', '\\') + fileSuffix;
	}
	
	public static String outFile(String projectPath, String packagePath) {
		if(!"\\".equals(projectPath.substring(projectPath.length()-1))){
			projectPath += "\\";
		}
		return projectPath + packagePath.replace('.', '\\') + fileSuffix;
	}
	
	public static String outFileExcel(String projectPath, String excelPath) {
		if(!"\\".equals(excelPath.substring(0, 1))){
			excelPath = excelPath.substring(1);
		}
		return projectPath + excelPath;
	}
}
