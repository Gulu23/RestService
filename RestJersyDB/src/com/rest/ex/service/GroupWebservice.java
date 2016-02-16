package com.rest.ex.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.ex.entity.BillAccount;
import com.rest.ex.entity.BillHistory;
import com.rest.ex.entity.Group;
import com.rest.ex.jaxb.BillAccountJaxb;
import com.rest.ex.jaxb.BillHistoryJaxb;
import com.rest.ex.jaxb.GroupJaxb;
import com.rest.ex.model.GroupServiceImpl;
import com.rest.ex.model.IGroupService;

@Path("/GroupService")
public class GroupWebservice {

	@GET
	@Path("/getAllGroups")
	@Produces("application/json")
	public Response getAllGroups() {
		
		//dao.insertData();
		IGroupService grService=new GroupServiceImpl();
		
	List<Group>  grps=	grService.retrieveAll();

	for(Group grp:grps){
	//Group grp =grps.
	GroupJaxb gr =new GroupJaxb();
	gr.setBpa_id(grp.getBpa_id());
	gr.setGroup_Number(grp.getGroup_Number());
	gr.setBpa_effect_frm_dt(gr.getBpa_effect_frm_dt());
	gr.setBpa_effect_to_dt(gr.getBpa_effect_to_dt());
	
	
	List<BillAccountJaxb>billJaxbList=new ArrayList<>();
	
	for(BillAccount blla:grp.getBillaccountList()){
		BillAccountJaxb billJaxb=new BillAccountJaxb();
		billJaxb.setBlla_id(blla.getBlla_id());
		billJaxb.setName(blla.getName());
		billJaxb.setBlla_effct_frm_dt(blla.getBlla_effct_frm_dt());
		billJaxb.setBlla_effct_to_dt(blla.getBlla_effct_to_dt());
		List<BillHistoryJaxb> bhiJaxbList=new ArrayList<>();
		
		for(BillHistory bhi:blla.getBillHistoryList()){
			BillHistoryJaxb bhiJaxb=new BillHistoryJaxb();
			bhiJaxb.setBhi_id(bhi.getBhi_id());
			bhiJaxb.setBlla_id(bhi.getBlla_id());
			bhiJaxb.setBhi_effct_frm_dt(bhi.getBhi_effct_frm_dt());
			bhiJaxb.setBhi_effct_to_dt(bhi.getBhi_effct_to_dt());
			bhiJaxbList.add(bhiJaxb);
		}
		billJaxb.setBillHistoryList(bhiJaxbList);
		billJaxbList.add(billJaxb);
	}
	gr.setBillaccountList(billJaxbList);
	
	
	}
	
	
	return Response.status(200).entity(grps).build();
	}
	
	@GET
	@Path("/getGroup/{id}")
	@Produces("application/json")
	public Response getGroup(@PathParam("id") int id) {
		
		//dao.insertData();
		IGroupService grService=new GroupServiceImpl();
		
		Group grp=	grService.retrieveData(id);

	
	//Group grp =grps.
	GroupJaxb gr =new GroupJaxb();
	gr.setBpa_id(grp.getBpa_id());
	gr.setGroup_Number(grp.getGroup_Number());
	gr.setBpa_effect_frm_dt(gr.getBpa_effect_frm_dt());
	gr.setBpa_effect_to_dt(gr.getBpa_effect_to_dt());
	
	
	List<BillAccountJaxb>billJaxbList=new ArrayList<>();
	
	for(BillAccount blla:grp.getBillaccountList()){
		BillAccountJaxb billJaxb=new BillAccountJaxb();
		billJaxb.setBlla_id(blla.getBlla_id());
		billJaxb.setName(blla.getName());
		billJaxb.setBlla_effct_frm_dt(blla.getBlla_effct_frm_dt());
		billJaxb.setBlla_effct_to_dt(blla.getBlla_effct_to_dt());
		List<BillHistoryJaxb> bhiJaxbList=new ArrayList<>();
		
		for(BillHistory bhi:blla.getBillHistoryList()){
			BillHistoryJaxb bhiJaxb=new BillHistoryJaxb();
			bhiJaxb.setBhi_id(bhi.getBhi_id());
			bhiJaxb.setBlla_id(bhi.getBlla_id());
			bhiJaxb.setBhi_effct_frm_dt(bhi.getBhi_effct_frm_dt());
			bhiJaxb.setBhi_effct_to_dt(bhi.getBhi_effct_to_dt());
			bhiJaxbList.add(bhiJaxb);
		}
		billJaxb.setBillHistoryList(bhiJaxbList);
		billJaxbList.add(billJaxb);
	}
	gr.setBillaccountList(billJaxbList);
	

	
	
	return Response.status(200).entity(gr).build();
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(String track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
		
	}

	
	private String convertDatetoString(Date date){
		String DATE_FORMAT_NOW = "yyyy-MM-dd";
		
		 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		 String stringDate = sdf.format(date );
		    try {
		        Date date2 = sdf.parse(stringDate);
		    } catch(ParseException e){
		     //Exception handling
		    } catch(Exception e){
		     //handle exception
		    }
			return stringDate;
	}
	/*private Group getGroup(){
		
Group grp = new Group();
        
        grp.setBpa_id(123);
        grp.setBpa_effect_frm_dt(new Date("01-Jan-2015"));
        grp.setBpa_effect_to_dt(new Date("31-Dec-2015"));
        grp.setGroup_Number(1719L);
        
        BillAccount blla1 = new BillAccount();
        
        blla1.setBlla_id(1230);
        blla1.setBlla_effct_frm_dt(new Date("01-Jan-2015"));
        blla1.setBlla_effct_to_dt(new Date("31-Dec-2015"));
        blla1.setBpa_id(1023);
        blla1.setName("Praveen");
        
        BillAccount blla2 = new BillAccount();
        blla2.setBlla_id(1231);
        blla2.setBlla_effct_frm_dt(new Date("01-Jan-2015"));
        blla2.setBlla_effct_to_dt(new Date("31-Dec-2015"));
        blla2.setBpa_id(1023);
        blla2.setName("Satya");
        
        BillHistory bhi1 = new BillHistory();
        
        bhi1.setBhi_id(12300);
        bhi1.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
        bhi1.setBhi_effct_to_dt(new Date("31-Jan-2015"));
        bhi1.setBlla_id(123);
        
        BillHistory bhi2 = new BillHistory();
        bhi2.setBhi_id(12310);
        bhi2.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
        bhi2.setBhi_effct_to_dt(new Date("31-Jan-2015"));
        bhi2.setBlla_id(123);
        BillHistory bhi3 = new BillHistory();
        bhi3.setBhi_id(12311);
        bhi3.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
        bhi3.setBhi_effct_to_dt(new Date("31-Jan-2015"));
        bhi3.setBlla_id(123);
        BillHistory bhi4 = new BillHistory();
        bhi4.setBhi_id(12312);
        bhi4.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
        bhi4.setBhi_effct_to_dt(new Date("31-Jan-2015"));
        bhi4.setBlla_id(123);
        
        List<BillHistory> billHistroyList1 = new ArrayList<BillHistory>();
        billHistroyList1.add(bhi1);
        billHistroyList1.add(bhi3);
        blla1.setBillHistoryList(billHistroyList1);
        
        List<BillHistory> billHistroyList2 = new ArrayList<BillHistory>();
        billHistroyList2.add(bhi2);
        billHistroyList2.add(bhi4);
        blla2.setBillHistoryList(billHistroyList2);
        
        List<BillAccount> billaccountList = new ArrayList<BillAccount>(); 
        billaccountList.add(blla1);
        billaccountList.add(blla2);
        grp.setBillaccountList(billaccountList);
		return grp;*/
        
	}

