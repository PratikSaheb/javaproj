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
public class RoleEntity extends IdentifierEntity  {
    //Persistent Fields
    @Column(name = "NAME")
    private String name;
    @Column(name = "LEVEL")
    private String level;
    @Column(name = "PAIDLEAVES")
    private Integer paidLeaves;


    public RoleEntity()
    {
        super();
    }

    public RoleEntity(
        Integer id1,
        String name1,
        String level1,
        Integer paidLeaves1    ){
        super(
                id1
            );
        this.name = name1;
        this.level = level1;
        this.paidLeaves = paidLeaves1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getPaidLeaves() {
        return paidLeaves;
    }

    public void setPaidLeaves(Integer paidLeaves) {
        this.paidLeaves = paidLeaves;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RoleEntity)) {
            return false;
        }

        RoleEntity other = (RoleEntity) object;

        return (!Objects.equals(this.getId(), other.getId()));
    }

    @Override
    public String toString() {
        return "com.books.entities.RoleEntity[ Id=" + this.getId() + " ]";
    }
}
