package com.rest.ex.jaxb;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)


public class GroupJaxb {
	
	
	private int bpa_id;
	
	private long group_Number;
	
	private Date bpa_effect_frm_dt;
	
	private Date bpa_effect_to_dt;
	
	
	
	private List<BillAccountJaxb> billaccountList;
	
	public GroupJaxb() {
		// TODO Auto-generated constructor stub
	}

	public int getBpa_id() {
		return bpa_id;
	}
	//@XmlElement

	public void setBpa_id(int bpa_id) {
		this.bpa_id = bpa_id;
	}

	public long getGroup_Number() {
		return group_Number;
	}
	//@XmlElement

	public void setGroup_Number(long group_Number) {
		this.group_Number = group_Number;
	}

	public Date getBpa_effect_frm_dt() {
		return bpa_effect_frm_dt;
	}
	//@XmlElement

	public void setBpa_effect_frm_dt(Date bpa_effect_frm_dt) {
		this.bpa_effect_frm_dt = bpa_effect_frm_dt;
	}

	public Date getBpa_effect_to_dt() {
		return bpa_effect_to_dt;
	}
//	@XmlElement

	public void setBpa_effect_to_dt(Date bpa_effect_to_dt) {
		this.bpa_effect_to_dt = bpa_effect_to_dt;
	}

	public List<BillAccountJaxb> getBillaccountList() {
		return billaccountList;
	}
//	@XmlElement

	public void setBillaccountList(List<BillAccountJaxb> billaccountList) {
		this.billaccountList = billaccountList;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return bpa_id+"  "+group_Number+"  "+bpa_effect_frm_dt+"  "+bpa_effect_to_dt+"  "+billaccountList;
	}
	
}
