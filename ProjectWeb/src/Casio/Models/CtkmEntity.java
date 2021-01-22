package Casio.Models;

import javax.persistence.*;



@Entity
@Table(name = "CTKM", schema = "dbo", catalog = "CASIO")
public class CtkmEntity {
    private int id;
    private Integer maKm;
    private String maSp;
    private Integer phanTram;

    public CtkmEntity(int id, Integer phanTram, Integer maKm, String maSp){
    	super();
    	this.id=id;
    	this.phanTram=phanTram;
    	this.maKm=maKm;
    	this.maSp=maSp;
    }
    public CtkmEntity(Integer phanTram, Integer maKm, String maSp){
    	super();
    	this.phanTram=phanTram;
    	this.maKm=maKm;
    	this.maSp=maSp;
    }
    
    public CtkmEntity() {
    	
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
    @Column(name = "MaKM", nullable = true)
    public Integer getMaKm() {
        return maKm;
    }

    public void setMaKm(Integer maKm) {
        this.maKm = maKm;
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
    @Column(name = "PhanTram", nullable = true)
    public Integer getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(Integer phanTram) {
        this.phanTram = phanTram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CtkmEntity that = (CtkmEntity) o;

        if (id != that.id) return false;
        if (maKm != null ? !maKm.equals(that.maKm) : that.maKm != null) return false;
        if (maSp != null ? !maSp.equals(that.maSp) : that.maSp != null) return false;
        if (phanTram != null ? !phanTram.equals(that.phanTram) : that.phanTram != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (maKm != null ? maKm.hashCode() : 0);
        result = 31 * result + (maSp != null ? maSp.hashCode() : 0);
        result = 31 * result + (phanTram != null ? phanTram.hashCode() : 0);
        return result;
    }

}
