package Casio.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Casio.Models.DonHangEntity;
import Casio.Utl.HibernateUtil;

public class DonHangDao {
	public void saveDonHang(DonHangEntity donhang) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(donhang);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update KhuyenMai
	 * 
	 * @param KhuyenMai
	 */
	public void updateDonHang(DonHangEntity donhang) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(donhang);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteDonHang(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			DonHangEntity donhang = session.get(DonHangEntity.class, id);
			if (donhang != null) {
				session.delete(donhang);
				System.out.println("donhang is deleted");
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get KhuyenMai ID
	 * 
	 * @param id
	 * @return
	 */
	public DonHangEntity getDonHang(int id) {
		Transaction transaction = null;
		DonHangEntity donhang = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			donhang = session.get(DonHangEntity.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return donhang;
	}

	/**
	 * Get all KhuyenMai
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DonHangEntity> getAllDonHang() {
		Transaction transaction = null;
		List<DonHangEntity> listOfdonhang = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			listOfdonhang = session.createQuery("from DonHangEntity").getResultList();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfdonhang;
	}
}
