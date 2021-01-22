package Casio.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Casio.Models.KhuyenMaiEntity;
import Casio.Utl.HibernateUtil;

public class KhuyenMaiDao {
	public void saveKhuyenMai(KhuyenMaiEntity khuyenmai) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//save the student object
			session.save(khuyenmai);
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
	 * Update KhuyenMai
	 * @param KhuyenMai
	 */
	public void updateKhuyenMai(KhuyenMaiEntity khuyenmai) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//save the student object
			session.update(khuyenmai);
			//commit transaction
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void deleteKhuyenMai(int id) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			
			//Delete a user object
			KhuyenMaiEntity khuyenmai=session.get(KhuyenMaiEntity.class, id);
			if(khuyenmai!=null) {
				session.delete(khuyenmai);
				System.out.println("KhuyenMai is deleted");
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
	 * Get KhuyenMai ID
	 * @param id
	 * @return
	 */
	public KhuyenMaiEntity getKhuyenMai(int id) {
		Transaction transaction=null;
		KhuyenMaiEntity khuyenmai=null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//get an user object
			khuyenmai=session.get(KhuyenMaiEntity.class, id);
			//commit transaction
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return khuyenmai;
	}
	
	
	/**
	 * Get all KhuyenMai
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List < KhuyenMaiEntity > getAllKhuyenMai(){
		Transaction transaction = null;
        List < KhuyenMaiEntity > listOfKhuyenMai = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listOfKhuyenMai = session.createQuery("from KhuyenMaiEntity").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
        	e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return listOfKhuyenMai;
    }
}
