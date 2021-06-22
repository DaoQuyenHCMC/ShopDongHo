package Casio.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Casio.Dao.SanPhamDao;
import Casio.Models.SanPhamEntity;
import Casio.Models.UsersEntity;

/**
 * Servlet implementation class SanPhamServlet
 */

public class SanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanPhamDao SanPhamDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		SanPhamDao = new SanPhamDao();
	}

	public SanPhamServlet() {
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
		SP(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SP(request, response);
	}

	protected void SP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		try {
			switch (action) {
			case "new":
				showNewFormInserSanPham(request, response);
				break;
			case "insert":
				insertSanPham(request, response);
				break;
			case "delete":
				deleteSanPham(request, response);
				break;
			case "edit":
				showEditFormSanPham(request, response);
				break;
			case "update":
				updateSanPham(request, response);
				break;
			case "buy":
				listMuaSanPham(request, response);
				break;
			case "sanpham":
				SanPham(request, response);
				break;
			default:
				listSanPham(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	private void listSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			UsersEntity user = (UsersEntity) session.getAttribute("user");
			if (user == null || user.getAllowed() != 1) {
				session.invalidate();
				response.sendRedirect("error/errorShoppingContinue.html");
				return;
			}
			List<SanPhamEntity> listOfSanPham = SanPhamDao.getAllSanPham();
			request.setAttribute("listOfSanPham", listOfSanPham);
			RequestDispatcher dispatcher = request.getRequestDispatcher("View/SanPhams/sanpham-list.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}

	}

	private void listMuaSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			UsersEntity user = (UsersEntity) session.getAttribute("user");
			if (user == null) {
				session.invalidate();
				response.sendRedirect("error/errorShoppingContinue.html");
				return;
			}
			List<SanPhamEntity> listOfSanPham = SanPhamDao.getAllSanPham();
			request.setAttribute("listOfSanPham", listOfSanPham);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Cart/productshow.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
	}

	private void SanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			UsersEntity user = (UsersEntity) session.getAttribute("user");
			if (user == null) {
				session.invalidate();
				response.sendRedirect("error/errorShoppingContinue.html");
				return;
			}
			List<SanPhamEntity> listOfSanPham = SanPhamDao.getAllSanPham();
			request.setAttribute("listOfSanPham", listOfSanPham);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Cart/listsanpham.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
	}

	private void showNewFormInserSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			UsersEntity user = (UsersEntity) session.getAttribute("user");
			if (user == null || user.getAllowed() != 1) {
				session.invalidate();
				response.sendRedirect("error/errorShoppingContinue.html");
				return;
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("View/SanPhams/sanpham-form.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
	}

	private void showEditFormSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			UsersEntity user = (UsersEntity) session.getAttribute("user");
			if (user == null || user.getAllowed() != 1) {
				session.invalidate();
				response.sendRedirect("error/errorShoppingContinue.html");
				return;
			}
			String maSp = request.getParameter("maSp");
			SanPhamEntity existingSanPham = SanPhamDao.getSanPham(maSp);
			RequestDispatcher dispatcher = request.getRequestDispatcher("View/SanPhams/sanpham-form.jsp");
			request.setAttribute("sanpham", existingSanPham);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
	}

	private void insertSanPham(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		HttpSession session = request.getSession();
		try {
			UsersEntity user = (UsersEntity) session.getAttribute("user");
			if (user == null || user.getAllowed() != 1) {
				session.invalidate();
				response.sendRedirect("error/errorShoppingContinue.html");
				return;
			}
			String maSp = request.getParameter("maSp");
			String maLoai = request.getParameter("maLoai");
			String giaStr = request.getParameter("gia");
			String soLuongKhoStr = request.getParameter("soLuongKho");
			String soLuongBanStr = request.getParameter("soLuongBan");
			String hinh = request.getParameter("hinh");
			String tinhNang = request.getParameter("tinhNang");
			String moTa = request.getParameter("moTa");

			Timestamp ngayThem = new Timestamp(System.currentTimeMillis());

			Map<String, String> errors = new HashMap<String, String>();
			maSp = (maSp == null) ? "" : maSp;
			if (maSp.length() == 0) {
				errors.put("maSp", "Không được để trống");
			} else if (maSp.length() > 30) {
				errors.put("maSp", "Phải có nhiều nhất 30 ký tự");
			}

			BigDecimal gia = new BigDecimal(0);
			try {
				gia = new BigDecimal(giaStr);
			} catch (NumberFormatException e) {
				errors.put("gia", e.getMessage());
			}

			int soLuongKho = 0;
			try {
				soLuongKho = Integer.parseInt(soLuongKhoStr);
				if (soLuongKho < 0) {
					throw new NumberFormatException("Phải lớn hơn hoặc bằng 0");
				}
			} catch (NumberFormatException e) {
				errors.put("soLuongKho", e.getMessage());
			}

			int soLuongBan = 0;
			try {
				soLuongBan = Integer.parseInt(soLuongBanStr);
				if (soLuongBan < 0) {
					throw new NumberFormatException("Phải lớn hơn hoặc bằng 0");
				}
			} catch (NumberFormatException e) {
				errors.put("soLuongBan", e.getMessage());
			}
			
			
			List<SanPhamEntity> listsp =  SanPhamDao.getAllSanPham();
			for (SanPhamEntity spEntity : listsp) {
				if (spEntity.getMaSp().equals(maSp)) {
					errors.put("maSp", "Mã sản phẩm đã tồn tại");
				}
			}

			if (!errors.isEmpty()) {
				request.setAttribute("error", errors);
				try {
					showNewFormInserSanPham(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}

			SanPhamEntity newSanPham = new SanPhamEntity(maSp, gia, ngayThem, soLuongKho, soLuongBan, hinh.trim(),
					tinhNang, moTa, maLoai);
			SanPhamDao.saveSanPham(newSanPham);
			response.sendRedirect("SanPham");
		} catch (Exception e) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
	}

	private void updateSanPham(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		HttpSession session = request.getSession();
		try {
			UsersEntity user = (UsersEntity) session.getAttribute("user");
			if (user == null || user.getAllowed() != 1) {
				session.invalidate();
				response.sendRedirect("error/errorShoppingContinue.html");
				return;
			}
			String maSp = request.getParameter("maSp");
			String maLoai = request.getParameter("maLoai");
			String giaStr = request.getParameter("gia");
			String soLuongKhoStr = request.getParameter("soLuongKho");
			String soLuongBanStr = request.getParameter("soLuongBan");
			String hinh = request.getParameter("hinh");
			String tinhNang = request.getParameter("tinhNang");
			String moTa = request.getParameter("moTa");

			Timestamp ngayThem = new Timestamp(System.currentTimeMillis());

			Map<String, String> errors = new HashMap<String, String>();
			maSp = (maSp == null) ? "" : maSp;
			if (maSp.length() == 0) {
				errors.put("maSp", "Không được để trống");
			} else if (maSp.length() > 30) {
				errors.put("maSp", "Phải có nhiều nhất 30 ký tự");
			}

			BigDecimal gia = new BigDecimal(0);
			try {
				gia = new BigDecimal(giaStr);
			} catch (NumberFormatException e) {
				errors.put("gia", e.getMessage());
			}

			int soLuongKho = 0;
			try {
				soLuongKho = Integer.parseInt(soLuongKhoStr);
				if (soLuongKho < 0) {
					throw new NumberFormatException("Phải lớn hơn hoặc bằng 0");
				}
			} catch (NumberFormatException e) {
				errors.put("soLuongKho", e.getMessage());
			}

			int soLuongBan = 0;
			try {
				soLuongBan = Integer.parseInt(soLuongBanStr);
				if (soLuongBan < 0) {
					throw new NumberFormatException("Phải lớn hơn hoặc bằng 0");
				}
			} catch (NumberFormatException e) {
				errors.put("soLuongBan", e.getMessage());
			}

			if (!errors.isEmpty()) {
				request.setAttribute("error", errors);
				try {
					showNewFormInserSanPham(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			SanPhamEntity SanPhamUpdate = new SanPhamEntity(maSp, gia, ngayThem, soLuongKho, soLuongBan, hinh.trim(),
					tinhNang, moTa, maLoai);
			SanPhamDao.updateSanPham(SanPhamUpdate);
			response.sendRedirect("SanPham");
		} catch (Exception e) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
	}

	private void deleteSanPham(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		HttpSession session = request.getSession();
		try {
			UsersEntity user = (UsersEntity) session.getAttribute("user");
			if (user == null || user.getAllowed() != 1) {
				session.invalidate();
				response.sendRedirect("error/errorShoppingContinue.html");
				return;
			}
			String maSp = request.getParameter("maSp");
			SanPhamDao.deleteSanPham(maSp);
			response.sendRedirect("SanPham");
		} catch (Exception e) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
	}

}
