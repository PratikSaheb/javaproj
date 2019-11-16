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
public class LeaveTypeEntity extends IdentifierEntity  {
    //Persistent Fields
    @Column(name = "TYPE")
    private String type;


    public LeaveTypeEntity()
    {
        super();
    }

    public LeaveTypeEntity(
        Integer id1,
        String type1    ){
        super(
                id1
            );
        this.type = type1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LeaveTypeEntity)) {
            return false;
        }

        LeaveTypeEntity other = (LeaveTypeEntity) object;

        return (!Objects.equals(this.getId(), other.getId()));
    }

    @Override
    public String toString() {
        return "com.books.entities.LeaveTypeEntity[ Id=" + this.getId() + " ]";
    }
}
