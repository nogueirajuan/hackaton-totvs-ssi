/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.service.bd.amazon.entities;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "avaliacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacoes.findAll", query = "SELECT a FROM Avaliacoes a")
    , @NamedQuery(name = "Avaliacoes.findByIdAvaliacao", query = "SELECT a FROM Avaliacoes a WHERE a.idAvaliacao = :idAvaliacao")
    , @NamedQuery(name = "Avaliacoes.findByNotaAvaliacao", query = "SELECT a FROM Avaliacoes a WHERE a.notaAvaliacao = :notaAvaliacao")
    , @NamedQuery(name = "Avaliacoes.findByComenAvaliacao", query = "SELECT a FROM Avaliacoes a WHERE a.comenAvaliacao = :comenAvaliacao")
    , @NamedQuery(name = "Avaliacoes.findByDataAvaliacao", query = "SELECT a FROM Avaliacoes a WHERE a.dataAvaliacao = :dataAvaliacao")})
public class Avaliacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_avaliacao")
    @GenericGenerator(name = "seqAvaliacoes", strategy = "org.hibernate.id.IncrementGenerator")
    @GeneratedValue(generator = "seqAvaliacoes")
    private Integer idAvaliacao;
    @Column(name = "nota_avaliacao")
    private Integer notaAvaliacao;
    @Size(max = 250)
    @Column(name = "comen_avaliacao")
    private String comenAvaliacao;
    @Column(name = "data_avaliacao")
    @Temporal(TemporalType.DATE)
    private Date dataAvaliacao;
    @JoinColumn(name = "#id_evento", referencedColumnName = "id_evento")
    @ManyToOne(optional = false)
    private Eventos idEvento;
    @JoinColumn(name = "#id_ususario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsusario;

    public Avaliacoes() {
    }

    public Avaliacoes(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Integer getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(Integer notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public String getComenAvaliacao() {
        return comenAvaliacao;
    }

    public void setComenAvaliacao(String comenAvaliacao) {
        this.comenAvaliacao = comenAvaliacao;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Eventos getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Eventos idEvento) {
        this.idEvento = idEvento;
    }

    public Usuarios getIdUsusario() {
        return idUsusario;
    }

    public void setIdUsusario(Usuarios idUsusario) {
        this.idUsusario = idUsusario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvaliacao != null ? idAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacoes)) {
            return false;
        }
        Avaliacoes other = (Avaliacoes) object;
        if ((this.idAvaliacao == null && other.idAvaliacao != null) || (this.idAvaliacao != null && !this.idAvaliacao.equals(other.idAvaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.previtale.service.bd.amazon.entities.Avaliacoes[ idAvaliacao=" + idAvaliacao + " ]";
    }
    
}
