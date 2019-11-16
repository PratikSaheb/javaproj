package com.leavemanagament.entities;

import java.io.Serializable;
import java.util.List;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.leavemanagament.entities.IdentifierEntity;

@Entity
public class LeaveEntity extends IdentifierEntity  {
    //Persistent Fields
    @Column(name = "STARTDATE")
    private Date startDate;
    @Column(name = "ENDDATE")
    private Date endDate;
    @Column(name = "TOTALDAYS")
    private Integer totalDays;
    @Column(name = "REASONFORLEAVE")
    private String reasonForLeave;
    @Column(name = "USERID")
    private String userId;
    @Column(name = "MANAGERID")
    private String managerId;
    @Column(name = "LEAVETYPE")
    private String leaveType;
    @Column(name = "STATUS")
    private String status;


    public LeaveEntity()
    {
        super();
    }

    public LeaveEntity(
        Integer id1,
        Date startDate1,
        Date endDate1,
        Integer totalDays1,
        String reasonForLeave1,
        String userId1,
        String managerId1,
        String leaveType1,
        String status1    ){
        super(
                id1
            );
        this.startDate = startDate1;
        this.endDate = endDate1;
        this.totalDays = totalDays1;
        this.reasonForLeave = reasonForLeave1;
        this.userId = userId1;
        this.managerId = managerId1;
        this.leaveType = leaveType1;
        this.status = status1;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public String getReasonForLeave() {
        return reasonForLeave;
    }

    public void setReasonForLeave(String reasonForLeave) {
        this.reasonForLeave = reasonForLeave;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LeaveEntity)) {
            return false;
        }

        LeaveEntity other = (LeaveEntity) object;

        return (!Objects.equals(this.getId(), other.getId()));
    }

    @Override
    public String toString() {
        return "com.books.entities.LeaveEntity[ Id=" + this.getId() + " ]";
    }
}
