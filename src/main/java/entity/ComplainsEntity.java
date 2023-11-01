package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "complains", schema = "hostal", catalog = "")
public class ComplainsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "complain_id")
    private int complainId;
    @Basic
    @Column(name = "complain_description")
    private String complainDescription;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "room_no")
    private Integer roomNo;
    @Basic
    @Column(name = "assets_id")
    private String assetsId;
    @Basic
    @Column(name = "evidence_image")
    private String evidenceImage;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @ManyToOne
    @JoinColumn(name = "assets_id", referencedColumnName = "assets_id")
    private AssetsEntity assetsByAssetsId;

    public int getComplainId() {
        return complainId;
    }

    public void setComplainId(int complainId) {
        this.complainId = complainId;
    }

    public String getComplainDescription() {
        return complainDescription;
    }

    public void setComplainDescription(String complainDescription) {
        this.complainDescription = complainDescription;
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

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public String getEvidenceImage() {
        return evidenceImage;
    }

    public void setEvidenceImage(String evidenceImage) {
        this.evidenceImage = evidenceImage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplainsEntity that = (ComplainsEntity) o;

        if (complainId != that.complainId) return false;
        if (complainDescription != null ? !complainDescription.equals(that.complainDescription) : that.complainDescription != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (roomNo != null ? !roomNo.equals(that.roomNo) : that.roomNo != null) return false;
        if (assetsId != null ? !assetsId.equals(that.assetsId) : that.assetsId != null) return false;
        if (evidenceImage != null ? !evidenceImage.equals(that.evidenceImage) : that.evidenceImage != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = complainId;
        result = 31 * result + (complainDescription != null ? complainDescription.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (roomNo != null ? roomNo.hashCode() : 0);
        result = 31 * result + (assetsId != null ? assetsId.hashCode() : 0);
        result = 31 * result + (evidenceImage != null ? evidenceImage.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    public AssetsEntity getAssetsByAssetsId() {
        return assetsByAssetsId;
    }

    public void setAssetsByAssetsId(AssetsEntity assetsByAssetsId) {
        this.assetsByAssetsId = assetsByAssetsId;
    }
}
