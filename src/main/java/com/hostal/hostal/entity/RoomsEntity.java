package com.hostal.hostal.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "rooms", schema = "hostal", catalog = "")
public class RoomsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "room_no")
    private int roomNo;
    @Basic
    @Column(name = "hostal")
    private String hostal;
    @Basic
    @Column(name = "floor")
    private Integer floor;
    @Basic
    @Column(name = "room_type")
    private String roomType;
    @OneToMany(mappedBy = "roomsByRoomNo")
    private Collection<AssetsEntity> assetsByRoomNo;
    @OneToMany(mappedBy = "roomsByRoomNo")
    private Collection<ComplainsEntity> complainsByRoomNo;

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getHostal() {
        return hostal;
    }

    public void setHostal(String hostal) {
        this.hostal = hostal;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomsEntity that = (RoomsEntity) o;

        if (roomNo != that.roomNo) return false;
        if (hostal != null ? !hostal.equals(that.hostal) : that.hostal != null) return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;
        if (roomType != null ? !roomType.equals(that.roomType) : that.roomType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomNo;
        result = 31 * result + (hostal != null ? hostal.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        return result;
    }

    public Collection<AssetsEntity> getAssetsByRoomNo() {
        return assetsByRoomNo;
    }

    public void setAssetsByRoomNo(Collection<AssetsEntity> assetsByRoomNo) {
        this.assetsByRoomNo = assetsByRoomNo;
    }

    public Collection<ComplainsEntity> getComplainsByRoomNo() {
        return complainsByRoomNo;
    }

    public void setComplainsByRoomNo(Collection<ComplainsEntity> complainsByRoomNo) {
        this.complainsByRoomNo = complainsByRoomNo;
    }
}
