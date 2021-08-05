package com.java.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Records {
    private Integer recordid;
    private Boolean type;
    private String reason;
    private Date date;
    private Staffs staffsByStaffid;

    @Id
    @Column(name = "recordid", nullable = false)
    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    @Basic
    @Column(name = "reason", nullable = true, length = 255)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "date", nullable = true)
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

        Records records = (Records) o;

        if (recordid != null ? !recordid.equals(records.recordid) : records.recordid != null) return false;
        if (type != null ? !type.equals(records.type) : records.type != null) return false;
        if (reason != null ? !reason.equals(records.reason) : records.reason != null) return false;
        if (date != null ? !date.equals(records.date) : records.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordid != null ? recordid.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "staffid", referencedColumnName = "staffid")
    public Staffs getStaffsByStaffid() {
        return staffsByStaffid;
    }

    public void setStaffsByStaffid(Staffs staffsByStaffid) {
        this.staffsByStaffid = staffsByStaffid;
    }
}
