package Casio.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Casio.Models.SanPhamEntity;
import Casio.Utl.HibernateUtil;

public class SanPhamDao {
	public void saveSanPham(SanPhamEntity sanpham) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//save the student object
			session.save(sanpham);
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
	public void updateSanPham(SanPhamEntity sanpham) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//save the student object
			session.update(sanpham);
			//commit transaction
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void deleteSanPham(String id) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			
			//Delete a user object
			SanPhamEntity sanpham=session.get(SanPhamEntity.class, id);
			if(sanpham!=null) {
				session.delete(sanpham);
				System.out.println("sanpham is deleted");
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
	public SanPhamEntity getSanPham(String id) {
		Transaction transaction=null;
		SanPhamEntity sanpham=null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start a transaction
			transaction=session.beginTransaction();
			//get an user object
			sanpham=session.get(SanPhamEntity.class, id);
			//commit transaction
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return sanpham;
	}
	
	
	/**
	 * Get all LoaiSanPham
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List < SanPhamEntity > getAllSanPham(){
		Transaction transaction = null;
        List < SanPhamEntity > listOfSanPham = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listOfSanPham = session.createQuery("from SanPhamEntity").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfSanPham;
    }
}
