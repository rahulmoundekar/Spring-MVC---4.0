package com.excel.apps.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.excel.apps.model.StoreData;
import com.excel.apps.model.UploadItem;
import com.excel.apps.service.ExcelService;

@Controller
public class AppController {

	@Autowired
	ExcelService excelService;

	private String saveDirectory = "E:/upload/";

	@RequestMapping(value = "/index")
	public String redirect(Model model) {
		System.out.println("in controller");

		model.addAttribute("uploadItem", new UploadItem());
		return "UploadForm";
	}

	@SuppressWarnings("resource")
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String upload(HttpServletRequest request,
			@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {

		System.out.println("in upload");

		System.out.println("description: "
				+ request.getParameter("description"));

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				if (!aFile.getOriginalFilename().equals("")) {
					UploadItem uploadItem = new UploadItem();
					uploadItem.setFile(aFile.getOriginalFilename());

					System.out.println("Saving file:--> "
							+ uploadItem.getFile());
					/*
					 * UploadItem b = excelService.saveFileName(uploadItem);
					 */
					aFile.transferTo(new File(saveDirectory
							+ aFile.getOriginalFilename()));
					final String fileName = saveDirectory + ""
							+ aFile.getOriginalFilename() + "";
					final String newFilename = fileName.replace("\'", "/");
					FileInputStream excelFile = new FileInputStream(new File(
							newFilename));
					Workbook workbook = new XSSFWorkbook(excelFile);
					Sheet dataSheet = workbook.getSheetAt(0);
					List<StoreData> list = new ArrayList<StoreData>();
					for (Row row : dataSheet) {
						if (row.getRowNum() != 0) {
							StoreData data = new StoreData();
							DataFormatter formatter = new DataFormatter();
							data.setProjectName(formatter.formatCellValue(row
									.getCell(0)));
							data.setAssignedTask(formatter.formatCellValue(row
									.getCell(1)));
							data.setTaskDate(formatter.formatCellValue(row
									.getCell(2)));
							data.setAllocatedHrs(formatter.formatCellValue(row
									.getCell(3)));
							data.setActualHrs(formatter.formatCellValue(row
									.getCell(4)));
							data.setExtraHrs(formatter.formatCellValue(row
									.getCell(5)));
							data.setRemark(formatter.formatCellValue(row
									.getCell(6)));
							list.add(data);
						}
					}

					for (StoreData data : list) {
						System.out.println("in controller-->"
								+ data.getProjectName());
					}
					excelService.saveExcel(list);
				}
			}
		}
		return "Result";
	}

	@RequestMapping(value = "/retrive")
	public String getData(Model model) {
		System.out.println("!!! in getController !!!");
		List<StoreData> list = excelService.getList();
		model.addAttribute("list", list);
		return "excelView";
	}

}
