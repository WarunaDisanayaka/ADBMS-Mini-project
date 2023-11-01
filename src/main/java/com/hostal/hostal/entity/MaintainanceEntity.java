package com.hostal.hostal.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "maintainance", schema = "hostal", catalog = "")
public class MaintainanceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "maintainance_id")
    private int maintainanceId;
    @Basic
    @Column(name = "assets_id")
    private String assetsId;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "evidence_image")
    private String evidenceImage;
    @Basic
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "assets_id", referencedColumnName = "assets_id")
    private AssetsEntity assetsByAssetsId;

    public int getMaintainanceId() {
        return maintainanceId;
    }

    public void setMaintainanceId(int maintainanceId) {
        this.maintainanceId = maintainanceId;
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaintainanceEntity that = (MaintainanceEntity) o;

        if (maintainanceId != that.maintainanceId) return false;
        if (assetsId != null ? !assetsId.equals(that.assetsId) : that.assetsId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (evidenceImage != null ? !evidenceImage.equals(that.evidenceImage) : that.evidenceImage != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maintainanceId;
        result = 31 * result + (assetsId != null ? assetsId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (evidenceImage != null ? evidenceImage.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public AssetsEntity getAssetsByAssetsId() {
        return assetsByAssetsId;
    }

    public void setAssetsByAssetsId(AssetsEntity assetsByAssetsId) {
        this.assetsByAssetsId = assetsByAssetsId;
    }
}
