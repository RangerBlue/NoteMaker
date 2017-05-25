package com.notemaker.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notemaker.hibernate.util.HibernateUtil;
import com.notemaker.model.Note;
import com.notemaker.model.Users;

public class NoteService {
	public boolean authenticateUser(String userId, String password) {
        //Users user = getUserByUserId(userId);          
       // if(user!=null && user.getUserId().equals(userId) && user.getPassword().equals(password)){
       //     return true;
      //  }else{ 
            return false;
      //  }
    }

    public Note getNoteById(int id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Note note = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Note where id='"+id+"'");
            note = (Note)query.uniqueResult();
            System.out.println(note.getId());
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return note;
    }
    
    public List<Note> getListOfNotes(Users user){
        List<Note> list = new ArrayList<Note>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            if(user.getRole().equals("ADMIN"))
            	list = session.createQuery("from Note where 1=1").list(); 
            else
            	list = session.createQuery("from Note where user_id='"+user.getUserId()+"'").list(); 
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
    
    public boolean save(Note note){
   	 Session session = HibernateUtil.openSession();
   	 if(note.getContent().isEmpty() || note.getTitle().isEmpty())
   		 return false;
   	
   	 Transaction tx = null;	
   	 try {
   		 tx = session.getTransaction();
   		 tx.begin();
   		 session.saveOrUpdate(note);		
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
    
    public boolean delete(Note note){
      	 Session session = HibernateUtil.openSession();
      	// if(isUserExists(user)) return false;	
      	
      	 Transaction tx = null;	
      	 try {
      		 tx = session.getTransaction();
      		 tx.begin();
      		 session.delete(note);;		
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
    
    public boolean update(Note note){
     	 Session session = HibernateUtil.openSession();
     	
     	 Transaction tx = null;	
     	 try {
     		 tx = session.getTransaction();
     		 tx.begin();
     		 System.out.println("tyt"+note.getId());
     		 session.merge(note);
     		 
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
}
