package com.rest.ex.dao;

import com.rest.ex.entity.Group;

public interface DataOperationsService {
	public void insertData();
	public Group retrieveData(int grp);
	public void updateData(Group group);
	public void deleteData();
	
	
}
