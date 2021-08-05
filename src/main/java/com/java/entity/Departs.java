package com.java.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Departs {
    private String departid;
    private String deoartname;
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
    @Column(name = "deoartname", nullable = true, length = 50)
    public String getDeoartname() {
        return deoartname;
    }

    public void setDeoartname(String deoartname) {
        this.deoartname = deoartname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departs departs = (Departs) o;

        if (departid != null ? !departid.equals(departs.departid) : departs.departid != null) return false;
        if (deoartname != null ? !deoartname.equals(departs.deoartname) : departs.deoartname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departid != null ? departid.hashCode() : 0;
        result = 31 * result + (deoartname != null ? deoartname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "departsByDepartid")
    public Collection<Staffs> getStaffsByDepartid() {
        return staffsByDepartid;
    }

    public void setStaffsByDepartid(Collection<Staffs> staffsByDepartid) {
        this.staffsByDepartid = staffsByDepartid;
    }
}
