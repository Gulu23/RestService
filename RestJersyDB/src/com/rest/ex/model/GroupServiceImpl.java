package com.rest.ex.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rest.ex.dao.DataOperationsService;
import com.rest.ex.dao.DataOperationsServiceImpl;
import com.rest.ex.entity.BillAccount;
import com.rest.ex.entity.BillHistory;
import com.rest.ex.entity.Group;
import com.satya.ws.db.util.EntityManagerUtil;


public class GroupServiceImpl  implements IGroupService{
	
	//private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAService");
	DataOperationsService dos=new DataOperationsServiceImpl();

	@Override
	public void insertData() {
		//dos=new DataOperationsServiceImpl();
		dos.insertData();
	}

	@Override
	public Group retrieveData(int bpa) {
		//dos=new DataOperationsServiceImpl();
		
		Group result=dos.retrieveData(bpa);
		return result;
	}

	@Override
	public void updateData(Group group) {
		dos.updateData(group);
	}
	@Override
	public void deleteData() {
		// TODO Auto-generated method stub
		dos.deleteData();
		
	}

	@Override
	public List<Group> retrieveAll() {
		List<Group> result=dos.retrieveAll();
		return result;
	}
	
	
	
}
