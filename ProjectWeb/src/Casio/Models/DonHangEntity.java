package Casio.Models;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;


@Entity
@Table(name = "DonHang", schema = "dbo", catalog = "CASIO")
public class DonHangEntity {
    private int maDh;
    private Date ngayMua;
    private BigDecimal tongTien;
    private Integer userId;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String trangThai;

    public DonHangEntity(int maDh, Date ngayMua, BigDecimal tongTien
    		, String hoTen, String diaChi, String sdt, String trangThai, Integer userId) {
    	super();
    	this.maDh=maDh;
    	this.ngayMua=ngayMua;
    	this.tongTien=tongTien;
    	this.sdt=sdt;
    	this.trangThai=trangThai;
    	this.diaChi=diaChi;
    	this.hoTen=hoTen;
    	this.userId=userId;
    }
    
    public DonHangEntity(Date ngayMua
    		, String hoTen, String diaChi, String sdt, String trangThai, Integer userId, BigDecimal tongTien) {
    	super();
    	this.ngayMua=ngayMua;
    	this.tongTien=tongTien;
    	this.sdt=sdt;
    	this.trangThai=trangThai;
    	this.diaChi=diaChi;
    	this.hoTen=hoTen;
    	this.userId=userId;
    	this.tongTien=tongTien;
    }

    public DonHangEntity(int maDh, Date ngayMua
    		, String hoTen, String diaChi, String sdt, String trangThai, Integer userId) {
    	super();
    	this.maDh=maDh;
    	this.ngayMua=ngayMua;
    	this.sdt=sdt;
    	this.trangThai=trangThai;
    	this.diaChi=diaChi;
    	this.hoTen=hoTen;
    	this.userId=userId;
    }
    
    public DonHangEntity(Date ngayMua, BigDecimal tongTien
    		, String hoTen, String diaChi, String sdt, String trangThai, Integer userId) {
    	super();
    	this.ngayMua=ngayMua;
    	this.tongTien=tongTien;
    	this.sdt=sdt;
    	this.trangThai=trangThai;
    	this.diaChi=diaChi;
    	this.hoTen=hoTen;
    	this.userId=userId;
    }
    public DonHangEntity(Date ngayMua
    		, String hoTen, String diaChi, String sdt, String trangThai, Integer userId) {
    	super();
    	this.ngayMua=ngayMua;
    	this.sdt=sdt;
    	this.trangThai=trangThai;
    	this.diaChi=diaChi;
    	this.hoTen=hoTen;
    	this.userId=userId;
    }
    
    public DonHangEntity() {
    	
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MaDH", nullable = false)
    public int getMaDh() {
        return maDh;
    }

    public void setMaDh(int maDh) {
        this.maDh = maDh;
    }

    @Basic
    @Column(name = "NgayMua", nullable = true)
    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    @Basic
    @Column(name = "TongTien", nullable = true)
    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    @Basic
    @Column(name = "UserID", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "HoTen", nullable = true, length = 100)
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Basic
    @Column(name = "DiaChi", nullable = true, length = 500)
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Basic
    @Column(name = "SDT", nullable = false, length = 10)
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Basic
    @Column(name = "TrangThai", nullable = true, length = 50)
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DonHangEntity that = (DonHangEntity) o;

        if (maDh != that.maDh) return false;
        if (ngayMua != null ? !ngayMua.equals(that.ngayMua) : that.ngayMua != null) return false;
        if (tongTien != null ? !tongTien.equals(that.tongTien) : that.tongTien != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (hoTen != null ? !hoTen.equals(that.hoTen) : that.hoTen != null) return false;
        if (diaChi != null ? !diaChi.equals(that.diaChi) : that.diaChi != null) return false;
        if (sdt != null ? !sdt.equals(that.sdt) : that.sdt != null) return false;
        if (trangThai != null ? !trangThai.equals(that.trangThai) : that.trangThai != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maDh;
        result = 31 * result + (ngayMua != null ? ngayMua.hashCode() : 0);
        result = 31 * result + (tongTien != null ? tongTien.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (hoTen != null ? hoTen.hashCode() : 0);
        result = 31 * result + (diaChi != null ? diaChi.hashCode() : 0);
        result = 31 * result + (sdt != null ? sdt.hashCode() : 0);
        result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
        return result;
    }


}

