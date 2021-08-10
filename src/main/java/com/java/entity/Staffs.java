package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Collection;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staffs {
    @NotNull
    private String staffid;
    @NotNull
    private String staffname;
    @NotNull
    private Boolean gender;
    @NotNull
    private Date birthday;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private Double salary;
    private String notes;
    private Collection<Records> recordsByStaffid;
    @NotNull
    private Departs departsByDepartid;

    @Id
    @Column(name = "staffid", nullable = false, length = 10)
    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    @Basic
    @Column(name = "staffname", nullable = true, length = 50)
    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "salary", nullable = true, precision = 0)
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "notes", nullable = true, length = 255)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staffs staffs = (Staffs) o;

        if (staffid != null ? !staffid.equals(staffs.staffid) : staffs.staffid != null) return false;
        if (staffname != null ? !staffname.equals(staffs.staffname) : staffs.staffname != null) return false;
        if (gender != null ? !gender.equals(staffs.gender) : staffs.gender != null) return false;
        if (birthday != null ? !birthday.equals(staffs.birthday) : staffs.birthday != null) return false;
        if (email != null ? !email.equals(staffs.email) : staffs.email != null) return false;
        if (phone != null ? !phone.equals(staffs.phone) : staffs.phone != null) return false;
        if (salary != null ? !salary.equals(staffs.salary) : staffs.salary != null) return false;
        if (notes != null ? !notes.equals(staffs.notes) : staffs.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffid != null ? staffid.hashCode() : 0;
        result = 31 * result + (staffname != null ? staffname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "staffsByStaffid")
    public Collection<Records> getRecordsByStaffid() {
        return recordsByStaffid;
    }

    public void setRecordsByStaffid(Collection<Records> recordsByStaffid) {
        this.recordsByStaffid = recordsByStaffid;
    }

    @ManyToOne
    @JoinColumn(name = "departid", referencedColumnName = "departid")
    public Departs getDepartsByDepartid() {
        return departsByDepartid;
    }

    public void setDepartsByDepartid(Departs departsByDepartid) {
        this.departsByDepartid = departsByDepartid;
    }
}
