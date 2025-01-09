//intially just read operation in this file
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
		CRUD obj =(CRUD) session.get("com.practice.entity.CRUD",1);
		if(obj!=null){
			System.out.println("ID :"+obj.getId());
			System.out.println("Name :"+obj.getName());
			System.out.println("Company :"+obj.getCompany());
			System.out.println("Salary :"+obj.getSalary());
		}else{
			System.out.println("Record not found..!");			
		}
		session.close();
	}
}
