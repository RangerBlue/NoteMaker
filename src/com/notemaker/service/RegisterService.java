package com.notemaker.service;
import java.security.NoSuchAlgorithmException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notemaker.hibernate.util.HibernateUtil;
import com.notemaker.model.Users;

import app.notemaker.security.Cipher;
public class RegisterService {
	
public boolean register(Users user){
	 Session session = HibernateUtil.openSession();
	 try {
		user.setPassword(Cipher.getEncodedString(user.getPassword()));
	} catch (NoSuchAlgorithmException e1) {
		e1.printStackTrace();
	}
	 if(isUserExists(user)) return false;	
	 
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 session.saveOrUpdate(user);		
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 session.close();
	 }	
	 return true;
}

public boolean isUserExists(Users user){
	 if(user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty() || user.getUserId().isEmpty())
		 return true;
	 Session session = HibernateUtil.openSession();
	 boolean result = false;
	 Transaction tx = null;
	 Users u = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Users where userId='"+user.getUserId()+"'");
		 u = (Users)query.uniqueResult();
		 tx.commit();
		 if(u!=null) result = true;
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return result;
}
}