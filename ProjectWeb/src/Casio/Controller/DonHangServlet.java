package Casio.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Casio.Dao.DonHangDao;
import Casio.Models.ChiTietDonHangEntity;
import Casio.Models.DonHangEntity;
import Casio.Models.UsersEntity;

/**
 * Servlet implementation class DonHangServlet
 */

public class DonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DonHangDao donhangDao;
	private Pattern numberPattern = Pattern.compile("[0-9]");
	private Pattern phonePattern = Pattern.compile("^(\\d){10}$");

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public void init() {
		donhangDao = new DonHangDao();
	}

	public DonHangServlet() {
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
		DonHang(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DonHang(request, response);
	}

	protected void DonHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		try {
			switch (action) {
			case "new":
				showNewFormInserDonHang(request, response);
				break;
			case "insert":
				insertDonHang(request, response);
				break;
			case "delete":
				deleteDonHang(request, response);
				break;
			case "edit":
				showEditFormDonHang(request, response);
				break;
			case "update":
				updateDonHang(request, response);
				break;
			case "lichsumuahang":
				lichSuMuaHang(request, response);
				break;
			default:
				listDonHang(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	private void listDonHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null || user.getAllowed()!=1) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		List<DonHangEntity> listOfdonghang = donhangDao.getAllDonHang();
		request.setAttribute("listOfdonhang", listOfdonghang);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/DonHangs/Donhang-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormInserDonHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null || user.getAllowed()!=1) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/DonHangs/Donhang-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormDonHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null || user.getAllowed()!=1) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		int maDh = Integer.parseInt(request.getParameter("maDh"));
		DonHangEntity existingDonhang = donhangDao.getDonHang(maDh);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/DonHangs/Donhang-form.jsp");
		request.setAttribute("donhang", existingDonhang);
		dispatcher.forward(request, response);
	}

	private void insertDonHang(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		int userId = Integer.parseInt(request.getParameter("userId"));
		String hoTen = request.getParameter("hoTen");
		String diaChi = request.getParameter("diaChi");
		String sdt = request.getParameter("sdt");
		String trangThai = request.getParameter("trangThai");
		long millis = System.currentTimeMillis();
		Date ngaymua = new java.sql.Date(millis);

		Map<String, String> errors = new HashMap<String, String>();
		hoTen = (hoTen == null) ? "" : hoTen;
		if (hoTen.length()==0) {
			errors.put("hoTen", "Không được để trống");
		} else if (numberPattern.matcher(hoTen).find()) {
			errors.put("hoTen", "Không được có chữ số");
		}

		diaChi = (diaChi == null) ? "" : diaChi;
		if (diaChi.length()==0) {
			errors.put("diaChi", "Không được để trống");
		} 

		sdt = (sdt == null) ? "" : sdt;
		if (!phonePattern.matcher(sdt).find()) {
			errors.put("sdt", "Phải có 10 chữ số");
		}

		if (!errors.isEmpty()) {
			request.setAttribute("error", errors);
			try {
				showNewFormInserDonHang(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		DonHangEntity newdonhang = new DonHangEntity(ngaymua, hoTen, diaChi, sdt, trangThai, userId);
		donhangDao.saveDonHang(newdonhang);
		response.sendRedirect("DonHangServlet");
	}

	private void updateDonHang(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null || user.getAllowed()!=1) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		int maDh = Integer.parseInt(request.getParameter("maDh"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String hoTen = request.getParameter("hoTen");
		String diaChi = request.getParameter("diaChi");
		String sdt = request.getParameter("sdt");
		String trangThai = request.getParameter("trangThai");
		BigDecimal tongTien = new BigDecimal(Double.parseDouble(request.getParameter("tongTien")));
		
		long millis = System.currentTimeMillis();
		Date ngaymua = new java.sql.Date(millis);

		Map<String, String> errors = new HashMap<String, String>();
		hoTen = (hoTen == null) ? "" : hoTen;
		if (hoTen.length()==0) {
			errors.put("hoTen", "Không được để trống");
		} else if (numberPattern.matcher(hoTen).find()) {
			errors.put("hoTen", "Không được có chữ số");
		}

		diaChi = (diaChi == null) ? "" : diaChi;
		if (diaChi.length()==0) {
			errors.put("diaChi", "Không được để trống");
		} else if (numberPattern.matcher(diaChi).find()) {
			errors.put("diaChi", "Không được có chữ số");
		}

		sdt = (sdt == null) ? "" : sdt;
		if (!phonePattern.matcher(sdt).find()) {
			errors.put("sdt", "Phải có 10 chữ số");
		}

		if (!errors.isEmpty()) {
			request.setAttribute("error", errors);
			try {
				showEditFormDonHang(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		DonHangEntity donhangUpdate = new DonHangEntity(maDh, ngaymua,tongTien, hoTen, diaChi, sdt, trangThai, userId);
		donhangDao.updateDonHang(donhangUpdate);
		response.sendRedirect("DonHang");
	}

	private void deleteDonHang(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null  || user.getAllowed()!=1) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		int maDh = Integer.parseInt(request.getParameter("maDh"));
		donhangDao.deleteDonHang(maDh);
		response.sendRedirect("DonHang");
	}
	private void lichSuMuaHang(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		List<DonHangEntity> listOfdonghang = donhangDao.getAllDonHang();
		List<DonHangEntity> listdonhang= new ArrayList<DonHangEntity>();
		for (int i = 0; i < listOfdonghang.size(); i++) {
			if(listOfdonghang.get(i).getUserId()==user.getUserId()) {
				listdonhang.add(listOfdonghang.get(i));
			}
		}
		request.setAttribute("listdonhang", listdonhang);
		RequestDispatcher dispatcher = request.getRequestDispatcher("KhachHang/LichSuMuaHang.jsp");
		dispatcher.forward(request, response);	
	}


}
