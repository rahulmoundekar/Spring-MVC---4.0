package com.excel.apps.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.web.servlet.view.document.AbstractJExcelView;

import jxl.write.Label;

import com.excel.apps.model.StoreData;

public class ExcelBuilder extends AbstractJExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			WritableWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<StoreData> storeDataList = (List<StoreData>) model.get("list");
		WritableSheet sheet = workbook.createSheet("Java Books", 0);
		sheet.addCell(new Label(0, 0, "Id"));
		sheet.addCell(new Label(1, 0, "Project Name"));
		sheet.addCell(new Label(2, 0, "Assing Task"));
		sheet.addCell(new Label(3, 0, "taskDate"));
		sheet.addCell(new Label(4, 0, "allocatedHrs"));
		sheet.addCell(new Label(5, 0, "extraHrs"));
		sheet.addCell(new Label(6, 0, "actualHrs"));
		sheet.addCell(new Label(7, 0, "remark"));
		int rowCount = 1;
		for (StoreData storeData : storeDataList) {
			sheet.addCell(new Label(0, rowCount, Integer
					.toString((int) storeData.getId())));
			sheet.addCell(new Label(1, rowCount, storeData.getProjectName()));
			sheet.addCell(new Label(2, rowCount, storeData.getAssignedTask()));
			sheet.addCell(new Label(3, rowCount, storeData.getTaskDate()));
			sheet.addCell(new Label(4, rowCount, storeData.getAllocatedHrs()));
			sheet.addCell(new Label(5, rowCount, storeData.getExtraHrs()));
			sheet.addCell(new Label(6, rowCount, storeData.getActualHrs()));
			sheet.addCell(new Label(7, rowCount, storeData.getRemark()));
			rowCount++;
		}
		

	}
}
