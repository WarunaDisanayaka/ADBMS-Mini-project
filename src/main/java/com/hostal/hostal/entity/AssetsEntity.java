package com.hostal.hostal.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "assets", schema = "hostal", catalog = "")
public class AssetsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "assets_id")
    private String assetsId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "room_no")
    private Integer roomNo;
    @Basic
    @Column(name = "added_date")
    private Date addedDate;

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssetsEntity that = (AssetsEntity) o;

        if (assetsId != null ? !assetsId.equals(that.assetsId) : that.assetsId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (roomNo != null ? !roomNo.equals(that.roomNo) : that.roomNo != null) return false;
        if (addedDate != null ? !addedDate.equals(that.addedDate) : that.addedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = assetsId != null ? assetsId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (roomNo != null ? roomNo.hashCode() : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        return result;
    }
}
