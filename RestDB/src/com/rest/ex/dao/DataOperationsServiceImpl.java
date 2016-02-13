package com.rest.ex.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rest.ex.entity.BillAccount;
import com.rest.ex.entity.BillHistory;
import com.rest.ex.entity.Group;
import com.satya.ws.db.util.EntityManagerUtil;


public class DataOperationsServiceImpl extends EntityManagerUtil implements DataOperationsService{
	
	//private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAService");
    EntityManager entityManager = null;

	@Override
	public void insertData() {
		//entityManager = entityManagerFactory.createEntityManager();
		entityManager=em;
       Group grp = new Group();
        
        grp.setBpa_id(123);
        grp.setBpa_effect_frm_dt(new Date("01-Jan-2015"));
        grp.setBpa_effect_to_dt(new Date("31-Dec-2015"));
        grp.setGroup_Number(1719L);
        
        BillAccount blla1 = new BillAccount();
        
        blla1.setBlla_id(1230);
        blla1.setBlla_effct_frm_dt(new Date("01-Jan-2015"));
        blla1.setBlla_effct_to_dt(new Date("31-Dec-2015"));
        blla1.setBpa_id(123);
        blla1.setName("Praveen");
        
        BillAccount blla2 = new BillAccount();
        blla2.setBlla_id(1231);
        blla2.setBlla_effct_frm_dt(new Date("01-Jan-2015"));
        blla2.setBlla_effct_to_dt(new Date("31-Dec-2015"));
        blla2.setBpa_id(123);
        blla2.setName("Satya");
        
        BillHistory bhi1 = new BillHistory();
        
        bhi1.setBhi_id(12300);
        bhi1.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
        bhi1.setBhi_effct_to_dt(new Date("31-Jan-2015"));
        bhi1.setBlla_id(1230);
        
        BillHistory bhi2 = new BillHistory();
        bhi2.setBhi_id(12310);
        bhi2.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
        bhi2.setBhi_effct_to_dt(new Date("31-Jan-2015"));
        bhi2.setBlla_id(1231);
        
        List<BillHistory> billHistroyList1 = new ArrayList<>();
        billHistroyList1.add(bhi1);
        blla1.setBillHistoryList(billHistroyList1);
        
        List<BillHistory> billHistroyList2 = new ArrayList<>();
        billHistroyList2.add(bhi2);
        blla2.setBillHistoryList(billHistroyList2);
        
        List<BillAccount> billaccountList = new ArrayList<>(); 
        billaccountList.add(blla1);
        billaccountList.add(blla2);
        grp.setBillaccountList(billaccountList);
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(bhi1);
        entityManager.persist(bhi2);
        entityManager.persist(blla1);
        entityManager.persist(blla2);
        entityManager.persist(grp);
	}

	@Override
	public Group retrieveData(int bpa) {
		entityManager = entityManagerFactory.createEntityManager();
		
		Group grp = new Group();
        
        grp.setBpa_id(123);
        grp.setBpa_effect_frm_dt(new Date("01-Jan-2015"));
        grp.setBpa_effect_to_dt(new Date("31-Dec-2015"));
        grp.setGroup_Number(1719L);
        
        BillAccount blla1 = new BillAccount();
        
        blla1.setBlla_id(1230);
        blla1.setBlla_effct_frm_dt(new Date("01-Jan-2015"));
        blla1.setBlla_effct_to_dt(new Date("31-Dec-2015"));
        blla1.setBpa_id(123);
        blla1.setName("Praveen");
        
        BillAccount blla2 = new BillAccount();
        blla2.setBlla_id(1231);
        blla2.setBlla_effct_frm_dt(new Date("01-Jan-2015"));
        blla2.setBlla_effct_to_dt(new Date("31-Dec-2015"));
        blla2.setBpa_id(123);
        blla2.setName("Satya");
        
        BillHistory bhi1 = new BillHistory();
        
        bhi1.setBhi_id(12300);
        bhi1.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
        bhi1.setBhi_effct_to_dt(new Date("31-Jan-2015"));
        bhi1.setBlla_id(1230);
        
        BillHistory bhi2 = new BillHistory();
        bhi2.setBhi_id(12310);
        bhi2.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
        bhi2.setBhi_effct_to_dt(new Date("31-Jan-2015"));
        bhi2.setBlla_id(1231);
        
        List<BillHistory> billHistroyList1 = new ArrayList<>();
        billHistroyList1.add(bhi1);
        blla1.setBillHistoryList(billHistroyList1);
        
        List<BillHistory> billHistroyList2 = new ArrayList<>();
        billHistroyList2.add(bhi2);
        blla2.setBillHistoryList(billHistroyList2);
        
        List<BillAccount> billaccountList = new ArrayList<>(); 
        billaccountList.add(blla1);
        billaccountList.add(blla2);
        grp.setBillaccountList(billaccountList);
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(bhi1);
        entityManager.persist(bhi2);
        entityManager.persist(blla1);
        entityManager.persist(blla2);
        entityManager.persist(grp);
        
		Group result = entityManager.find(Group.class, bpa);
		return result;
	}

	@Override
	public void updateData(Group group) {
		entityManager = entityManagerFactory.createEntityManager();
		Group result = entityManager.find(Group.class, group.getBpa_id());
		entityManager.createQuery(" update Group set bpa_effect_frm_dt='01-FEB-2016' where bpa_id = "+ group.getBpa_id()+" ");
	}

	@Override
	public void deleteData() {
		// TODO Auto-generated method stub
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.createNativeQuery("delete from Group");
		
	}
	
	
	
}
