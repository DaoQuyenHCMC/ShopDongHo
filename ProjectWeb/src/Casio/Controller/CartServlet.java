package Casio.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
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


import Casio.Dao.CartDao;
import Casio.Dao.ChiTietDonHangDao;
import Casio.Dao.DonHangDao;
import Casio.Dao.SanPhamDao;
import Casio.Models.CartEntity;
import Casio.Models.ChiTietDonHangEntity;

import Casio.Models.DonHangEntity;
import Casio.Models.SanPhamEntity;
import Casio.Models.UsersEntity;

/**
 * Servlet implementation class CartServlet
 */

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDao cartDao;
	private SanPhamDao SanPhamDao;
	private DonHangDao donhangDao;
	private ChiTietDonHangDao chitietdonhangDao;
	private Pattern numberPattern = Pattern.compile("[0-9]");
	private Pattern phonePattern = Pattern.compile("^(\\d){10}$");

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public void init() {
		cartDao = new CartDao();
		SanPhamDao = new SanPhamDao();
		donhangDao = new DonHangDao();
		chitietdonhangDao = new ChiTietDonHangDao();
	}

	public CartServlet() {
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
		doGet_DisplayCart(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet_DisplayCart(request, response);
	}

	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		try {
			switch (action) {
			case "delete":
				RemoveItem(request, response);
				break;
			case "thanhtoan":
				showNewFormThanhToan(request, response);
				break;
			case "checkthanhtoan":
				ThanhToan(request, response);
				break;
			case "tieptucmuahang":
				TiepTucMuaHang(request, response);
				break;
			default:
				processRequestt(request, response);
				break;
			}
		} catch (IOException e) {
			throw new ServletException(e);
		}
	}

	protected void RemoveItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		String url = "/Cart/cart.jsp";
		CartDao cart = (CartDao) session.getAttribute("cart");
		
		String maSp = request.getParameter("maSp");
		double tong = 0;
		if (cart == null) {
			cart = new CartDao();
			session.setAttribute("cart", cart);
		}

		// Find out whether this item is already in the cart.
		CartEntity item = cart.lookup(maSp);
		if (item != null) {
			cart.RemoveItem(maSp);
		}

		for (int i = 0; i < cartDao.GetSize(); i++) {
			CartEntity gio = cartDao.getItems(i);
			tong += gio.getGia().doubleValue();
		}
		request.setAttribute("tong", tong);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	private void showNewFormThanhToan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		double tong = Double.parseDouble(request.getParameter("tong"));
		request.setAttribute("tong", tong);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Cart/thanhtoan.jsp");
		dispatcher.forward(request, response);
	}
	private void TiepTucMuaHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="TaiKhoan?action=checklogin";
		response.sendRedirect(url);
	}


	protected void ThanhToan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		String url = "/Cart/thanhtoan.jsp";
		CartDao cart = (CartDao) session.getAttribute("cart");
		double tong = Double.parseDouble(request.getParameter("tong"));
		BigDecimal tongtienthanhtoan=null;
		Map<String, String> errors = new HashMap<String, String>();

		if (tong == 0) {
			errors.put("tong", "chưa có sản phẩm để thanh toán");
			request.setAttribute("error", errors);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
			return;
		}
		
		String hoTen = request.getParameter("hoTen");
		String diaChi = request.getParameter("diaChi");
		String sdt = request.getParameter("sdt");
		String trangThai = request.getParameter("trangThai");
		long millis = System.currentTimeMillis();
		Date ngaymua = new java.sql.Date(millis);

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
		tongtienthanhtoan=new BigDecimal(tong);
		int soluongdhct=0;
		BigDecimal gia=null;
		
		DonHangEntity newdonhang = new DonHangEntity(ngaymua, hoTen, diaChi, sdt, trangThai, user.getUserId(),tongtienthanhtoan);
		donhangDao.saveDonHang(newdonhang);
		DonHangEntity donhang=donhangDao.getDonHang(newdonhang.getMaDh());
		for (int i = 0; i < cart.GetSize(); i++) {
			CartEntity gio = cart.getItems(i);
			soluongdhct=cart.getItems(i).getQuantity();
			gia= cart.getItems(i).getGia();
			ChiTietDonHangEntity newctdh = new ChiTietDonHangEntity(soluongdhct, gia,donhang.getMaDh(), gio.getmaSp());
			chitietdonhangDao.saveCTDH(newctdh);
		}
		request.setAttribute("tong", newdonhang.getTongTien());
		request.setAttribute("diaChi", diaChi);
		request.setAttribute("sdt", sdt);
		url="Cart/thankyoufororder.jsp";
		//url="UsersServlet?action=checklogin&userName="+user.getUserName()+"&password="+user.getPassword();
		//response.sendRedirect(url);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void processRequestt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		String url = "/Cart/cart.jsp";
		CartDao cart = (CartDao) session.getAttribute("cart");
	
		if (cart == null) {
			cart = new CartDao();
			session.setAttribute("cart", cart);
		}

		String maSp = request.getParameter("maSp");
		if(maSp==null || maSp=="") {
			response.sendRedirect("Cart/UserMuaHang.jsp");
			return;
		}
		// Find out whether this item is already in the cart.
		CartEntity item = cart.lookup(maSp);
		SanPhamEntity sanpham = SanPhamDao.getSanPham(maSp);
		BigDecimal giasanpham = sanpham.getGia();
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		// Tính tiền sau khi giảm
		BigDecimal gia = null;
		String hinh = "/ProjectWeb/Root/SanPhamImage/" + sanpham.getMaLoai().trim() + "/" + sanpham.getHinh().trim()
				+ ".png";
		double tong = 0;

		// if so, and the quantity >0, add to the quantity
		if (item != null && quantity > 0) {
			int oldQuantity = item.getQuantity();
			item.setQuantity(oldQuantity + quantity);
			gia = new BigDecimal(giasanpham.doubleValue() * (double) (oldQuantity + quantity));
			item.setGia(gia);
			item.setHinh(hinh);
		}

		if (item == null && quantity > 0) {	
			gia = new BigDecimal(giasanpham.doubleValue() * (double) quantity);
			cart.addItem(maSp, quantity, gia, hinh);
		}

		for (int i = 0; i < cart.GetSize(); i++) {
			CartEntity gio = cart.getItems(i);
			tong += gio.getGia().doubleValue();
		}

		request.setAttribute("tong", tong);
		// Store the new copy of the cart in the session
		session.setAttribute("cart", cart);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
