package com.excel.apps.service;

import java.util.List;

import com.excel.apps.model.StoreData;
import com.excel.apps.model.UploadItem;

public interface ExcelService {
public boolean saveFileName(UploadItem uploadItem);
public int saveExcel(List<StoreData> list);

public List<StoreData>getList();
}
