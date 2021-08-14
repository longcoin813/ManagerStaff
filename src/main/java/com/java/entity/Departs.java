package com.java.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Departs {
    @NotNull
        private String departid;
    @NotNull
        private String departname;
    @JsonIgnore
    private Collection<Staffs> staffsByDepartid;

    @Id
    @Column(name = "departid", nullable = false, length = 10)
    public String getDepartid() {
        return departid;
    }

    public void setDepartid(String departid) {
        this.departid = departid;
    }

    @Basic
    @Column(name = "departname", nullable = true, length = 50)
    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departs departs = (Departs) o;

        if (departid != null ? !departid.equals(departs.departid) : departs.departid != null) return false;
        if (departname != null ? !departname.equals(departs.departname) : departs.departname != null) return false;

        return true;
    }
    @JsonIgnore
    @Override
    public int hashCode() {
        int result = departid != null ? departid.hashCode() : 0;
        result = 31 * result + (departname != null ? departname.hashCode() : 0);
        return result;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "departsByDepartid")
    public Collection<Staffs> getStaffsByDepartid() {
        return staffsByDepartid;
    }

    public void setStaffsByDepartid(Collection<Staffs> staffsByDepartid) {
        this.staffsByDepartid = staffsByDepartid;
    }
}
