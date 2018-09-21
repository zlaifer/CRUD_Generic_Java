/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.enu.StateEnum;

/**
 *
 * @author HP 240 G6
 */
@MappedSuperclass
public abstract class AbstractEntity implements IEntity{
    @Basic(optional = false)
    @Column(name = "STATE")
    @Enumerated(EnumType.ORDINAL)
    private StateEnum state;
    @Basic(optional = false)
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    
    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
