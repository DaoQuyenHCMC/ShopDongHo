package Casio.Models;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "SanPham", schema = "dbo", catalog = "CASIO")
public class SanPhamEntity {
    private String maSp;
    private BigDecimal gia;
    private Timestamp ngayThem;
    private Integer soLuongKho;
    private Integer soLuongBan;
    private String maLoai;
    private String hinh;
    private String tinhNang;
    private String moTa;

    public SanPhamEntity(String maSp, BigDecimal gia, Timestamp ngayThem
    		, Integer soLuongKho, Integer soLuongBan, String hinh, String tinhNang, String moTa, String maLoai) {
    	super();
    	this.maSp=maSp;
    	this.gia=gia;
    	this.hinh=hinh;
    	this.soLuongBan=soLuongBan;
    	this.soLuongKho=soLuongKho;
    	this.moTa=moTa;
    	this.ngayThem=ngayThem;
    	this.tinhNang=tinhNang;
    	this.maLoai=maLoai;
    }
    
    
    public SanPhamEntity() {
    	
    }
    
    @Id
    @Column(name = "MaSP", nullable = false, length = 30)
    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    @Basic
    @Column(name = "Gia", nullable = false)
    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    @Basic
    @Column(name = "NgayThem", nullable = true)
    public Timestamp getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Timestamp ngayThem) {
        this.ngayThem = ngayThem;
    }

    @Basic
    @Column(name = "SoLuongKho", nullable = true)
    public Integer getSoLuongKho() {
        return soLuongKho;
    }

    public void setSoLuongKho(Integer soLuongKho) {
        this.soLuongKho = soLuongKho;
    }

    @Basic
    @Column(name = "SoLuongBan", nullable = true)
    public Integer getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(Integer soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    @Basic
    @Column(name = "MaLoai", nullable = true, length = 10)
    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    @Basic
    @Column(name = "Hinh", nullable = true, length = 500)
    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @Basic
    @Column(name = "TinhNang", nullable = true, length = -1)
    public String getTinhNang() {
        return tinhNang;
    }

    public void setTinhNang(String tinhNang) {
        this.tinhNang = tinhNang;
    }

    @Basic
    @Column(name = "MoTa", nullable = true, length = -1)
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SanPhamEntity that = (SanPhamEntity) o;

        if (maSp != null ? !maSp.equals(that.maSp) : that.maSp != null) return false;
        if (gia != null ? !gia.equals(that.gia) : that.gia != null) return false;
        if (ngayThem != null ? !ngayThem.equals(that.ngayThem) : that.ngayThem != null) return false;
        if (soLuongKho != null ? !soLuongKho.equals(that.soLuongKho) : that.soLuongKho != null) return false;
        if (soLuongBan != null ? !soLuongBan.equals(that.soLuongBan) : that.soLuongBan != null) return false;
        if (maLoai != null ? !maLoai.equals(that.maLoai) : that.maLoai != null) return false;
        if (hinh != null ? !hinh.equals(that.hinh) : that.hinh != null) return false;
        if (tinhNang != null ? !tinhNang.equals(that.tinhNang) : that.tinhNang != null) return false;
        if (moTa != null ? !moTa.equals(that.moTa) : that.moTa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maSp != null ? maSp.hashCode() : 0;
        result = 31 * result + (gia != null ? gia.hashCode() : 0);
        result = 31 * result + (ngayThem != null ? ngayThem.hashCode() : 0);
        result = 31 * result + (soLuongKho != null ? soLuongKho.hashCode() : 0);
        result = 31 * result + (soLuongBan != null ? soLuongBan.hashCode() : 0);
        result = 31 * result + (maLoai != null ? maLoai.hashCode() : 0);
        result = 31 * result + (hinh != null ? hinh.hashCode() : 0);
        result = 31 * result + (tinhNang != null ? tinhNang.hashCode() : 0);
        result = 31 * result + (moTa != null ? moTa.hashCode() : 0);
        return result;
    }


}

