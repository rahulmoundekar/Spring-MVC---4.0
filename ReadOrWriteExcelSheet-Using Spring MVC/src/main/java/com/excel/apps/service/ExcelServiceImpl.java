package com.excel.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.excel.apps.dao.ExcelDao;
import com.excel.apps.model.StoreData;
import com.excel.apps.model.UploadItem;

public class ExcelServiceImpl implements ExcelService{

	@Autowired
	ExcelDao excelDao;
	
	public boolean saveFileName(UploadItem file) {
		return excelDao.saveFileName(file);
	}

	public int saveExcel(List<StoreData> list) {
		excelDao.saveExcel(list);
		return 0;
	}

	public List<StoreData> getList() {

		return excelDao.getList();
	}

}
