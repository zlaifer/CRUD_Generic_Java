/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP 240 G6
 */
@Entity
@Table(name = "CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
    , @NamedQuery(name = "Category.findById", query = "SELECT c FROM Category c WHERE c.id = :id")
    , @NamedQuery(name = "Category.findByDescription", query = "SELECT c FROM Category c WHERE c.description = :description")
    , @NamedQuery(name = "Category.findByState", query = "SELECT c FROM Category c WHERE c.state = :state")
    , @NamedQuery(name = "Category.findByCreatedDate", query = "SELECT c FROM Category c WHERE c.createdDate = :createdDate")
    , @NamedQuery(name = "Category.findByUpdatedDate", query = "SELECT c FROM Category c WHERE c.updatedDate = :updatedDate")})
public class Category extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;

    public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }

    public Category(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Category[ id=" + id + " ]";
    }
    
}
