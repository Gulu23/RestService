package com.rest.ex.model;

import com.rest.ex.entity.Group;

public interface IGroupService {
	public void insertData();
	public Group retrieveData(int grp);
	public void updateData(Group group);
	public void deleteData();
	
	
}
