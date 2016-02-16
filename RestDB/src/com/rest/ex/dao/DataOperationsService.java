package com.rest.ex.dao;

import java.util.List;

import com.rest.ex.entity.Group;

public interface DataOperationsService {
	public void insertData();
	public Group retrieveData(int grp);
	public void updateData(Group group);
	public void deleteData();
	public List<Group> retrieveAll();
	
	
}
