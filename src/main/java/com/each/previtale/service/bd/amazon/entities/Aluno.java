/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.service.bd.amazon.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findByNroUsp", query = "SELECT a FROM Aluno a WHERE a.nroUsp = :nroUsp")
    , @NamedQuery(name = "Aluno.findByUserRg", query = "SELECT a FROM Aluno a WHERE a.alunoPK.userRg = :userRg")
    , @NamedQuery(name = "Aluno.findByTimeIdtime", query = "SELECT a FROM Aluno a WHERE a.alunoPK.timeIdtime = :timeIdtime")
    , @NamedQuery(name = "Aluno.findByAnoIngresso", query = "SELECT a FROM Aluno a WHERE a.anoIngresso = :anoIngresso")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoPK alunoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nroUsp")
    private int nroUsp;
    @Column(name = "anoIngresso")
    private Integer anoIngresso;
    @JoinColumn(name = "time_idtime", referencedColumnName = "idtime", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Time time;
    @JoinColumn(name = "user_rg", referencedColumnName = "rg", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Aluno() {
    }

    public Aluno(AlunoPK alunoPK) {
        this.alunoPK = alunoPK;
    }

    public Aluno(AlunoPK alunoPK, int nroUsp) {
        this.alunoPK = alunoPK;
        this.nroUsp = nroUsp;
    }

    public Aluno(int userRg, int timeIdtime) {
        this.alunoPK = new AlunoPK(userRg, timeIdtime);
    }

    public AlunoPK getAlunoPK() {
        return alunoPK;
    }

    public void setAlunoPK(AlunoPK alunoPK) {
        this.alunoPK = alunoPK;
    }

    public int getNroUsp() {
        return nroUsp;
    }

    public void setNroUsp(int nroUsp) {
        this.nroUsp = nroUsp;
    }

    public Integer getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(Integer anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoPK != null ? alunoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.alunoPK == null && other.alunoPK != null) || (this.alunoPK != null && !this.alunoPK.equals(other.alunoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.previtale.service.bd.amazon.entities.Aluno[ alunoPK=" + alunoPK + " ]";
    }
    
}
