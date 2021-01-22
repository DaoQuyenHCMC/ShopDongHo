package Casio.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Casio.Models.UsersEntity;
import Casio.Utl.HibernateUtil;


/**
 * CRUD database operations
 * @author DaoQuyen
 *
 */

public class UsersDao {

	/**
	 * Save User
	 * @parma user
	 */
	public void saveUser(UsersEntity user) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//save the student object
			session.save(user);
			//commit transaction
			transaction.commit();
		} catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	/**
	 * Update User
	 * @param user
	 */
	public void updateUser(UsersEntity user) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//save the student object
			session.update(user);
			//commit transaction
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int id) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			
			//Delete a user object
			UsersEntity user=session.get(UsersEntity.class, id);
			if(user!=null) {
				session.delete(user);
				System.out.println("user is deleted");
			}
			//commit transaction
			transaction.commit();
		}catch(Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	/**
	 * Get User By ID
	 * @param id
	 * @return
	 */
	public UsersEntity getUser(int id) {
		Transaction transaction=null;
		UsersEntity user=null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//get an user object
			user=session.get(UsersEntity.class, id);
			//commit transaction
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}
	
	
	/**
	 * Get all Users
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List < UsersEntity > getAllUser(){
		Transaction transaction = null;
        List < UsersEntity > listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listOfUser = session.createQuery("from UsersEntity").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }
}
