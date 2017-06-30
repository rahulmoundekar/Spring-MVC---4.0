package com.excel.apps.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static final String fileName = "D:\'Workspace\'MavenSpring-IOC\'GSK-WritingExcelSheet_24_04_17\'WriteExcelSheet.xlsx";
	public static final String newFilename = fileName.replace("\'", "/");

	@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args) {
		
		try{
			
			FileInputStream excelFile= new FileInputStream(new File(newFilename));
			
			Workbook workbook= new XSSFWorkbook(excelFile);
			
			Sheet dataSheet=workbook.getSheetAt(0);
			Iterator<Row> iterator= dataSheet.iterator();
				while(iterator.hasNext()){
					Row currentRow=iterator.next();
					Iterator<Cell> cellIterator =currentRow.iterator();
					while(cellIterator.hasNext()){
						Cell currentCell=cellIterator.next();
						 if (currentCell.getCellTypeEnum() == CellType.STRING) {
		                        System.out.print(currentCell.getStringCellValue() + "-+-");
		                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
		                        System.out.print(currentCell.getNumericCellValue() + "--");
		                    }
					}
					System.out.println();
				}
		}catch(FileNotFoundException f) {
			
		}
		catch(IOException e){
			
		}
	}

}
