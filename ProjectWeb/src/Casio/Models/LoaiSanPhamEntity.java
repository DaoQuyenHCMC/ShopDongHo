package Casio.Models;

import javax.persistence.*;


@Entity
@Table(name = "LoaiSanPham", schema = "dbo", catalog = "CASIO")
public class LoaiSanPhamEntity {
    private String maLoai;
    private String tinhTrang;

    public LoaiSanPhamEntity(String maLoai, String tinhTrang) {
    	super();
    	this.maLoai=maLoai;
    	this.tinhTrang=tinhTrang;
    }
    
    public LoaiSanPhamEntity() {
    	
    }
    
    @Id
    @Column(name = "MaLoai", nullable = false, length = 10)
    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    @Basic
    @Column(name = "TinhTrang", nullable = true, length = 30)
    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoaiSanPhamEntity that = (LoaiSanPhamEntity) o;

        if (maLoai != null ? !maLoai.equals(that.maLoai) : that.maLoai != null) return false;
        if (tinhTrang != null ? !tinhTrang.equals(that.tinhTrang) : that.tinhTrang != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maLoai != null ? maLoai.hashCode() : 0;
        result = 31 * result + (tinhTrang != null ? tinhTrang.hashCode() : 0);
        return result;
    }

}


