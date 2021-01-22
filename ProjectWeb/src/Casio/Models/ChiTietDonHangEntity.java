package Casio.Models;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "ChiTietDonHang", schema = "dbo", catalog = "CASIO")
public class ChiTietDonHangEntity {
    private int id;
    private Integer maDh;
    private String maSp;
    private int soLuong;
    private BigDecimal gia;


    public ChiTietDonHangEntity(int id, int soLuong, BigDecimal gia, Integer maDh, String maSp) {
    	super();
    	this.id=id;
    	this.soLuong=soLuong;
    	this.gia=gia;
    	this.maDh=maDh;
    	this.maSp=maSp;
    }
    
    public ChiTietDonHangEntity(int soLuong, BigDecimal gia, Integer maDh, String maSp) {
    	super();
    	this.soLuong=soLuong;
    	this.gia=gia;
    	this.maDh=maDh;
    	this.maSp=maSp;
    }
    
    public ChiTietDonHangEntity() {
    	
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MaDH", nullable = true)
    public Integer getMaDh() {
        return maDh;
    }

    public void setMaDh(Integer maDh) {
        this.maDh = maDh;
    }

    @Basic
    @Column(name = "MaSP", nullable = true, length = 30)
    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    @Basic
    @Column(name = "SoLuong", nullable = false)
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Basic
    @Column(name = "Gia", nullable = false)
    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChiTietDonHangEntity that = (ChiTietDonHangEntity) o;

        if (id != that.id) return false;
        if (soLuong != that.soLuong) return false;
        if (maDh != null ? !maDh.equals(that.maDh) : that.maDh != null) return false;
        if (maSp != null ? !maSp.equals(that.maSp) : that.maSp != null) return false;
        if (gia != null ? !gia.equals(that.gia) : that.gia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (maDh != null ? maDh.hashCode() : 0);
        result = 31 * result + (maSp != null ? maSp.hashCode() : 0);
        result = 31 * result + soLuong;
        result = 31 * result + (gia != null ? gia.hashCode() : 0);
        return result;
    }

}

