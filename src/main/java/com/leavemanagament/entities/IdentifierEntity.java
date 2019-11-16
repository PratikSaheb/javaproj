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


@Entity
public abstract class IdentifierEntity  {
    //Persistent Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Basic(optional = false)
    @Column(name = "ID")
    protected Integer id;


    public IdentifierEntity()
    {
    }

    public IdentifierEntity(
        Integer id1    ){
        this.id = id1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IdentifierEntity)) {
            return false;
        }

        IdentifierEntity other = (IdentifierEntity) object;

        return (!Objects.equals(this.getId(), other.getId()));
    }

    @Override
    public String toString() {
        return "com.books.entities.IdentifierEntity[ Id=" + this.getId() + " ]";
    }
}
