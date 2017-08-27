/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.service.bd.amazon.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "periodos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodos.findAll", query = "SELECT p FROM Periodos p")
    , @NamedQuery(name = "Periodos.findByIdPeriodo", query = "SELECT p FROM Periodos p WHERE p.idPeriodo = :idPeriodo")
    , @NamedQuery(name = "Periodos.findByDtIniPeriodo", query = "SELECT p FROM Periodos p WHERE p.dtIniPeriodo = :dtIniPeriodo")
    , @NamedQuery(name = "Periodos.findByDtFimPeriodo", query = "SELECT p FROM Periodos p WHERE p.dtFimPeriodo = :dtFimPeriodo")})
public class Periodos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo")
    private Integer idPeriodo;
    @Size(max = 45)
    @Column(name = "dt_ini_periodo")
    private String dtIniPeriodo;
    @Size(max = 45)
    @Column(name = "dt_fim_periodo")
    private String dtFimPeriodo;
    @JoinColumn(name = "eventos_id_evento", referencedColumnName = "id_evento")
    @ManyToOne(optional = false)
    private Eventos eventosIdEvento;

    public Periodos() {
    }

    public Periodos(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getDtIniPeriodo() {
        return dtIniPeriodo;
    }

    public void setDtIniPeriodo(String dtIniPeriodo) {
        this.dtIniPeriodo = dtIniPeriodo;
    }

    public String getDtFimPeriodo() {
        return dtFimPeriodo;
    }

    public void setDtFimPeriodo(String dtFimPeriodo) {
        this.dtFimPeriodo = dtFimPeriodo;
    }

    public Eventos getEventosIdEvento() {
        return eventosIdEvento;
    }

    public void setEventosIdEvento(Eventos eventosIdEvento) {
        this.eventosIdEvento = eventosIdEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodos)) {
            return false;
        }
        Periodos other = (Periodos) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.previtale.service.bd.amazon.entities.Periodos[ idPeriodo=" + idPeriodo + " ]";
    }
    
}
