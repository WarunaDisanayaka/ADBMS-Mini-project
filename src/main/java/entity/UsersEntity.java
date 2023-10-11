package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "users", schema = "hostal", catalog = "")
public class UsersEntity {
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name = "reg_no")
    private String regNo;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "role_id")
    private int roleId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<ComplainsEntity> complainsByUserId;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    private RolesEntity rolesByRoleId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (roleId != that.roleId) return false;
        if (userId != that.userId) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (regNo != null ? !regNo.equals(that.regNo) : that.regNo != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + (regNo != null ? regNo.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + roleId;
        result = 31 * result + userId;
        return result;
    }

    public Collection<ComplainsEntity> getComplainsByUserId() {
        return complainsByUserId;
    }

    public void setComplainsByUserId(Collection<ComplainsEntity> complainsByUserId) {
        this.complainsByUserId = complainsByUserId;
    }

    public RolesEntity getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(RolesEntity rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
}
