package com.rest.ex.model;

import java.util.List;

import com.rest.ex.entity.Group;

public interface IGroupService {
	public void insertData();
	public Group retrieveData(int grp);
	public List<Group> retrieveAll();
	public void updateData(Group group);
	public void deleteData();
	
	
}
