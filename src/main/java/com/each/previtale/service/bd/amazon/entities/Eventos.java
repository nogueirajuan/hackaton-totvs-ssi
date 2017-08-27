/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.service.bd.amazon.entities;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventos.findAll", query = "SELECT e FROM Eventos e")
    , @NamedQuery(name = "Eventos.findByIdEvento", query = "SELECT e FROM Eventos e WHERE e.idEvento = :idEvento")
    , @NamedQuery(name = "Eventos.findByImgEvento", query = "SELECT e FROM Eventos e WHERE e.imgEvento = :imgEvento")
    , @NamedQuery(name = "Eventos.findByNomeEvento", query = "SELECT e FROM Eventos e WHERE e.nomeEvento = :nomeEvento")
    , @NamedQuery(name = "Eventos.findByEnderecoEvento", query = "SELECT e FROM Eventos e WHERE e.enderecoEvento = :enderecoEvento")
    , @NamedQuery(name = "Eventos.findByDescEvento", query = "SELECT e FROM Eventos e WHERE e.descEvento = :descEvento")
    , @NamedQuery(name = "Eventos.findByLatituEvento", query = "SELECT e FROM Eventos e WHERE e.latituEvento = :latituEvento")
    , @NamedQuery(name = "Eventos.findByLongEvento", query = "SELECT e FROM Eventos e WHERE e.longEvento = :longEvento")})
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_evento")
    @GenericGenerator(name = "seqAEvento", strategy = "org.hibernate.id.IncrementGenerator")
    @GeneratedValue(generator = "seqAEvento")
    private Integer idEvento;
    @Size(max = 45)
    @Column(name = "img_evento")
    private String imgEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_evento")
    private String nomeEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "endereco_evento")
    private String enderecoEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "desc_evento")
    private String descEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "latitu_evento")
    private String latituEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "long_evento")
    private String longEvento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvento")
    private List<Avaliacoes> avaliacoesList;
    @JoinColumn(name = "#id_periodo", referencedColumnName = "id_periodo")
    @ManyToOne
    private Periodos idPeriodo;

    public Eventos() {
    }

    public Eventos(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Eventos(Integer idEvento, String nomeEvento, String enderecoEvento, String descEvento, String latituEvento, String longEvento) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.enderecoEvento = enderecoEvento;
        this.descEvento = descEvento;
        this.latituEvento = latituEvento;
        this.longEvento = longEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getImgEvento() {
        return imgEvento;
    }

    public void setImgEvento(String imgEvento) {
        this.imgEvento = imgEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getEnderecoEvento() {
        return enderecoEvento;
    }

    public void setEnderecoEvento(String enderecoEvento) {
        this.enderecoEvento = enderecoEvento;
    }

    public String getDescEvento() {
        return descEvento;
    }

    public void setDescEvento(String descEvento) {
        this.descEvento = descEvento;
    }

    public String getLatituEvento() {
        return latituEvento;
    }

    public void setLatituEvento(String latituEvento) {
        this.latituEvento = latituEvento;
    }

    public String getLongEvento() {
        return longEvento;
    }

    public void setLongEvento(String longEvento) {
        this.longEvento = longEvento;
    }

    @XmlTransient
    public List<Avaliacoes> getAvaliacoesList() {
        return avaliacoesList;
    }

    public void setAvaliacoesList(List<Avaliacoes> avaliacoesList) {
        this.avaliacoesList = avaliacoesList;
    }

    public Periodos getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodos idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.previtale.service.bd.amazon.entities.Eventos[ idEvento=" + idEvento + " ]";
    }
    
}
