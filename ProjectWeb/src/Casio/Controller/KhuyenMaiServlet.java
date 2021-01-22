package Casio.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Casio.Dao.KhuyenMaiDao;
import Casio.Models.KhuyenMaiEntity;

/**
 * Servlet implementation class KhuyenMaiServlet
 */

public class KhuyenMaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhuyenMaiDao khuyenMaiDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		khuyenMaiDao=new KhuyenMaiDao();
    }
	public KhuyenMaiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		KhuyenMai(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		KhuyenMai(request, response);
	}

	protected void KhuyenMai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) { action = ""; }
		try {
			switch (action) {
			case "new":
				showNewFormInserKhuyenMai(request, response);
				break;
			case "insert":
				insertKhuyenMai(request, response);
				break;
			case "delete":
				deleteKhuyenMai(request, response);
				break;
			case "edit":
				showEditFormKhuyenMai(request, response);
				break;
			case "update":
				updateKhuyenMai(request, response);
				break;
			default:
				listKhuyenMai(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	private void listKhuyenMai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<KhuyenMaiEntity> listOfKhuyenMai = khuyenMaiDao.getAllKhuyenMai();
		request.setAttribute("listOfKhuyenMai", listOfKhuyenMai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/KhuyenMais/khuyenmai-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormInserKhuyenMai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/KhuyenMais/khuyenmai-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormKhuyenMai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int maKm = Integer.parseInt(request.getParameter("maKm"));
		KhuyenMaiEntity existingKhuyenMai = khuyenMaiDao.getKhuyenMai(maKm);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/KhuyenMais/khuyenmai-form.jsp");
		request.setAttribute("khuyenMai", existingKhuyenMai);
		dispatcher.forward(request, response);
	}

	private void insertKhuyenMai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		java.util.Date dayBd = null;
		try {
			dayBd = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("thoigianBd"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.Date dayKt=null;
		try {
			dayKt = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("thoigianKt"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date thoigianBd = new Date(dayBd.getTime());
		Date thoigianKt = new Date(dayKt.getTime());

		KhuyenMaiEntity newKhuyenMai = new KhuyenMaiEntity(thoigianBd, thoigianKt);
		khuyenMaiDao.saveKhuyenMai(newKhuyenMai);
		response.sendRedirect("KhuyenMaiServlet");
	}

	private void updateKhuyenMai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int maKm = Integer.parseInt(request.getParameter("maKm"));
		java.util.Date dayBd = null;
		try {
			dayBd = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("thoigianBd"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.Date dayKt=null;
		try {
			dayKt = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("thoigianKt"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date thoigianBd = new Date(dayBd.getTime());
		Date thoigianKt = new Date(dayKt.getTime());

		KhuyenMaiEntity KhuyenMaiUpdate = new KhuyenMaiEntity(maKm, thoigianBd, thoigianKt);
		khuyenMaiDao.updateKhuyenMai(KhuyenMaiUpdate);
		response.sendRedirect("KhuyenMaiServlet");
	}

	private void deleteKhuyenMai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int maKm = Integer.parseInt(request.getParameter("maKm"));

		khuyenMaiDao.deleteKhuyenMai(maKm);
		response.sendRedirect("KhuyenMaiServlet");
	}

}
