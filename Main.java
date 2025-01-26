//intially just read operation in this file
// operations are in this file
package com.practice;
import com.practice.entity.CRUD;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class Main{
	public static void main(String[] args){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		CRUD obj =new CRUD();
//READ operation
	  /*try{
	  obj1 = (CRUD) session.load("com.practice.entity.CRUD",1);        ---> lazy loading by load() method cause using proxy object
	  		System.out.println("ID :"+obj1.getId());
			System.out.println("Name :"+obj1.getName());
			System.out.println("Company :"+obj1.getCompany());
			System.out.println("Salary :"+obj1.getSalary());
	  }catch(ObjectNotFoundException e){
	  		System.out.println("Record not found..!");			
	  }
	  */
		obj = (CRUD) session.get("com.practice.entity.CRUD",1);
		
		if(obj!=null){
			System.out.println("ID :"+obj.getId());
			System.out.println("Name :"+obj.getName());
			System.out.println("Company :"+obj.getCompany());
			System.out.println("Salary :"+obj.getSalary());
		}else{
			System.out.println("Record not found..!");			
		}
		
//INSERT or UPDATE
		CRUD obj2 = new CRUD();
		Transaction tx =null;
		try{
		tx = session.beginTransaction();
		//obj2.setId(2);             ---> Id not need to mention because use of generator class in mapping file
		obj2.setName("Tester");
		obj2.setCompany("wipro");
		obj2.setSalary(10000.01);
		session.saveOrUpdate(obj2);
		tx.commit();
		System.out.println("Record inserted Successfully...");
		}catch(Exception e){
			e.printStackTrace();
		}
		
//DELETE 
		//working....
		
		session.close();
	}
}
