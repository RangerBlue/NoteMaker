package com.notemaker.service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notemaker.hibernate.util.HibernateUtil;
import com.notemaker.model.Users;

public class LoginService {

    public boolean authenticateUser(String userId, String password) {
    	if(userId.isEmpty() || password.isEmpty())
    		return false;
        Users user = getUserByUserId(userId);          
        if(user!=null && user.getUserId().equals(userId) && user.getPassword().equals(password)){
            return true;
        }else{ 
            return false;
        }
    }

    public Users getUserByUserId(String userId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Users user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Users where userId='"+userId+"'");
            user = (Users)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
    
    public List<Users> getListOfUsers(Users user){
        List<Users> list = new ArrayList<Users>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null; 
        try {
            tx = session.getTransaction();
            tx.begin();
            if(user.getRole().equals("ADMIN"))
            	list = session.createQuery("from Users where 1=1").list(); 
            else
            	list = session.createQuery("from Users where userId='"+user.getUserId()+"'").list(); 
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
