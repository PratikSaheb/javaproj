package com.leavemanagament.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERMODEL")
public class UserEntity implements Serializable{
    private static final long serialVersionUID = 637032795656007640L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PASSWORD")
    private String password;
    
    public UserEntity()
    {
    }

    public UserEntity(
        String email1,
        String password1
    ){        
        this.email = email1;
        this.password = password1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}