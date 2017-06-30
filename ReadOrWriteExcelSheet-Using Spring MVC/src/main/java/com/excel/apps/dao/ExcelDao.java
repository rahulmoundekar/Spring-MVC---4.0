package com.excel.apps.dao;

import java.util.List;

import com.excel.apps.model.StoreData;
import com.excel.apps.model.UploadItem;

public interface ExcelDao {
	public boolean saveFileName(UploadItem file);
	public int saveExcel(List<StoreData> list);
	
	public List<StoreData>getList();
}
