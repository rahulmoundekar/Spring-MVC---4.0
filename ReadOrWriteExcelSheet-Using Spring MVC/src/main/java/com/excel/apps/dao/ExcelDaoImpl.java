package com.excel.apps.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.excel.apps.model.StoreData;
import com.excel.apps.model.UploadItem;

public class ExcelDaoImpl implements ExcelDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean saveFileName(UploadItem file) {
		Session session = sessionFactory.openSession();
		session.save(file);
		session.beginTransaction().commit();
		return session.beginTransaction().wasCommitted();
	}

	public int saveExcel(List<StoreData> list) {
		Session session = sessionFactory.openSession();
		for (StoreData data : list) {
			try {
				session.save(data);
				session.beginTransaction().commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<StoreData> getList() {
		List<StoreData> list = new ArrayList<StoreData>();
		Session session = sessionFactory.openSession();
		try {
			list = session.createCriteria(StoreData.class).list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
}
