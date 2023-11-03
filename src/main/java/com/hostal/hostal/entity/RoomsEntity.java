package com.hostal.hostal.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "rooms", schema = "hostal", catalog = "")
public class RoomsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "room_id")
    private String roomId;
    @Basic
    @Column(name = "room_no")
    private Integer roomNo;
    @Basic
    @Column(name = "hostal")
    private String hostal;
    @Basic
    @Column(name = "floor")
    private Integer floor;
    @Basic
    @Column(name = "room_type")
    private String roomType;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
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

        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (roomNo != null ? !roomNo.equals(that.roomNo) : that.roomNo != null) return false;
        if (hostal != null ? !hostal.equals(that.hostal) : that.hostal != null) return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;
        if (roomType != null ? !roomType.equals(that.roomType) : that.roomType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + (roomNo != null ? roomNo.hashCode() : 0);
        result = 31 * result + (hostal != null ? hostal.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        return result;
    }


}
