package Casio.Models;

import javax.persistence.*;


@Entity
@Table(name = "Users", schema = "dbo", catalog = "CASIO")
public class UsersEntity {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String sdt;
    private String address;
    private String avatar;
    private Integer allowed;

    public UsersEntity(int userId, Integer allowed) {
    	super();
    	this.userId=userId;
    	this.allowed=allowed;
    
    }
    
    public UsersEntity(int userId, String userName, 
    		String password, String email, String sdt, 
    		String address, Integer allowed) {
    	super();
    	this.userId=userId;
    	this.userName=userName;
    	this.sdt=sdt;
    	this.password=password;
    	this.address=address;
    	this.allowed=allowed;
    	this.email=email;
    
    }
    
    public UsersEntity(String userName, 
    		String password, String email, String sdt, 
    		String address, Integer allowed) {
    	super();
    	this.userName=userName;
    	this.sdt=sdt;
    	this.password=password;
    	this.address=address;
    	this.allowed=allowed;
    	this.email=email;
    	
    }
    public UsersEntity(String userName, 
    		String password, String email, String sdt, 
    		String address, Integer allowed, String avatar) {
    	super();
    	this.userName=userName;
    	this.sdt=sdt;
    	this.password=password;
    	this.address=address;
    	this.allowed=allowed;
    	this.email=email;
    	this.avatar=avatar;
    }
    
    public UsersEntity() {
    	
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "UserID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserName", nullable = false, length = 30, unique=true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "Password", nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "SDT", nullable = true, length = 10)
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 500)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Avatar", nullable = true, length = 500)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "Allowed", nullable = true)
    public Integer getAllowed() {
        return allowed;
    }

    public void setAllowed(Integer allowed) {
        this.allowed = allowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (sdt != null ? !sdt.equals(that.sdt) : that.sdt != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;
        if (allowed != null ? !allowed.equals(that.allowed) : that.allowed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (sdt != null ? sdt.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (allowed != null ? allowed.hashCode() : 0);
        return result;
    }

}

