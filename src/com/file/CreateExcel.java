package com.file;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.analysisControl.ControlBo;
import com.utils.FileUtils;

public class CreateExcel {
	private String modelPath = "";
	private String outPutFilePath = "";
	private XSSFWorkbook wBook;
	
	public CreateExcel(String outPutFilePath) {
		try{
			this.modelPath = getModelPath();
			this.outPutFilePath = outPutFilePath;
			CreateFile.checkFileExistAndCreateFold(this.outPutFilePath);
			wBook = readModel();
		}catch(Exception e){
		}	
	}

	public String getModelPath(){
		return FileUtils.getPath() + "/model/model.xlsx";
	}
	
	public String createExcel(List<ControlBo> list_setDataControl) {
		String message = "";
		FileOutputStream outputStream = null;
		try{
			XSSFSheet xSheet = wBook.getSheetAt(0);
			createHeadCellWithOutStyle(xSheet, list_setDataControl.size());		
			setCellData(xSheet, list_setDataControl);
			outputStream = new FileOutputStream(this.outPutFilePath);
	        wBook.write(outputStream);   
	        return message;
		}catch(Exception e){
			e.printStackTrace();
			return "生成excel错误！\n";
		}finally{
			if(null!=outputStream){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	public void setCellData(XSSFSheet xSheet, List<ControlBo> list_setDataControl){
		int i = 0;
		for(ControlBo bo : list_setDataControl){
			XSSFCell xCell = xSheet.getRow(i).getCell(0);
			xCell.setCellValue(generaterCellData(bo.getIdentify()));			
			i++;
		}
		xSheet.setColumnWidth(0, 70 * 80);
	}
	
	public String generaterCellData(String data){
		return data;
	}
	
	public void createHeadCellWithOutStyle(XSSFSheet xSheet, int end){
		for(int i=0;i<end;i++){
			XSSFRow currRow = xSheet.createRow(i);
			currRow.createCell(0);
		}	
	}
	
	public XSSFWorkbook readModel() {
		try {
			return new XSSFWorkbook(new FileInputStream(modelPath));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
