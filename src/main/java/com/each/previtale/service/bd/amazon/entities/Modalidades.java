/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.service.bd.amazon.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "modalidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modalidades.findAll", query = "SELECT m FROM Modalidades m")
    , @NamedQuery(name = "Modalidades.findByModalidadesId", query = "SELECT m FROM Modalidades m WHERE m.modalidadesId = :modalidadesId")
    , @NamedQuery(name = "Modalidades.findBySigla", query = "SELECT m FROM Modalidades m WHERE m.sigla = :sigla")
    , @NamedQuery(name = "Modalidades.findByNome", query = "SELECT m FROM Modalidades m WHERE m.nome = :nome")})
public class Modalidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ModalidadesId")
    private Integer modalidadesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sigla")
    private String sigla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @ManyToMany(mappedBy = "modalidadesList")
    private List<PracaEsportiva> pracaEsportivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modalidadesModalidadesId")
    private List<Time> timeList;

    public Modalidades() {
    }

    public Modalidades(Integer modalidadesId) {
        this.modalidadesId = modalidadesId;
    }

    public Modalidades(Integer modalidadesId, String sigla, String nome) {
        this.modalidadesId = modalidadesId;
        this.sigla = sigla;
        this.nome = nome;
    }

    public Integer getModalidadesId() {
        return modalidadesId;
    }

    public void setModalidadesId(Integer modalidadesId) {
        this.modalidadesId = modalidadesId;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<PracaEsportiva> getPracaEsportivaList() {
        return pracaEsportivaList;
    }

    public void setPracaEsportivaList(List<PracaEsportiva> pracaEsportivaList) {
        this.pracaEsportivaList = pracaEsportivaList;
    }

    @XmlTransient
    public List<Time> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Time> timeList) {
        this.timeList = timeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modalidadesId != null ? modalidadesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidades)) {
            return false;
        }
        Modalidades other = (Modalidades) object;
        if ((this.modalidadesId == null && other.modalidadesId != null) || (this.modalidadesId != null && !this.modalidadesId.equals(other.modalidadesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.previtale.service.bd.amazon.entities.Modalidades[ modalidadesId=" + modalidadesId + " ]";
    }
    
}
