package Casio.Models;

import java.math.BigDecimal;

public class CartEntity {
	private String maSp;
	private int quantity;
	private BigDecimal gia;
	private String hinh;

	public CartEntity() {
	}

	public CartEntity(String maSp, int quantity, BigDecimal gia, String hinh) {
		this.maSp = maSp;
		this.quantity = quantity;
		this.gia=gia;
		this.hinh=hinh;
	}

	public String getmaSp() {
		return maSp;
	}

	public void setmaSp(String maSp) {
		this.maSp = maSp;
	}
	
	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh=hinh;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	
	public BigDecimal getGia() {
		return gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

}
