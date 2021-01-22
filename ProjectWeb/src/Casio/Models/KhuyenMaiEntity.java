package Casio.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "KhuyenMai", schema = "dbo", catalog = "CASIO")
public class KhuyenMaiEntity {
    private int maKm;
    private Date thoiGianBd;
    private Date thoiGianKt;

    public KhuyenMaiEntity(Date thoiGianBd, Date thoiGianKt) {
    	super();
    	this.thoiGianBd=thoiGianBd;
    	this.thoiGianKt=thoiGianKt;
    }
    
    public KhuyenMaiEntity(int maKm, Date thoiGianBd, Date thoiGianKt) {
    	super();
    	this.maKm=maKm;
    	this.thoiGianBd=thoiGianBd;
    	this.thoiGianKt=thoiGianKt;
    }
    
    public KhuyenMaiEntity() {
    	
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MaKM", nullable = false)
    public int getMaKm() {
        return maKm;
    }

    public void setMaKm(int maKm) {
        this.maKm = maKm;
    }

    @Basic
    @Column(name = "ThoiGianBD", nullable = true)
    public Date getThoiGianBd() {
        return thoiGianBd;
    }

    public void setThoiGianBd(Date thoiGianBd) {
        this.thoiGianBd = thoiGianBd;
    }

    @Basic
    @Column(name = "ThoiGianKT", nullable = true)
    public Date getThoiGianKt() {
        return thoiGianKt;
    }

    public void setThoiGianKt(Date thoiGianKt) {
        this.thoiGianKt = thoiGianKt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KhuyenMaiEntity that = (KhuyenMaiEntity) o;

        if (maKm != that.maKm) return false;
        if (thoiGianBd != null ? !thoiGianBd.equals(that.thoiGianBd) : that.thoiGianBd != null) return false;
        if (thoiGianKt != null ? !thoiGianKt.equals(that.thoiGianKt) : that.thoiGianKt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maKm;
        result = 31 * result + (thoiGianBd != null ? thoiGianBd.hashCode() : 0);
        result = 31 * result + (thoiGianKt != null ? thoiGianKt.hashCode() : 0);
        return result;
    }

}
