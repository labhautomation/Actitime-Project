package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExcelUtilities {
String filepath;
	
	public ExcelUtilities(String filepath){
		this.filepath=filepath;
	}

	public String readData(String sheet, int row, int cell){
		
		String value=null;
		Workbook wb=null;
		
		try
		{
			File file= new File(filepath);
			FileInputStream fis=new FileInputStream(file);
			
			if(filepath.contains(".xslx"))
			{
				wb=XSSFWorkbookFactory.create(fis);
			}
			else if(filepath.contains(".xls"))
			{
				wb=HSSFWorkbookFactory.create(fis);
			}	
			Cell cl = wb.getSheet(sheet).getRow(row).getCell(cell);
			switch(cl.getCellType())
			{
			case STRING:
				value=cl.getStringCellValue();
				break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cl)){
					Date date=cl.getDateCellValue();
					SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
					value=sdf.format(date);
				}
				else{
					long longValue=(long) cl.getNumericCellValue();
					value=Long.toString(longValue);
				}
				break;
			case BOOLEAN:
				value=Boolean.toString(cl.getBooleanCellValue());
				break;
			default:
			System.out.println("Cell format is not matching");
				break;
			}
		}
		catch(IOException e){
			
		}
		
			return value;		
	}

}
