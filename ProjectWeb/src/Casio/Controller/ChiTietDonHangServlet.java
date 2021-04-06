package Casio.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Casio.Dao.CTKMDao;
import Casio.Dao.ChiTietDonHangDao;
import Casio.Dao.SanPhamDao;
import Casio.Models.ChiTietDonHangEntity;
import Casio.Models.CtkmEntity;
import Casio.Models.SanPhamEntity;

/**
 * Servlet implementation class ChiTietDonHangServlet
 */

public class ChiTietDonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChiTietDonHangDao chitietdonhangDao;
	private SanPhamDao SanPhamDao;
	private CTKMDao ctkmDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		chitietdonhangDao = new ChiTietDonHangDao();
		SanPhamDao = new SanPhamDao();
		ctkmDao = new CTKMDao();
	}

	public ChiTietDonHangServlet() {
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
		ChiTietDonHang(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ChiTietDonHang(request, response);
	}

	protected void ChiTietDonHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		try {
			switch (action) {
			case "new":
				showNewFormInserCTDH(request, response);
				break;
			case "insert":
				insertCTDH(request, response);
				break;
			case "delete":
				deleteCTDH(request, response);
				break;
			case "edit":
				showEditFormCTDH(request, response);
				break;
			case "update":
				updateCTDH(request, response);
				break;
			default:
				listCTDH(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	private void listCTDH(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int maDh = Integer.parseInt(request.getParameter("maDh"));
		List<ChiTietDonHangEntity> listOfctdh = chitietdonhangDao.getAllCTDH();
		List<ChiTietDonHangEntity> listctdh= new ArrayList<ChiTietDonHangEntity>();
		for (int i = 0; i < listOfctdh.size(); i++) {
			if(listOfctdh.get(i).getMaDh().equals(maDh)) {
				listctdh.add(listOfctdh.get(i));
			}
		}
		request.setAttribute("listctdh", listctdh);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ChiTietDonHangs/CTDH-list.jsp");
		dispatcher.forward(request, response);	
		}

	private void showNewFormInserCTDH(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ChiTietDonHangs/CTDH-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormCTDH(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ChiTietDonHangEntity existingCTDH = chitietdonhangDao.getCTDH(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ChiTietDonHangs/CTDH-form.jsp");
		request.setAttribute("ctdh", existingCTDH);
		dispatcher.forward(request, response);
	}

	private void insertCTDH(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		int maDh = Integer.parseInt(request.getParameter("maDh"));
		String maSp = request.getParameter("maSp");
		SanPhamEntity existingSanPham = SanPhamDao.getSanPham(maSp);

		String soLuongStr = request.getParameter("soLuong");

		Map<String, String> errors = new HashMap<String, String>();
		int soLuong = 0;
		try {
			soLuong = Integer.parseInt(soLuongStr);
			if (soLuong < 0) {
				throw new NumberFormatException("Phải lớn hơn hoặc bằng 0");
			}
		} catch (NumberFormatException e) {
			errors.put("soLuong", e.getMessage());
		}

		if (!errors.isEmpty()) {
			request.setAttribute("error", errors);
			try {
				showNewFormInserCTDH(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		double giamuahang = soLuong * Double.parseDouble(existingSanPham.getGia().toString());
		BigDecimal gia = BigDecimal.valueOf(giamuahang);

		ChiTietDonHangEntity newctdh = new ChiTietDonHangEntity(soLuong, gia, maDh, maSp);
		chitietdonhangDao.saveCTDH(newctdh);
		response.sendRedirect("ChiTietDonHangServlet");
	}

	private void updateCTDH(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int maDh = Integer.parseInt(request.getParameter("maDh"));
		String maSp = request.getParameter("maSp");
		SanPhamEntity existingSanPham = SanPhamDao.getSanPham(maSp);

		String soLuongStr = request.getParameter("soLuong");

		Map<String, String> errors = new HashMap<String, String>();
		int soLuong = 0;
		try {
			soLuong = Integer.parseInt(soLuongStr);
			if (soLuong < 0) {
				throw new NumberFormatException("Phải lớn hơn hoặc bằng 0");
			}
		} catch (NumberFormatException e) {
			errors.put("soLuong", e.getMessage());
		}

		if (!errors.isEmpty()) {
			request.setAttribute("error", errors);
			try {
				showEditFormCTDH(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		double giamuahang = soLuong * Double.parseDouble(existingSanPham.getGia().toString());
		BigDecimal gia = BigDecimal.valueOf(giamuahang);
		ChiTietDonHangEntity updatectdh = new ChiTietDonHangEntity(id, soLuong, gia, maDh, maSp);
		chitietdonhangDao.updateCTDH(updatectdh);
		response.sendRedirect("ChiTietDonHangServlet");
	}

	private void deleteCTDH(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		chitietdonhangDao.deleteCTDH(id);
		response.sendRedirect("ChiTietDonHangServlet");
	}

}
