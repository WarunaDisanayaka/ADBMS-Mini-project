package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "rooms", schema = "hostal", catalog = "")
public class RoomsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "room_id")
    private int roomId;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "floor")
    private Integer floor;
    @Basic
    @Column(name = "no_of_students")
    private Integer noOfStudents;
    @OneToMany(mappedBy = "roomsByRoomId")
    private Collection<AssetsEntity> assetsByRoomId;
    @OneToMany(mappedBy = "roomsByRoomId")
    private Collection<ComplainsEntity> complainsByRoomId;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(Integer noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomsEntity that = (RoomsEntity) o;

        if (roomId != that.roomId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;
        if (noOfStudents != null ? !noOfStudents.equals(that.noOfStudents) : that.noOfStudents != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (noOfStudents != null ? noOfStudents.hashCode() : 0);
        return result;
    }

    public Collection<AssetsEntity> getAssetsByRoomId() {
        return assetsByRoomId;
    }

    public void setAssetsByRoomId(Collection<AssetsEntity> assetsByRoomId) {
        this.assetsByRoomId = assetsByRoomId;
    }

    public Collection<ComplainsEntity> getComplainsByRoomId() {
        return complainsByRoomId;
    }

    public void setComplainsByRoomId(Collection<ComplainsEntity> complainsByRoomId) {
        this.complainsByRoomId = complainsByRoomId;
    }
}
