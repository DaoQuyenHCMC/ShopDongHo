package Casio.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Casio.Models.LoaiSanPhamEntity;
import Casio.Utl.HibernateUtil;



public class LoaiSanPhanDao {
	public void saveLoaiSanPham(LoaiSanPhamEntity loaisanpham) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//save the student object
			session.save(loaisanpham);
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
	public void updateLoaiSanPham(LoaiSanPhamEntity loaisanpham) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//save the student object
			session.update(loaisanpham);
			//commit transaction
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void deleteLoaiSanPham(String id) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			
			//Delete a user object
			LoaiSanPhamEntity loaisanpham=session.get(LoaiSanPhamEntity.class, id);
			if(loaisanpham!=null) {
				session.delete(loaisanpham);
				System.out.println("loaisanpham is deleted");
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
	public LoaiSanPhamEntity getLoaiSanPham(String id) {
		Transaction transaction=null;
		LoaiSanPhamEntity loaisanpham=null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//get an user object
			loaisanpham=session.get(LoaiSanPhamEntity.class, id);
			//commit transaction
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return loaisanpham;
	}
	
	
	/**
	 * Get all LoaiSanPham
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List < LoaiSanPhamEntity > getAllLoaiSanPham(){
		Transaction transaction = null;
        List < LoaiSanPhamEntity > listOfSanPham = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listOfSanPham = session.createQuery("from LoaiSanPhamEntity").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
        	  e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
          
        }
        return listOfSanPham;
    }
}
